import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { CONNECT } from '../state';
import Page from './pages';

const Client = () => {
	let { token } = useParams()
	const [state, setState] = useState(CONNECT);
	const [data, setData] = useState({});
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
		const receivedData = JSON.parse(e.data);
		setState(receivedData['state']);
		setData(receivedData['data']);
	}

	ws.onclose = () => {
		console.log('disconnected')
		// automatically try to reconnect on connection loss
	}

	const packageData = () => {
		return {
			data,
			sendMessage,
		}
	}

	return (
		<div>
			<h2>Game Joined</h2>
			<Page currentState={state} data={packageData()}></Page>
		</div>
	);
};

export default Client;