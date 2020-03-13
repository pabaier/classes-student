import React, {useState, useEffect, useRef} from 'react';

const Timer = ({time, sendMessage, startTime}) => {
	const [vars, setVars] = useState({'timeLeft': time, 'startTime': startTime})
	const [timeLeft, setTimeLeft] = useState(time);
	const t = useRef(time);
	const [rendered, setRendered] = useState(startTime);
	console.log('*** render ***');
	console.log('timeLeft', vars.timeLeft);
	console.log('t', t.current);
	console.log('startTime', vars.startTime);
	console.log('--------------------------------')

	const calculateTimeLeft = () => {
		console.log('*** ctl ***')
		// console.log('t current', t.current);
		// console.log('time left', timeLeft);
		// if(timeLeft <= 0){
		// 	// t.current = time
		// 	stop();
		// }
	}

	useEffect(() => {
		console.log('effect')
		if(startTime != vars.startTime) {
			console.log('if');
			setVars({'timeLeft': time, 'startTime': startTime});
			t.current = time;
		}
		else {
			console.log('else')
			const timer = setTimeout(() => {
			  calculateTimeLeft();
			  console.log('after ctl')
			  t.current -= 1;
			  if(t.current < 0)
				stop()
			  else
			  	setVars({...vars, 'timeLeft': t.current});
			}, 1500);
			return () => {clearTimeout(timer);};
		}
	  });

	const stop = () => {
		console.log('stop');
		sendMessage('stop');
	}

	return (
		<div>
			<div>Timer: {vars.timeLeft}</div>
		</div>
	)
}

export default Timer;