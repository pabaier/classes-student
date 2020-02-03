import React, { useEffect } from 'react';
import { connect } from "react-redux";
import { getGames } from "../../actions/games"


const mapStateToProps = state => {
	return { games: state.root.games };
}

const ConnectedGames = ( {games=[], dispatch} ) => {
	useEffect(() => {
		// {console.log(games)}
		dispatch(getGames());
	}, [dispatch]);

	const listItems = games.map( (g) => (
	<li key={'g'+g.id}>{g.name} - {g.questions.length} questions</li>
	));

	return (
		<div>
			<h2>Games</h2>
			<ul>
				{ listItems }
			</ul>
			<br />
		</div>
	);
};

const Games = connect(mapStateToProps)(ConnectedGames)

export default Games;