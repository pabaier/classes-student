import React from 'react';
import { Button, Form } from 'react-bootstrap'

const Question = ({data, sendMessage}) => {

	const onSubmit = e => {
		e.preventDefault();
		const playerName = e.target.elements.playerName.value;
		sendMessage(playerName, 'registration');
	}

	return (
		<div>
			<h3>{data.text}</h3>

			{/* <Form onSubmit={ e => onSubmit(e)}>
				<Form.Row >
					<Form.Control type="text" name="playerName" placeholder="Enter Name" />
					<Button  type="submit">Enter</Button>
				</Form.Row>
			</Form> */}
		</div>
	)
}

export default Question;