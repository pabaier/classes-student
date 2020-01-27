import React from 'react';
import { connect } from "react-redux";
import { logIn } from "../actions/index"

const mapStateToProps = state => {
	return { isLoggedIn: state.user.isLoggedIn };
}

const connectedLogin = ( {isLoggedIn, dispatch} ) => {
	return (
		<div>
			<h2>Login</h2>
			<br />
			{
				isLoggedIn ? <h3>Logged In!</h3> : <h3>Please log in...</h3>
			}
			<button onClick={() => {
						dispatch(logIn())
					}}>
				click to {isLoggedIn ? 'log out' : 'log in'}
			</button>
		</div>
	);
};

const Login = connect(mapStateToProps)(connectedLogin)

export default Login;