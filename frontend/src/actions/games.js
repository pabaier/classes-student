import { SET_GAMES } from "../constants/action-types";
import * as api from "./api"

const baseURL = 'http://127.0.0.1:8000/'

const handleError = (e) => {
	throw Error(e.statusText)
}

export function getGame() {
	return (dispatch, getState) => {
		const games = getState().root.games
		if(games.length <= 0) {
			dispatch(getGameData());
		}
	}
}

export function getGames() {
	return (dispatch, getState) => {
	  dispatch(getGameData());
	}
}

const getGameData = () => {
	return function(dispatch, getState) {
		api.getData(baseURL + 'games/details', getState().root.user.access)
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