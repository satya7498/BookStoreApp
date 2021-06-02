import React, { useState } from "react";
import { Link, useHistory } from "react-router-dom";
import ErrorMessage from "../ErrorMessage";
import Header from "../Header/Header";

export default function Register() {
  const [username, setusername] = useState("");
  const [password, setpassword] = useState("");
  const [emailid, setemailid] = useState("");
  const [error, setError] = useState("");
  const history = useHistory();

  function registerUser(event) {
    console.log("handling submit event");
    event.preventDefault();
    fetch(`http://localhost:8090/register`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        username: username,
        emailid: emailid,
        password: password,
      }),
    })
      .then((res) => res.json())
      .then((data) => {
        console.log(data);
        history.push("/login");
      })
      .catch((err) => {
        setError(err);
      });
  }
  return (
    <>
      <Header />
      <div
        className="container d-flex align-items-center justify-content-center align-center my-auto "
        style={{ minHeight: "800px" }}
      >
        <div className="card main my-5">
          <div className="row" style={{ minHeight: "600px" }}>
            <div className=" col-lg-5 col-md-5 col-sm-12 col-xs-12">
              <img
                src="images/signup2.jpg"
                alt="Paris"
                className=" imgLogin"
                width="100%"
                height="100%"
              />
            </div>
            <div className="col-lg-7 col-md-7 col-sm-12 col-xs-12 d-flex  justify-content-center align-items-center">
              <div className="d-flex w-100  justify-content-center align-self-center">
                <form onSubmit={registerUser} className="text-center">
                  <h2
                    data-testid="registerheading"
                    id="registerhead"
                    className="my-4 header"
                  >
                    Create New Account
                  </h2>
                  <div className="form-group  mb-2">
                    <i className="fas fa-user fa-lg fa-lg px-2 mt-2"></i>
                    <input
                      className="text-center rounded-pill px-lg-5 px-4 p-1 bg-input text-center"
                      type="text"
                      id="username"
                      placeholder="* Username"
                      onChange={(e) => setusername(e.target.value)}
                      required
                    />
                  </div>
                  <div className="form-group mb-2">
                    <i className="fas fa-envelope fa-lg px-2 mt-2"></i>
                    <input
                      className="text-center rounded-pill px-lg-5 px-4 p-1 bg-input text-center"
                      type="text"
                      id="registeremail"
                      placeholder="* Email"
                      onChange={(e) => setemailid(e.target.value)}
                      required
                    />
                  </div>
                  <div className="form-group mb-2">
                    <i className="fas fa-lock fa-lg fa-lg px-2 mt-2"></i>
                    <input
                      className="text-center rounded-pill px-lg-5 px-4 p-1 bg-input text-center"
                      type="password"
                      id="registerpassword"
                      placeholder="* Password"
                      onChange={(e) => setpassword(e.target.value)}
                      required
                    />
                  </div>
                  <button
                    className="butt text-center"
                    type="submit"
                    id="btnRegister"
                  >
                    CREATE ACCOUNT
                  </button>
                  <p
                    data-testid="registerpara"
                    className="text-center my-4 mb-2"
                  >
                    Already have an account?
                    <Link to="/login" id="refertologin" className="px-1">
                      Login
                    </Link>{" "}
                  </p>
                  <ErrorMessage error={error} />
                </form>
              </div>
            </div>
          </div>
          {/* <Snackbar className={classes.root} open={open} anchorOrigin={{ vertical: 'top', horizontal: 'center' }} autoHideDuration={5000} onClose={handleClose}>
                   <Alert onClose={handleClose} severity={color}>
                       {error}
                   </Alert>
               </Snackbar> */}
        </div>
      </div>
    </>
  );
}
