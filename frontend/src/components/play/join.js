import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom'
import * as states from './client/states'

// const mapStateToProps = state => {
// 	return { isLoggedIn: state.root.user.isLoggedIn };
// }

// const ConnectedJoin = ( {dispatch} ) => {
const Join = () => {
	let { token } = useParams()
	const [clientState, setclientState] = useState(states.ENTERING_NAME);
	const [ws, setWs] = useState(null);

	useEffect(() => {
		if(!ws){
			setWs(new WebSocket(`ws://localhost:8000/ws/join/${token}/`))
		}

		return function cleanup() {
			if(ws){
				ws.close();
			}
		}
	}, [ws]);

	const sendMessage = (data) => {
		try {
			ws.send(JSON.stringify({
				'message': data
			}));
		} catch (error) {
			console.log(error);
		}
	}

	if(!ws) {
		return (<div></div>)
	}
	ws.onclose = () => {
		console.log('disconnected')
		// automatically try to reconnect on connection loss
	}

	return (
		<div>
			<h2>Game Joined</h2>
			{states.ClientState(clientState, {ws, sendMessage, setclientState})}
		</div>
	);
};

// const Join = connect(mapStateToProps)(ConnectedJoin)

export default Join;