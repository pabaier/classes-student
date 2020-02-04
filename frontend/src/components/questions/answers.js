import React from 'react';

const Answers = ( {answers} ) => {
	const listItems = answers.map( (a) => (
		<li key={'a'+a.id}>{a.option} {a.isAnswer? "*" : ""}</li>
	));

	return (
		<ul>
			{ listItems }
		</ul>
	);
}

export default Answers
