import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import Question from '../../questions/question'


const Game = ( {game} ) => {
	console.log(game.questions)
	const questions = game.questions.map( (q) =>
		<Col key={"gq" + q.question.id}><Question question={q} /></Col>
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

	// return <h1>hi</h1>
}

export default Game;