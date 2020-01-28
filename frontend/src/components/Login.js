import React from 'react';
import { connect } from "react-redux";
import { postLogIn, logOut } from "../actions/index";
import LoginForm from "./LoginForm";

const mapStateToProps = state => {
	return { isLoggedIn: state.root.user.isLoggedIn };
}

const connectedLogin = ( {isLoggedIn, dispatch} ) => {
	const loginSubmit = values => {
		dispatch(postLogIn(values))
	}

	return (
		<div>
			<h2>Login</h2>
			<br />
			{
				isLoggedIn ? <h3>Logged In!</h3> : <LoginForm onSubmit={loginSubmit} />
			}
			{
				isLoggedIn ? <button onClick={() => {dispatch(logOut())}}> Logout </button> : null
			}
		</div>
	);
};

const Login = connect(mapStateToProps)(connectedLogin)

export default Login;