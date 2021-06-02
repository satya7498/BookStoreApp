import React, { useEffect, useState } from "react";
import BookCard from "./BookCard/BookCard";

const AllBooks = () => {
  return (
    <div className="row">
      {books.map((book) => {
        <BookCard />;
      })}
    </div>
  );
};

export default AllBooks;
