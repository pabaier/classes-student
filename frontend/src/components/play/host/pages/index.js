import React from 'react';
import * as state from '../../state';
import Connect from './connect';
import Question from './question';
import PostQuestion from './postQuestion';
import Finished from './finished';

const Page = (props) => {
	switch(props.currentState) {
		case state.STANDBY:
			return <div>Stand By</div>;
		case state.CONNECT:
			return <Connect {...props} />;
		case state.REGISTRATION:
			return <div>Registration</div>;
		case state.POST_REGISTRATION:
			return <div>Post-Registration</div>;
		case state.PRE_QUESTION:
			return <div>Pre-Question</div>;
		case state.QUESTION:
			return <Question {...props} />;
		case state.POST_QUESTION:
			return <PostQuestion {...props} />;
		case state.GAME_OVER:
			return <div>Game Over</div>;
		case state.FINISHED:
			return <Finished {...props} />;
		default:
			return <div>Default</div>;
	}
}

export default Page;