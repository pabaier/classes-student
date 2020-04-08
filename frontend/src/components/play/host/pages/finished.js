import React from 'react';
import LeaderBoard from '../../leaderboard'

const Finished = ({data}) => {

	return (
		<LeaderBoard data={data} title={'Final Results'}></LeaderBoard>
	)
}

export default Finished;