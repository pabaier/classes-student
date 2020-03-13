import React, {useState, useEffect, useRef} from 'react';

const Timer = ({time, sendMessage, startTime}) => {
	const [vars, setVars] = useState({'timeLeft': time, 'startTime': startTime})
	const t = useRef(time);

	const calculateTimeLeft = () => {
		t.current -= 1;
		if(t.current < 0)
			stop()
		else
			setVars({...vars, 'timeLeft': t.current});
	}

	useEffect(() => {
		if(startTime != vars.startTime) {
			setVars({'timeLeft': time, 'startTime': startTime});
			t.current = time;
		}
		else {
			const timer = setTimeout(() => {
				calculateTimeLeft();
			}, 1000);
			return () => {clearTimeout(timer);};
		}
	  });

	const stop = () => {
		sendMessage('stop');
	}

	return (
		<div>
			<div>Timer: {vars.timeLeft}</div>
		</div>
	)
}

export default Timer;