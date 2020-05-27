import React, { useState } from 'react';
import { Button, Form, Col } from 'react-bootstrap'

const onSubmit = (e) => {
	e.preventDefault();
	const question = e.target.elements.question.value;
	const category = e.target.elements.category.value;
	console.log('submit', checked + " " + category + " " + question);
}

const checkChange = (e) => {
	checked = !checked
}

var checked = false;

const Create = () => {
	const [key, setKey] = useState(1)
	const [answerOptions, setAnswerOptions] = useState([
		<Form.Row key={0}>
			<Form.Control type="text" placeholder="answer option" name="answerOption" />
		</Form.Row>
	]);

	const addAnswerOption = () => {
		setAnswerOptions([...answerOptions, 
			<Form.Row key={key}>
				<Form.Control type="text" placeholder="answer option" name="answerOption" />
			</Form.Row>
		]);
		setKey(key + 1);
	}

	const removeAnswerOption = () => {
		if(key <= 0) return;
		var options = [...answerOptions];
		options.pop();
		setAnswerOptions([...options]);
		setKey(key-1);
	}


	return (
		<>
			<h3>Create Question</h3>

			<Form onSubmit={ e => onSubmit(e)}>
				<Form.Row>
					<Form.Control type="text" placeholder="question" name="question" />
				</Form.Row>
				<Form.Row>
					<Form.Control type="text" placeholder="category" name="category" />
				</Form.Row>
				<Form.Row>
					<Form.Check type="checkbox" label="Public" id="publicCheck" onChange={checkChange} />
				</Form.Row>
				{ answerOptions }
				<Form.Row>
					<Button variant="primary" onClick={addAnswerOption}>+</Button>
					<Button variant="danger" onClick={removeAnswerOption}>-</Button>
				</Form.Row>
				<Form.Row>
					<Button type="submit">Create Question</Button>
				</Form.Row>

			</Form>
		</>
	);
};

export default Create;