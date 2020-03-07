import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom'
import { CONNECT } from '../state'

const Client = () => {
	let { token } = useParams()
	const [state, setState] = useState(CONNECT);
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
	}, [ws, token]);

	const sendMessage = (data, type) => {
		try {
			ws.send(JSON.stringify({
				'data': data,
				'type': type,
			}));
		} catch (error) {
			console.log(error);
		}
	}

	if(!ws) {
		return (<div></div>)
	}

	ws.onmessage = e => {
		const data = JSON.parse(e.data);
		const newState = data['state'];
		setState(newState);
		console.log(data);
	}

	ws.onclose = () => {
		console.log('disconnected')
		// automatically try to reconnect on connection loss
	}

	return (
		<div>
			<h2>Game Joined</h2>
			{/* {states.ClientState(state, {ws, sendMessage, setclientState})} */}
		</div>
	);
};

export default Client;