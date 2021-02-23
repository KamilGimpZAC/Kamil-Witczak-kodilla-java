package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    @Test
    void testDefaultSharingStrategies(){
        //Given
        User userFb = new Millenials("John");
        User userTw = new YGeneration("Steven");
        User userSc = new ZGeneration("Will");
        //When
        String fbOutput = userFb.sharePost();
        String twOutput = userTw.sharePost();
        String scOutput = userSc.sharePost();
        //Then
        assertEquals("Facebook", fbOutput);
        assertEquals("Twitter", twOutput);
        assertEquals("Snapchat", scOutput);
    }

    @Test
    void testIndividualSharingStrategy(){
        //Given
        User user = new Millenials("John");
        //When
        user.setSocialPublisher(new TwitterPublisher());
        String output = user.sharePost();
        //Then
        assertEquals("Twitter", output);
    }
}
