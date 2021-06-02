import React, { useEffect, useState } from "react";
import BookCard from "../BookCard/BookCard";
import Header from "../Header/Header";

const Home = () => {
  const [books, setBooks] = useState([]);
  const [searchedBooks, setSearchedBooks] = useState([]);

  useEffect(() => {
    allbooks();
    setSearchedBooks(books);
  }, [books.length]);

  const allbooks = () => {
    fetch("http://localhost:8090/allbooks", {
      method: "GET",
      headers: {
        Authorization: `Bearer ${localStorage.getItem("token")}`,
      },
    })
      .then((res) => res.json())
      .then((data) => {
        setBooks(data);
      })
      .catch((err) => console.log(err));
  };

  const searchBooks = (e) => {
    if (e.target.value === "") {
      setSearchedBooks(books);
    } else {
      setSearchedBooks(
        books.filter((book) =>
          book.title.toLowerCase().includes(e.target.value.toLowerCase())
        )
      );
    }
  };

  return (
    <>
      <Header search={true} searchBooks={searchBooks} />
      <div className="Home">
        <div className="container">
          <div className="row">
            {searchedBooks.map((book) => (
             
                
                  <BookCard
                    key={book.id}
                    id={book.id}
                    title={book.title}
                    image={book.image}
                    isbn={book.isbn13}
                    url={book.url}
                  />
                
              
            ))}
          </div>
        </div>
      </div>
    </>
  );
};

export default Home;
