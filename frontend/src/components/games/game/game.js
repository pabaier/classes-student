import React from 'react';
import { CardColumns, CardDeck, Col, Container, Row } from 'react-bootstrap';
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
		<div>
			<h3>{game.name}</h3>
			<Container>
				<Row>
					<CardDeck>
						{questions}
					</CardDeck>
				</Row>
			</Container>
		</div>
	)
}

export default Game;