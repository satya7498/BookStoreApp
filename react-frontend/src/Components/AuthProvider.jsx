import React, { createContext, useEffect, useState } from "react";

export const AuthContext = createContext();

const AuthProvider = ({ children }) => {
  const [user, setUser] = useState({ token: "", isAuthenticated: false });

  useEffect(() => {
    if (localStorage.getItem("isAuthenticated") === "true") {
      login(localStorage.getItem("token"));
    }
  }, []);

  const login = (token) => {
    setUser({
      token: token,
      isAuthenticated: true,
    });
    localStorage.setItem("token", token);
    localStorage.setItem("isAuthenticated", "true");
  };

  const logout = () => {
    setUser({
      token: "",
      isAuthenticated: false,
    });
    localStorage.clear();
  };

  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

export default AuthProvider;
