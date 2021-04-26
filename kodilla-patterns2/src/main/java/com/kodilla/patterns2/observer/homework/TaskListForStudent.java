package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.Observer;

import java.util.ArrayList;
import java.util.List;

public class TaskListForStudent implements ObservableHomework{

    private final List<ObserverHomework> observers;
    private final List<String> tasks;
    private final String name;

    public TaskListForStudent(String name) {
        observers = new ArrayList<>();
        tasks = new ArrayList<>();
        this.name = name;
    }

    public void addTask(String name){
        tasks.add(name);
        notifyObservers();
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }

    @Override
    public void registerObserver(ObserverHomework observerHomework) {
        observers.add(observerHomework);
    }

    @Override
    public void notifyObservers() {
        for (ObserverHomework observerHomework : observers) {
            observerHomework.update(this);
        }
    }

    @Override
    public void removeObserver(ObserverHomework observerHomework) {
        observers.remove(observerHomework);
    }
}
