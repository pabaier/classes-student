import React from 'react';
import { Button, Navbar, Nav, NavDropdown, Form, FormControl } from 'react-bootstrap'
import { Link, NavLink } from 'react-router-dom'

const Navb = () => (
	<Navbar bg="light" expand="lg">
	<Navbar.Brand as={Link} to='/'>React-Bootstrap</Navbar.Brand>
	<Navbar.Toggle aria-controls="basic-navbar-nav" />
	<Navbar.Collapse id="basic-navbar-nav">
		<Nav className="mr-auto">
		{/* <Nav.Link href="/">Home</Nav.Link> */}
		<Nav.Link as={NavLink} to='/' exact>Home</Nav.Link>
		<Nav.Link as={NavLink} to='/about'>About</Nav.Link>
		<NavDropdown title="Topics" id="basic-nav-dropdown" as={NavLink} to='/topics'>
			<NavDropdown.Item as={NavLink} to="/topics/components">Components</NavDropdown.Item>
			<NavDropdown.Item as={NavLink} to="/topics/props-v-state">Props v. State</NavDropdown.Item>
			<NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
			<NavDropdown.Divider />
			<NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
		</NavDropdown>
		</Nav>
		<Form inline>
		<FormControl type="text" placeholder="Search" className="mr-sm-2" />
		<Button variant="outline-success">Search</Button>
		</Form>
	</Navbar.Collapse>
	</Navbar>
);

export default Navb;