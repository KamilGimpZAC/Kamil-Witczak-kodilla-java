package com.kodilla.rps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {
        Random AI = new Random();
        Scanner input = new Scanner(System.in);
        Scanner rounds = new Scanner(System.in);
        Scanner endGame = new Scanner(System.in);
        boolean end = false;
        int scorePlayer = 0;
        int scoreAI = 0;
        int i = 0;
        while(!end) {
            System.out.println("Proszę podać imię:");
            String s = input.nextLine();
            System.out.println("Ile rund chcesz zagrać?");
            int r = Integer.parseInt(rounds.nextLine());
            System.out.println("Zasady:\nKlawisz 1 – zagranie \"kamień\",\n" +
                    "Klawisz 2 – zagranie \"papier\",\n" +
                    "Klawisz 3 – zagranie \"nożyce\",\n" +
                    "Klawisz x – zakończenie gry,\n" +
                    "Klawisz n – uruchomienie gry od nowa.");
            while(i != r) {
                System.out.println("Proszę wykonać ruch:");
                int move = Integer.parseInt(input.nextLine());
                int AIMove = AI.nextInt(3) + 1;
                if(move == 1 && AIMove == 1){
                    System.out.println("Remis");
                }
                if(move == 2 && AIMove == 2){
                    System.out.println("Remis");
                }
                if(move == 3 && AIMove == 3){
                    System.out.println("Remis");
                }
                if(move == 1 && AIMove == 2){
                    System.out.println("Punkt dla przeciwnika!");
                    scoreAI++;
                }
                if(move == 1 && AIMove == 3){
                    System.out.println("Punkt dla Ciebie!");
                    scorePlayer++;
                }
                if(move == 2 && AIMove == 1){
                    System.out.println("Punkt dla Ciebie!");
                    scorePlayer++;
                }
                if(move == 2 && AIMove == 3){
                    System.out.println("Punkt dla przeciwnika!");
                    scoreAI++;
                }
                if(move == 3 && AIMove == 1){
                    System.out.println("Punkt dla przeciwnika!");
                    scoreAI++;
                }
                if(move == 3 && AIMove == 2){
                    System.out.println("Punkt dla Ciebie!");
                    scorePlayer++;
                }
                i++;
            }
            if(scorePlayer < scoreAI){
                System.out.println("Niestety przegrałeś, dobra gra " + s);
            }
            if(scorePlayer > scoreAI){
                System.out.println("Gratulacje, wygrałeś " + s);
            }
            if(scorePlayer == scoreAI){
                System.out.println("Remis!");
            }
            System.out.println("Zakończyć grę czy rozpocząć od nowa?");
            String e = endGame.nextLine();
            if(endGame.equals("x")){
                end = true;
            }
        }
    }
}
