package com.stensaxpase;

import com.stensaxpase.Fist.Types;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static  Player player1,player2;
    public static String answer,playerPlayed,winnerText;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        boolean onOff = true;

        player1= new Player("Player");
        player2 = new Player(true);

        while(onOff){
            System.out.print("Rock, Paper, Scissors!: " );
            //Ta emot det spelaren spelade
            playerPlayed = reader.readLine();

            //slumpa fram datorns gissning från 0-2
            int randomFist = (int) Math.floor( Math.random() * 3 );
            System.out.println("computer guessed"+ randomFist);

            player2.setPlayedFist(new RockPaperScissors((Types.values()[randomFist])));


            //kontrollera vem vad som skrevs in
            if(playerPlayed.equalsIgnoreCase("rock")){
                player1.setPlayedFist(new RockPaperScissors(Types.ROCK));
            }
            if(playerPlayed.equalsIgnoreCase("paper")){
                player1.setPlayedFist(new RockPaperScissors(Types.PAPER));
            }
            if(playerPlayed.equalsIgnoreCase("scissors")){
                player1.setPlayedFist(new RockPaperScissors(Types.SCISSORS));
            }

            //sätt rätt text
            //kontrollera vilken spelare som van
            Player winner = WhoWon(player1,player2);

            //om det inte finns vinnare är det oavgjort
            if(winner == null){
                winnerText = "It is a draw!";

            }
            //skriv ut rätt text beroende på vinnare
            else{
                winnerText  = winner.isAi ? "you loose!" : "you win!";
            }

            //skriv ut text med rätt vinnare och spela igen!
            System.out.println("You played : "+playerPlayed + " , AI played :" + player2.getPlayedFist().getSelected().name().toLowerCase() +" " + winnerText + " Want to play again?" );
            System.out.print("(y/n)");
            answer = reader.readLine();

            //om spelaren inte vill fortsätta stäng av loopen
            if(answer.equals("n")){
                onOff = false;
            }
        }

    }

    //kontrollera vilken hand som slår vad
    public static Player WhoWon(Player player1,Player player2){
        if(player1.getPlayedFist().getSelected().equals(Types.ROCK)){
            //både har STEN, ingen vinner
            if(player2.getPlayedFist().getSelected() == Types.ROCK){
                 return null;
             }
            //spelare två vinner då papper vinner över sten
            if(player2.getPlayedFist().getSelected() == Types.PAPER){
                return player2;
            }
            //spelare 1 vinner för att sten vinner över sax
            else{
                return player1;
            }
        }

        if(player1.getPlayedFist().getSelected().equals(Types.SCISSORS)){
            //både har Sax, ingen vinner
            if(player2.getPlayedFist().getSelected() == Types.SCISSORS){
                return null;
            }
            //spelare två vinner då sten vinner över sax
            if(player2.getPlayedFist().getSelected() == Types.ROCK){
                return player2;
            }
            //spelare 1 vinner för att sax vinner över papper
            else{
                return player1;
            }
        }

        if(player1.getPlayedFist().getSelected().equals(Types.PAPER)){
            //både har papper, ingen vinner
            if(player2.getPlayedFist().getSelected() == Types.PAPER){
                return null;
            }
            //spelare två vinner då sax vinner över papper
            if(player2.getPlayedFist().getSelected() == Types.SCISSORS){
                return player2;
            }
            //spelare 1 vinner för att papper vinner över sten
            else{
                return player1;
            }
        }
        return null;
    }
}
