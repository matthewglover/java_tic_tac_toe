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

- Board Class:
    - [x] makes moves (throws error if square already taken)
    - [x] records moves
    - [x] checks if player has won
    - [x] checks if board is complete

- Game Class:
    - [x] stores current player
    - [x] makes move on board
    - [x] reports on current status of game (isGameOver, isWinner, getWinner)

- BoardRenderer:
    - [x] getRenderLines takes a board and returns a list of strings representing the board,
    each string being an individual line

- ConsoleGame:
    - [x] Initialises a Game
    - [x] Prints an introduction to the game
    - [x] Requests current player's move
    - [x] Makes move and renders updated game
    - [x] If game over, reports winner or draw and offers a play again option
    - [x] If not game over, requests current player's move
    - [x] Allows Game to be quit
