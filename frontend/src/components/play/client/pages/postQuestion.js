import React from 'react';

const displayTotalScore = (score, rank) => {
	return (
		<div>
			You are in {rank}{placeSuffix(rank)} place{rank === 1 ? '!' : ''}<br />
			Total Score: {score}
		</div>
	)
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

const placeSuffix = (value) => {
	switch (value % 10) {
		case 1:
			return 'st'
		case 2:
			return 'nd'
		case 3:
			return 'rd'
		default:
			return 'th'
	}
}

const PostQuestion = ({ data }) => {

	return (
		<div>
			<h3>Post Question</h3>
			<h5>{data.totalScore || data.totalScore >= 0 ? displayTotalScore(data.totalScore, data.rank) : ''}</h5>
			<h5>{data.roundResult ? displayRoundScore(data.roundResult) : ''}</h5>
		</div>
	)
}

export default PostQuestion