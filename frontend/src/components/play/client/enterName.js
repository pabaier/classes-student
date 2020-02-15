import React from 'react';
import { Button, Col, Form } from 'react-bootstrap'
import { WAITING_TO_PLAY } from './states'

const EnterName = ({ws, callback, setState}) => {

	const onSubmit = e => {
		e.preventDefault();
		const playerName = e.target.elements.playerName.value;
		callback(playerName);
		setState(WAITING_TO_PLAY);
	}

	return (
		<div>
			<h3>Enter Name</h3>
			<Form onSubmit={ e => onSubmit(e)}>
				<Form.Row >
					<Form.Control type="text" name="playerName" placeholder="Enter Name" />
					<Button  type="submit">Join Game</Button>
				</Form.Row>
			</Form>
		</div>
	)
}

export default EnterName;