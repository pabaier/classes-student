import { SET_GAMES } from "../constants/action-types";

const baseURL = 'http://127.0.0.1:8000/'

const handleError = (e) => {
	throw Error(e.statusText)
}

export function getGames() {
	return (dispatch, getState) => {
	  const token = getState().root.user.access;
	  dispatch(getGameData(token));
	}
}

const getGameData = token => {
	return function(dispatch, getState) {
		getData(baseURL + 'games/details', token)
		.then(res => res.ok? res.json() : handleError(res))
		.then((data) => {
			dispatch(setGames(data));
		})
		.catch(console.log);
	}
}

export function setGames(payload) {
	return { type: SET_GAMES, payload}
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