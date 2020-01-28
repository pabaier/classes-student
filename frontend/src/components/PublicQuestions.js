import React from 'react';
import { connect } from "react-redux";
import { getPublicQuestions } from "../actions/index"

const mapStateToProps = state => {
	return { questions: state.root.questions };
}

const connectedPublicQuestions = ( {questions, dispatch} ) => {
	const listItems = questions.map( (q) => (
		<li key={'q'+q.id}>{q.text}
			<ul>
				{
					q.answerOptions.map( (a) => (
						<li key={'a'+a.id}>{a.option} {a.isAnswer? "*" : ""}</li>
					))
				}
			</ul>
		</li>
	));

	return (
		<div>
			<h2>Public Questions</h2>
			<ul>
				{ listItems }
			</ul>
			<br />
			<button onClick={ () => { dispatch(getPublicQuestions()) } }>Get Public Questions</button>
		</div>
	);
};

const PublicQuestions = connect(mapStateToProps)(connectedPublicQuestions)

export default PublicQuestions;