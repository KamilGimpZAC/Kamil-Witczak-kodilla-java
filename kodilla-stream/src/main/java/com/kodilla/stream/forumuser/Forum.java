package com.kodilla.stream.forumuser;

import com.kodilla.stream.book.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> usersList = new ArrayList<>();

    public Forum(){
        usersList.add(new ForumUser(001,"User1",'M', LocalDate.of(1989,10,23),32));
        usersList.add(new ForumUser(002,"User2",'F', LocalDate.of(1998,5,10),0));
        usersList.add(new ForumUser(003,"User3",'F', LocalDate.of(1978,4,6),1));
        usersList.add(new ForumUser(004,"User4",'M', LocalDate.of(1995,12,30),45));
        usersList.add(new ForumUser(005,"User5",'M', LocalDate.of(2001,3,15),120));
        usersList.add(new ForumUser(006,"User6",'F', LocalDate.of(2005,5,24),0));
        usersList.add(new ForumUser(007,"User7",'M', LocalDate.of(2009,9,19),3));
    }

    public List<ForumUser> getList() {
        return new ArrayList<>(usersList);
    }
}
