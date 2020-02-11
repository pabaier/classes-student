import React, { useEffect } from 'react';
import { connect } from "react-redux";
import { useParams } from 'react-router-dom'
import { activateGame } from "../../actions/play"

const mapStateToProps = (state, {location: {game}}) => {
	return { activeGame: state.root.activeGame, game };
}

const ConnectedHost = ( {activeGame, game, dispatch} ) => {
	let { id, numId=+id } = useParams()

	useEffect(() => {
		if(!activeGame){
			dispatch(activateGame(id));
		}
	}, [dispatch, id, activeGame]);

	if(activeGame){
		const ws = new WebSocket(`ws://localhost:8000/ws/host/${activeGame.slug}/`)

		return (
			<div>
				<h3>Play Game {game ? game.name : ''}</h3>
				<h5>pin: {activeGame.slug}</h5>
			</div>
		)
	}
	return (<div></div>)
	
}

const Host = connect(mapStateToProps)(ConnectedHost)

export default Host;