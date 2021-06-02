import React, { useEffect, useState } from "react";
import FavoriteCard from "../FavoriteCard/FavoriteCard";
import Header from "../Header/Header";

const MyFavorites = () => {
  const [favorites, setFavorites] = useState([]);
  const [searchedFavorites, setSearchedFavorites] = useState([]);

  useEffect(() => {
    myFavorites();
    setSearchedFavorites(favorites);
  }, [favorites]);

  const myFavorites = () => {
    fetch("http://localhost:8090/myfav", {
      method: "GET",
      headers: {
        Authorization: `Bearer ${localStorage.getItem("token")}`,
      },
    })
      .then((res) => res.json())
      .then((data) => {
        setFavorites(data);
      })
      .catch((err) => console.log(err));
  };

  const searchBooks = (e) => {
    if (e.target.value === "") {
      setSearchedFavorites(favorites);
    } else {
      setSearchedFavorites(
        favorites.filter((favorite) =>
          favorite.title.toLowerCase().includes(e.target.value.toLowerCase())
        )
      );
    }
  };

  return (
    <>
      <Header search={true} searchBooks={searchBooks} />
      <div className="Favorites">
        <div className="container">
          <div className="row">
            {searchedFavorites.map((favorite) => {
              console.log(favorite);
              return (
                <div className="col">
                  <FavoriteCard
                    id={favorite.id}
                    title={favorite.title}
                    image={favorite.image}
                    isbn={favorite.isbn}
                    url={favorite.url}
                  />
                </div>
              );
            })}
          </div>
        </div>
      </div>
    </>
  );
};

export default MyFavorites;
