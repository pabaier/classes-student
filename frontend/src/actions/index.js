import { LOG_IN, LOG_OUT, SET_QUESTIONS, SET_PUBLIC_QUESTIONS } from "../constants/action-types";
import * as api from './api';

const baseURL = 'http://127.0.0.1:8000/'

export function logIn(payload) {
	return { type: LOG_IN, payload}
}

export function logOut(payload) {
	return { type: LOG_OUT, payload}
}

const handleError = (e) => {
	throw Error(e.statusText)
}

export function postLogIn(payload) {
	return function(dispatch, getState) {
		api.postData(baseURL + 'auth/jwt-token/', payload.creds)
		.then(res => res.ok? res.json() : handleError(res))
		.then((data) => {
			dispatch(logIn(data));
			payload.loginSuccess()
		})
		.catch(console.log);
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
	  dispatch(getQuestionData());
	}
}

const getQuestionData = () => {
	return function(dispatch, getState) {
		api.getData(baseURL + 'questions/details', getState().root.user.access)
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