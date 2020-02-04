import React, { useEffect } from 'react';
import { connect } from "react-redux";
import { useParams } from 'react-router-dom'
import { getGame } from "../../actions/games"

// const Game = ( props ) => {
// 	{console.log(props.location.game)}
// 	return (
// 		<h3>Game</h3>
// 	)
// }

const mapStateToProps = state => {
	return { games: state.root.games };
}

const ConnectedGame = ( {games, dispatch}) => {
	let { id, numId=+id } = useParams()
	useEffect(() => {
		dispatch(getGame());
	}, [dispatch]);
	const game = games.filter(g => {
		return g.id === numId
	  })[0]
	if (game) {
		return (
			<div>
				<h2>This is Game #{game.id} </h2>
				<div>
					{
						console.log(game),
						game.name
					}
				</div>
			</div>
		);
	}
	return <h2> No Games </h2>;
  }

const Game = connect(mapStateToProps)(ConnectedGame)

export default Game;