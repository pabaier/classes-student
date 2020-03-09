import React from 'react';
import { Button } from 'react-bootstrap'

const Question = ({data, sendMessage}) => {

	const stop = () => {
		sendMessage('next')
	}

	const makeRows = () => {
		if(!data.answers) return;
		var key = 0;
		return data.answers.map(x => (
			<Button key={key++} value={x} block disabled>{x}</Button>
		));
	}

	return (
		<div>
			<h3>{data.text ? data.text : ''}</h3>
			{makeRows()}
			<Button size='sm' onClick={stop}>Times Up!</Button>
		</div>
	)
}

export default Question;