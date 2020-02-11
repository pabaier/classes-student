import { Button, Modal, Container, Row, Col, Form } from 'react-bootstrap'
import React, { useState } from 'react';
import { Login } from './auth/'

function Splash(props) {
	const [show, setShow] = useState(true);
	const handleClose = () => setShow(false);

	return (
	  <Modal
		{...props}
		size="lg"
		aria-labelledby="contained-modal-title-vcenter"
		centered
		onHide={handleClose}
		show={show}
	  >
		<Modal.Header>
		  <Modal.Title id="contained-modal-title-vcenter">
			Login
		  </Modal.Title>
		</Modal.Header>
		<Modal.Body>
			<Container>
				<Row className="show-grid text-center" >
					<Col className="border-right">
						<Login />
						<br />
					</Col>
					<Col className="align-self-center">
						<Button  onClick={handleClose}>Sign Up!</Button>
					</Col>
				</Row>
			</Container>
		</Modal.Body>
		<Modal.Footer className="d-block">
			<Form>
				<Form.Row >
						<Col>
							<Form.Control type="text" placeholder="Enter Game ID" />
						</Col>
						<Col>
							<Button className="show-grid text-left" onClick={handleClose}>Join Game</Button>
						</Col>
				</Form.Row>
			</Form>
		</Modal.Footer>
	  </Modal>
	);
  }

export default Splash;