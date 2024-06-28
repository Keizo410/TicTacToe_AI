
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author iek42
 */
public class Minimax_Algorithm_Test {

    public static void main(String[] args) {
   
        boolean gameDone = false;
        TicTacToe game = new TicTacToe();
        Player_AI ai = new Player_AI();
        
  
        while(!gameDone){
            System.out.println("--------------------------------------------------------------------");
            game.draw();
           if(game.turn==" X "){
               int[] best = ai.bestmove(game);
               game.play(best[0], best[1]);
           }else{
               System.out.print("Enter your row coordination: ");
               Scanner inr = new Scanner(System.in);
               int row = inr.nextInt();

               System.out.print("Enter your col coordination: ");
               Scanner inc = new Scanner(System.in);
               int col = inc.nextInt();

                game.play(row, col);
            
            }
           
            if(game.checkWinner(game.board)!=null){
                gameDone = true;
                game.draw();
                System.out.println("Winner is "+ game.checkWinner(game.board));
            }
            
        }
    }
}
    
   