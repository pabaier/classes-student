import { Button, Modal } from 'react-bootstrap'
import React, { useState } from 'react';
import Login from "./Login"


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
		<Modal.Header closeButton>
		  <Modal.Title id="contained-modal-title-vcenter">
			Login
		  </Modal.Title>
		</Modal.Header>
		<Modal.Body>
			<Login />
		</Modal.Body>
		<Modal.Footer>
		  <Button  onClick={handleClose}>Close</Button>
		</Modal.Footer>
	  </Modal>
	);
  }

export default Splash;