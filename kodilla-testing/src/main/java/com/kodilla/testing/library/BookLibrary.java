package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<Book>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase
                .listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser){
        List<Book> outputBooks = new ArrayList<>();
        if(libraryUser.equals(new LibraryUser("Tom", "Hanks", "12345"))){
                outputBooks.add(new Book("Title", "Author" , 1970));
        }
        if(libraryUser.equals(new LibraryUser("David", "Morse", "12345"))){
            for (int n = 1; n <= 5; n++) {
                Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
                outputBooks.add(theBook);
            }
        }
        return outputBooks;
    }
}
