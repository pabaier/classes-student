import React, { useEffect, useState } from 'react';
import { connect } from "react-redux";
import { useParams } from 'react-router-dom'
import { activateGame } from "../../actions/play"

const mapStateToProps = (state, {location: {game}}) => {
	return { activeGame: state.root.activeGame, game };
}

const ConnectedHost = ( {activeGame, game, dispatch} ) => {
	let { id } = useParams()
	const [players, setPlayers] = useState('');
	const [ws, setWs] = useState(null);

	useEffect(() => {
		if(!activeGame){
			dispatch(activateGame(id));
		}
	}, [activeGame]);

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
		const data = JSON.parse(e.data)
		var message = data['message'];
		// this.setState({dataFromServer: message})
		setPlayers(`${players} ${message}`)
		console.log(message)
	}

	ws.onclose = () => {
		console.log('disconnected')
		// automatically try to reconnect on connection loss
	}

	return (
		<div>
			<h3>Play Game {game ? game.name : ''}</h3>
			<h5>pin: {activeGame.slug}</h5>
			<div id='players'>{players}</div>
		</div>
	)
}

const Host = connect(mapStateToProps)(ConnectedHost)

export default Host;