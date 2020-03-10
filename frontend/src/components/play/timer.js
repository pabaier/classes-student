import React from 'react';

const Timer = ({time, sendMessage}) => {

	const stop = () => {
		sendMessage('stop');
	}

	setTimeout(() => { stop(); }, time * 1000);

	return (
		<div>Timer: {time}</div>
	)
}

export default Timer;