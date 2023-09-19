package com.systechafrika.part2.interfaces.Books;

public class BooksDemo {
    public static void main(String[] args) {
        BookController bookController = new BookControllerImpl();

        Book book1 = new Book("001", "ISBN-001", "The River Between", "ngungi wa thiongo");
        Book book2 = new Book("002", "ISBN-002", "The River & the Source", "Margaret A. Ogola");
        Book book3 = new Book("003", "ISBN-003", "Damu Nyeusi", "Walubengo Mendi ");

        System.out.println("First book created is :" + bookController.createBook(book1));
        System.out.println("second book is:" + bookController.createBook(book2));
        System.out.println("third book is :" + bookController.createBook(book3));

        // find book

        String isbnToFind = "ISBN-001";
        System.out.println("Please be patient ,we are finding book whose  ISBN  is" + isbnToFind + ":");
        Book foundBook = bookController.findBook(isbnToFind);
        if (foundBook != null) {
            System.out.println("book found,here's the details" + foundBook);
        } else {
            System.out.println("Sorry,we couldn't find the Book.");
        }
    }
}
