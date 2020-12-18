package com.kodilla.testing.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import com.kodilla.testing.forum.statistics.Statistics;

@ExtendWith(MockitoExtension.class)
public class ForumTestSuite {

    private List<String> generateListOfUsers(int usersQuantity) {
        List<String> resultList = new ArrayList<>();
        for (int n = 1; n <= usersQuantity; n++) {
            resultList.add("Name " + n);
        }
        return resultList;
    }

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Mock
    private Statistics statistics;

    @Nested
    @DisplayName("Test for posts")
    class TestForPosts {
        @Test
        void testCalculateAdvStatisticsWhenZeroPosts() {
            //Given
            Forum forum = new Forum(statistics);
            when(statistics.postsCount()).thenReturn(0);
            //When
            forum.calculateAdvStatistics(statistics);
            //Then
            assertEquals(0, forum.getAvaragePostsOnUser());
        }

        @Test
        void testCalculateAdvStatisticsWhenThousandPosts() {
            //Given
            Forum forum = new Forum(statistics);
            when(statistics.postsCount()).thenReturn(1000);
            when(statistics.usersNames()).thenReturn(generateListOfUsers(10));
            //When
            forum.calculateAdvStatistics(statistics);
            //Then
            assertEquals(100, forum.getAvaragePostsOnUser());
        }
    }

    @Nested
    @DisplayName("Test for comments")
    class TestForComments {
        @Test
        void testCalculateAdvStatisticsWhenZeroComments() {
            //Given
            Forum forum = new Forum(statistics);
            when(statistics.commentsCount()).thenReturn(0);
            //When
            forum.calculateAdvStatistics(statistics);
            //Then
            assertEquals(0, forum.getAvarageCommentsOnUser());
        }
    }

    @Nested
    @DisplayName("Test for posts and comments")
    class TestForPostsAndComments {
        @Test
        void testCalculateAdvStatisticsWhenMorePostsThenComments() {
            //Given
            Forum forum = new Forum(statistics);
            when(statistics.commentsCount()).thenReturn(10);
            when(statistics.postsCount()).thenReturn(100);
            //When
            forum.calculateAdvStatistics(statistics);
            //Then
            assertEquals(0.1, forum.getAvarageCommentsOnPost());
        }

        @Test
        void testCalculateAdvStatisticsWhenLessPostsThenComments() {
            //Given
            Forum forum = new Forum(statistics);
            when(statistics.commentsCount()).thenReturn(100);
            when(statistics.postsCount()).thenReturn(10);
            //When
            forum.calculateAdvStatistics(statistics);
            //Then
            assertEquals(10, forum.getAvarageCommentsOnPost());
        }
    }

    @Nested
    @DisplayName("Test for users")
    class TestForUsers {
        @Test
        void testCalculateAdvStatisticsWhenZeroUsers() {
            //Given
            Forum forum = new Forum(statistics);
            when(statistics.usersNames()).thenReturn(generateListOfUsers(0));
            //When
            forum.calculateAdvStatistics(statistics);
            //Then
            assertEquals(0, forum.getAvarageCommentsOnUser());
            assertEquals(0, forum.getAvaragePostsOnUser());
        }

        @Test
        void testCalculateAdvStatisticsWhenHoundredUsers() {
            //Given
            Forum forum = new Forum(statistics);
            when(statistics.usersNames()).thenReturn(generateListOfUsers(100));
            when(statistics.postsCount()).thenReturn(10);
            when(statistics.commentsCount()).thenReturn(16);
            //When
            forum.calculateAdvStatistics(statistics);
            //Then
            assertEquals(0.1, forum.getAvaragePostsOnUser());
            assertEquals(0.16, forum.getAvarageCommentsOnUser());
        }
    }

}
