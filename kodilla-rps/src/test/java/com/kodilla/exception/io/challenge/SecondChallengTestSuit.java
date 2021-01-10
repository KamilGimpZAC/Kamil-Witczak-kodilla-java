package com.kodilla.exception.io.challenge;

import com.kodilla.exception.test.ExceptionHandling;
import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengTestSuit {

    @Test
    void probablyIWillThrowExceptionTest(){
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2,2)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(3,1)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0,3)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5,1.5)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5,2))
        );
    }
}
