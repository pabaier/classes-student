import React from 'react';

const Leaderboard = ({data, title}) => {
	const leaderboard = () => {
		return data.map((entry, i) => (
			<li key={i}>{entry.name}.......{entry.totalScore}</li>
		))
	}
	return (
		<div>
			<h3>{title}</h3>
			<ol>
				{leaderboard()}
			</ol>
		</div>
	)
}

export default Leaderboard;