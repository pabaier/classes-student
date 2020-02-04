import React from 'react';
import { Button, Card } from 'react-bootstrap';
import Answers from './answers'

const Question = ( {question: {question, time_limit}} ) => {
	return (
		<div>
			<Card style={{ width: '18rem' }} >
				<Card.Body>
					<Card.Title>{question.text}</Card.Title>
					<Card.Text >
						{time_limit}
					</Card.Text>
					<Answers  componentClass='span' answers={question.answerOptions} />
					<Button variant="primary">edit</Button>
					<br />
					{question.category}
				</Card.Body>
			</Card>
		</div>
	)
}

export default Question
