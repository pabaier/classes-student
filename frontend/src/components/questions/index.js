import React, { useEffect } from 'react';
import { connect } from "react-redux";
import { getQuestions } from "../../actions/index"


const mapStateToProps = state => {
	return { questions: state.root.questions };
}

const ConnectedQuestions = ( {questions=[], dispatch} ) => {
	useEffect(() => {
		dispatch(getQuestions());
	}, [dispatch]);

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
			<h2>Questions</h2>
			<ul>
				{ listItems }
			</ul>
			<br />
		</div>
	);
};

const Questions = connect(mapStateToProps)(ConnectedQuestions)

export default Questions;