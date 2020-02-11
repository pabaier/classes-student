import React from 'react';
import { useParams } from 'react-router-dom'
import { Button } from 'react-bootstrap'

// const mapStateToProps = state => {
// 	return { isLoggedIn: state.root.user.isLoggedIn };
// }

// const ConnectedJoin = ( {dispatch} ) => {
const Join = () => {
	let { token } = useParams()

	const ws = new WebSocket(`ws://localhost:8000/ws/join/${token}/`)

	const sendMessage = () => {
		try {
			ws.send(JSON.stringify({
				'message': 'hiho'
			}));
		} catch (error) {
			console.log(error);
		}
	}

	return (
		<div>
			<h2>Game Joined</h2>
			<Button onClick={sendMessage}>Send</Button>
		</div>
	);
};

// const Join = connect(mapStateToProps)(ConnectedJoin)

export default Join;