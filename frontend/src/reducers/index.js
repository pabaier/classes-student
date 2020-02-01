import { LOG_IN, LOG_OUT, SET_PUBLIC_QUESTIONS } from "../constants/action-types";
import { combineReducers } from "redux";

const initialState = {
	user: {
		isLoggedIn: true,
		access: '',
		refresh: '',
	},
	questions: [],
};

const rootReducer = combineReducers({
	root: appReducer,
})

function appReducer(state = initialState, action) {
	switch (action.type) {
		case LOG_IN:
			return Object.assign({}, state, {
				user: {
					...state.user,
					isLoggedIn: true,
					...action.payload
				}
			})
		case LOG_OUT:
			return Object.assign({}, state, {
				user: {
					...state.user,
					isLoggedIn: false,
					access: '',
					refresh: '',
				}
			})
		case SET_PUBLIC_QUESTIONS:
			return Object.assign({}, state, {
				questions: action.payload.results
			})
		default:
			return state;
	}
  }

export default rootReducer;

// function rootReducer(state = initialState, action) {
// 	if (action.type === ADD_ARTICLE) {
// 		return Object.assign({}, state, {
// 			articles: state.articles.concat(action.payload)
// 		});
// 	}
// 	return state;
// };

// function login(state = false, action) {
// 	switch (action.type) {
// 		case LOG_IN:
// 			console.log('*******', state);
// 			return !state;
// 	}
// }

// const rootReducer = (state = initialState, action) => {
// 	console.log('*******', state);
// 	return {
// 		isLoggedIn: login(state.user.isLoggedIn, action),
// 	}
// };