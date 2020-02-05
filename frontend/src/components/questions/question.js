import React from 'react';
import { Card } from 'react-bootstrap';
import Answers from './answers'

const Question = ( {question} ) => {
	return (
		<div>
			<Card style={{ width: '18rem' }} >
				<Card.Body>
					<Card.Title>{question.text}</Card.Title>
					<Card.Text >
					</Card.Text>
					<Answers  componentClass='span' answers={question.answerOptions} />
					{question.category}
				</Card.Body>
			</Card>
		</div>
	)
}

export default Question
