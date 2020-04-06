import React, { useEffect } from 'react';
import { connect } from "react-redux";
import { getGames } from "../../actions/games"
import { ListGroup, Button, Form, Container, Row, Col } from 'react-bootstrap';
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

	const dropdown = () => {
			let a = []
			for(let i = 2; i<=20; i++ ) {
				a.push(<option key={i} value={i}>{i}</option>)
			}
			return a
	}

	const onSubmit = (e) => {
		e.preventDefault();
		var teamNumber = 0

		const name = e.target.elements[0].name;
		const nameArray = name.split('-');
		const gameId = nameArray[0];
		const gameType = nameArray[1]
		const team = gameType === 'team' 
		if (team)
			teamNumber = e.target.elements[1].value

		history.push({
			pathname: `/play/host/${gameId}`,
			teamNumber
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
				<Container>
					<Row>
						<Col>
							<Form onSubmit={ e => onSubmit(e)}>
								<Button  variant="outline-info" name={g.id + '-team'} type='submit'>
									play team
								</Button><br/>
								<Form.Label>Number of teams: </Form.Label>
								<Form.Control as="select" size="sm" style={{ width: '25%' }} name={g.id + '-team-amount'}>
									{dropdown()}
								</Form.Control>
							</Form>
						</Col>
						<Col>
							<Form onSubmit={ e => onSubmit(e)}>
								<Button  variant="outline-warning"  name={g.id + '-individual' } type='submit'>
									play individual
								</Button>
							</Form>
						</Col>
					</Row>
				</Container>
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