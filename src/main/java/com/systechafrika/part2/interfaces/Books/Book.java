package com.systechafrika.part2.interfaces.Books;

public class Book {
    private String id;
    private String isbn;
    private String title;
    private String authorName;

    public Book(String id, String isbn, String title, String authorName) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.authorName = authorName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", authorName=" + authorName + "]";
    }

}
