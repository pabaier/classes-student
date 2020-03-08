import React from 'react';
import * as state from '../../state'
import Registration from './registration'

const Page = ({currentState, data}) => {
	switch(currentState) {
		case state.STANDBY:
			return <div>Stand By</div>;
		case state.REGISTRATION:
			return <Registration {...data}></Registration>;
		case state.POST_REGISTRATION:
			return <div>Post Registration</div>;
		case state.PRE_QUESTION:
			return <div>Pre Question</div>;
		case state.QUESTION:
			return <div>Question</div>;
		case state.POST_QUESTION:
			return <div>Post Question</div>;
		case state.GAME_OVER:
			return <div>Game Over</div>;
		case state.FINISHED:
			return <div>Finished</div>;																		
		default:
			return <div>Default</div>;
	}
}

export default Page;