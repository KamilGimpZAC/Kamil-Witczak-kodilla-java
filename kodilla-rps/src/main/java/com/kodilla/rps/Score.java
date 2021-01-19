package com.kodilla.rps;

import java.util.ArrayList;

public class Score {
    private ArrayList<Integer> points;

    public Score(ArrayList<Integer> points) {
        this.points = points;
    }

    public void addPoint(){
        points.add(1);
    }

    public int getPlayerScore(){
        return points.size();
    }
}
