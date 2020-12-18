package com.kodilla.testing.statistics;

import com.kodilla.testing.forum.statistics.Statistics;
import java.util.List;

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

    public List<String> usersNames(){
        return statistics.usersNames();
    }
    public int postsCount(){
        return statistics.postsCount();
    }

    public int commentsCount(){
        return  statistics.commentsCount();
    }

    public void calculateAdvStatistics(Statistics statistics) {
        if (postsCount() == 0) {
            avaragePostsOnUser = 0;
            avarageCommentsOnPost = 0;
        }

        if (commentsCount() == 0) {
            avarageCommentsOnUser = 0;
            avarageCommentsOnPost = 0;
        }

        if (usersNames().size() == 0) {
            avaragePostsOnUser = 0;
            avarageCommentsOnUser = 0;
        } else {
            double comments = commentsCount();
            double users = usersNames().size();
            double posts = postsCount();
            avaragePostsOnUser = posts/users;
            avarageCommentsOnPost = comments/posts;
            avarageCommentsOnUser = comments/users;
        }
    }
}
