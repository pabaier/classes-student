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

	let i = 0;
	const listItems = games.map( (g) => {
		i = i + 1;
		if(i>3){i=0}
		return (
		<ListGroup.Item action href={'/games/' + g.id} key={'g'+g.id}
			variant={i%4===0 ? 'warning' : i%3===0 ? 'info' : i%2===0 ? 'secondary' : null}
		>
			{g.name} - {g.questions.length} questions
		</ListGroup.Item>)
	});

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