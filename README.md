# TicTocToe with Minimax_Algorithm AI
__Hello!__
This is a simple __*console*__ based TicTocToe game. You can play with ___Minimax Algorithm AI___.

## Implementation

### How to calculate Heuristics: 
Thanks to the simplicity and limited state space of this game nature, heuristics is simple enough to be calculated just based on either __win__ or __lose__. 
If we won, +10. Tie means 0. Lose -10. 

https://github.com/Keizo410/TicTacToe_AI/blob/8c17966b8012c3d6084abc9ec094d2bbb82f785f/Player_AI.java#L17-L27

### How to initiate the minimax algorithm:
This method is sometimes called __decision__ function, which literally decides which action to be taken for AI player side.

https://github.com/Keizo410/TicTacToe_AI/blob/1711fb49a030dba82c5dccad4cc1e2ad7ed03ba1/Player_AI.java#L29-L55

### How MinMax algorithm Works:
There are several ways to implement minmax algorithm. Some people creates __2 different function min and max__ for simulating the state each other. For this implementation,
I used __isMaximizing__ parameter to identify which player's turn this is. 
**Important: You have to adjust the decision, heuristics, recusive call parameters depend on which player is responsible for the FIRST move. If this was not properly implemented, AI player chooses self-destructive move.**
On this implementation, AI is assumed to be the first move player, which means isMaximizing should be set to be __FALSE__ in the __decision method__ above as we start simulating the second player's move. 

https://github.com/Keizo410/TicTacToe_AI/blob/ab1003e041030351b850bc597602a75f6567fa9b/Player_AI.java#L57-L95

These state space search AI for game playing is heavily based on ***how the game is implemented***. TicTacToe is fairly simple and fun to program for beginners like me:)

### Enjoy!
