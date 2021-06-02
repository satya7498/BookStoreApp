import React, { useContext, useEffect } from "react";
import { Redirect, Route } from "react-router";
import { AuthContext } from "./AuthProvider";

const PrivateRoute = ({ component: Component, ...rest }) => {
  return (
    <Route
      {...rest}
      render={(props) =>
        localStorage.getItem("isAuthenticated") === "true" ? (
          <Component {...props} />
        ) : (
          <Redirect to="/login" />
        )
      }
    />
  );
};

export default PrivateRoute;
