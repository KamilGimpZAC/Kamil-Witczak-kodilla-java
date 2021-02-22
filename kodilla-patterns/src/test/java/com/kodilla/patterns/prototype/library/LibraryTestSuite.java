package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() throws CloneNotSupportedException {
        //Given
        Library library = new Library("Library1");
        Book book1 = new Book("Title1", "Author1", LocalDate.of(2003, 5, 25));
        Book book2 = new Book("Title2", "Author2", LocalDate.of(2014, 9, 13));
        Book book3 = new Book("Title3", "Author3", LocalDate.of(2009, 2, 5));
        library.books.add(book1);
        library.books.add(book2);
        library.books.add(book3);
        //ShallowCopy
        Library libraryShallowCopy = null;
        try {
            libraryShallowCopy = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //DeepCopy
        Library libraryDeepCopy = null;
        try {
            libraryDeepCopy = library.deepCopy();
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }
        //When
        Set<Book> outputShallowCopy = libraryShallowCopy.getBooks();
        Set<Book> outputDeepCopy = libraryDeepCopy.getBooks();
        library.books.remove(book3);
        //Then
        System.out.println("Shallow copy: ");
        outputShallowCopy.stream()
                .forEach(System.out::println);
        assertEquals(2,outputShallowCopy.size());
        System.out.println("Deep copy: ");
        outputDeepCopy.stream()
                .forEach(System.out::println);
        assertEquals(3,outputDeepCopy.size());
    }
}
