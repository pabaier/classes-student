import React, { useEffect } from 'react';
import { connect } from "react-redux";
import { getGames } from "../../actions/games"
import { ListGroup, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';

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
		const linkTo = {
			pathname: `/play/${g.id}`,
			game: g
		}
		return (
		<ListGroup.Item key={'g'+g.id}
			variant={i%4===0 ? 'warning' : i%3===0 ? 'info' : i%2===0 ? 'secondary' : null}
		>
			<Link to={linkTo}>
				{g.name} - {g.questions.length} questions
			</Link>
			-
			<Link to={`/games/${g.id}`}>
				<Button  variant="outline-secondary">
					edit
				</Button>
			</Link>
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