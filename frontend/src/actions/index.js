import { LOG_IN, LOG_OUT, SET_QUESTIONS, SET_PUBLIC_QUESTIONS } from "../constants/action-types";

const baseURL = 'http://127.0.0.1:8000/'

export function logIn(payload) {
	return { type: LOG_IN, payload}
}

export function logOut(payload) {
	return { type: LOG_OUT, payload}
}

async function postData(url = '', data = {}) {
	// Default options are marked with *
	const response = await fetch(url, {
		method: 'POST', // *GET, POST, PUT, DELETE, etc.
		mode: 'cors', // no-cors, *cors, same-origin
		cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
		credentials: 'same-origin', // include, *same-origin, omit
		headers: {
			'Content-Type': 'application/json'
			// 'Content-Type': 'application/x-www-form-urlencoded',
		},
		redirect: 'follow', // manual, *follow, error
		referrerPolicy: 'no-referrer', // no-referrer, *client
		body: JSON.stringify(data) // body data type must match "Content-Type" header
	});
	return await response; // parses JSON response into native JavaScript objects
}

const handleError = (e) => {
	throw Error(e.statusText)
}

export function postLogIn(payload) {
	return function(dispatch, getState) {

		postData(baseURL + 'auth/jwt-token/', payload.creds)
		.then(res => res.ok? res.json() : handleError(res))
		.then((data) => {
			dispatch(logIn(data));
			payload.loginSuccess()
		})
		.catch(console.log)
		;
	}
};

export function setPublicQuestions(payload) {
	return { type: SET_PUBLIC_QUESTIONS, payload}
}

export function getPublicQuestions() {
	return function(dispatch, getState) {
		fetch(baseURL + 'questions/public')
		.then(res => res.json())
		.then((data) => {
			dispatch(setPublicQuestions(data));
		})
		.catch(console.log)
	}
}

export function getQuestions() {
	return (dispatch, getState) => {
	  const token = getState().root.user.access;
	  dispatch(getQuestionData(token));
	}
}

const getQuestionData = token => {
	return function(dispatch, getState) {
		getData(baseURL + 'questions/details', token)
		.then(res => res.ok? res.json() : handleError(res))
		.then((data) => {
			dispatch(setQuestions(data));
		})
		.catch(console.log);
	}
}

export function setQuestions(payload) {
	return { type: SET_QUESTIONS, payload}
}

async function getData(url = '', token = '') {
	const response = await fetch(url, {
		method: 'GET', // *GET, POST, PUT, DELETE, etc.
		mode: 'cors', // no-cors, *cors, same-origin
		cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
		credentials: 'same-origin', // include, *same-origin, omit
		headers: {
			'Content-Type': 'application/json',
			'Authorization': 'Bearer ' + token,
			// 'Content-Type': 'application/x-www-form-urlencoded',
		},
		redirect: 'follow', // manual, *follow, error
		referrerPolicy: 'no-referrer', // no-referrer, *client
	});
	return response;
}