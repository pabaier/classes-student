import React from 'react';
import { Field, reduxForm } from "redux-form"
import { logIn } from "../actions/index";

const LoginForm1 = () => {
	const [username, setUsername] = React.useState('');
	const [password, setPassword] = React.useState('');

	const handleUserChange = event => {
	  setUsername(event.target.value);
	};

	const handlePasswordChange = event => {
		setPassword(event.target.value);
	  };

	const handleSubmit = event => {
		// console.log(event);
		event.preventDefault();
	};


	return (
		<form onSubmit={handleSubmit}>
			<h1>Log In Form</h1>
			<input type="text" name="username" placeholder="username" value={username} onChange={handleUserChange}></input>
			<br />
			<input type="password" name="password" placeholder="password" value={password} onChange={handlePasswordChange}></input>
			<br />
			<button type="submit">log in </button>
		</form>
	)
}

// export default LoginForm;

let LoginForm = props => {
	const { handleSubmit } = props
	return (
		<form onSubmit={ handleSubmit }>
			<Field name="username" component="input" type="text" placeholder="username" />
			<br />
			<Field name="password" component="input" type="password" placeholder="password" />
			<br />
			<button type="submit">Login</button>
		</form>
	)
	
}

LoginForm = reduxForm({
	form: 'login'
})(LoginForm)

export default LoginForm;
