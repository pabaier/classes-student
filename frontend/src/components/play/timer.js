import React, {useState, useEffect} from 'react';

const Timer = ({time, start, sendMessage}) => {
	const [timeLeft, setTimeLeft] = useState(time);
	
	const calculateTimeLeft = () => {
		var millis = Date.now() - start;
		var left = time - Math.floor(millis/1000)
		setTimeLeft(left);
		if(left <= 0){
			stop();
		}
		return left;
	}

	useEffect(() => {
		const timer = setTimeout(() => {
		  setTimeLeft(calculateTimeLeft());
		}, 1000);
		return () => {clearTimeout(timer)};
	  });

	const stop = () => {
		sendMessage('stop');
	}

	return (
		<div>
			<div>Timer: {timeLeft}</div>
		</div>
	)
}

export default Timer;