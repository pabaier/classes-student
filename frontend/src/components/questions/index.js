import React, { useEffect } from 'react';
import { connect } from "react-redux";
import { getQuestions } from "../../actions/questions"
import Question from "./question"
import { Container, Row, Col } from 'react-bootstrap';

const mapStateToProps = state => {
	return { questions: state.root.questions };
}

const ConnectedQuestions = ( {questions=[], dispatch} ) => {
	useEffect(() => {
		dispatch(getQuestions());
	}, [dispatch]);

	const listItems = questions.map( (q) => (
		<Col key={"gq" + q.id}><Question question={q} /></Col>
	));

	return (
		<div>
			<h2>Questions</h2>
			<Container>
				<Row>
					{listItems}
				</Row>
			</Container>
		</div>
	);
};

const Questions = connect(mapStateToProps)(ConnectedQuestions)

export default Questions;