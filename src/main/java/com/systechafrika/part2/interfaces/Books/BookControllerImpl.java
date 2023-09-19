package com.systechafrika.part2.interfaces.Books;

import java.util.ArrayList;
import java.util.List;

public class BookControllerImpl implements BookController {

    private List<Book> bookList; // Using an ArrayList to store books

    public BookControllerImpl() {
        this.bookList = new ArrayList<>();
    }

    @Override
    public Book createBook(Book book) {
        // Add the new book to the list
        bookList.add(book);
        return book;
    }

    @Override
    public void deleteBook(String isbn) {

    }

    @Override
    public Book findBook(String isbn) {

        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;

    }

    @Override
    public Book updateBook(String isbn, String title) {

        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn)) {
                book.setTitle(title);
                return book;
            }
        }

        return null;
    }

}
