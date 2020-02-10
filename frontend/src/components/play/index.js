import React, { useEffect } from 'react';
import { connect } from "react-redux";
import { useParams } from 'react-router-dom'

const Play = () => {
	let { id, numId=+id } = useParams()


	// ws = new WebSocket('ws://localhost:8000/ws/host')

	return (
		<h3>Play Game {numId}</h3>
	)
}

export default Play;


