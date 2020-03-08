import React from 'react';
import * as state from '../state'

const Page = (props) => {
	switch(props.currentState) {
		case state.STANDBY:
			return <div>Stand By</div>;
			// return <Wait ws={websocket}/>;
		case state.REGISTRATION:
			return <div>Registration</div>;
			// return <EnterName ws={websocket} callback={callback} setState={setclientState}/>;
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