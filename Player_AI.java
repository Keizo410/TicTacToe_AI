/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.minimax_algorithm_test;

/**
 *
 * @author iek42
 */
public class Player_AI {

    Player_AI() {

    }

    public int score(String winner) {
        int score = -100;
        if (winner.equals(" X ")) {
            score = 10;
        } else if (winner.equals(" O ")) {
            score = -10;
        } else if (winner.equals("tie")) {
            score = 0;
        }
        return score;
    }

    public int[] bestmove(TicTacPho game) {
        int bestscore = (int) Double.NEGATIVE_INFINITY;
        int[] bestmove = null;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game.board[i][j] == null) {
                    // myturn, and next turn will be opponent, so it is not maximizing -> false
                    // if ai is second player, change score reverse, isMaximizing true, game playAI
                    // to "O"
                    game.playAI(i, j, " X ");
                    int score = minimax(game, 0, false);
                    System.out.println(score);
                    game.board[i][j] = null;

                    if (score > bestscore) {
                        bestscore = score;
                        bestmove = new int[] { i, j };
                    }

                }

            }
        }

        return bestmove;
    }

    public int minimax(TicTacPho game, int depth, boolean isMaximizing) {
        String result = game.checkWinner(game.board);
        int score;
        if (result != null) {

            return this.score(result);
        }

        if (isMaximizing) {
            int bestscore = (int) Double.NEGATIVE_INFINITY;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (game.isAvailable(i, j)) {
                        game.playAI(i, j, " X ");
                        score = minimax(game, depth + 1, false);

                        game.board[i][j] = null;

                        bestscore = Math.max(score, bestscore);
                    }
                }
            }

            return bestscore;
        } else {
            int bestscore = (int) Double.POSITIVE_INFINITY;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (game.isAvailable(i, j)) {
                        game.playAI(i, j, " O ");
                        score = minimax(game, depth + 1, true);
                        game.board[i][j] = null;
                        bestscore = Math.min(score, bestscore);
                    }
                }
            }
            return bestscore;
        }
    }
}
