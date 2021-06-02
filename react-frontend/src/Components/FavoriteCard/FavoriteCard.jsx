import React from "react";
import "./FavoriteCard.css";

const FavoriteCard = ({ id, title, image }) => {
  const removeFromFavorites = () => {
    fetch(`http://localhost:8090/deletefav/${id}`, {
      method: "DELETE",
      headers: {
        Authorization: `Bearer ${localStorage.getItem("token")}`,
      },
    })
      .then((res) => res.json())
      .then((data) => {
        alert("Book removed successfully");
      })
      .catch((err) => console.log(err));
  };

  return (
    <div className="card favoriteCard" style={{ width: "18rem" }}>
      <img
        src={image}
        className="card-img-top favoriteCard__img mx-auto"
        alt="..."
      />
      <div className="card-body text-center">
        <h5 className="card-title">{title}</h5>
        <button
          className="butt favoriteCard__butt"
          onClick={removeFromFavorites}
        >
          Remove
        </button>
      </div>
    </div>
  );
};

export default FavoriteCard;
