import React from 'react';
import LeaderBoard from '../../leaderboard'

const PostQuestion = ({data}) => {
	return (
		<LeaderBoard data={data} title={'Standings'}></LeaderBoard>
	)
}

export default PostQuestion;