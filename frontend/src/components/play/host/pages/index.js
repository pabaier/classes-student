import React from 'react';
import * as state from '../../state';
// import Registration from './registration';
// import Question from './question';

const Page = (props) => {
	switch(props.currentState) {
		case state.STANDBY:
			return <div>Stand By</div>;
		case state.CONNECT:
			return <div>Connect</div>;
		case state.REGISTRATION:
			return <div>Registration</div>
		// return <Registration {...props} />;
		case state.POST_REGISTRATION:
			return <div>Post Registration</div>;
		case state.PRE_QUESTION:
			return <div>Pre Question</div>;
		case state.QUESTION:
			return <div>Questions</div>
			// return <Question {...props} />;
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