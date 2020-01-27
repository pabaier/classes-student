import { LOG_IN } from "../constants/action-types";

export function logIn(payload) {
	return { type: LOG_IN, payload}
};