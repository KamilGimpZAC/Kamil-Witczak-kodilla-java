package com.kodilla.stream.invoice.simple;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SimpleInvoiceTestSuite {

    @Test
    void testGetValueToPay() {
        //Given
        SimpleInvoice invoice = new SimpleInvoice();

        //When
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 1", 17.28), 2.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 2", 11.99), 3.5));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 3",  6.49), 5.0));
        //Then
        assertEquals(108.975, invoice.getValueToPay(), 0.001);
    }

    @Test
    void testDebbuger(){
        //Given
        SimpleItem simpleProduct2 = new SimpleItem(new SimpleProduct("Product 2", 11.99), 3.5);
        //When
        simpleProduct2.getValue();
        //Then
        //do nothing
    }
}
