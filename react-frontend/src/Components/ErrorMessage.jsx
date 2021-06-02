import React from "react";

const ErrorMessage = ({ error }) => {
  if (error) {
    return <p className="error">Error: {error}</p>;
  }
  return null;
};

export default ErrorMessage;
