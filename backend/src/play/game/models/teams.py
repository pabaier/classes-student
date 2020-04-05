import json


class Team():
    def __init__(self):
        self.players = []
        self.roundScore = 0
        self.totalScore = 0


class Teams():
    def __init__(self):
        self.teams = {}

    def add(self, name, team=None) -> Team:
        if not team:
            team = Team()
        self.teams[name] = team
        return self.teams[name]

    def get(self, name) -> Team:
        return self.teams[name]

    def get_team_keys(self):
        return list(self.teams.keys())

    def sort_by_total_score(self):
        ''' Returns list of {'totalScore': '7', 'name': 'team go'} '''

        sorted_teams = []
        for index, team_tuple_id_value in enumerate(
                sorted(self.teams.items(), key=lambda team: team[1].totalScore, reverse=True), start=1):
            team_name = team_tuple_id_value[0]
            team_total_score = self.teams[team_name].totalScore
            sorted_teams.append({
                'name': team_name,
                'totalScore': team_total_score
            })
        return sorted_teams

    def toDict(self):
        ''' returns a dict of channel keys and player object values'''
        json_string = json.dumps(self.teams, default=lambda x: x.__dict__)
        return json.loads(json_string)

    def __iter__(self):
        ''' returns the Iterator object '''
        return TeamsIterator(self)


class TeamsIterator:
    ''' Iterator class '''

    def __init__(self, teams):
        self._teams_keys = teams.get_team_keys()
        self._teams = teams
        # member variable to keep track of current index
        self._index = 0

    def __next__(self):
        ''''Returns the next value from team object's lists '''
        if self._index < len(self._teams_keys):
            result = self._teams.get(self._teams_keys[self._index])
            self._index += 1
            return result
        # End of Iteration
        raise StopIteration
