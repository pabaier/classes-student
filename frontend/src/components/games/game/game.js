import React from 'react';
import { CardDeck, Col, Container, Row } from 'react-bootstrap';
import Question from '../../questions/question'


const Game = ( {game} ) => {
	const questions = game.questions.map( (q) =>
		<Col>
			<Question key={"gq" + q.question.id} question={q.question}>
				{q.time_limit}
			</Question>
		</Col>
	)

	return (
		<Container>
			<Row>
				<CardDeck>
					{questions}
				</CardDeck>
			</Row>
		</Container>
	)
}

export default Game;