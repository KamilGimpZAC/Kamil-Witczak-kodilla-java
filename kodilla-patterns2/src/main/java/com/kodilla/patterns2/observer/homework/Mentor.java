package com.kodilla.patterns2.observer.homework;

public class Mentor implements ObserverHomework{

    private int count;
    private final String name;

    public Mentor(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void update(TaskListForStudent taskListForStudent) {
        if (taskListForStudent.getTasks().size() == 1){
            System.out.println(name + ": New task sent form  " + taskListForStudent.getName() + "\n" +
                    " (total: " + taskListForStudent.getTasks().size() + " task)");
        } else {
            System.out.println(name + ": New task sent form  " + taskListForStudent.getName() + "\n" +
                    " (total: " + taskListForStudent.getTasks().size() + " tasks)");
        }
        count++;
    }
}
