package com.example.scrabble_cs301_team1;

import java.util.Random;

public class ScrabbleState {
    //15 x 15 board
    private ScrabbleLetter[][] board = new ScrabbleLetter[15][15];

    //an in to tell whos move it is 0 for human 1 for AI
    private int playerToMove;

    //array of SrabbleLetters for hand
    private ScrabbleLetter[] player1Hand = new ScrabbleLetter[7];
    private ScrabbleLetter[] player2Hand = new ScrabbleLetter[7];

    //array of ScrabbleLetters for Pool (100) total letters
    private ScrabbleLetter[] pool = new ScrabbleLetter[100];

    //game pause: 1 for pause 0 for playing
    private int gamePause;


    //constructor
    public ScrabbleState(){

        //sets board to blanks
        for(int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                board[i][j] = new ScrabbleLetter(' ');
            }
        }

        for(int i = 0; i < 7; i++){
            //generating random chars for each player
            Random rnd = new Random();
            char randomChar1 = (char) ('a' + rnd.nextInt(26));
            char randomChar2 = (char) ('a' + rnd.nextInt(26));
            //creating SrabbleLetters
            player1Hand[i] = new ScrabbleLetter(randomChar1);
            player2Hand[i] = new ScrabbleLetter(randomChar2);
        }

        for(int i = 0; i < 100; i++){
            Random rnd = new Random();
            char randomChar = (char) ('a' + rnd.nextInt(26));
            //doing random pool for now we can change how many of each letters we want later
            pool[i] = new ScrabbleLetter(randomChar);
        }

        //player 0 is human player
        playerToMove = 0;
        //0 = playing, 1 = pause
        gamePause = 0;

    }

    //deep copy
    public ScrabbleState(ScrabbleState scrabbleStateCopy){
            ScrabbleState myScrabbleState = new ScrabbleState();
            myScrabbleState.playerToMove = this.playerToMove;
            myScrabbleState.gamePause = this.gamePause;
            myScrabbleState.pool = this.pool;
            myScrabbleState.board = this.board;
            myScrabbleState.player1Hand = this.player1Hand;
            myScrabbleState.player2Hand = null; //player1 can't see player 2 hand
    }

}
