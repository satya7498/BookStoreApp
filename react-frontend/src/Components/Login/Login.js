import React, { useState, useContext } from "react";
import { Link, useHistory } from "react-router-dom";
import { AuthContext } from "../AuthProvider";
import ErrorMessage from "../ErrorMessage";
import Header from "../Header/Header";

export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const history = useHistory();
  const { login } = useContext(AuthContext);

  function loginUser(event) {
    console.log("handling submit event");
    event.preventDefault();
    fetch(`http://localhost:8090/authenticate`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        username: username,
        password: password,
      }),
    })
      .then((res) => {
        return res.json();
      })
      .then(async (data) => {
        if (data.error) {
          throw data;
        }
        console.log(data.token);
        await login(data.token);
        history.push("/home");
      })
      .catch((err) => setError(err.message));
  }

  return (
    <>
      <Header />
      <div
        className="container d-flex align-items-center justify-content-center"
        style={{ minHeight: "800px" }}
      >
        <div className="card main">
          <div className="row" style={{ minHeight: "600px" }}>
            <div className=" col-lg-5 col-md-5 col-sm-12 col-xs-12">
              <img
                className="imgLogin"
                src="images/signup2.jpg"
                alt="Paris"
                width="100%"
                height="100%"
              />
            </div>
            <div className="col-lg-7 col-md-7 col-sm-12 col-xs-12 d-flex  justify-content-center align-items-center">
              <form onSubmit={loginUser} className="text-center">
                <h2
                  data-testid="loginheader"
                  id="loginhead"
                  className="my-4 header "
                >
                  Login
                </h2>
                <div className="form-group d-flex mb-2">
                  <i className="fas fa-envelope fa-lg px-2 mt-2"></i>
                  <input
                    id="loginuser"
                    className="text-center rounded-pill px-4 p-1 bg-input"
                    value={username}
                    type="text"
                    placeholder="Username"
                    onChange={(e) => setUsername(e.target.value)}
                  />
                </div>
                <div className="form-group">
                  <i className="fas fa-lock fa-lg px-2 mt-2"></i>
                  <input
                    className="text-center rounded-pill px-4 p-1 bg-input"
                    id="loginpassword"
                    value={password}
                    type="password"
                    placeholder="Password"
                    onChange={(e) => setPassword(e.target.value)}
                  />
                </div>
                <div className="text-center ">
                  <button className="butt" type="submit" id="btnLogin">
                    Login
                  </button>
                </div>
                <p data-testid="loginpara" className="text-center my-4 mb-2">
                  Don't have an account?
                  <Link to="/register" className="px-1">
                    Register
                  </Link>{" "}
                </p>
                <ErrorMessage error={error} />
              </form>
            </div>
          </div>
        </div>
        {/* <Snackbar className={classes.root} open={open} anchorOrigin={{ vertical: 'top', horizontal: 'center' }} autoHideDuration={3000} onClose={handleClose}>
               <Alert onClose={handleClose} severity={color}>
                   {error}
               </Alert>
           </Snackbar> */}
      </div>
    </>
  );
}
