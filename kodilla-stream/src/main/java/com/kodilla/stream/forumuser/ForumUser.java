package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Objects;

public class ForumUser {
    private final int id;
    private final String userName;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int posts;

    public ForumUser(int id, String userName, char sex, LocalDate dateOfBirth, int posts) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.posts = posts;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        return id == forumUser.id && sex == forumUser.sex && posts == forumUser.posts && Objects.equals(userName, forumUser.userName) && Objects.equals(dateOfBirth, forumUser.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, sex, dateOfBirth, posts);
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", posts=" + posts +
                '}';
    }
}
