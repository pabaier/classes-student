import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  useRouteMatch,
  useParams
} from "react-router-dom";
import Navb from './components/Navb';
import Login from './components/Login';
import PublicQuestions from './components/PublicQuestions';
import PrivateRoute from './components/PrivateRoute';

const App = () => {
  return (
    <div>
      <Router>
        <div>
          <Switch>
            <Route path="/login">
              <Login />
            </Route>
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
    <Route path="/about" component={About} />
    <Route path="/topics">
      <Topics />
    </Route>
    <Route path="/publicQuestions">
      <PublicQuestions />
    </Route>
    <Route path="/home">
      <Home />
    </Route>
  </div>
)

const Home = () => {
  return <h2>Home</h2>;
}

function About() {
  return <h2>About</h2>;
}

function Topics() {
  let match = useRouteMatch();

  return (
    <div>
      <h2>Topics</h2>

      <ul>
        <li>
          <Link to={`${match.url}/components`}>Components</Link>
        </li>
        <li>
          <Link to={`${match.url}/props-v-state`}>Props v. State</Link>
        </li>
      </ul>

      {/* The Topics page has its own <Switch> with more routes
          that build on the /topics URL path. You can think of the
          2nd <Route> here as an "index" page for all topics, or
          the page that is shown when no topic is selected */}
      <Switch>
        <Route path={`${match.path}/:topicId`}>
          <Topic />
        </Route>
        <Route path={match.path}>
          <h3>Please select a topic.</h3>
        </Route>
      </Switch>
    </div>
  );
}

function Topic() {
  let { topicId } = useParams();
  return <h3>Requested topic ID: {topicId}</h3>;
}

export default App;