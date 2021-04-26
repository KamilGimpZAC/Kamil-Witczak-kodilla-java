package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookA;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest(){
        //Given
        BookA bookA1 = new BookA("TestAuthor1", "TestTitle1", 2011, "TestSignature1");
        BookA bookA2 = new BookA("TestAuthor2", "TestTitle2", 2012, "TestSignature2");
        BookA bookA3 = new BookA("TestAuthor3", "TestTitle3", 2013, "TestSignature3");
        Set<BookA> bookSet = new HashSet<>(){{
           add(bookA1);
           add(bookA2);
           add(bookA3);
        }};
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int median = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(2012, median);
    }
}
