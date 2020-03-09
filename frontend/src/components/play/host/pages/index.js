import React from 'react';
import { Button } from 'react-bootstrap'
import * as state from '../../state';
import Connect from './connect';
import Question from './question';

const defaultPage = (name, sendMessage) => {
	const next = () => {
		sendMessage('next');
	}

	return (
		<div>
			<div>{name}</div>
			<Button size='sm' onClick={next}>next</Button>
		</div>
	)
}

const Page = (props) => {
	switch(props.currentState) {
		case state.STANDBY:
			return <div>Stand By</div>;
		case state.CONNECT:
			return <Connect {...props} />;
		case state.REGISTRATION:
			return defaultPage('Registration', props.sendMessage)
		case state.POST_REGISTRATION:
			return defaultPage('Post-Registration', props.sendMessage)
		case state.PRE_QUESTION:
			return defaultPage('Pre-Question', props.sendMessage)
		case state.QUESTION:
			return <Question {...props} />;
		case state.POST_QUESTION:
			return defaultPage('Post-Question', props.sendMessage)
		case state.GAME_OVER:
			return defaultPage('Game Over', props.sendMessage)
		case state.FINISHED:
			return defaultPage('Finished', props.sendMessage)
		default:
			return defaultPage('Default', props.sendMessage)
	}
}

export default Page;