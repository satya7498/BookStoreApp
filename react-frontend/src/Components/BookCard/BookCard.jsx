import React from "react";
import "./BookCard.css";
import swal from 'sweetalert';

const BookCard = ({ id, title, image, isbn, url }) => {
  const addToFavorites = () => {
    fetch(`http://localhost:8090/addtoFav/${id}`, {
      method: "POST",
      headers: {
        Authorization: `Bearer ${localStorage.getItem("token")}`,
      },
    })
      .then((res) => res.json())
      .then((data) => {
        console.log(data);
        swal("Added!", "Favourites Added", "success");
      })
      .catch((err) => console.log(err));
  };

  return (
    <div className="col-lg-4">
    <div className="card bookCard" style={{  minHeight:"500px" }}>
      <img
        src={image}
        className="card-img-top bookCard__img mx-auto"
        alt="..."
      />
      <div className="card-body text-center">
        <h5 style={{minHeight:"20px" } } 
        className="card-title">{title}</h5>
       
        <button className="butt" onClick={addToFavorites}>
          Add to favorites
        </button>
        <a href={url} className="read_now" target="_blank">
          Read Now
        </a>
      </div>
    </div>
    </div>
  );
};

export default BookCard;
