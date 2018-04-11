package com.example.android.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * player1Score and player2Score saves the score of the first and second players
     * respectively.
     * turnCount is an integer variable that keeps track of the number turns made.
     */
    int player1Score = 0;
    int player2Score = 0;
    int turnCount = 0;
    /**
     * button11 to button33 are Button objects for each cell on the game board.
     * resetButton is the Button object for resetting the game board.
     */
    Button button11, button12, button13, button21, button22, button23, button31, button32, button33,
            button115By5, button125By5, button135By5, button145By5, button155By5,
            button215By5, button225By5, button235By5, button245By5, button255By5,
            button315By5, button325By5, button335By5, button345By5, button355By5,
            button415By5, button425By5, button435By5, button445By5, button455By5,
            button515By5, button525By5, button535By5, button545By5, button555By5, resetButton,
            play3By3Button, play5By5Button;

    TableLayout gameBoard;
    HorizontalScrollView gameBoard5By5;

    /**
     * boolean variable systemPlayed checks if the system has played its turn in a single player
     * mode.
     * boolean variable gotWinner checks if a winner has emerged of the two players.
     */
    boolean systemPlayed = false;
    boolean gotWinner = false;
    boolean playX = true;
    boolean playSingle = false;
    boolean play3By3 = true;

    /**
     * playTypeRadios RadioGroup object for either single player or double player.
     * playSignRadios RadioGroup object for either X or O as the first player sign.
     */
    RadioGroup playTypeRadios;
    RadioGroup playSignRadios;

    /**
     * turnTextView connects with the TextView that displays whose turn it is in the UI.
     * winnerTextView connects with the TextView that displays who wins a round of the game.
     * player1ScoreTextView connects with the TextView that displays the score for the first player
     * player2ScoreTextView connects with the TextView that displays the score for the second player
     */
    TextView player1ScoreTextView;
    TextView player2ScoreTextView;
    TextView turnTextView;

    /**
     * cellStatuses saves the statuses of the cells in a 2-D array.
     * Each cell status is initialized as -1
     */
    int[][] cellStatuses = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
    int[][] cellStatuses5By5 = {{-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button11 = findViewById(R.id.cell11);
        button12 = findViewById(R.id.cell12);
        button13 = findViewById(R.id.cell13);
        button21 = findViewById(R.id.cell21);
        button22 = findViewById(R.id.cell22);
        button23 = findViewById(R.id.cell23);
        button31 = findViewById(R.id.cell31);
        button32 = findViewById(R.id.cell32);
        button33 = findViewById(R.id.cell33);
        button115By5 = findViewById(R.id.cell11_5by5);
        button125By5 = findViewById(R.id.cell12_5by5);
        button135By5 = findViewById(R.id.cell13_5by5);
        button145By5 = findViewById(R.id.cell14_5by5);
        button155By5 = findViewById(R.id.cell15_5by5);
        button215By5 = findViewById(R.id.cell21_5by5);
        button225By5 = findViewById(R.id.cell22_5by5);
        button235By5 = findViewById(R.id.cell23_5by5);
        button245By5 = findViewById(R.id.cell24_5by5);
        button255By5 = findViewById(R.id.cell25_5by5);
        button315By5 = findViewById(R.id.cell31_5by5);
        button325By5 = findViewById(R.id.cell32_5by5);
        button335By5 = findViewById(R.id.cell33_5by5);
        button345By5 = findViewById(R.id.cell34_5by5);
        button355By5 = findViewById(R.id.cell35_5by5);
        button415By5 = findViewById(R.id.cell41_5by5);
        button425By5 = findViewById(R.id.cell42_5by5);
        button435By5 = findViewById(R.id.cell43_5by5);
        button445By5 = findViewById(R.id.cell44_5by5);
        button455By5 = findViewById(R.id.cell45_5by5);
        button515By5 = findViewById(R.id.cell51_5by5);
        button525By5 = findViewById(R.id.cell52_5by5);
        button535By5 = findViewById(R.id.cell53_5by5);
        button545By5 = findViewById(R.id.cell54_5by5);
        button555By5 = findViewById(R.id.cell55_5by5);
        play3By3Button = findViewById(R.id.play_3by3_button);
        play5By5Button = findViewById(R.id.play_5by5_button);
        resetButton = findViewById(R.id.reset_button);
        gameBoard = findViewById(R.id.game_board);
        gameBoard5By5 =
                findViewById(R.id.game_board_5by5);
        playTypeRadios = findViewById(R.id.play_type_radios);
        playSignRadios = findViewById(R.id.play_sign_radios);
        turnTextView = findViewById(R.id.turn_text_view);
        player1ScoreTextView = findViewById(R.id.player1_score_text_view);
        player2ScoreTextView = findViewById(R.id.player2_score_text_view);
    }


    /**
     * This method checks the clicked play sign radio and updates the value of boolean variable
     * playX to either true or false. It then resets the game board and the score board.
     */
    public void onPlaySignRadioClicked(View view) {
        switch (view.getId()) { // switch statement compares the ID of the clicked RadioButton.
            case R.id.play_x: // if Play X was clicked.
                playX = true; // set boolean variable playX to true.
                turnTextView.setText(R.string.x_turn); /* updates the turnTextView so it displays
                X's turn.*/
                resetButton.performClick(); // resetButton is auto clicked clearing the game board.
                player1Score = 0; // first player's score is set to 0.
                player2Score = 0; // first player's score is set to 0.
                player1ScoreTextView.setText("" + player1Score); // resets the score board to 0.
                player2ScoreTextView.setText("" + player2Score); // resets the score board to 0.
                break;
            case R.id.play_o: // if Play O was clicked.
                playX = false; // set boolean variable playX to false.
                turnTextView.setText(R.string.o_turn); /* updates the turnTextView so it displays
                O's turn.*/
                resetButton.performClick(); // resetButton is auto clicked clearing the game board.
                player1Score = 0; // first player's score is set to 0.
                player2Score = 0; // first player's score is set to 0.
                player1ScoreTextView.setText("" + player1Score); // resets the score board to 0.
                player2ScoreTextView.setText("" + player2Score); // resets the score board to 0.
                break;
        }
    }

    /**
     * This method checks the clicked play type radio and updates the value of boolean variable
     * playSingle to either true or false. It then resets the game board and the score board.
     */
    public void onPlayTypeRadioClicked(View view) {
        switch (view.getId()) {// switch statement compares the ID of the clicked RadioButton.
            case R.id.single_player: // if Play Single was clicked.
                playSingle = true; // boolean variable playSingle is set to true.
                resetButton.performClick(); // resetButton is auto clicked clearing the game board.
                player1Score = 0; // first player's score is set to 0.
                player2Score = 0; // first player's score is set to 0.
                player1ScoreTextView.setText("" + player1Score); // resets the score board to 0.
                player2ScoreTextView.setText("" + player2Score); // resets the score board to 0.
                break;
            case R.id.double_player: // if Play with another was clicked.
                playSingle = false; // boolean variable playSingle is set to false.
                resetButton.performClick(); // resetButton is auto clicked clearing the game board.
                player1Score = 0; // first player's score is set to 0.
                player2Score = 0; // first player's score is set to 0.
                player1ScoreTextView.setText("" + player1Score); // resets the score board to 0.
                player2ScoreTextView.setText("" + player2Score); // resets the score board to 0.
                break;
        }
    }


    /**
     * onAnyGameBoardCellClicked defines what happens when a button on the game boards is
     * clicked.
     */
    @SuppressWarnings("UnnecessaryReturnStatement")
    public void onAnyGameBoardCellClicked(View view) {
        // Handles click event from human players.
        /* the method stops implementation if a winner has emerged in the current round of the game.
         */
        if (play3By3) {// if player chose to play the 3 by 3 game board.
            if (!gotWinner) {
                // if no winner has emerged.
                // test the ID of the clicked button other button ID values.
                switch (view.getId()) {
                    case R.id.cell11: // if cell11 is clicked.
                        if (cellStatuses[0][0] == -1) {
                            if (playX) { // if it is player X's turn.
                                button11.setText("X"); // sets cell's text to X
                                cellStatuses[0][0] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button11.setText("O"); // sets cell's text to O
                                cellStatuses[0][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell12: // if cell12 is clicked.
                        if (cellStatuses[0][1] == -1) {
                            if (playX) { // if it is player X's turn.
                                button12.setText("X"); // sets cell's text to X
                                cellStatuses[0][1] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button12.setText("O"); // sets cell's text to O
                                cellStatuses[0][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell13: // if cell13 is clicked.
                        if (cellStatuses[0][2] == -1) {
                            if (playX) { // if it is player X's turn.
                                button13.setText("X"); // sets cell's text to X
                                cellStatuses[0][2] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button13.setText("O"); // sets cell's text to O
                                cellStatuses[0][2] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell21: // if cell21 is clicked.
                        if (cellStatuses[1][0] == -1) {
                            if (playX) { // if it is player X's turn.
                                button21.setText("X"); // sets cell's text to X
                                cellStatuses[1][0] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button21.setText("O"); // sets cell's text to O
                                cellStatuses[1][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell22: // if cell22 is clicked.
                        if (cellStatuses[1][1] == -1) {
                            if (playX) { // if it is player X's turn.
                                button22.setText("X"); // sets cell's text to X
                                cellStatuses[1][1] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button22.setText("O"); // sets cell's text to O
                                cellStatuses[1][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell23: // if cell23 is clicked.
                        if (cellStatuses[1][2] == -1) {
                            if (playX) { // if it is player X's turn.
                                button23.setText("X"); // sets cell's text to X
                                cellStatuses[1][2] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button23.setText("O"); // sets cell's text to O
                                cellStatuses[1][2] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell31: // if cell31 is clicked.
                        if (cellStatuses[2][0] == -1) {
                            if (playX) { // if it is player X's turn.
                                button31.setText("X"); // sets cell's text to X
                                cellStatuses[2][0] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button31.setText("O"); // sets cell's text to O
                                cellStatuses[2][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell32: // if cell32 is clicked.
                        if (cellStatuses[2][1] == -1) {
                            if (playX) { // if it is player X's turn.
                                button32.setText("X"); // sets cell's text to X
                                cellStatuses[2][1] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button32.setText("O"); // sets cell's text to O
                                cellStatuses[2][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell33: // if cell33 is clicked.
                        if (cellStatuses[2][2] == -1) {
                            if (playX) { // if it is player X's turn.
                                button33.setText("X"); // sets cell's text to X
                                cellStatuses[2][2] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button33.setText("O"); // sets cell's text to O
                                cellStatuses[2][2] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                }

                if (turnCount > 4) {// winner is only obtainable when turnCount is >= 5
                    checkWinner();
                }

                if (playX) {// if playX is true.
                    turnTextView.setText(R.string.x_turn); // X's turn is displayed. X plays next.
                } else {// if playX is false.
                    turnTextView.setText(R.string.o_turn); // O's turn is displayed. O plays next.
                }

                if (playSingle && turnCount != 9 && !gotWinner && !systemPlayed) {/* if player chose to
                play against the system and all moves have not been made while a winner has not emerged
                yet and system has not played.*/
                    systemPlay();// system plays.
                }
            }
        } else {//if player chose to play on the 5 by 5 game board.
            if (!gotWinner) {
                // if no winner has emerged.
                // test the ID of the clicked button other button ID values.
                switch (view.getId()) {
                    case R.id.cell11_5by5: // if cell11 is clicked.
                        if (cellStatuses5By5[0][0] == -1) {
                            if (playX) { // if it is player X's turn.
                                button115By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[0][0] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button115By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[0][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell12_5by5: // if cell12 is clicked.
                        if (cellStatuses5By5[0][1] == -1) {
                            if (playX) { // if it is player X's turn.
                                button125By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[0][1] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button125By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[0][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell13_5by5: // if cell13 is clicked.
                        if (cellStatuses5By5[0][2] == -1) {
                            if (playX) { // if it is player X's turn.
                                button135By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[0][2] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button135By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[0][2] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell14_5by5: // if cell13 is clicked.
                        if (cellStatuses5By5[0][3] == -1) {
                            if (playX) { // if it is player X's turn.
                                button145By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[0][3] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button145By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[0][3] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell15_5by5: // if cell13 is clicked.
                        if (cellStatuses5By5[0][4] == -1) {
                            if (playX) { // if it is player X's turn.
                                button155By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[0][4] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button155By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[0][4] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell21_5by5: // if cell21 is clicked.
                        if (cellStatuses5By5[1][0] == -1) {
                            if (playX) { // if it is player X's turn.
                                button215By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[1][0] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button215By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[1][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell22_5by5: // if cell22 is clicked.
                        if (cellStatuses5By5[1][1] == -1) {
                            if (playX) { // if it is player X's turn.
                                button225By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[1][1] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button225By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[1][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell23_5by5: // if cell23 is clicked.
                        if (cellStatuses5By5[1][2] == -1) {
                            if (playX) { // if it is player X's turn.
                                button235By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[1][2] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button235By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[1][2] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell24_5by5: // if cell13 is clicked.
                        if (cellStatuses5By5[1][3] == -1) {
                            if (playX) { // if it is player X's turn.
                                button245By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[1][3] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button245By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[1][3] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell25_5by5: // if cell13 is clicked.
                        if (cellStatuses5By5[1][4] == -1) {
                            if (playX) { // if it is player X's turn.
                                button255By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[1][4] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button255By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[1][4] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell31_5by5: // if cell31 is clicked.
                        if (cellStatuses5By5[2][0] == -1) {
                            if (playX) { // if it is player X's turn.
                                button315By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[2][0] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button315By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[2][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell32_5by5: // if cell32 is clicked.
                        if (cellStatuses5By5[2][1] == -1) {
                            if (playX) { // if it is player X's turn.
                                button325By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[2][1] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button325By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[2][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell33_5by5: // if cell33 is clicked.
                        if (cellStatuses5By5[2][2] == -1) {
                            if (playX) { // if it is player X's turn.
                                button335By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[2][2] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button335By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[2][2] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell34_5by5: // if cell13 is clicked.
                        if (cellStatuses5By5[2][3] == -1) {
                            if (playX) { // if it is player X's turn.
                                button345By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[2][3] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button345By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[2][3] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell35_5by5: // if cell13 is clicked.
                        if (cellStatuses5By5[2][4] == -1) {
                            if (playX) { // if it is player X's turn.
                                button355By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[2][4] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button355By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[2][4] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell41_5by5: // if cell11 is clicked.
                        if (cellStatuses5By5[3][0] == -1) {
                            if (playX) { // if it is player X's turn.
                                button415By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[3][0] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button415By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[3][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell42_5by5: // if cell12 is clicked.
                        if (cellStatuses5By5[3][1] == -1) {
                            if (playX) { // if it is player X's turn.
                                button425By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[3][1] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button425By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[3][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell43_5by5: // if cell13 is clicked.
                        if (cellStatuses5By5[3][2] == -1) {
                            if (playX) { // if it is player X's turn.
                                button435By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[3][2] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button435By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[3][2] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell44_5by5: // if cell13 is clicked.
                        if (cellStatuses5By5[3][3] == -1) {
                            if (playX) { // if it is player X's turn.
                                button445By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[3][3] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button445By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[3][3] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell45_5by5: // if cell13 is clicked.
                        if (cellStatuses5By5[3][4] == -1) {
                            if (playX) { // if it is player X's turn.
                                button455By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[3][4] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button455By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[3][4] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell51_5by5: // if cell21 is clicked.
                        if (cellStatuses5By5[4][0] == -1) {
                            if (playX) { // if it is player X's turn.
                                button515By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[4][0] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button515By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[4][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell52_5by5: // if cell22 is clicked.
                        if (cellStatuses5By5[4][1] == -1) {
                            if (playX) { // if it is player X's turn.
                                button525By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[4][1] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button525By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[4][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell53_5by5: // if cell23 is clicked.
                        if (cellStatuses5By5[4][2] == -1) {
                            if (playX) { // if it is player X's turn.
                                button535By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[4][2] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button535By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[4][2] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell54_5by5: // if cell13 is clicked.
                        if (cellStatuses5By5[4][3] == -1) {
                            if (playX) { // if it is player X's turn.
                                button545By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[4][3] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button545By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[4][3] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell55_5by5: // if cell13 is clicked.
                        if (cellStatuses5By5[4][4] == -1) {
                            if (playX) { // if it is player X's turn.
                                button555By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[4][4] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button555By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[4][4] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                }

                if (turnCount > 8) {// winner is only obtainable when turnCount is >= 5
                    checkWinner5By5();
                }

                if (playX) {// if playX is true.
                    turnTextView.setText(R.string.x_turn); // X's turn is displayed. X plays next.
                } else {// if playX is false.
                    turnTextView.setText(R.string.o_turn); // O's turn is displayed. O plays next.
                }

                if (playSingle && turnCount != 25 && !gotWinner && !systemPlayed) {/* if player chose
                to play against the system and all moves have not been made while winner has not
                emerged and system has not played.*/
                    systemPlay5By5();// system plays.
                }
            }
        }
    }

    /**
     * reset method is called when the "reset" button is clicked. It resets scores to 0,
     * gotWinner to false, turnCount to 0, playX to either true or false based on checked
     * RadioButton (and the turnTextView), as well as playSingle.
     * Each cell's text is reset to blank and the winnerTextView's visibility to GONE.
     */
    public void reset(View view) {

        if (play3By3){// if player chose to play on the 3 by 3 game board.
            // for loop resets the cell statuses to -1.
            for (int indexRow = 0; indexRow < cellStatuses.length; indexRow++)
                for (int indexCol = 0; indexCol < cellStatuses[0].length; indexCol++)
                    cellStatuses[indexRow][indexCol] = -1;

            // for loop is used to set the content of each cell on the game board to an
            //empty string.
            Button[] buttonsArray = {button11, button12, button13, button21, button22, button23,
                    button31, button32, button33};
            for (Button each : buttonsArray) {
                each.setText("");// each button text is set to blank.
            }
        } else {// if player chose to play on the 5 by 5 game board.
            // for loop resets the cell statuses to -1.
            for (int indexRow = 0; indexRow < cellStatuses5By5.length; indexRow++)
                for (int indexCol = 0; indexCol < cellStatuses5By5[0].length; indexCol++)
                    cellStatuses5By5[indexRow][indexCol] = -1;

            // for loop is used to set the content of each cell on the game board to an
            //empty string.
            Button[] buttonsArray5By5 = {button115By5, button125By5, button135By5, button145By5, button155By5,
                    button215By5, button225By5, button235By5, button245By5, button255By5,
                    button315By5, button325By5, button335By5, button345By5, button355By5,
                    button415By5, button425By5, button435By5, button445By5, button455By5,
                    button515By5, button525By5, button535By5, button545By5, button555By5};
            for (Button each : buttonsArray5By5) {
                each.setText("");// each button text is set to blank.
            }
        }

        gotWinner = false; // boolean variable gotWinner is reset to false
        turnCount = 0; // int variable turnCount is reset to zero.

        if (playSingle) {// if the player chose to play against computer.
            if (play3By3) {// if player  chose to play 3 by 3.

                switch (playSignRadios.getCheckedRadioButtonId()) {/* switch statement checks the checked
            play sign.*/
                    case R.id.play_x:// if player plays X.
                        if (!playX) {/* if player made the last move in the last round of the game then
                        system plays first.*/
                            systemPlay(); // system plays on the 3 by 3 game board.
                        }
                        break;
                    case R.id.play_o:// if player plays O.
                        if (playX) {
                    /* if player made the last move in the last round of the game then
                        system plays first.*/
                            systemPlay();// system plays on the 3 by 3 game board.
                        }
                        break;
                }
            } else {// if player chose to play 5 by 5 game board,

                switch (playSignRadios.getCheckedRadioButtonId()) {/* switch statement checks the checked
            play sign.*/
                    case R.id.play_x:// if player plays X.
                        if (!playX) {/* if player made the last move in the last round of the game then
                        system plays first.*/
                            systemPlay5By5();// system plays on the 5 by 5 game board.
                        }
                        break;
                    case R.id.play_o:// if player plays O.
                        if (playX) {
                    /* if player made the last move in the last round of the game then
                        system plays first.*/
                            systemPlay5By5();// system plays on the 5 by 5 game board.
                        }
                        break;
                }
            }
        }

        if (playX) {// if playX is true.
            turnTextView.setText(R.string.x_turn); // X's turn is displayed. X plays next.
        } else {// if playX is false.
            turnTextView.setText(R.string.o_turn); // O's turn is displayed. O plays next.
        }
    }

    /**
     * checks if there is winner, who it is, displays who win, updates the score
     * and displays it.
     */
    private void checkWinner() {
        gotWinner = false; // If we're checking for winner then winner has not been gotten.

        for (int index = 0; index < 3; index++) {
            // The three rows.
            if (cellStatuses[index][0] == cellStatuses[index][1] && cellStatuses[index][1] ==
                    cellStatuses[index][2] && (cellStatuses[index][0] == 0 ||
                    cellStatuses[index][0] == 1)) {/* if the three elements are the same and
                        either of O and 1 in value. */
                if (gotWinner) {
                    break;
                }
                gotWinner = true; // a winner has emerged.

                switch (cellStatuses[index][0]) { /* switch statement tests the value against
                        0 and 1 to get the winner. */

                    case 0: // if the value is 0
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player O as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; /* player O is the second player then and his score is
                                incremented. */
                            player2ScoreTextView.setText("" + player2Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player1Score++; // then player O is the player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score); // the new score is displayed.
                        }
                        break;

                    case 1: // if the value is 1
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player X as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; /* player X is the player 1 then and his score is
                                incremented. */
                            player1ScoreTextView.setText("" + player1Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player2Score++; // then player O is the player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score); // the new score is displayed.
                        }
                        break;
                }
                // the three columns.
            } else if (cellStatuses[0][index] == cellStatuses[1][index] && cellStatuses[1][index] ==
                    cellStatuses[2][index] && (cellStatuses[0][index] == 0 ||
                    cellStatuses[0][index] == 1)) {/* if the three elements are the same and
                        either of O and 1 in value. */
                gotWinner = true; // a winner has emerged.

                switch (cellStatuses[0][index]) { /* switch statement tests the value against
                        0 and 1 to get the winner. */

                    case 0: // if the value is 0
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player O as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; /* player O is the player 2 then and his score is
                                incremented. */
                            player2ScoreTextView.setText("" + player2Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player1Score++; // then player O is the player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score); // the new score is displayed.
                        }
                        break;

                    case 1: // if the value is 1
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player X as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; /* player X is the player 1 then and his score is
                                incremented. */
                            player1ScoreTextView.setText("" + player1Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player2Score++; // then player X is the player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score); // the new score is displayed.
                        }
                        break;
                }
            }
        }
        // the left-to-right diagonal.
        if (!gotWinner) {// if winner has still not emerged.
            if (cellStatuses[0][0] == cellStatuses[1][1] && cellStatuses[1][1] ==
                    cellStatuses[2][2] && (cellStatuses[0][0] == 0 || cellStatuses[0][0] == 1)) {
                    /* if the three elements are the same and either of O and 1 in value. */
                gotWinner = true; // a winner has emerged.

                switch (cellStatuses[0][0]) { /* switch statement tests the value against
                        0 and 1 to get the winner. */

                    case 0: // if the value is 0
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player O as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; /* player O is the player 2 then and his score is
                                incremented. */
                            player2ScoreTextView.setText("" + player2Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player1Score++; // then player O is the player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score); // the new score is displayed.
                        }
                        break;

                    case 1: // if the value is 1
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player X as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; /* player X is the player 1 then and his score is
                                incremented. */
                            player1ScoreTextView.setText("" + player1Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player2Score++; // then player X is the player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score); // the new score is displayed.
                        }
                        break;
                }
            }
        }

        // the right-to-left diagonal.
        if (!gotWinner) {// if winner has still not emerged.
            if (cellStatuses[0][2] == cellStatuses[1][1] && cellStatuses[1][1] ==
                    cellStatuses[2][0] && (cellStatuses[0][2] == 0 || cellStatuses[0][2] == 1)) {
                    /* if the three elements are the same and either of O and 1 in value. */
                gotWinner = true; // a winner has emerged.

                switch (cellStatuses[0][2]) { /* switch statement tests the value against
                        0 and 1 to get the winner. */

                    case 0: // if the value is 0
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player O as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; /* player O is the player 2 then and his score is
                                incremented. */
                            player2ScoreTextView.setText("" + player2Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player1Score++; // then player O is the player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score); // the new score is displayed.
                        }
                        break;

                    case 1: // if the value is 1
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player X as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; /* player X is the player 1 then and his score is
                                incremented. */
                            player1ScoreTextView.setText("" + player1Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player2Score++; // then player X is the player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score); // the new score is displayed.
                        }
                        break;
                }
            }
        }

        if (!gotWinner && turnCount == 9) {// if no winner emerged and all move had been made.
            // if there is no winner yet and all cells has been played.
            Toast.makeText(this, R.string.draw, Toast.LENGTH_LONG).show(); // Toast displays "Draw!".
        }
    }

    /**
     * checks if there is winner on the 5 by 5 game board, who it is, displays who win, updates the score
     * and displays it.
     */
    private void checkWinner5By5() {
        gotWinner = false; // If we're checking for winner then winner has not been gotten.

        for (int index = 0; index < 5; index++) {
            // The five rows.
            if (cellStatuses5By5[index][0] == cellStatuses5By5[index][1] && cellStatuses5By5[index][1] ==
                    cellStatuses5By5[index][2] && cellStatuses5By5[index][2] == cellStatuses5By5[index][3]
                    && cellStatuses5By5[index][3] == cellStatuses5By5[index][4] && (cellStatuses5By5[index][0] ==
                    0 || cellStatuses5By5[index][0] == 1)) {/* if the five elements are the same and
                        either of O and 1 in value. */
                if (gotWinner) {
                    break;
                }
                gotWinner = true; // a winner has emerged.

                switch (cellStatuses5By5[index][0]) { /* switch statement tests the value against
                        0 and 1 to get the winner. */

                    case 0: // if the value is 0
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player O as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; /* player O is the second player then and his score is
                                incremented. */
                            player2ScoreTextView.setText("" + player2Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player1Score++; // then player O is the player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score); // the new score is displayed.
                        }
                        break;

                    case 1: // if the value is 1
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player X as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; /* player X is the player 1 then and his score is
                                incremented. */
                            player1ScoreTextView.setText("" + player1Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player2Score++; // then player O is the player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score); // the new score is displayed.
                        }
                        break;
                }
                // the five columns.
            } else if (cellStatuses5By5[0][index] == cellStatuses5By5[1][index] && cellStatuses5By5[1][index] ==
                    cellStatuses5By5[2][index] && cellStatuses5By5[2][index] == cellStatuses5By5[3][index] &&
            cellStatuses5By5[3][index] == cellStatuses5By5[4][index] && (cellStatuses5By5[0][index] == 0 ||
                    cellStatuses5By5[0][index] == 1)) {/* if the three elements are the same and
                        either of O and 1 in value. */
                gotWinner = true; // a winner has emerged.

                switch (cellStatuses5By5[0][index]) { /* switch statement tests the value against
                        0 and 1 to get the winner. */

                    case 0: // if the value is 0
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player O as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; /* player O is the player 2 then and his score is
                                incremented. */
                            player2ScoreTextView.setText("" + player2Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player1Score++; // then player O is the player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score); // the new score is displayed.
                        }
                        break;

                    case 1: // if the value is 1
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player X as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; /* player X is the player 1 then and his score is
                                incremented. */
                            player1ScoreTextView.setText("" + player1Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player2Score++; // then player X is the player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score); // the new score is displayed.
                        }
                        break;
                }
            }
        }
        // the left-to-right diagonal.
        if (!gotWinner) {// if winner has still not emerged.
            if (cellStatuses5By5[0][0] == cellStatuses5By5[1][1] && cellStatuses5By5[1][1] ==
                    cellStatuses5By5[2][2] && cellStatuses5By5[2][2] == cellStatuses5By5[3][3] &&
            cellStatuses5By5[3][3] == cellStatuses5By5[4][4] && (cellStatuses5By5[0][0] == 0 ||
                    cellStatuses5By5[0][0] == 1)) {
                    /* if the five elements are the same and either of O and 1 in value. */
                gotWinner = true; // a winner has emerged.

                switch (cellStatuses5By5[0][0]) { /* switch statement tests the value against
                        0 and 1 to get the winner. */

                    case 0: // if the value is 0
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player O as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; /* player O is the player 2 then and his score is
                                incremented. */
                            player2ScoreTextView.setText("" + player2Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player1Score++; // then player O is the player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score); // the new score is displayed.
                        }
                        break;

                    case 1: // if the value is 1
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player X as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; /* player X is the player 1 then and his score is
                                incremented. */
                            player1ScoreTextView.setText("" + player1Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player2Score++; // then player X is the player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score); // the new score is displayed.
                        }
                        break;
                }
            }
        }

        // the right-to-left diagonal.
        if (!gotWinner) {// if winner has still not emerged.
            if (cellStatuses5By5[0][4] == cellStatuses5By5[1][3] && cellStatuses5By5[1][3] ==
                    cellStatuses5By5[2][2] && cellStatuses5By5[2][2] == cellStatuses5By5[3][1] &&
            cellStatuses5By5[3][1] == cellStatuses5By5[4][0] && (cellStatuses5By5[0][4] == 0 ||
                    cellStatuses5By5[0][4] == 1)) {
                    /* if the three elements are the same and either of O and 1 in value. */
                gotWinner = true; // a winner has emerged.

                switch (cellStatuses5By5[0][4]) { /* switch statement tests the value against
                        0 and 1 to get the winner. */

                    case 0: // if the value is 0
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player O as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; /* player O is the player 2 then and his score is
                                incremented. */
                            player2ScoreTextView.setText("" + player2Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player1Score++; // then player O is the player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score); // the new score is displayed.
                        }
                        break;

                    case 1: // if the value is 1
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player X as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; /* player X is the player 1 then and his score is
                                incremented. */
                            player1ScoreTextView.setText("" + player1Score); // the score is displayed.
                        } else {// if the first player's sign is O.
                            player2Score++; // then player X is the player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score); // the new score is displayed.
                        }
                        break;
                }
            }
        }

        if (!gotWinner && turnCount == 25) {// if no winner emerged and all move had been made.
            // if there is no winner yet and all cells has been played.
            Toast.makeText(this, R.string.draw, Toast.LENGTH_LONG).show(); // Toast displays "Draw!".
        }
    }

    /** Method handles system's turn of play by implementing the checkForTwoAndPlay(), checkForOneAndPlay(),
     * and playAnyFreeCell.
     */
    private void systemPlay() {
        systemPlayed = false;
        checkForTwoAndPlay();/* check for two cells played by system with a free cell on the same
            line and play or check if such has been played by opponent and block.*/

        if (!systemPlayed) {// if system has still not played.
            checkForOneAndPlay();/* the system should check for a cell it has played with two free
                cells in the same line to play to move closer to a win.*/
        }

        if (!systemPlayed) {// if system has still not played.
            playAnyFreeCell();// the system should check and play any free cell.
        }
        if (systemPlayed) {// if system has played.
            turnCount++;// turnCount is incremented.
            playX = !playX;// playX is negated so the next player could play.

            if (playX) {// if playX is true.
                turnTextView.setText(R.string.x_turn); // X's turn is displayed. X plays next.
            } else {// if playX is false.
                turnTextView.setText(R.string.o_turn); // O's turn is displayed. O plays next.
            }

            if (turnCount > 4) {// winner is only obtainable when turnCount is >= 5
                checkWinner();
            }
        }
    }


    /** Method handles system's turn of play on the 5 by 5 game board
     */
    private void systemPlay5By5() {
        systemPlayed = false;

        playAnyFreeCell5By5();// the system should check and play any free cell.

        if (systemPlayed) {// if system has played.
            turnCount++;// turnCount is incremented.
            playX = !playX;// playX is negated so the next player could play.

            if (playX) {// if playX is true.
                turnTextView.setText(R.string.x_turn); // X's turn is displayed. X plays next.
            } else {// if playX is false.
                turnTextView.setText(R.string.o_turn); // O's turn is displayed. O plays next.
            }

            if (turnCount > 8) {// winner is only obtainable when turnCount is >= 5
                checkWinner5By5();
            }
        }
    }

    /** This method checks for two X in a row so the system can play and win.*/
    private void checkForTwoXAndPlayToWinOrBlock() {
        Button[][] buttons2D = {{button11, button12, button13}, {button21, button22, button23},
                {button31, button32, button33}};

        for (int index = 0; index < 3; index++) {
		/*checking through the 3 rows and 3 columns if system has played 2 rows with a free
		cell on the line to play and win.*/
            if (cellStatuses[index][0] == cellStatuses[index][1] && cellStatuses[index][2] == -1 &&
                    cellStatuses[index][0] == 1) {/* In each row if the first and second cells have been
                 played by the system with a last cell free*/
                buttons2D[index][2].setText("X");// Then system clicks the free button.
                cellStatuses[index][2] = 1;
                systemPlayed = true;// system has played.
                break; // breaks out of the for loop.
            } else if (cellStatuses[index][1] == cellStatuses[index][2] && cellStatuses[index][0] == -1 &&
                    cellStatuses[index][1] == 1) {/* Else in each row if the second and last cells
                have been played by the system with the first cell free*/
                buttons2D[index][0].setText("X");// Then system clicks the free cell.
                cellStatuses[index][0] = 1;
                systemPlayed = true;// system has played
                break; // breaks out of the for loop.
            } else if (cellStatuses[index][0] == cellStatuses[index][2] && cellStatuses[index][1] == -1 &&
                    cellStatuses[index][0] == 1) {/* Else in each row if the first and last cells
                    have been played with the second cell free.*/
                buttons2D[index][1].setText("X");// System clicks the free cell.
                cellStatuses[index][1] = 1;
                systemPlayed = true;// system has played.
                break; // breaks out of the for loop.
            } else if (cellStatuses[0][index] == cellStatuses[1][index] && cellStatuses[2][index] == -1 &&
                    cellStatuses[0][index] == 1) {/* In each column if the first and second cells
                        have been played by the system with a last cell free*/
                buttons2D[2][index].setText("X");// Then system clicks the free button.
                cellStatuses[2][index] = 1;
                systemPlayed = true;// system has played.
                break; // breaks out of the for loop.
            } else if (cellStatuses[1][index] == cellStatuses[2][index] && cellStatuses[0][index] == -1 &&
                    cellStatuses[1][index] == 1) {/* Else in each column if the second and last cells
                have been played by the system with the first cell free*/
                buttons2D[0][index].setText("X");// Then system clicks the free cell.
                cellStatuses[0][index] = 1;
                systemPlayed = true;// system has played
                break; // breaks out of the for loop.
            } else if (cellStatuses[0][index] == cellStatuses[2][index] && cellStatuses[1][index] == -1 &&
                    cellStatuses[0][index] == 1) {/* Else in each column if the first and last cells
                    have been played with the second cell free.*/
                buttons2D[1][index].setText("X");// System clicks the free cell.
                cellStatuses[1][index] = 1;
                systemPlayed = true;// system has played.
                break; // breaks out of the for loop.
            }
        }

        if (!systemPlayed) {// if system has still not played

            if (cellStatuses[0][0] == cellStatuses[1][1] && cellStatuses[2][2] == -1 &&
                    cellStatuses[0][0] == 1) {/* In the left-to-right diagonal, if the first and
                         second cells in the diagonal have been played by system with the last cell free.*/
                buttons2D[2][2].setText("X");// the free cell is clicked.
                cellStatuses[2][2] = 1;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[1][1] == cellStatuses[2][2] && cellStatuses[0][0] == -1 &&
                    cellStatuses[1][1] == 1) {/* In the left-to-right diagonal, if the second
                        and last cells in the diagonal have been played by system with the first cell free.*/
                buttons2D[0][0].setText("X");// the free cell is clicked.
                cellStatuses[0][0] = 1;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[0][0] == cellStatuses[2][2] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][0] == 1) {/* /* In the left-to-right diagonal, if the first
                        and last cells in the diagonal have been played by system with the second cell free.*/
                buttons2D[1][1].setText("X");// the free cell is clicked.
                cellStatuses[1][1] = 1;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[0][2] == cellStatuses[1][1] && cellStatuses[2][0] == -1 &&
                    cellStatuses[0][2] == 1) {/* In the right-to-left diagonal, if the first and second cells in the diagonal
                        have been played by system with the last cell free.*/
                buttons2D[2][0].setText("X");// the free cell is clicked.
                cellStatuses[2][0] = 1;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[1][1] == cellStatuses[2][0] && cellStatuses[0][2] == -1 &&
                    cellStatuses[1][1] == 1) {/* In the right-to-left diagonal, if the second and
                         last cells in the diagonal have been played by system with the first cell free.*/
                buttons2D[0][2].setText("X");// the free cell is clicked.
                cellStatuses[0][2] = 1;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[0][2] == cellStatuses[2][0] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][2] == 1) {/* In the right-to-left diagonal, if the first and
                        last cells in the diagonal have been played by system with the second cell free.*/
                buttons2D[1][1].setText("X");// the free cell is clicked.
                cellStatuses[1][1] = 1;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[0][0] == cellStatuses[1][1] && cellStatuses[2][2] == -1 &&
                    cellStatuses[0][0] == 0) {/* In the left-to-right diagonal, if the first and
                         second cells in the diagonal have been played by opponent with the last cell free.*/
                buttons2D[2][2].setText("X");// the free cell is clicked and the opponent is blocked.
                cellStatuses[2][2] = 1;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[1][1] == cellStatuses[2][2] && cellStatuses[0][0] == -1 &&
                    cellStatuses[1][1] == 0) {/* In the left-to-right diagonal, if the second
                        and last cells in the diagonal have been played by opponent with the first cell free.*/
                buttons2D[0][0].setText("X");// the free cell is clicked and opponent is blocked.
                cellStatuses[0][0] = 1;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[0][0] == cellStatuses[2][2] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][0] == 0) {/* /* In the left-to-right diagonal, if the first
                        and last cells in the diagonal have been played by opponent with the second cell free.*/
                buttons2D[1][1].setText("X");// the free cell is clicked and opponent is blocked.
                cellStatuses[1][1] = 1;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[0][2] == cellStatuses[1][1] && cellStatuses[2][0] == -1 &&
                    cellStatuses[0][2] == 0) {/* In the right-to-left diagonal, if the first and
                        second cells in the diagonal have been played by opponent with the last cell free.*/
                buttons2D[2][0].setText("X");// the free cell is clicked and opponent is blocked.
                cellStatuses[2][0] = 1;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[1][1] == cellStatuses[2][0] && cellStatuses[0][2] == -1 &&
                    cellStatuses[1][1] == 0) {/* In the right-to-left diagonal, if the second and
                         last cells in the diagonal have been played by system with the first cell free.*/
                buttons2D[0][2].setText("X");// the free cell is clicked.
                cellStatuses[0][2] = 1;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[0][2] == cellStatuses[2][0] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][2] == 0) {/* In the right-to-left diagonal, if the first and
                        last cells in the diagonal have been played by opponent with the second cell free.*/
                buttons2D[1][1].setText("X");// the free cell is clicked and opponent is blocked.
                cellStatuses[1][1] = 1;
                systemPlayed = true;// system has played.

            } else {// the three rows and column is checked to block the opponent.
                for (int index = 0; index < 3; index++) {
		/*checking through the 3 rows and 3 columns if opponent has played 2 rows with a free
		cell on the line to play and win.*/
                    if (cellStatuses[index][0] == cellStatuses[index][1] && cellStatuses[index][2] == -1 &&
                            cellStatuses[index][0] == 0) {/* In each row if the first and second cells have been
                 played by the opponent with a last cell free*/
                        buttons2D[index][2].setText("X");/* Then system clicks the free button
                            and opponent is blocked.*/
                        cellStatuses[index][2] = 1;
                        systemPlayed = true;// system has played.
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[index][1] == cellStatuses[index][2] && cellStatuses[index][0] == -1 &&
                            cellStatuses[index][1] == 0) {/* Else in each row if the second and last cells
                have been played by opponent with the first cell free*/
                        buttons2D[index][0].setText("X");/* Then system clicks the free button
                            and opponent is blocked.*/
                        cellStatuses[index][0] = 1;
                        systemPlayed = true;// system has played
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[index][0] == cellStatuses[index][2] && cellStatuses[index][1] == -1 &&
                            cellStatuses[index][0] == 0) {/* Else in each row if the first and last cells
                    have been played by opponent with the second cell free.*/
                        buttons2D[index][1].setText("X");/* Then system clicks the free button
                            and opponent is blocked.*/
                        cellStatuses[index][1] = 1;
                        systemPlayed = true;// system has played.
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[0][index] == cellStatuses[1][index] && cellStatuses[2][index] == -1 &&
                            cellStatuses[0][index] == 0) {/* In each column if the first and second cells
                        have been played by the opponent with a last cell free*/
                        buttons2D[2][index].setText("X");/* Then system clicks the free button
                            and opponent is blocked.*/
                        cellStatuses[2][index] = 1;
                        systemPlayed = true;// system has played.
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[1][index] == cellStatuses[2][index] && cellStatuses[0][index] == -1 &&
                            cellStatuses[1][index] == 0) {/* Else in each column if the second and last cells
                have been played by the opponent with the first cell free*/
                        buttons2D[0][index].setText("X");/* Then system clicks the free button
                            and opponent is blocked.*/
                        cellStatuses[0][index] = 1;
                        systemPlayed = true;// system has played
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[0][index] == cellStatuses[2][index] && cellStatuses[1][index] == -1 &&
                            cellStatuses[0][index] == 0) {/* Else in each column if the first and last cells
                    have been played by opponent with the second cell free.*/
                        buttons2D[1][index].setText("X");/* System clicks the free cell and
                            opponent is blocked.*/
                        cellStatuses[1][index] = 1;
                        systemPlayed = true;// system has played.
                        break; // breaks out of the for loop.
                    }
                }
            }
        }
    }

    /** This method checks for two Os and play.*/
    private void checkForTwoOAndPlayToWinOrBlock() {
        Button[][] buttons2D = {{button11, button12, button13}, {button21, button22, button23},
                {button31, button32, button33}};
        for (int index = 0; index < 3; index++) {
		/*checking through the 3 rows and 3 columns if system has played 2 rows with a free
		cell on the line to play and win.*/
            if (cellStatuses[index][0] == cellStatuses[index][1] && cellStatuses[index][2] == -1 &&
                    cellStatuses[index][0] == 0) {/* In each row if the first and second cells have been
                 played by the system with a last cell free*/
                buttons2D[index][2].setText("O");// Then system clicks the free button.
                cellStatuses[index][2] = 0;
                systemPlayed = true;// system has played.
                break; // breaks out of the for loop.
            } else if (cellStatuses[index][1] == cellStatuses[index][2] && cellStatuses[index][0] == -1 &&
                    cellStatuses[index][1] == 0) {/* Else in each row if the second and last cells
                have been played by the system with the first cell free*/
                buttons2D[index][0].setText("O");// Then system clicks the free cell.
                cellStatuses[index][0] = 0;
                systemPlayed = true;// system has played
                break; // breaks out of the for loop.
            } else if (cellStatuses[index][0] == cellStatuses[index][2] && cellStatuses[index][1] == -1 &&
                    cellStatuses[index][0] == 0) {/* Else in each row if the first and last cells
                    have been played with the second cell free.*/
                buttons2D[index][1].setText("O");// System clicks the free cell.
                cellStatuses[index][1] = 0;
                systemPlayed = true;// system has played.
                break; // breaks out of the for loop.
            } else if (cellStatuses[0][index] == cellStatuses[1][index] && cellStatuses[2][index] == -1 &&
                    cellStatuses[0][index] == 0) {/* In each column if the first and second cells
                        have been played by the system with a last cell free*/
                buttons2D[2][index].setText("O");// Then system clicks the free button.
                cellStatuses[2][index] = 0;
                systemPlayed = true;// system has played.
                break; // breaks out of the for loop.
            } else if (cellStatuses[1][index] == cellStatuses[2][index] && cellStatuses[0][index] == -1 &&
                    cellStatuses[1][index] == 0) {/* Else in each column if the second and last cells
                have been played by the system with the first cell free*/
                buttons2D[0][index].setText("O");// Then system clicks the free cell.
                cellStatuses[0][index] = 0;
                systemPlayed = true;// system has played
                break; // breaks out of the for loop.
            } else if (cellStatuses[0][index] == cellStatuses[2][index] && cellStatuses[1][index] == -1 &&
                    cellStatuses[0][index] == 0) {/* Else in each column if the first and last cells
                    have been played with the second cell free.*/
                buttons2D[1][index].setText("O");// System clicks the free cell.
                cellStatuses[1][index] = 0;
                systemPlayed = true;// system has played.
                break; // breaks out of the for loop.
            }
        }

        if (!systemPlayed) {// if system has still not played

            if (cellStatuses[0][0] == cellStatuses[1][1] && cellStatuses[2][2] == -1 &&
                    cellStatuses[0][0] == 0) {/* In the left-to-right diagonal, if the first and
                         second cells in the diagonal have been played by system with the last cell free.*/
                buttons2D[2][2].setText("O");// the free cell is clicked.
                cellStatuses[2][2] = 0;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[1][1] == cellStatuses[2][2] && cellStatuses[0][0] == -1 &&
                    cellStatuses[1][1] == 0) {/* /* In the left-to-right diagonal, if the second
                        and last cells in the diagonal have been played by system with the first cell free.*/
                buttons2D[0][0].setText("O");// the free cell is clicked.
                cellStatuses[0][0] = 0;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[0][0] == cellStatuses[2][2] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][0] == 0) {/* /* In the left-to-right diagonal, if the first
                        and last cells in the diagonal have been played by system with the second cell free.*/
                buttons2D[1][1].setText("O");// the free cell is clicked.
                cellStatuses[1][1] = 0;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[0][2] == cellStatuses[1][1] && cellStatuses[2][0] == -1 &&
                    cellStatuses[0][2] == 0) {/* In the right-to-left diagonal, if the first and second cells in the diagonal
                        have been played by system with the last cell free.*/
                buttons2D[2][0].setText("O");// the free cell is clicked.
                cellStatuses[2][0] = 0;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[1][1] == cellStatuses[2][0] && cellStatuses[0][2] == -1 &&
                    cellStatuses[1][1] == 0) {/* In the right-to-left diagonal, if the second and
                         last cells in the diagonal have been played by system with the first cell free.*/
                buttons2D[0][2].setText("O");// the free cell is clicked.
                cellStatuses[0][2] = 0;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[0][2] == cellStatuses[2][0] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][2] == 0) {/* In the right-to-left diagonal, if the first and
                        last cells in the diagonal have been played by system with the second cell free.*/
                buttons2D[1][1].setText("O");// the free cell is clicked.
                cellStatuses[1][1] = 0;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[0][0] == cellStatuses[1][1] && cellStatuses[2][2] == -1 &&
                    cellStatuses[0][0] == 1) {/* In the left-to-right diagonal, if the first and
                         second cells in the diagonal have been played by opponent with the last cell free.*/
                buttons2D[2][2].setText("O");// the free cell is clicked and the opponent is blocked.
                cellStatuses[2][2] = 0;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[1][1] == cellStatuses[2][2] && cellStatuses[0][0] == -1 &&
                    cellStatuses[1][1] == 1) {/* In the left-to-right diagonal, if the second
                        and last cells in the diagonal have been played by opponent with the first cell free.*/
                buttons2D[0][0].setText("O");// the free cell is clicked and opponent is blocked.
                cellStatuses[0][0] = 0;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[0][0] == cellStatuses[2][2] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][0] == 1) {/* /* In the left-to-right diagonal, if the first
                        and last cells in the diagonal have been played by opponent with the second cell free.*/
                buttons2D[1][1].setText("O");// the free cell is clicked and opponent is blocked.
                cellStatuses[1][1] = 0;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[0][2] == cellStatuses[1][1] && cellStatuses[2][0] == -1 &&
                    cellStatuses[0][2] == 1) {/* In the right-to-left diagonal, if the first and
                        second cells in the diagonal have been played by opponent with the last cell free.*/
                buttons2D[2][0].setText("O");// the free cell is clicked and opponent is blocked.
                cellStatuses[2][0] = 0;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[1][1] == cellStatuses[2][0] && cellStatuses[0][2] == -1 &&
                    cellStatuses[1][1] == 1) {/* In the right-to-left diagonal, if the second and
                         last cells in the diagonal have been played by system with the first cell free.*/
                buttons2D[0][2].setText("O");// the free cell is clicked.
                cellStatuses[0][2] = 0;
                systemPlayed = true;// system has played.

            } else if (cellStatuses[0][2] == cellStatuses[2][0] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][2] == 1) {/* In the right-to-left diagonal, if the first and
                        last cells in the diagonal have been played by opponent with the second cell free.*/
                buttons2D[1][1].setText("O");// the free cell is clicked and opponent is blocked.
                cellStatuses[1][1] = 0;
                systemPlayed = true;// system has played.

            } else {// the three rows and column is checked to block the opponent.
                for (int index = 0; index < 3; index++) {
		/*checking through the 3 rows and 3 columns if opponent has played 2 rows with a free
		cell on the line to play and win.*/
                    if (cellStatuses[index][0] == cellStatuses[index][1] && cellStatuses[index][2] == -1 &&
                            cellStatuses[index][0] == 1) {/* In each row if the first and second cells have been
                 played by the opponent with a last cell free*/
                        buttons2D[index][2].setText("O");/* Then system clicks the free button
                            and opponent is blocked.*/
                        cellStatuses[index][2] = 0;
                        systemPlayed = true;// system has played.
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[index][1] == cellStatuses[index][2] && cellStatuses[index][0] == -1 &&
                            cellStatuses[index][1] == 1) {/* Else in each row if the second and last cells
                have been played by opponent with the first cell free*/
                        buttons2D[index][0].setText("O");/* Then system clicks the free button
                            and opponent is blocked.*/
                        cellStatuses[index][0] = 0;
                        systemPlayed = true;// system has played
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[index][0] == cellStatuses[index][2] && cellStatuses[index][1] == -1 &&
                            cellStatuses[index][0] == 1) {/* Else in each row if the first and last cells
                    have been played by opponent with the second cell free.*/
                        buttons2D[index][1].setText("O");/* Then system clicks the free button
                            and opponent is blocked.*/
                        cellStatuses[index][1] = 0;
                        systemPlayed = true;// system has played.
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[0][index] == cellStatuses[1][index] && cellStatuses[2][index] == -1 &&
                            cellStatuses[0][index] == 1) {/* In each column if the first and second cells
                        have been played by the opponent with a last cell free*/
                        buttons2D[2][index].setText("O");/* Then system clicks the free button
                            and opponent is blocked.*/
                        cellStatuses[2][index] = 0;
                        systemPlayed = true;// system has played.
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[1][index] == cellStatuses[2][index] && cellStatuses[0][index] == -1 &&
                            cellStatuses[1][index] == 1) {/* Else in each column if the second and last cells
                have been played by the opponent with the first cell free*/
                        buttons2D[0][index].setText("O");/* Then system clicks the free button
                            and opponent is blocked.*/
                        cellStatuses[0][index] = 0;
                        systemPlayed = true;// system has played
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[0][index] == cellStatuses[2][index] && cellStatuses[1][index] == -1 &&
                            cellStatuses[0][index] == 1) {/* Else in each column if the first and last cells
                    have been played by opponent with the second cell free.*/
                        buttons2D[1][index].setText("O");// System clicks the free cell.
                        cellStatuses[1][index] = 0;
                        systemPlayed = true;// system has played.
                        break; // breaks out of the for loop.
                    }
                }
            }
        }
    }

    /**
     * This method guides the system to check through each row or each column or each diagonal
     * if it has played
     */
    private void checkForTwoAndPlay() {

        if (playX) {// if system's turn plays X
            checkForTwoXAndPlayToWinOrBlock();// checks for two X in a row and play.
        } else {// if system's turn plays O
            checkForTwoOAndPlayToWinOrBlock();// checks for two O in a row and play.
        }
    }

    /**
     * This method guides the system to check through each row or each column or each diagonal
     * if it has played one cell with two free cells in the same line.
     */
    private void checkForOneAndPlay() {
        Button[][] buttons2D = {{button11, button12, button13}, {button21, button22, button23},
                {button31, button32, button33}};
        if (playX) {// if system's turn plays X

            for (int index = 0; index < 3; index++) {
		/*checking through the 3 rows and 3 columns if system has played 1 cell with 2 free
		cells on the line to play and move closer to a win.*/
                if (cellStatuses[index][0] == cellStatuses[index][1] && cellStatuses[index][0] == -1 &&
                        cellStatuses[index][2] == 1) {/* In each row if the first and second cells are
                        free with the last cell played by system.*/
                    int[] freeCellsColumnIndexArray = {0, 1};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsColumnIndex = freeCellsColumnIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[index][oneOfFreeCellsColumnIndex].setText("X");/* Then system clicks
                    randomly one of the free buttons.*/
                    cellStatuses[index][oneOfFreeCellsColumnIndex] = 1;
                    systemPlayed = true;// system has played.
                    break; // breaks out of the for loop.

                } else if (cellStatuses[index][1] == cellStatuses[index][2] && cellStatuses[index][1] == -1 &&
                        cellStatuses[index][0] == 1) {/* Else in each row if the second and last cells
                are free with the first cell played by system.*/
                    int[] freeCellsColumnIndexArray = {1, 2};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsColumnIndex = freeCellsColumnIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[index][oneOfFreeCellsColumnIndex].setText("X");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[index][oneOfFreeCellsColumnIndex] = 1;// cellStatus is updated.
                    systemPlayed = true;// system has played
                    break; // breaks out of the for loop.

                } else if (cellStatuses[index][0] == cellStatuses[index][2] && cellStatuses[index][0] == -1 &&
                        cellStatuses[index][0] == 1) {/* Else in each row if the first and last cells
                    are free with the second cell played by system.*/
                    int[] freeCellsColumnIndexArray = {0, 2};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsColumnIndex = freeCellsColumnIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[index][oneOfFreeCellsColumnIndex].setText("X");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[index][oneOfFreeCellsColumnIndex] = 1;
                    systemPlayed = true;// system has played.
                    break; // breaks out of the for loop.
                } else if (cellStatuses[0][index] == cellStatuses[1][index] && cellStatuses[0][index] == -1 &&
                        cellStatuses[2][index] == 1) {/* In each column if the first and second cells
                        are free with the last cell played by the system.*/
                    int[] freeCellsRowIndexArray = {0, 1};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndex = freeCellsRowIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsRowIndex][index].setText("X");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndex][index] = 1;
                    systemPlayed = true;// system has played.
                    break; // breaks out of the for loop.
                } else if (cellStatuses[1][index] == cellStatuses[2][index] && cellStatuses[1][index] == -1 &&
                        cellStatuses[0][index] == 1) {/* Else in each column if the second and last cells
                are free with the first cell played by system.*/
                    int[] freeCellsRowIndexArray = {1, 2};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndex = freeCellsRowIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsRowIndex][index].setText("X");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndex][index] = 1;
                    systemPlayed = true;// system has played
                    break; // breaks out of the for loop.
                } else if (cellStatuses[0][index] == cellStatuses[2][index] && cellStatuses[0][index] == -1 &&
                        cellStatuses[1][index] == 1) {/* Else in each column if the first and last cells
                    have been played with the second cell free.*/
                    int[] freeCellsRowIndexArray = {0, 2};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndex = freeCellsRowIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsRowIndex][index].setText("X");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndex][index] = 1;
                    systemPlayed = true;// system has played
                    break; // breaks out of the for loop.
                }
            }

            if (!systemPlayed) {// if system has still not played

                if (cellStatuses[0][0] == cellStatuses[1][1] && cellStatuses[0][0] == -1 &&
                        cellStatuses[2][2] == 1) {/* In the left-to-right diagonal, if the first and
                         second cells in the diagonal are free with the last cell played by system.*/
                    int[] freeCellsIndexArray = {0, 1};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsIndex = freeCellsIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsIndex][oneOfFreeCellsIndex].setText("X");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[oneOfFreeCellsIndex][oneOfFreeCellsIndex] = 1;
                    systemPlayed = true;// system has played

                } else if (cellStatuses[1][1] == cellStatuses[2][2] && cellStatuses[1][1] == -1 &&
                        cellStatuses[0][0] == 1) {/* In the left-to-right diagonal, if the second
                        and last cells in the diagonal are free with the first cell played by system.*/
                    int[] freeCellsIndexArray = {1, 2};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsIndex = freeCellsIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsIndex][oneOfFreeCellsIndex].setText("X");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[oneOfFreeCellsIndex][oneOfFreeCellsIndex] = 1;
                    systemPlayed = true;// system has played

                } else if (cellStatuses[0][0] == cellStatuses[2][2] && cellStatuses[0][0] == -1 &&
                        cellStatuses[1][1] == 1) {/* /* In the left-to-right diagonal, if the first
                        and last cells in the diagonal are free with the second cell played by system.*/
                    int[] freeCellsIndexArray = {0, 2};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsIndex = freeCellsIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsIndex][oneOfFreeCellsIndex].setText("X");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[oneOfFreeCellsIndex][oneOfFreeCellsIndex] = 1;
                    systemPlayed = true;// system has played

                } else if (cellStatuses[0][2] == cellStatuses[1][1] && cellStatuses[2][0] == -1 &&
                        cellStatuses[0][2] == 1) {/* In the right-to-left diagonal, if the first and
                        second cells in the diagonal are free with the last cell played by system.*/
                    int[] freeCellsRowIndexArray = {0, 1};// array store the row index of the free cells.
                    int[] freeCellsColumnIndexArray = {2, 1};// array store the column index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndex = freeCellsRowIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random row index of the free cells index.*/
                    int oneOfFreeCellsColumnIndex = freeCellsColumnIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random column index of the free cells index.*/
                    buttons2D[oneOfFreeCellsRowIndex][oneOfFreeCellsColumnIndex].setText("X");/* system
                    randomly clicks one the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndex][oneOfFreeCellsColumnIndex] = 1;
                    systemPlayed = true;// system has played.

                } else if (cellStatuses[1][1] == cellStatuses[2][0] && cellStatuses[1][1] == -1 &&
                        cellStatuses[0][2] == 1) {/* In the right-to-left diagonal, if the second and
                         last cells in the diagonal are free with the first cell played by system.*/
                    int[] freeCellsRowIndexArray = {1, 2};// array store the row index of the free cells.
                    int[] freeCellsColumnIndexArray = {1, 0};// array store the column index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndex = freeCellsRowIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random row index of the free cells index.*/
                    int oneOfFreeCellsColumnIndex = freeCellsColumnIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random column index of the free cells index.*/
                    buttons2D[oneOfFreeCellsRowIndex][oneOfFreeCellsColumnIndex].setText("X");/* system
                    randomly clicks one the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndex][oneOfFreeCellsColumnIndex] = 1;
                    systemPlayed = true;// system has played.

                } else if (cellStatuses[0][2] == cellStatuses[2][0] && cellStatuses[0][2] == -1 &&
                        cellStatuses[1][1] == 1) {/* In the right-to-left diagonal, if the first and
                        last cells in the diagonal are free with the second cell played by system.*/
                    int[] freeCellsRowIndexArray = {0, 2};// array store the row index of the free cells.
                    int[] freeCellsColumnIndexArray = {2, 0};// array store the column index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndex = freeCellsRowIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random row index of the free cells index.*/
                    int oneOfFreeCellsColumnIndex = freeCellsColumnIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random column index of the free cells index.*/
                    buttons2D[oneOfFreeCellsRowIndex][oneOfFreeCellsColumnIndex].setText("X");/* system
                    randomly clicks one the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndex][oneOfFreeCellsColumnIndex] = 1;
                    systemPlayed = true;// system has played.
                }
            }
        } else {// if system's turn plays O

            for (int index = 0; index < 3; index++) {
		/*checking through the 3 rows and 3 columns if system has played 1 cell with 2 free
		cells on the line to play and move closer to a win.*/
                if (cellStatuses[index][0] == cellStatuses[index][1] && cellStatuses[index][0] == -1 &&
                        cellStatuses[index][2] == 0) {/* In each row if the first and second cells are
                        free with the last cell played by system.*/
                    int[] freeCellsColumnIndexArray = {0, 1};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsColumnIndex = freeCellsColumnIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[index][oneOfFreeCellsColumnIndex].setText("O");/* Then system clicks
                    randomly one of the free buttons.*/
                    cellStatuses[index][oneOfFreeCellsColumnIndex] = 0;
                    systemPlayed = true;// system has played.
                    break; // breaks out of the for loop.

                } else if (cellStatuses[index][1] == cellStatuses[index][2] && cellStatuses[index][1] == -1 &&
                        cellStatuses[index][0] == 0) {/* Else in each row if the second and last cells
                are free with the first cell played by system.*/
                    int[] freeCellsColumnIndexArray = {1, 2};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsColumnIndex = freeCellsColumnIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[index][oneOfFreeCellsColumnIndex].setText("O");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[index][oneOfFreeCellsColumnIndex] = 0;
                    systemPlayed = true;// system has played
                    break; // breaks out of the for loop.

                } else if (cellStatuses[index][0] == cellStatuses[index][2] && cellStatuses[index][0] == -1 &&
                        cellStatuses[index][0] == 0) {/* Else in each row if the first and last cells
                    are free with the second cell played by system.*/
                    int[] freeCellsColumnIndexArray = {0, 2};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsColumnIndex = freeCellsColumnIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[index][oneOfFreeCellsColumnIndex].setText("O");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[index][oneOfFreeCellsColumnIndex] = 0;
                    systemPlayed = true;// system has played.
                    break; // breaks out of the for loop.
                } else if (cellStatuses[0][index] == cellStatuses[1][index] && cellStatuses[0][index] == -1 &&
                        cellStatuses[2][index] == 0) {/* In each column if the first and second cells
                        are free with the last cell played by the system.*/
                    int[] freeCellsRowIndexArray = {0, 1};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndex = freeCellsRowIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsRowIndex][index].setText("O");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndex][index] = 0;
                    systemPlayed = true;// system has played.
                    break; // breaks out of the for loop.
                } else if (cellStatuses[1][index] == cellStatuses[2][index] && cellStatuses[1][index] == -1 &&
                        cellStatuses[0][index] == 0) {/* Else in each column if the second and last cells
                are free with the first cell played by system.*/
                    int[] freeCellsRowIndexArray = {1, 2};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndex = freeCellsRowIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsRowIndex][index].setText("O");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndex][index] = 0;
                    systemPlayed = true;// system has played
                    break; // breaks out of the for loop.
                } else if (cellStatuses[0][index] == cellStatuses[2][index] && cellStatuses[0][index] == -1 &&
                        cellStatuses[1][index] == 0) {/* Else in each column if the first and last cells
                    have been played with the second cell free.*/
                    int[] freeCellsRowIndexArray = {0, 2};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndex = freeCellsRowIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsRowIndex][index].setText("O");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndex][index] = 0;
                    systemPlayed = true;// system has played
                    break; // breaks out of the for loop.
                }
            }

            if (!systemPlayed) {// if system has still not played

                if (cellStatuses[0][0] == cellStatuses[1][1] && cellStatuses[0][0] == -1 &&
                        cellStatuses[2][2] == 0) {/* In the left-to-right diagonal, if the first and
                         second cells in the diagonal are free with the last cell played by system.*/
                    int[] freeCellsIndexArray = {0, 1};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsIndex = freeCellsIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsIndex][oneOfFreeCellsIndex].setText("O");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[oneOfFreeCellsIndex][oneOfFreeCellsIndex] = 0;
                    systemPlayed = true;// system has played

                } else if (cellStatuses[1][1] == cellStatuses[2][2] && cellStatuses[1][1] == -1 &&
                        cellStatuses[0][0] == 0) {/* In the left-to-right diagonal, if the second
                        and last cells in the diagonal are free with the first cell played by system.*/
                    int[] freeCellsIndexArray = {1, 2};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsIndex = freeCellsIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsIndex][oneOfFreeCellsIndex].setText("O");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[oneOfFreeCellsIndex][oneOfFreeCellsIndex] = 0;
                    systemPlayed = true;// system has played

                } else if (cellStatuses[0][0] == cellStatuses[2][2] && cellStatuses[0][0] == -1 &&
                        cellStatuses[1][1] == 0) {/* /* In the left-to-right diagonal, if the first
                        and last cells in the diagonal are free with the second cell played by system.*/
                    int[] freeCellsIndexArray = {0, 2};// array stores the index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsIndex = freeCellsIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsIndex][oneOfFreeCellsIndex].setText("O");/* Then system randomly
                    clicks one of the the free cells.*/
                    cellStatuses[oneOfFreeCellsIndex][oneOfFreeCellsIndex] = 0;
                    systemPlayed = true;// system has played

                } else if (cellStatuses[0][2] == cellStatuses[1][1] && cellStatuses[2][0] == -1 &&
                        cellStatuses[0][2] == 0) {/* In the right-to-left diagonal, if the first and
                        second cells in the diagonal are free with the last cell played by system.*/
                    int[] freeCellsRowIndexArray = {0, 1};// array store the row index of the free cells.
                    int[] freeCellsColumnIndexArray = {2, 1};// array store the column index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndex = freeCellsRowIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random row index of the free cells index.*/
                    int oneOfFreeCellsColumnIndex = freeCellsColumnIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random column index of the free cells index.*/
                    buttons2D[oneOfFreeCellsRowIndex][oneOfFreeCellsColumnIndex].setText("O");/* system
                    randomly clicks one the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndex][oneOfFreeCellsColumnIndex] = 0;
                    systemPlayed = true;// system has played.

                } else if (cellStatuses[1][1] == cellStatuses[2][0] && cellStatuses[1][1] == -1 &&
                        cellStatuses[0][2] == 0) {/* In the right-to-left diagonal, if the second and
                         last cells in the diagonal are free with the first cell played by system.*/
                    int[] freeCellsRowIndexArray = {1, 2};// array store the row index of the free cells.
                    int[] freeCellsColumnIndexArray = {1, 0};// array store the column index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndex = freeCellsRowIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random row index of the free cells index.*/
                    int oneOfFreeCellsColumnIndex = freeCellsColumnIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random column index of the free cells index.*/
                    buttons2D[oneOfFreeCellsRowIndex][oneOfFreeCellsColumnIndex].setText("O");/* system
                    randomly clicks one the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndex][oneOfFreeCellsColumnIndex] = 0;/* cellStatus
                    is updated.*/
                    systemPlayed = true;// system has played.

                } else if (cellStatuses[0][2] == cellStatuses[2][0] && cellStatuses[0][2] == -1 &&
                        cellStatuses[1][1] == 0) {/* In the right-to-left diagonal, if the first and
                        last cells in the diagonal are free with the second cell played by system.*/
                    int[] freeCellsRowIndexArray = {0, 2};// array store the row index of the free cells.
                    int[] freeCellsColumnIndexArray = {2, 0};// array store the column index of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndex = freeCellsRowIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random row index of the free cells index.*/
                    int oneOfFreeCellsColumnIndex = freeCellsColumnIndexArray[randomIndex];/* the
                    generated randomIndex is used to get a random column index of the free cells index.*/
                    buttons2D[oneOfFreeCellsRowIndex][oneOfFreeCellsColumnIndex].setText("O");/* system
                    randomly clicks one the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndex][oneOfFreeCellsColumnIndex] = 0;/* cellStatus
                    is updated.*/
                    systemPlayed = true;// system has played.
                }
            }
        }
    }

    /**
     * This method guides the system to check any free cell and play. It checks through rows and
     * columns randomly till plays.
     */
    @SuppressWarnings("UnnecessaryContinue")
    private void playAnyFreeCell() {
        Button[][] buttons2D = {{button11, button12, button13}, {button21, button22, button23},
                {button31, button32, button33}};

            while (!systemPlayed) {// while system has not played.
                int randRowIndex = (int) (Math.random() * 3);// generates a random row index.
                int randColIndex = (int) (Math.random() * 3);// generates a random column index
                if (cellStatuses[randRowIndex][randColIndex] == 0 ||
                        cellStatuses[randRowIndex][randColIndex] == 1) {/* if the selected cell has been
                            played.*/
                    continue;// continue to the next iteration of the loop.

                } else {// if the selected cell has not been played.
                    if (playX) {// if system plays X
                        buttons2D[randRowIndex][randColIndex].setText("X");/* the cell in the present iteration
                    of the for loop is clicked.*/
                        cellStatuses[randRowIndex][randColIndex] = 1;
                        systemPlayed = true;
                        break;
                    } else {// if system plays O
                        buttons2D[randRowIndex][randColIndex].setText("O");/* the cell in the present iteration
                    of the for loop is clicked.*/
                        cellStatuses[randRowIndex][randColIndex] = 0;// cellStatus is updated.
                        systemPlayed = true;
                        break;
                    }
                }
            }
    }


    /**
     * This method guides the system to check any free cell on the 5 by 5 game board and play. It checks
     * each column each row of each row starting from the first.
     */
    @SuppressWarnings("UnnecessaryContinue")
    private void playAnyFreeCell5By5() {
        Button[][] buttons2D5By5 = {{button115By5, button125By5, button135By5, button145By5, button155By5},
                {button215By5, button225By5, button235By5, button245By5, button255By5},
                {button315By5, button325By5, button335By5, button345By5, button355By5},
                {button415By5, button425By5, button435By5, button445By5, button455By5},
                {button515By5, button525By5, button535By5, button545By5, button555By5}};
        while (!systemPlayed) {
            int randRowIndex = (int)(Math.random() * 5);// generates a random row index.
            int randColIndex = (int)(Math.random() * 5);// generates a random column index.
            if (cellStatuses5By5[randRowIndex][randColIndex] == 0 ||
                    cellStatuses5By5[randRowIndex][randColIndex] == 1) {/* if the selected cell has been
                            played.*/
                continue;// continue to the next iteration of the loop.

            } else {// if the selected cell has not been played.
                if (playX) {// if system plays X
                    buttons2D5By5[randRowIndex][randColIndex].setText("X");/* the cell in the present iteration
                    of the for loop is clicked.*/
                    cellStatuses5By5[randRowIndex][randColIndex] = 1;
                    systemPlayed = true;
                    break;
                } else {// if system plays O
                    buttons2D5By5[randRowIndex][randColIndex].setText("O");/* the cell in the present iteration
                    of the for loop is clicked.*/
                    cellStatuses5By5[randRowIndex][randColIndex] = 0;// cellStatus is updated.
                    systemPlayed = true;
                    break;
                }
            }
        }

        /*
        for (int rowIndex = 0; rowIndex < 5; rowIndex++) {// in each row.
            if (systemPlayed) {// if system has played.
                break; // break out of the loop.
            }
            for (int colIndex = 0; colIndex < 5; colIndex++) {// each column

            }
        }*/
    }

    /** Method handles click from the play 3 by 3 and play 5 by 5 buttons.*/
    public void playSize(View view) {
        switch (view.getId()) {/* switch statement checks the id of the clicked button against IDs of
            each play size button.*/
            case R.id.play_3by3_button:// if the play 3 by 3 button is clicked.
                gameBoard5By5.setVisibility(View.GONE);// the 5 by 5 game board disappears.
                gameBoard.setVisibility(View.VISIBLE);// the 3 by 3 game board appears.
                play3By3Button.setVisibility(View.GONE);// play 3 by 3 button disappears.
                play5By5Button.setVisibility(View.VISIBLE);// play 5 by 5 button appears.
                play3By3 = true;// players has chosen to play 3 by 3.
                break;

            case R.id.play_5by5_button:// if the play 5 by 5 button is clicked.
                gameBoard.setVisibility(View.GONE);// the 3 by 3 game board disappears.
                gameBoard5By5.setVisibility(View.VISIBLE);// the 5 by 5 game board appears.
                play5By5Button.setVisibility(View.GONE);// play 5 by 5 button disappears.
                play3By3Button.setVisibility(View.VISIBLE);// play 3 by 3 button appears.
                play3By3 = false;// players has chosen otherwise of 3 by 3 (5 by 5).
                break;
        }
        resetButton.performClick();// game is reset.
        player1Score = 0; // first player's score is set to 0.
        player2Score = 0; // first player's score is set to 0.
        player1ScoreTextView.setText("" + player1Score); // resets the score board to 0.
        player2ScoreTextView.setText("" + player2Score); // resets the score board to 0.
    }
}
