import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import Question from '../../questions/question'


const Game = ( {game} ) => {
	const questions = game.questions.map( (q) =>
		<Col key={"gq" + q.question.id}><Question question={q.question} />{q.time_limit}</Col>
	)

	return (
		<div>
			<h3>{game.name}</h3>
			<Container>
				<Row>
					{questions}
				</Row>
			</Container>
		</div>
	)
}

export default Game;