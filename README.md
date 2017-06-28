# Tic Tac Toe in Java

## Game Requirements

- A command line application
- Two players can play tic tac toe
- Each player is prompted in turn to make his/her move
- After making a move, an updated tic tac toe board will be rendered with the last player's requested move
- Following display of the updated board, the next player will be prompted for their next move
- This process will repeat until the game is over
- On Game Over, the application will indicate whether the game was won by X, O or was a draw


## Technical requirements

- Built in Java
- Built using TDD (no new code written without a failing unit test)
- 100% test coverage (except for main)


## Implementation

- Game Class: records moves and indicates game completed and winner based on moves made
    - public Player getCurrentPlayer()
    - public Player[] getBoard()
    - public boolean isGameOver()
    - public Player getWinner()
    - public boolean isDrawnGame()
