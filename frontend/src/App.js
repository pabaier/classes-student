import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";
import Navb from './components/Navb';
import PrivateRoute from './components/PrivateRoute';
import Splash from './components/Splash'
import { Games, PublicGames, GamePage } from './components/games'
import { Questions, PublicQuestions } from "./components/questions";
import { Host, Client } from "./components/play";

const App = () => {
  return (
    <div>
      <Router>
        <div>
          <Switch>
            <Route path="/login">
              <Splash />
            </Route>
            <Route path="/play/join/:token" component={Client} />
            <PrivateRoute path="/" component={LoggedIn} />
          </Switch>
        </div>
      </Router>
    </div>
  )
}

const LoggedIn = () => (
  <div>
    <Navb />
    <Route path="/games" component={Games} exact />
    <Route path="/games/:id" component={GamePage} />
    <Route path="/games/public" component={PublicGames} />
    <Route path="/play/host/:id" component={Host} />
    <Route exact path="/questions">
      <Questions />
    </Route>
    <Route path="/questions/public">
      <PublicQuestions />
    </Route>
    <Route exact path="/">
      <Home />
    </Route>
  </div>
)

const Home = () => {
  return <h2>Home</h2>;
}

export default App;