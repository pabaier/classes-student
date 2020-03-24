import React from 'react';

const displayTotalScore = (score) => {
	return `Your Total: ${score}`;
}

const displayRoundScore = (result) => {
	return (
		<div>
			Last Round:<br />
			<div style={{ paddingLeft: '100px' }}>
				Answer: {result.answer}<br />
				Correct: {result.correct ? "Yes!" : "No"}<br />
				Score: {result.score}<br />
				Time: {result.time}
			</div>
		</div>
	);
}

const PostQuestion = ({ data }) => {

	return (
		<div>
			<h3>Post Question</h3>
			<h5>{data.totalScore ? displayTotalScore(data.totalScore) : ''}</h5>
			<h5>{data.roundResult ? displayRoundScore(data.roundResult) : ''}</h5>
		</div>
	)
}

export default PostQuestion