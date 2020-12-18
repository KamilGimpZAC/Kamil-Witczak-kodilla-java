package com.kodilla.testing.statistics;

import com.kodilla.testing.forum.statistics.Statistics;

public class Forum {

    private Statistics statistics;
    private double avaragePostsOnUser;
    private double avarageCommentsOnUser;
    private double avarageCommentsOnPost;

    public double getAvaragePostsOnUser() {
        return avaragePostsOnUser;
    }

    public double getAvarageCommentsOnUser() {
        return avarageCommentsOnUser;
    }

    public double getAvarageCommentsOnPost() {
        return avarageCommentsOnPost;
    }

    public Forum(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        if (statistics.postsCount() == 0) {
            avaragePostsOnUser = 0;
            avarageCommentsOnPost = 0;
        }
        if (statistics.commentsCount() == 0) {
            avarageCommentsOnUser = 0;
            avarageCommentsOnPost = 0;
        }
        if (statistics.usersNames().size() == 0) {
            avaragePostsOnUser = 0;
            avarageCommentsOnUser = 0;
        }
        if(statistics.postsCount() != 0 && statistics.commentsCount() != 0 || statistics.usersNames().size() != 0) {
            double comments = statistics.commentsCount();
            double users = statistics.usersNames().size();
            double posts = statistics.postsCount();
            avaragePostsOnUser = posts/users;
            avarageCommentsOnPost = comments/posts;
            avarageCommentsOnUser = comments/users;
        }
    }
}
