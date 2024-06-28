/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.minimax_algorithm_test;

import java.util.ArrayList;

/**
 *
 * @author iek42
 */
public class TicTacToe {
    int[][] spot = new int[3][3];
    String[][] board = new String[3][3];
    String player1;
    String player2;
    String turn;
    //Constructor for game initializaiton    
    TicTacPho(){
        this.player1 = " X ";
        this.player2 = " O ";
        //initialize the board
        for(String[] row: this.board){
           for(String element : row){
               element = null;
           } 
        }
        this.turn = " X ";
    }
    
    public void draw(){
         for(int row  = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
           System.out.print("|");
           if(board[row][col]==null){
               System.out.print("null");
           }else if(board[row][col]==" X "){
               System.out.print(" X ");
           }else{
               System.out.print(" O ");              
           }
         }
            System.out.println("|");
            
        }
    }
    public void playAI(int row, int col, String who){
        this.board[row][col]=who;
        
    }
    public void play(int row, int col){
        if(isAvailable(row,col)){
            this.board[row][col]=turn;
            playerChange();
        }else{
            System.out.println("Cant put here!! Try again");
        }
        
    }
    
    public boolean isAvailable(int row, int col){
        if(board[row][col]!=null){
            return false;
        }else{
            return true;
        }
    }
    
    public void playerChange(){
        if(this.turn.equals(" X ")){
            turn =  " O ";
        }else{
            turn = " X ";
        }
    }
    
    public boolean checkGameFinished(String[][] board){
        boolean gamefinished = true;
        for(String[] row: board){
            for(String element: row){
                if(element==null){
                    gamefinished = false;
                }
            }
        }
        return gamefinished;
    }
    
    public String checkWinner(String[][] board){
        String winner = null;
      
            for(int i = 0; i < 3; i++){
                if(board[i][0]!=null&&board[i][0]==board[i][1]&&board[i][1]==board[i][2]){
                   //horizontal check
                   winner = board[i][0];
                   break;
                }else if(board[0][i]!=null&&board[0][i]==board[1][i]&&board[1][i]==board[2][i]){
                    //vertical check
                    winner = board[0][i];
                    break;
                }else if(board[1][1]!=null&&(board[0][0]==board[1][1]&&board[1][1]==board[2][2])||(board[0][2]==board[1][1]&&board[1][1]==board[2][0])){
                    //diagonal check
                    winner = board[1][1];
                    break;
                }        
        
            //if winner is not set after iteration and no availability, it means the game is tie
            if(winner==null&&checkGameFinished(board)){
            
                winner = "tie";
             
            }
    }
        return winner;
}
}
