import Header from "./Components/Header/Header";
import Register from "./Components/Register/Register";
import {
  BrowserRouter as Router,
  Redirect,
  Route,
  Switch,
} from "react-router-dom";
import Login from "./Components/Login/Login";
import Home from "./Components/Home/Home";
import PrivateRoute from "./Components/PrivateRoute";
import MyFavorites from "./Components/MyFavorites/MyFavorites";

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path="/">
            {localStorage.getItem("isAuthenticated") === "true" ? (
              <Redirect to="/home" />
            ) : (
              <Redirect to="/login" />
            )}
          </Route>
          <Route exact path="/login" component={Login} />
          <Route exact path="/register" component={Register} />
          <PrivateRoute exact path="/home" component={Home} />
          <PrivateRoute exact path="/favorites" component={MyFavorites} />
        </Switch>
      </Router>
    </div>
  );
}

export default App;
