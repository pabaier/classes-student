import React, {useState, useEffect, useRef} from 'react';

const Timer = ({time, sendMessage}) => {
	const [timeLeft, setTimeLeft] = useState(time);
	const timeStart = useRef(Date.now());
	
	const calculateTimeLeft = () => {
		var millis = Date.now() - timeStart.current;
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