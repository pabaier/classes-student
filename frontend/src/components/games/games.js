import React, { useEffect } from 'react';
import { connect } from "react-redux";
import { getGames } from "../../actions/games"
import { ListGroup, Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';
import { useHistory } from "react-router-dom";

const mapStateToProps = state => {
	return { games: state.root.games };
}

const ConnectedGames = ( {games=[], dispatch} ) => {
	useEffect(() => {
		dispatch(getGames());
	}, [dispatch]);

	let history = useHistory();

	const play = (gameId, team=false) => {
		history.push({
			pathname: `/play/host/${gameId}`,
			team
		})
	}

	const listItems = games.map( (g, index) => {

		return (
		<ListGroup.Item key={'g'+g.id}
			variant={index%2===0 ? 'light' : null}
		>
			<Link to={`/games/${g.id}`}>
				{g.name} - {g.questions.length} questions
			</Link>
			-
			<Button  variant="outline-info" onClick={() => play(g.id, true)}>
				play team
			</Button>
			<Button  variant="outline-warning" onClick={() => play(g.id, false)}>
				play individual
			</Button>

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