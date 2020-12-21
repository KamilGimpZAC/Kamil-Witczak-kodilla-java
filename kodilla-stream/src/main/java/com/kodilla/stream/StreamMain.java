package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        Forum forum = new Forum();
        Map<Integer, ForumUser> resultMap = forum.getList().stream()
                .filter(ForumUser -> ForumUser.getSex() == 'M')
                .filter(ForumUser -> ForumUser.getDateOfBirth().getYear() <= 2000)
                .filter(ForumUser -> ForumUser.getPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, ForumUser -> ForumUser));

        resultMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}