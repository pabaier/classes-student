import React from 'react';
import { Button } from 'react-bootstrap'

const Connect = ({data, sendMessage}) => {
	const start = () => {
		sendMessage('next')
	}

	return (
		<div>
			<h1>Players</h1>
			<h3>{data.players ? data.players : ''}</h3>
			<Button size='sm' onClick={start}>Start</Button>
		</div>
	)
}

export default Connect;