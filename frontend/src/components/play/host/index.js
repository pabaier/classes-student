import React, { useEffect, useState } from 'react';
import { connect } from "react-redux";
import { useParams } from 'react-router-dom'
import { activateGame } from "../../../actions/play"
import { Button } from 'react-bootstrap'
import { CONNECT, REGISTRATION } from '../state'
import Page from './pages';
import Timer from '../timer';

const mapStateToProps = (state, {location: {game}}) => {
	return { activeGame: state.root.activeGame, game };
}

const ConnectedHost = ( {activeGame, game, dispatch} ) => {
	let { id } = useParams()
	const [players, setPlayers] = useState('');
	const [ws, setWs] = useState(null);
	const [stateAndData, setStateAndData] = useState({
		state: CONNECT,
		data: {}
	});

	useEffect(() => {
		if(!activeGame){
			dispatch(activateGame(id));
		}
	}, [activeGame, dispatch, id]);

	useEffect(() => {
		if(activeGame && !ws){
			setWs(new WebSocket(`ws://localhost:8000/ws/host/${activeGame.slug}/`))
		}
		return function cleanup() {
			if(ws){
				ws.close();
			}
		}
	}, [activeGame, ws]);

	if(!(activeGame && ws)) {
		return (<div></div>)
	}

	ws.onopen = () => {
		// on connecting, do nothing but log it to the console
		console.log('client connected')
	}

	ws.onmessage = e => {
		// listen to data sent from the websocket server
		var message = JSON.parse(e.data);
		if(message.state === REGISTRATION) {
			setPlayers(`${players} ${message.data.name}`)
		}
		else{
			setStateAndData({
				state: message['state'],
				data: message['data']
			});
		}
	}

	ws.onclose = () => {
		console.log('disconnected')
		// automatically try to reconnect on connection loss
	}

	const sendMessage = (message) => {
		try {
			ws.send(JSON.stringify({
				'message': message,
			}));
		} catch (error) {
			console.log(error);
		}
	}

	const nextState = () => {
		sendMessage('next');
	}

	const packageData = () => {
		stateAndData.data.players = players;
		return{
			currentState:stateAndData.state,
			data: stateAndData.data,
			sendMessage,
		}	
	}

	return (
		<div>
			<h5>Game pin: {activeGame.slug}</h5>
			<Page {...packageData()}></Page>
			{stateAndData.data.time ? <Timer time={stateAndData.data.time} sendMessage={sendMessage} /> : ''}
		</div>
	)
}

const Host = connect(mapStateToProps)(ConnectedHost)

export default Host;