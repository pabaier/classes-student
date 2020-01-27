import { LOG_IN, SET_PUBLIC_QUESTIONS } from "../constants/action-types";

const baseURL = 'http://127.0.0.1:8000/'

export function logIn(payload) {
	return { type: LOG_IN, payload}
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