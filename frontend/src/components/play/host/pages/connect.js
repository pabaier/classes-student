import React, { useState, useEffect } from 'react';
import { Button } from 'react-bootstrap'

const Connect = ({data, pin}) => {
	console.log(data)
	const [players, setPlayers] = useState([]);

	useEffect(() => {
		setPlayers(data.players)
	}, [data.players]);

	var printPlayers = () => {
		return players.map( (value, index) => (
			<li key={index}>{value}</li>
		))
	}

	return (
		<div>
			<h5>Game pin: {pin}</h5>
			<h1>Players</h1>
			<ul>
				{printPlayers()}
			</ul>
		</div>
	)
}

export default Connect;