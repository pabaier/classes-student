import React from 'react';
import { Button } from 'react-bootstrap'

const MakeTeams = ({data}) => {

	var printTeams = (teams) => {
		if(!teams) return <div></div>;
		var teamNames = Object.keys(teams);
		return (
			<div>
				{
					teamNames.map( (name, i) => (
						<div key={i}>
							<h3>{name}</h3>
							<ul>
								{listPlayers(teams[name])}
							</ul>
						</div>
					))
				}
			</div>
		)
	}

	var listPlayers = (team) => {
		return (
			team.map((player, j) => (
				<li key={j}>{player}</li>
			))	
		)
	}

	return (
		<div>
			<h1>Teams</h1>
			{printTeams(data)}
		</div>
	)
}

export default MakeTeams;