import React from 'react';
import Wait from './wait'
import EnterName from './enterName'

const WAITING_TO_PLAY = "WAITING_TO_PLAY"
const ENTERING_NAME = "ENTERING_NAME"
const ANSWERING_QUESTION = "ANSWERING_QUESTION"
const DONE_QUESTION = "DONE_QUESTION"

function ClientState (state, {ws:websocket, sendMessage:callback, setclientState}) {
	switch(state) {
		case WAITING_TO_PLAY:
			return <Wait ws={websocket}/>;
		case ENTERING_NAME:
			return <EnterName ws={websocket} callback={callback} setState={setclientState}/>;
		default:
			return null;
	}
}

export {
	WAITING_TO_PLAY,
	ENTERING_NAME,
	ANSWERING_QUESTION,
	DONE_QUESTION,
	ClientState,
}