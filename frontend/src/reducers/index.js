import { LOG_IN } from "../constants/action-types";
// import { combineReducers } from "redux";

const initialState = {
	user: {
		isLoggedIn: true
	},
	questions: [],
};

function rootReducer(state = initialState, action) {
	switch (action.type) {
	  case LOG_IN:
		return Object.assign({}, state, {
		  user: {
			  isLoggedIn: !state.user.isLoggedIn,
		  }
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