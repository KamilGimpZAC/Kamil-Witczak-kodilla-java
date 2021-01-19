package com.kodilla.rps;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {
        Random AI = new Random();
        Scanner input = new Scanner(System.in);
        Scanner rounds = new Scanner(System.in);
        Scanner endGame = new Scanner(System.in);
        Scanner endGame2 = new Scanner(System.in);
        boolean end = false;
        int i = 0;
        while(!end) {
            ArrayList<Integer> playerPoints = new ArrayList<>();
            ArrayList<Integer> AIPoints = new ArrayList<>();
            Score playerScore = new Score(playerPoints);
            Score AIScore = new Score(AIPoints);
            System.out.println("Proszę podać imię:");
            Player p1 = new Player(input.nextLine());
            Player p2 = new Player("AI");
            System.out.println("Ile rund chcesz zagrać?");
            int r = Integer.parseInt(rounds.nextLine());
            System.out.println("Zasady:\nKlawisz 1 – zagranie \"kamień\",\n" +
                    "Klawisz 2 – zagranie \"papier\",\n" +
                    "Klawisz 3 – zagranie \"nożyce\",\n" +
                    "Klawisz x – zakończenie gry,\n" +
                    "Klawisz n – uruchomienie gry od nowa.");
            while(i != r) {
                System.out.println("Proszę wykonać ruch:");
                Type p1Type = new Type(Integer.parseInt(input.nextLine()));
                Type AIType = new Type(AI.nextInt(3) + 1);
                System.out.println("Twój przeciwnik wybrał: " + AIType.getTypeName());
                if(p1Type.beats(AIType)){
                    playerScore.addPoint();
                }
                else if(AIType.beats(p1Type)){
                    AIScore.addPoint();
                }
                i++;
            }
            System.out.println("Wynik gracza: " + playerScore.getPlayerScore());
            System.out.println("Wynik AI: " + AIScore.getPlayerScore());
            if(playerScore.getPlayerScore() < AIScore.getPlayerScore()){
                System.out.println("Niestety wygrało " + p2.getPlayerName());
            }
            if(playerScore.getPlayerScore() > AIScore.getPlayerScore()){
                System.out.println("Gratulacje, wygrałeś " + p1.getPlayerName());
            }
            if(playerScore.getPlayerScore() == AIScore.getPlayerScore()){
                System.out.println("Remis!");
            }
            System.out.println("Zakończyć grę czy rozpocząć od nowa?");
            if(endGame.nextLine().equals("x")){
                System.out.println("Czy na pewno zakończyć grę?\ntak/nie");
                if(endGame2.nextLine().equals("tak")){
                    end = true;
                }
            }
        }
    }
}
