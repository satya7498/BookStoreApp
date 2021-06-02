import React, { useContext, useEffect } from "react";
import { Link } from "react-router-dom";
import "../../App.css";
import { AuthContext } from "../AuthProvider";

export default function Header({ search, searchBooks }) {
  const { user, logout, login } = useContext(AuthContext);

  const logoutUser = () => {
    logout();
  };

  useEffect(() => {
    async function logUser() {
      if (localStorage.getItem("isAuthenticated") === "true") {
        await login(localStorage.getItem("token"));
      }
    }
    logUser();
  }, []);

  const loginButton = (
    <li className="nav-item fw-bold">
      <Link
        to="/login"
        data-cy="header-link-login"
        className="nav-link hoverLink mx-1"
      >
        Login
      </Link>
    </li>
  );

  const logoutButton = (
    <li className="nav-item fw-bold">
      <Link
        onClick={logoutUser}
        to="/login"
        data-cy="header-link-login"
        className="nav-link hoverLink mx-1"
      >
        Logout
      </Link>
    </li>
  );

  return (
    //Header implementation start here
    <nav data-testid="navid" className="nav navbar navbar-expand-lg bg-header">
      <div className="container-fluid">
        <Link to="/" id="headbrand" className="navbar-brand text-dark fw-bold">
          {" "}
          <img className="px-2" src="" alt="" height="50px" />
          Book Store
        </Link>
        <button
          data-testid="navbar-toggler"
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="fas fa-bars text-dark"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav  mb-2 mb-lg-0">
            {user.isAuthenticated && (
              <li className="nav-item fw-bold">
                <Link
                  to="/home"
                  data-cy="header-link-register"
                  className="nav-link hoverLink mx-1 "
                >
                  Home
                </Link>
              </li>
            )}
            {!user.isAuthenticated && (
              <li className="nav-item fw-bold">
                <Link
                  to="/register"
                  data-cy="header-link-register"
                  className="nav-link hoverLink mx-1 "
                >
                  Register
                </Link>
              </li>
            )}
            {user.isAuthenticated && (
              <li className="nav-item fw-bold">
                <Link
                  to="/favorites"
                  data-cy="header-link-register"
                  className="nav-link hoverLink mx-1 "
                >
                  My Favorites
                </Link>
              </li>
            )}
            {user.isAuthenticated ? logoutButton : loginButton}
          </ul>
          {search && (
            <input id="searchbar"
              type="search"
              style={{ height: "2rem", width: "40rem", float: "right",borderRadius:"30px" }}
              className="form-control my-auto mx-auto text-left"
              placeholder="Search..."
              aria-label="Search"
              onChange={searchBooks}
            />
          )}
        </div>
      </div>
    </nav>
  );
}
