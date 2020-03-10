import React from 'react';
import { Button } from 'react-bootstrap'

const Connect = ({data}) => {

	return (
		<div>
			<h1>Players</h1>
			<h3>{data.players ? data.players : ''}</h3>
		</div>
	)
}

export default Connect;