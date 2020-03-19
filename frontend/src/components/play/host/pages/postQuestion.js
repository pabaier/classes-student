import React from 'react';
import { Button } from 'react-bootstrap'

const PostQuestion = ({data}) => {
	console.log('data', data);
	console.log('scores', data.scores);
	const leaderboard = () => {
		return data.map((entry, i) => (
			<li key={i}>{entry.name}.......{entry.totalScore}</li>
		))
	}
	return (
		<div>
			<h3>Standings</h3>
			<ol>
				{leaderboard()}
			</ol>
		</div>
	)
}

export default PostQuestion;