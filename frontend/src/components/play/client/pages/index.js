import React from 'react';
import * as state from '../../state';
import Registration from './registration';
import Question from './question';
import PostQuestion from './postQuestion'
import Finished from './finished'
import MakeTeams from './makeTeams';
import Hook from './hook';

const Page = (props) => {
	switch (props.currentState) {
		case state.STANDBY:
			return <div>Stand By</div>;
		case state.HOOK:
			return <Hook {...props} />;
		case state.REGISTRATION:
			return <Registration {...props} />;
		case state.MAKE_TEAMS:
			return <MakeTeams {...props} />;
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