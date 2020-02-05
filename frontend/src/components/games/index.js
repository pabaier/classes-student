import React, { useEffect } from 'react';
import { connect } from "react-redux";
import { getGames } from "../../actions/games"
import { ListGroup } from 'react-bootstrap';

const mapStateToProps = state => {
	return { games: state.root.games };
}

const ConnectedGames = ( {games=[], dispatch} ) => {
	useEffect(() => {
		dispatch(getGames());
	}, [dispatch]);

	const listItems = games.map( (g) => (
		<ListGroup.Item action href={'/games/' + g.id} key={'g'+g.id}>
			{g.name} - {g.questions.length} questions
		</ListGroup.Item>
	));

	return (
		<div>
			<h2>Games</h2>
			<ListGroup defaultActiveKey="#link1">
					{listItems}
			</ListGroup>
		</div>
	);
};

const Games = connect(mapStateToProps)(ConnectedGames)

export default Games;