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

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /**
     * player1Score and player2Score saves the score of the first and second players respectively.
     * turnCount is an integer variable that keeps track of the number of turns made.
     */
    int player1Score = 0;
    int player2Score = 0;
    int turnCount = 0;

    /**
     * button11 to button33 are Button objects for each cell on the 3 by 3 game board.
     * button11_5By5 to button55_5By5 are Button objects for each cells on the 5 by 5 game board.
     * resetButton is the Button object for resetting the game board and score board.
     * play3By3Button and play5By5Button are Button objects for choosing to play on the 3 by 3 or
     * the
     * 5 by 5 game board.
     */
    Button button11, button12, button13, button21, button22, button23, button31, button32, button33,
            button11_5By5, button12_5By5, button13_5By5, button14_5By5, button15_5By5,
            button21_5By5, button22_5By5, button23_5By5, button24_5By5, button25_5By5,
            button31_5By5, button32_5By5, button33_5By5, button34_5By5, button35_5By5,
            button41_5By5, button42_5By5, button43_5By5, button44_5By5, button45_5By5,
            button51_5By5, button52_5By5, button53_5By5, button54_5By5, button55_5By5, resetButton,
            play3By3Button, play5By5Button;

    /** gameBoard is a TableLayout object bounded to the 3 by 3 game board.*/
    TableLayout gameBoard;

    /** gameBoard5By5 is a HorizontalScrollView object bounded to the 5 by 5 game board.*/
    HorizontalScrollView gameBoard5By5;

    /**
     * boolean variable systemPlayed checks if the system has played its turn in a single player
     * mode.
     * boolean variable gotWinner checks if a winner has emerged of the two players.
     * boolean variable playX tracks the turn of play. If the turn will play X then playX is true,
     * otherwise playX is false.
     * boolean variable playSingle tracks if the user chose to play against the bot (true) or
     * another human (false).
     * boolean play3By3 tracks if the user chose to play on the 3 by 3 game board or the 5 by 5
     * game board.
     */
    boolean systemPlayed = false;
    boolean gotWinner = false;
    boolean playX = true;
    boolean playSingle = false;
    boolean play3By3 = true;

    /**
     * playTypeRadios is RadioGroup object for either single player or double player.
     * playSignRadios is RadioGroup object for either X or O as the first player sign.
     */
    RadioGroup playTypeRadios;
    RadioGroup playSignRadios;

    /**
     * turnTextView connects with the TextView that displays whose turn it is in the UI.
     * player1ScoreTextView connects with the TextView that displays the score for the first player
     * player2ScoreTextView connects with the TextView that displays the score for the second player
     */
    TextView player1ScoreTextView;
    TextView player2ScoreTextView;
    TextView turnTextView;

    /**
     * cellStatuses saves the statuses of the cells on the 3 by 3 game board in a 2-D array.
     * cellStatuses5by5 saves the statuses of the cells on the 5 by 5 game board in a 2-D array.
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
        button11_5By5 = findViewById(R.id.cell11_5by5);
        button12_5By5 = findViewById(R.id.cell12_5by5);
        button13_5By5 = findViewById(R.id.cell13_5by5);
        button14_5By5 = findViewById(R.id.cell14_5by5);
        button15_5By5 = findViewById(R.id.cell15_5by5);
        button21_5By5 = findViewById(R.id.cell21_5by5);
        button22_5By5 = findViewById(R.id.cell22_5by5);
        button23_5By5 = findViewById(R.id.cell23_5by5);
        button24_5By5 = findViewById(R.id.cell24_5by5);
        button25_5By5 = findViewById(R.id.cell25_5by5);
        button31_5By5 = findViewById(R.id.cell31_5by5);
        button32_5By5 = findViewById(R.id.cell32_5by5);
        button33_5By5 = findViewById(R.id.cell33_5by5);
        button34_5By5 = findViewById(R.id.cell34_5by5);
        button35_5By5 = findViewById(R.id.cell35_5by5);
        button41_5By5 = findViewById(R.id.cell41_5by5);
        button42_5By5 = findViewById(R.id.cell42_5by5);
        button43_5By5 = findViewById(R.id.cell43_5by5);
        button44_5By5 = findViewById(R.id.cell44_5by5);
        button45_5By5 = findViewById(R.id.cell45_5by5);
        button51_5By5 = findViewById(R.id.cell51_5by5);
        button52_5By5 = findViewById(R.id.cell52_5by5);
        button53_5By5 = findViewById(R.id.cell53_5by5);
        button54_5By5 = findViewById(R.id.cell54_5by5);
        button55_5By5 = findViewById(R.id.cell55_5by5);
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
     * Handles clicks from the RadioButtons "Play as X" and "Play as O", updates the value of the
     * boolean variable playX to either true or false and resets the game board and the score board.
     */
    public void onPlaySignRadioClicked(View view) {
        switch (view.getId()) { // switch statement compares the ID of the clicked RadioButton.
            case R.id.play_x: // if "Play as X" was clicked.
                playX = true; // sets boolean variable playX to true.
                turnTextView.setText(R.string.x_turn); // displays X's turn.
                break;

            case R.id.play_o: // if "Play as O" was clicked.
                playX = false; // sets boolean variable playX to false.
                turnTextView.setText(R.string.o_turn); // displays O's turn.
                break;
        }
        resetButton.performClick(); // resetButton is auto clicked clearing the game board.
        player1Score = 0; // first player's score is set to 0.
        player2Score = 0; // second player's score is set to 0.
        player1ScoreTextView.setText("" + player1Score); // displays first player's score (as 0).
        player2ScoreTextView.setText("" + player2Score); // displays second player's score (as 0).
    }

    /**
     * Handles clicks from RadioButtons "vs. Bot" and "vs. Human", updates the value of boolean the
     * variable playSingle to either true or false and resets the game board and the score board.
     */
    public void onPlayTypeRadioClicked(View view) {
        switch (view.getId()) {// switch statement compares the ID of the clicked RadioButton.
            case R.id.single_player: // if "vs. Bot" was clicked.
                playSingle = true; // playSingle is set to true.
                break;
            case R.id.double_player: // if Play with another was clicked.
                playSingle = false; // boolean variable playSingle is set to false.
                break;
        }
        resetButton.performClick(); // resetButton is auto clicked clearing the game board.
        player1Score = 0; // first player's score is set to 0.
        player2Score = 0; // second player's score is set to 0.
        player1ScoreTextView.setText("" + player1Score); // displays first player's score (as 0).
        player2ScoreTextView.setText("" + player2Score); // displays second player's score (as 0).
    }


    /**
     * Handles clicks from buttons on the game boards. If the number of turns made is up to 5 (for
     * the 3 by 3 game board) or 9 (for the 5 by 5 game board) it checks for winner.
     * System's turn of play is embedded in here in case the user chose to play against the bot.
     */
    @SuppressWarnings("UnnecessaryReturnStatement")
    public void onAnyGameBoardCellClicked(View view) {
        if (play3By3) {// if player chose to play the 3 by 3 game board.
            if (!gotWinner) {// if no winner has emerged.
                switch (view.getId()) { // compares the ID of the clicked button.
                    case R.id.cell11: // if cell11 is clicked.
                        if (cellStatuses[0][0] == -1) { // If the cell has not been played before.
                            if (playX) { // if player X's turn.
                                button11.setText("X"); // sets cell's text to X.
                                cellStatuses[0][0] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button11.setText("O"); // sets cell's text to O.
                                cellStatuses[0][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell12: // if cell12 is clicked.
                        if (cellStatuses[0][1] == -1) { // If the cell has not been played before.
                            if (playX) { // if player X's turn.
                                button12.setText("X"); // sets cell's text to X
                                cellStatuses[0][1] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button12.setText("O"); // sets cell's text to O
                                cellStatuses[0][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell13: // if cell13 is clicked.
                        if (cellStatuses[0][2] == -1) { // If the cell has not been played before.
                            if (playX) { // if player X's turn.
                                button13.setText("X"); // sets cell's text to X
                                cellStatuses[0][2] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button13.setText("O"); // sets cell's text to O
                                cellStatuses[0][2] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell21: // if cell21 is clicked.
                        if (cellStatuses[1][0] == -1) { // If the cell has not been played before.
                            if (playX) { // if player X's turn.
                                button21.setText("X"); // sets cell's text to X
                                cellStatuses[1][0] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button21.setText("O"); // sets cell's text to O
                                cellStatuses[1][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell22: // if cell22 is clicked.
                        if (cellStatuses[1][1] == -1) { // If the cell has not been played before.
                            if (playX) { // if player X's turn.
                                button22.setText("X"); // sets cell's text to X
                                cellStatuses[1][1] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button22.setText("O"); // sets cell's text to O
                                cellStatuses[1][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell23: // if cell23 is clicked.
                        if (cellStatuses[1][2] == -1) { // If the cell has not been played before.
                            if (playX) { // if player X's turn.
                                button23.setText("X"); // sets cell's text to X
                                cellStatuses[1][2] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button23.setText("O"); // sets cell's text to O
                                cellStatuses[1][2] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell31: // if cell31 is clicked.
                        if (cellStatuses[2][0] == -1) { // If the cell has not been played before.
                            if (playX) { // if player X's turn.
                                button31.setText("X"); // sets cell's text to X
                                cellStatuses[2][0] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button31.setText("O"); // sets cell's text to O
                                cellStatuses[2][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell32: // if cell32 is clicked.
                        if (cellStatuses[2][1] == -1) { // If the cell has not been played before.
                            if (playX) { // if player X's turn.
                                button32.setText("X"); // sets cell's text to X
                                cellStatuses[2][1] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button32.setText("O"); // sets cell's text to O
                                cellStatuses[2][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell33: // if cell33 is clicked.
                        if (cellStatuses[2][2] == -1) { // If the cell has not been played before.
                            if (playX) { // if player X's turn.
                                button33.setText("X"); // sets cell's text to X
                                cellStatuses[2][2] = 1; // updates the cell status.
                            } else { // if player O's turn.
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
                    checkWinner();// Checks for winner.
                }
                if (playX) {// if playX is true.
                    turnTextView.setText(R.string.x_turn); // X's turn is displayed. X plays next.
                } else {// if playX is false.
                    turnTextView.setText(R.string.o_turn); // O's turn is displayed. O plays next.
                }
                if (playSingle && turnCount != 9 && !gotWinner && !systemPlayed) {/* if player chose
                to play against the system and all moves have not been made while a winner has not
                emerged yet and system has not played.*/
                    systemPlay();// system plays.
                }
            }
        } else { // if player chose to play on the 5 by 5 game board.
            if (!gotWinner) { // if no winner has emerged.

                switch (view.getId()) { // compares the ID of the clicked button.
                    case R.id.cell11_5by5: // if cell11_5by5 is clicked.
                        if (cellStatuses5By5[0][0] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button11_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[0][0] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button11_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[0][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell12_5by5: // if cell12_5by5 is clicked.
                        if (cellStatuses5By5[0][1] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button12_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[0][1] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button12_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[0][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell13_5by5: // if cell13_5by5 is clicked.
                        if (cellStatuses5By5[0][2] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button13_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[0][2] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button13_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[0][2] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell14_5by5: // if cell14_5by5 is clicked.
                        if (cellStatuses5By5[0][3] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button14_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[0][3] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button14_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[0][3] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell15_5by5: // if cell15_5by5 is clicked.
                        if (cellStatuses5By5[0][4] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button15_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[0][4] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button15_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[0][4] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell21_5by5: // if cell21_5by5 is clicked.
                        if (cellStatuses5By5[1][0] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button21_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[1][0] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button21_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[1][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell22_5by5: // if cell22_5by5 is clicked.
                        if (cellStatuses5By5[1][1] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button22_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[1][1] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button22_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[1][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell23_5by5: // if cell23_5by5 is clicked.
                        if (cellStatuses5By5[1][2] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button23_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[1][2] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button23_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[1][2] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell24_5by5: // if cell24_5by5 is clicked.
                        if (cellStatuses5By5[1][3] == -1) {
                            if (playX) { // if it is player X's turn.
                                button24_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[1][3] = 1; // updates the cell status.
                            } else { // if it is player O's turn.
                                button24_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[1][3] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;

                    case R.id.cell25_5by5: // if cell25_5by5 is clicked.
                        if (cellStatuses5By5[1][4] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button25_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[1][4] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button25_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[1][4] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell31_5by5: // if cell31_5by5 is clicked.
                        if (cellStatuses5By5[2][0] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button31_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[2][0] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button31_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[2][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell32_5by5: // if cell32_5by5 is clicked.
                        if (cellStatuses5By5[2][1] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button32_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[2][1] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button32_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[2][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell33_5by5: // if cell33_5by5 is clicked.
                        if (cellStatuses5By5[2][2] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button33_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[2][2] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button33_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[2][2] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell34_5by5: // if cell34_5by5 is clicked.
                        if (cellStatuses5By5[2][3] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button34_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[2][3] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button34_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[2][3] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell35_5by5: // if cell35_5by5 is clicked.
                        if (cellStatuses5By5[2][4] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button35_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[2][4] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button35_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[2][4] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell41_5by5: // if cell41_5by5 is clicked.
                        if (cellStatuses5By5[3][0] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button41_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[3][0] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button41_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[3][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell42_5by5: // if cell42_5by5 is clicked.
                        if (cellStatuses5By5[3][1] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button42_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[3][1] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button42_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[3][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell43_5by5: // if cell43_5by5 is clicked.
                        if (cellStatuses5By5[3][2] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button43_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[3][2] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button43_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[3][2] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell44_5by5: // if cell44_5by5 is clicked.
                        if (cellStatuses5By5[3][3] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button44_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[3][3] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button44_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[3][3] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell45_5by5: // if cell45_5by5 is clicked.
                        if (cellStatuses5By5[3][4] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button45_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[3][4] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button45_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[3][4] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell51_5by5: // if cell51_5by5 is clicked.
                        if (cellStatuses5By5[4][0] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button51_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[4][0] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button51_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[4][0] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell52_5by5: // if cell52_5by5 is clicked.
                        if (cellStatuses5By5[4][1] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button52_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[4][1] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button52_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[4][1] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell53_5by5: // if cell53_5by5 is clicked.
                        if (cellStatuses5By5[4][2] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button53_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[4][2] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button53_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[4][2] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell54_5by5: // if cell54_5by5 is clicked.
                        if (cellStatuses5By5[4][3] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button54_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[4][3] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button54_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[4][3] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                    case R.id.cell55_5by5: // if cell55_5by5 is clicked.
                        if (cellStatuses5By5[4][4] == -1) { // If the cell has not been played.
                            if (playX) { // if player X's turn.
                                button55_5By5.setText("X"); // sets cell's text to X
                                cellStatuses5By5[4][4] = 1; // updates the cell status.
                            } else { // if player O's turn.
                                button55_5By5.setText("O"); // sets cell's text to O
                                cellStatuses5By5[4][4] = 0; // updates the cell status.
                            }
                            systemPlayed = false;// system has not played.
                            playX = !playX; // current value of playX is negated.
                            turnCount++; // turnCount is incremented.
                        }
                        break;
                }
                if (turnCount > 8) { // winner is only obtainable when turnCount is > 8.
                    checkWinner5By5(); // checks for winner.
                }
                if (playX) {// if playX is true.
                    turnTextView.setText(R.string.x_turn); // X's turn is displayed. X plays next.
                } else {// if playX is false.
                    turnTextView.setText(R.string.o_turn); // O's turn is displayed. O plays next.
                }
                if (playSingle && turnCount != 25 && !gotWinner && !systemPlayed) {/* if player
                chose to play against the system and all moves have not been made while winner has
                not emerged and system has not played.*/
                    systemPlay5By5();// system plays.
                }
            }
        }
    }

    /**
     * Resets gotWinner to false, turnCount to 0, playX to either true or false based on checked
     * RadioButton (and the turnTextView), as well as playSingle. Each cell's text is reset to blank
     * text.
     * In case of the single player mode, if user was the last player, then system plays first on
     * the new round of the game.
     */
    public void reset(View view) {

        if (play3By3) { // if player chose to play on the 3 by 3 game board.
            // for loops resets all values of cellStatuses to -1.
            for (int indexRow = 0; indexRow < cellStatuses.length; indexRow++) {
                for (int indexCol = 0; indexCol < cellStatuses[0].length; indexCol++) {
                    cellStatuses[indexRow][indexCol] = -1;
                }
            }
            // buttonsArray stores Button objects of the 3 by 3 game board.
            Button[] buttonsArray = {button11, button12, button13, button21, button22, button23,
                    button31, button32, button33};
            // for loop sets the content of each cell on the game board to empty string.
            for (Button each : buttonsArray) {
                each.setText("");
            }
        } else { // if player chose to play on the 5 by 5 game board.
            // for loops resets all values of cellStatuses5By5 to -1.
            for (int indexRow = 0; indexRow < cellStatuses5By5.length; indexRow++) {
                for (int indexCol = 0; indexCol < cellStatuses5By5[0].length; indexCol++) {
                    cellStatuses5By5[indexRow][indexCol] = -1;
                }
            }
            // buttonsArray5By5 stores Button objects of the 5 by 5 game board.
            Button[] buttonsArray5By5 = {button11_5By5, button12_5By5, button13_5By5, button14_5By5,
                    button15_5By5, button21_5By5, button22_5By5, button23_5By5, button24_5By5,
                    button25_5By5, button31_5By5, button32_5By5, button33_5By5, button34_5By5,
                    button35_5By5, button41_5By5, button42_5By5, button43_5By5, button44_5By5,
                    button45_5By5, button51_5By5, button52_5By5, button53_5By5, button54_5By5,
                    button55_5By5};
            // for loop sets the content of each cell on the game board to empty string.
            for (Button each : buttonsArray5By5) {
                each.setText("");
            }
        }
        gotWinner = false; // boolean variable gotWinner is set to false
        turnCount = 0; // int variable turnCount is set to zero.

        if (playSingle) { // if the player chose to play against computer.
                switch (playSignRadios.getCheckedRadioButtonId()) { /* switch statement checks the
                checked play sign.*/
                    case R.id.play_x: // if user plays as X.
                        if (!playX) { /* if player made the last move in the last round of the game
                        then system plays first.*/
                            if (play3By3) { // if player  chose to play 3 by 3 game board.
                                systemPlay(); // system plays on the 3 by 3 game board.
                            } else {// if player chose to play 5 by 5 game board,
                                systemPlay5By5();// system plays on the 5 by 5 game board.
                            }
                        }
                        break;
                    case R.id.play_o: // if user plays as O.
                        if (playX) { /* if player made the last move in the last round of the game
                        then system plays first.*/
                            if (play3By3) { // if player  chose to play 3 by 3.
                                systemPlay(); // system plays on the 3 by 3 game board.
                            } else {// if player chose to play 5 by 5 game board,
                                systemPlay5By5();// system plays on the 5 by 5 game board.
                            }
                        }
                        break;
                }
        }
        if (playX) {// if playX is true.
            turnTextView.setText(R.string.x_turn); // X's turn is displayed. X plays next.
        } else {// if playX is false.
            turnTextView.setText(R.string.o_turn); // O's turn is displayed. O plays next.
        }
    }

    /**
     * Checks if there is winner, who it is, displays who win, updates the score
     * and displays it.
     */
    private void checkWinner() {
        gotWinner = false; // If we're checking for winner then winner has not emerged.
        for (int index = 0; index < 3; index++) {// The three rows.
            if (gotWinner) { // If winner has emerged
                break; // breaks out of the loop.
            }
            if (cellStatuses[index][0] == cellStatuses[index][1] && cellStatuses[index][1] ==
                    cellStatuses[index][2] && (cellStatuses[index][0] == 0 ||
                    cellStatuses[index][0] == 1)) {/* if the three elements are the same and
                        either of O and 1 in value. */
                gotWinner = true; // a winner has emerged.
                switch (cellStatuses[index][0]) { /* switch statement tests the value against
                        0 and 1 to get the winner. */
                    case 0: // if the value is 0
                        // Toast announces player O as the winner.
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; // player O is player 2 and his score is incremented
                            player2ScoreTextView.setText("" + player2Score);//new score is displayed
                        } else {// if the first player's sign is O.
                            player1Score++; // player O is player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        }
                        break;
                    case 1: // if the value is 1
                        // Toast announces player X as the winner.
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; // player X is player 1 and his score is incremented
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        } else {// if the first player's sign is O.
                            player2Score++; // player X is player 2 and his score is incremented
                            player2ScoreTextView.setText("" + player2Score);//new score is displayed
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
                        // Toast announces player O as the winner.
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; // player O is player 2 and his score is incremented
                            player2ScoreTextView.setText("" + player2Score);//new score is displayed
                        } else { // if the first player's sign is O.
                            player1Score++; // player O is player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        }
                        break;
                    case 1: // if the value is 1
                        // Toast announces player X as the winner.
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; // player X is player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        } else { // if the first player's sign is O.
                            player2Score++; // player X is player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score);//new score is displayed
                        }
                        break;
                }
            }
        }
        // the left-to-right diagonal.
        if (!gotWinner) { // if winner has still not emerged.
            if (cellStatuses[0][0] == cellStatuses[1][1] && cellStatuses[1][1] ==
                    cellStatuses[2][2] && (cellStatuses[0][0] == 0 || cellStatuses[0][0] == 1)) {
                    // if the three elements are the same and either of O and 1 in value.
                gotWinner = true; // a winner has emerged.
                switch (cellStatuses[0][0]) { /* switch statement tests the value against
                        0 and 1 to get the winner. */
                    case 0: // if the value is 0
                        // Toast announces player O as the winner.
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; // player O is player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score);//the score is displayed
                        } else { // if the first player's sign is O.
                            player1Score++; // player O is player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        }
                        break;

                    case 1: // if the value is 1
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        // Toast announces player X as the winner.

                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; // player X is player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        } else { // if the first player's sign is O.
                            player2Score++; // player X is player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score);//new score is displayed
                        }
                        break;
                }
            }
        }
        // the right-to-left diagonal.
        if (!gotWinner) { // if winner has still not emerged.
            if (cellStatuses[0][2] == cellStatuses[1][1] && cellStatuses[1][1] ==
                    cellStatuses[2][0] && (cellStatuses[0][2] == 0 || cellStatuses[0][2] == 1)) {
                    // if the three elements are the same and either of O and 1 in value.
                gotWinner = true; // a winner has emerged.
                switch (cellStatuses[0][2]) { /* switch statement tests the value against
                        0 and 1 to get the winner. */
                    case 0: // if the value is 0
                        // Toast announces player O as the winner.
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; // player O is player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score);//new score is displayed
                        } else { // if the first player's sign is O.
                            player1Score++; // player O is player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        }
                        break;
                    case 1: // if the value is 1
                        // Toast announces player X as the winner.
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; // player X is player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        } else { // if the first player's sign is O.
                            player2Score++; // player X is player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score);//new score is displayed
                        }
                        break;
                }
            }
        }
        if (!gotWinner && turnCount == 9) { // if no winner emerged and all move had been made.
            // Toast displays "Draw!".
            Toast.makeText(this, R.string.draw, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Checks if there is winner on the 5 by 5 game board, who it is, displays who win, updates the score
     * and displays it.
     */
    private void checkWinner5By5() {
        gotWinner = false; // If we're checking for winner then winner has not emerged.
        for (int index = 0; index < 5; index++) {// The five rows.
            if (gotWinner) { // If winner has emerged
                break; // breaks out of the loop.
            }
            if (cellStatuses5By5[index][0] == cellStatuses5By5[index][1] &&
                    cellStatuses5By5[index][1] == cellStatuses5By5[index][2] &&
                    cellStatuses5By5[index][2] == cellStatuses5By5[index][3] &&
                    cellStatuses5By5[index][3] == cellStatuses5By5[index][4] &&
                    (cellStatuses5By5[index][0] == 0 || cellStatuses5By5[index][0] == 1)) {
                // if the five elements are the same and either of O and 1 in value.
                gotWinner = true; // a winner has emerged.
                switch (cellStatuses5By5[index][0]) { /* switch statement tests the value against
                        0 and 1 to get the winner. */
                    case 0: // if the value is 0
                        // Toast announces player O as the winner.
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; //player O is player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score);//new score is displayed
                        } else { // if the first player's sign is O.
                            player1Score++; // player O is player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        }
                        break;
                    case 1: // if the value is 1
                        // Toast announces player X as the winner.
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; // player X is player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        } else { // if the first player's sign is O.
                            player2Score++; // player X is player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score);//new score is displayed
                        }
                        break;
                }
                // the five columns.
            } else if (cellStatuses5By5[0][index] == cellStatuses5By5[1][index] &&
                    cellStatuses5By5[1][index] == cellStatuses5By5[2][index] &&
                    cellStatuses5By5[2][index] == cellStatuses5By5[3][index] &&
                    cellStatuses5By5[3][index] == cellStatuses5By5[4][index] &&
                    (cellStatuses5By5[0][index] == 0 || cellStatuses5By5[0][index] == 1)) {
                // if the three elements are the same and either of O and 1 in value.
                gotWinner = true; // a winner has emerged.
                switch (cellStatuses5By5[0][index]) { /* switch statement tests the value against
                        0 and 1 to get the winner. */
                    case 0: // if the value is 0
                        // Toast announces player O as the winner.
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; // player O is player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score);//new score is displayed
                        } else { // if the first player's sign is O.
                            player1Score++; // player O is player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        }
                        break;
                    case 1: // if the value is 1
                        // Toast announces player X as the winner.
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; // player X is player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        } else { // if the first player's sign is O.
                            player2Score++; // player X is player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score);//new score is displayed
                        }
                        break;
                }
            }
        }
        // the left-to-right diagonal.
        if (!gotWinner) { // if winner has still not emerged.
            if (cellStatuses5By5[0][0] == cellStatuses5By5[1][1] && cellStatuses5By5[1][1] ==
                    cellStatuses5By5[2][2] && cellStatuses5By5[2][2] == cellStatuses5By5[3][3] &&
                    cellStatuses5By5[3][3] == cellStatuses5By5[4][4] && (cellStatuses5By5[0][0] == 0
                    || cellStatuses5By5[0][0] == 1)) {
                    // if the five elements are the same and either of O and 1 in value.
                gotWinner = true; // a winner has emerged.

                switch (cellStatuses5By5[0][0]) { /* switch statement tests the value against
                        0 and 1 to get the winner. */
                    case 0: // if the value is 0
                        // Toast announces player O as the winner.
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; // player O is player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score);//new score is displayed
                        } else  { // if the first player's sign is O.
                            player1Score++; // player O is player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        }
                        break;
                    case 1: // if the value is 1
                        // Toast announces player X as the winner.
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; // player X is player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        } else { // if the first player's sign is O.
                            player2Score++; // player X is player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score);//new score is displayed
                        }
                        break;
                }
            }
        }
        // the right-to-left diagonal.
        if (!gotWinner) { // if winner has still not emerged.
            if (cellStatuses5By5[0][4] == cellStatuses5By5[1][3] && cellStatuses5By5[1][3] ==
                    cellStatuses5By5[2][2] && cellStatuses5By5[2][2] == cellStatuses5By5[3][1] &&
                    cellStatuses5By5[3][1] == cellStatuses5By5[4][0] && (cellStatuses5By5[0][4] ==
                    0 || cellStatuses5By5[0][4] == 1)) {
                    /* if the five elements are the same and either of O and 1 in value. */
                gotWinner = true; // a winner has emerged.
                switch (cellStatuses5By5[0][4]) { /* switch statement tests the value against
                        0 and 1 to get the winner. */
                    case 0: // if the value is 0
                        // Toast announces player O as the winner.
                        Toast.makeText(this, R.string.o_wins, Toast.LENGTH_LONG).show();
                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player2Score++; // player O is player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score);//new score is displayed
                        } else { // if the first player's sign is O.
                            player1Score++; // player O is player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        }
                        break;
                    case 1: // if the value is 1
                        // Toast announces player X as the winner.
                        Toast.makeText(this, R.string.x_wins, Toast.LENGTH_LONG).show();
                        if (playSignRadios.getCheckedRadioButtonId() == R.id.play_x) {
                            // if the first player chose X as his sign.
                            player1Score++; // player X is player 1 and his score is incremented.
                            player1ScoreTextView.setText("" + player1Score);//new score is displayed
                        } else { // if the first player's sign is O.
                            player2Score++; // player X is player 2 and his score is incremented.
                            player2ScoreTextView.setText("" + player2Score);//new score is displayed
                        }
                        break;
                }
            }
        }
        if (!gotWinner && turnCount == 25) {// if no winner emerged and all moves had been made.
            // Toast displays "Draw!".
            Toast.makeText(this, R.string.draw, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles system's turn of play on the 3 by 3 game board by implementing methods
     * checkForTwoAndPlay(), checkForOneAndPlay() and playAnyFreeCell.
     */
    private void systemPlay() {
        systemPlayed = false; // System has not played.
        checkForTwoAndPlay();/* checks for two cells played by system with a free cell on the same
            line and plays or check if such has been played by opponent and blocks.*/
        if (!systemPlayed) { // if system has still not played.
            checkForOneAndPlay(); /* the system should check for a cell it has played with two free
                cells in the same line to play to move closer to a win.*/
        }
        if (!systemPlayed) { // if system has still not played.
            playAnyFreeCell(); // the system should check and play any free cell.
        }
        if (systemPlayed) { // if system has played.
            turnCount++; // turnCount is incremented.
            playX = !playX; // playX is negated so the next player could play.
            if (playX) { // if playX is true.
                turnTextView.setText(R.string.x_turn); // X's turn is displayed. X plays next.
            } else { // if playX is false.
                turnTextView.setText(R.string.o_turn); // O's turn is displayed. O plays next.
            }
            if (turnCount > 4) {// winner is only obtainable when turnCount is >= 5
                checkWinner(); // Checks for winner
            }
        }
    }


    /**
     * Handles system's turn of play on the 5 by 5 game board by implementing methods
     * checkFourSystemPlaysAndPlayFreeCell(), checkFourOpponentPlaysAndPlayFreeCell(),
     * checkThreeSystemPlaysAndPlayAFreeCellOfTwo(), checkThreeSystemPlaysAndPlayAFreeCellOfTwo(),
     * checkThreeOpponentPlaysAndPlayAFreeCellOfTwo(), playConsecutiveFreeCellsApproachWin(),
     * playAnyFreeCell5By5().
     */
    private void systemPlay5By5() {
        systemPlayed = false;
        checkFourSystemPlaysAndPlayFreeCell();
        // If system has still not played.
        if (!systemPlayed) checkFourOpponentPlaysAndPlayFreeCell();
        // If system has still not played.
        if (!systemPlayed) checkThreeSystemPlaysAndPlayAFreeCellOfTwo();
        // If system has still not played.
        if (!systemPlayed) checkThreeOpponentPlaysAndPlayAFreeCellOfTwo();
        // If system has still not played.
        if (!systemPlayed) playConsecutiveFreeCellsApproachWin();
        // If system has still not played.
        if (!systemPlayed) playAnyFreeCell5By5();
        if (systemPlayed) { // if system has played.
            turnCount++;// turnCount is incremented.
            playX = !playX; // playX is negated so the next player could play.
            if (playX) { // if playX is true.
                turnTextView.setText(R.string.x_turn); // X's turn is displayed. X plays next.
            } else { // if playX is false.
                turnTextView.setText(R.string.o_turn); // O's turn is displayed. O plays next.
            }
            if (turnCount > 8) { // winner is only obtainable when turnCount is > 8
                checkWinner5By5(); // Checks for winner.
            }
        }
    }

    /**
     * Checks for two X in a each row, column or diagonal with a free cell on the line on the 3 by 3
     * game board so the system can play and win.
     * Otherwise it checks for two O (opponent's play) as such and plays to block opponent's win.
     */
    private void checkForTwoXAndPlayToWinOrBlockTwoO() {
        Button[][] buttons2D = {{button11, button12, button13}, {button21, button22, button23},
                {button31, button32, button33}}; /* 2D array stores Button objects of the 3 by 3
        game board.*/
        for (int index = 0; index < 3; index++) {
		/*checking through the 3 rows and 3 columns if system has played 2 rows with a free
		cell on the line to play and win.*/
            if (cellStatuses[index][0] == cellStatuses[index][1] && cellStatuses[index][2] == -1 &&
                    cellStatuses[index][0] == 1) { /* In each row if the first and second cells have
                    been played by the system with a last cell free. */
                buttons2D[index][2].setText("X"); // System plays the free button.
                cellStatuses[index][2] = 1; // cellStatuses is updated.
                systemPlayed = true; // system has played.
                break; // breaks out of the for loop.
            } else if (cellStatuses[index][1] == cellStatuses[index][2] && cellStatuses[index][0] ==
                    -1 && cellStatuses[index][1] == 1) { /* Else in each row if the second and last
                    cells have been played by the system with the first cell free. */
                buttons2D[index][0].setText("X"); // System plays the free cell.
                cellStatuses[index][0] = 1; // cellStatuses is updated.
                systemPlayed = true; // system has played
                break; // breaks out of the for loop.
            } else if (cellStatuses[index][0] == cellStatuses[index][2] && cellStatuses[index][1] ==
                    -1 && cellStatuses[index][0] == 1) { /* Else in each row if the first and last
                    cells have been played with the second cell free.*/
                buttons2D[index][1].setText("X");// System plays the free cell.
                cellStatuses[index][1] = 1; // cellStatuses is updated.
                systemPlayed = true;// system has played.
                break; // breaks out of the for loop.
            } else if (cellStatuses[0][index] == cellStatuses[1][index] && cellStatuses[2][index] ==
                    -1 && cellStatuses[0][index] == 1) { /* In each column if the first and second
                    cells have been played by the system with a last cell free. */
                buttons2D[2][index].setText("X"); // System plays the free button.
                cellStatuses[2][index] = 1; // cellStatuses is updated.
                systemPlayed = true;// system has played.
                break; // breaks out of the for loop.
            } else if (cellStatuses[1][index] == cellStatuses[2][index] && cellStatuses[0][index] ==
                    -1 && cellStatuses[1][index] == 1) { /* Else in each column if the second and
                    last cells have been played by the system with the first cell free. */
                buttons2D[0][index].setText("X");// System plays the free cell.
                cellStatuses[0][index] = 1; // cellStatuses is updated.
                systemPlayed = true;// system has played
                break; // breaks out of the for loop.
            } else if (cellStatuses[0][index] == cellStatuses[2][index] && cellStatuses[1][index] ==
                    -1 && cellStatuses[0][index] == 1) {/* Else in each column if the first and last
                     cells have been played with the second cell free.*/
                buttons2D[1][index].setText("X");// System plays the free cell.
                cellStatuses[1][index] = 1; // cellStatuses is updated.
                systemPlayed = true;// system has played.
                break; // breaks out of the for loop.
            }
        }

        if (!systemPlayed) { // if system has still not played
            if (cellStatuses[0][0] == cellStatuses[1][1] && cellStatuses[2][2] == -1 &&
                    cellStatuses[0][0] == 1) { /* In the left-to-right diagonal, if the first and
                         second cells in the diagonal have been played by system with the last cell
                         free. */
                buttons2D[2][2].setText("X");// the free cell is played.
                cellStatuses[2][2] = 1; // cellStatuses is updated.
                systemPlayed = true;// system has played.
            } else if (cellStatuses[1][1] == cellStatuses[2][2] && cellStatuses[0][0] == -1 &&
                    cellStatuses[1][1] == 1) { /* In the left-to-right diagonal, if the second and
                    last cells in the diagonal have been played by system with the first
                    cell free. */
                buttons2D[0][0].setText("X"); // the free cell is played.
                cellStatuses[0][0] = 1; // cellStatuses is updated.
                systemPlayed = true;// system has played.
            } else if (cellStatuses[0][0] == cellStatuses[2][2] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][0] == 1) { /* In the left-to-right diagonal, if the first and
                    last cells in the diagonal have been played by system with the second cell
                    free. */
                buttons2D[1][1].setText("X");// the free cell is played.
                cellStatuses[1][1] = 1; // cellStatuses is updated.
                systemPlayed = true; // system has played.
            } else if (cellStatuses[0][2] == cellStatuses[1][1] && cellStatuses[2][0] == -1 &&
                    cellStatuses[0][2] == 1) { /* In the right-to-left diagonal, if the first and
                    second cells in the diagonal have been played by system with the last cell
                    free. */
                buttons2D[2][0].setText("X"); // the free cell is played.
                cellStatuses[2][0] = 1; // cellStatuses is updated.
                systemPlayed = true; // system has played.
            } else if (cellStatuses[1][1] == cellStatuses[2][0] && cellStatuses[0][2] == -1 &&
                    cellStatuses[1][1] == 1) { /* In the right-to-left diagonal, if the second and
                         last cells in the diagonal have been played by system with the first cell
                         free. */
                buttons2D[0][2].setText("X");// the free cell is played.
                cellStatuses[0][2] = 1; // cellStatuses is updated.
                systemPlayed = true;// system has played.
            } else if (cellStatuses[0][2] == cellStatuses[2][0] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][2] == 1) { /* In the right-to-left diagonal, if the first and
                        last cells in the diagonal have been played by system with the second cell
                        free.*/
                buttons2D[1][1].setText("X"); // the free cell is played.
                cellStatuses[1][1] = 1; // cellStatuses is played.
                systemPlayed = true;// system has played.
            } else if (cellStatuses[0][0] == cellStatuses[1][1] && cellStatuses[2][2] == -1 &&
                    cellStatuses[0][0] == 0) { /* In the left-to-right diagonal, if the first and
                         second cells in the diagonal have been played by opponent with the last
                         cell free. */
                buttons2D[2][2].setText("X");// the free cell is clicked and the opponent is blocked
                cellStatuses[2][2] = 1; // cellStatuses is updated.
                systemPlayed = true;// system has played.
            } else if (cellStatuses[1][1] == cellStatuses[2][2] && cellStatuses[0][0] == -1 &&
                    cellStatuses[1][1] == 0) { /* In the left-to-right diagonal, if the second and
                    last cells in the diagonal have been played by opponent with the first cell
                    free.*/
                buttons2D[0][0].setText("X"); // the free cell is clicked and opponent is blocked.
                cellStatuses[0][0] = 1; // cellStatuses is updated.
                systemPlayed = true; // system has played.
            } else if (cellStatuses[0][0] == cellStatuses[2][2] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][0] == 0) { /* In the left-to-right diagonal, if the first and
                    last cells in the diagonal have been played by opponent with the second cell
                    free. */
                buttons2D[1][1].setText("X");// the free cell is played and opponent is blocked.
                cellStatuses[1][1] = 1; // cellStatuses is updated.
                systemPlayed = true;// system has played.
            } else if (cellStatuses[0][2] == cellStatuses[1][1] && cellStatuses[2][0] == -1 &&
                    cellStatuses[0][2] == 0) { /* In the right-to-left diagonal, if the first and
                        second cells in the diagonal have been played by opponent with the last cell
                        free. */
                buttons2D[2][0].setText("X");// the free cell is played and opponent is blocked.
                cellStatuses[2][0] = 1; // cellStatuses is updated.
                systemPlayed = true;// system has played.
            } else if (cellStatuses[1][1] == cellStatuses[2][0] && cellStatuses[0][2] == -1 &&
                    cellStatuses[1][1] == 0) { /* In the right-to-left diagonal, if the second and
                         last cells in the diagonal have been played by system with the first cell
                         free.*/
                buttons2D[0][2].setText("X"); // the free cell is played and opponent is blocked.
                cellStatuses[0][2] = 1; // cellStatuses is updated.
                systemPlayed = true;// system has played.
            } else if (cellStatuses[0][2] == cellStatuses[2][0] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][2] == 0) { /* In the right-to-left diagonal, if the first and
                        last cells in the diagonal have been played by opponent with the second cell
                        free.*/
                buttons2D[1][1].setText("X"); // the free cell is played and opponent is blocked.
                cellStatuses[1][1] = 1; // cellStatuses is updated.
                systemPlayed = true;// system has played.

            } else { // the three rows and column is checked to block the opponent.
                for (int index = 0; index < 3; index++) {
		/* checking through the 3 rows and 3 columns if opponent has played 2 rows with a free
		cell on the line to play and win.*/
                    if (cellStatuses[index][0] == cellStatuses[index][1] &&
                            cellStatuses[index][2] == -1 && cellStatuses[index][0] == 0) {
                        /* In each row if the first and second cells have been played by the
                        opponent with a last cell free. */
                        buttons2D[index][2].setText("X"); // the free cell is played.
                        cellStatuses[index][2] = 1; // cellStatuses is updated.
                        systemPlayed = true; // system has played.
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[index][1] == cellStatuses[index][2] &&
                            cellStatuses[index][0] == -1 && cellStatuses[index][1] == 0) {
                        /* Else in each row if the second and last cells have been played by
                        opponent with the first cell free*/
                        buttons2D[index][0].setText("X"); // the free cell is played.
                        cellStatuses[index][0] = 1; // cellStatuses is updated.
                        systemPlayed = true; // system has played
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[index][0] == cellStatuses[index][2] &&
                            cellStatuses[index][1] == -1 && cellStatuses[index][0] == 0) {
                        /* Else in each row if the first and last cells have been played by opponent
                         with the second cell free.*/
                        buttons2D[index][1].setText("X"); // the free cell is played.
                        cellStatuses[index][1] = 1; // cellStatuses is updated.
                        systemPlayed = true; // system has played.
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[0][index] == cellStatuses[1][index] &&
                            cellStatuses[2][index] == -1 && cellStatuses[0][index] == 0) {
                        /* In each column if the first and second cells have been played by the
                        opponent with a last cell free*/
                        buttons2D[2][index].setText("X"); // the free cell is played.
                        cellStatuses[2][index] = 1; // cellStatuses is updated.
                        systemPlayed = true; // system has played.
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[1][index] == cellStatuses[2][index] &&
                            cellStatuses[0][index] == -1 && cellStatuses[1][index] == 0) {
                        /* Else in each column if the second and last cells have been played by the
                        opponent with the first cell free*/
                        buttons2D[0][index].setText("X"); // the free cell is played.
                        cellStatuses[0][index] = 1; // cellStatuses is updated.
                        systemPlayed = true; // system has played
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[0][index] == cellStatuses[2][index] &&
                            cellStatuses[1][index] == -1 && cellStatuses[0][index] == 0) {
                        /* Else in each column if the first and last cells have been played by
                        opponent with the second cell free.*/
                        buttons2D[1][index].setText("X"); // the free cell is played.
                        cellStatuses[1][index] = 1; // cellStatuses is updated.
                        systemPlayed = true; // system has played.
                        break; // breaks out of the for loop.
                    }
                }
            }
        }
    }

    /**
     * * Checks for two O in a each row, column or diagonal with a free cell on the line on
     * the 3 by 3 game board so the system can play and win.
     * Otherwise it checks for two X (opponent's play) as such and plays to block opponent's win.
     */
    private void checkForTwoOAndPlayToWinOrBlockTwoX() {
        // buttons2D is a 2D array that stores the Button objects of the 3 by 3 game board
        Button[][] buttons2D = {{button11, button12, button13}, {button21, button22, button23},
                {button31, button32, button33}};
        for (int index = 0; index < 3; index++) {
		/*checking through the 3 rows and 3 columns if system has played 2 rows with a free
		cell on the line to play and win.*/
            if (cellStatuses[index][0] == cellStatuses[index][1] && cellStatuses[index][2] == -1 &&
                    cellStatuses[index][0] == 0) {/* In each row if the first and second cells have
                    been played by the system with a last cell free. */
                buttons2D[index][2].setText("O"); // the free cell is played.
                cellStatuses[index][2] = 0; // cellStatuses is updated.
                systemPlayed = true; // system has played.
                break; // breaks out of the for loop.
            } else if (cellStatuses[index][1] == cellStatuses[index][2] &&
                    cellStatuses[index][0] == -1 && cellStatuses[index][1] == 0) {
                /* Else in each row if the second and last cells have been played by the system with
                 the first cell free*/
                buttons2D[index][0].setText("O"); // the free cell is played.
                cellStatuses[index][0] = 0; // cellStatuses is updated.
                systemPlayed = true; // system has played
                break; // breaks out of the for loop.
            } else if (cellStatuses[index][0] == cellStatuses[index][2] &&
                    cellStatuses[index][1] == -1 && cellStatuses[index][0] == 0) {
                /* Else in each row if the first and last cells have been played with the second
                cell free.*/
                buttons2D[index][1].setText("O"); // the free cell is played.
                cellStatuses[index][1] = 0; // cellStatuses is updated.
                systemPlayed = true; // system has played.
                break; // breaks out of the for loop.
            } else if (cellStatuses[0][index] == cellStatuses[1][index] &&
                    cellStatuses[2][index] == -1 && cellStatuses[0][index] == 0) {
                /* In each column if the first and second cells have been played by the system with
                a last cell free*/
                buttons2D[2][index].setText("O"); // the free cell is played.
                cellStatuses[2][index] = 0; // cellStatuses is updated.
                systemPlayed = true; // system has played.
                break; // breaks out of the for loop.
            } else if (cellStatuses[1][index] == cellStatuses[2][index] && cellStatuses[0][index] ==
                    -1 && cellStatuses[1][index] == 0) {/* Else in each column if the second and
                    last cells have been played by the system with the first cell free. */
                buttons2D[0][index].setText("O"); // the free cell is played.
                cellStatuses[0][index] = 0; // cellStatuses is updated.
                systemPlayed = true; // system has played
                break; // breaks out of the for loop.
            } else if (cellStatuses[0][index] == cellStatuses[2][index] &&
                    cellStatuses[1][index] == -1 && cellStatuses[0][index] == 0) {
                /* Else in each column if the first and last cells have been played with the second
                cell free.*/
                buttons2D[1][index].setText("O"); // the free cell is played.
                cellStatuses[1][index] = 0; // cellStatuses is updated.
                systemPlayed = true; // system has played.
                break; // breaks out of the for loop.
            }
        }

        if (!systemPlayed) {// if system has still not played
            if (cellStatuses[0][0] == cellStatuses[1][1] && cellStatuses[2][2] == -1 &&
                    cellStatuses[0][0] == 0) { /* In the left-to-right diagonal, if the first and
                    second cells in the diagonal have been played by the system with the last cell
                    free.*/
                buttons2D[2][2].setText("O"); // the free cell is played.
                cellStatuses[2][2] = 0; // cellStatuses is updated.
                systemPlayed = true; // system has played.
            } else if (cellStatuses[1][1] == cellStatuses[2][2] && cellStatuses[0][0] == -1 &&
                    cellStatuses[1][1] == 0) { /* In the left-to-right diagonal, if the second and
                    last cells in the diagonal have been played by the system with the first cell
                    free.*/
                buttons2D[0][0].setText("O"); // the free cell is played.
                cellStatuses[0][0] = 0; // cellStatuses is updated.
                systemPlayed = true; // system has played.
            } else if (cellStatuses[0][0] == cellStatuses[2][2] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][0] == 0) { /* In the left-to-right diagonal, if the first and
                    last cells in the diagonal have been played by the system with the second cell
                    free.*/
                buttons2D[1][1].setText("O"); // the free cell is played.
                cellStatuses[1][1] = 0; // cellStatuses is updated.
                systemPlayed = true; // system has played.
            } else if (cellStatuses[0][2] == cellStatuses[1][1] && cellStatuses[2][0] == -1 &&
                    cellStatuses[0][2] == 0) { /* In the right-to-left diagonal, if the first and
                    second cells in the diagonal have been played by the system with the last cell
                    free.*/
                buttons2D[2][0].setText("O"); // the free cell is played.
                cellStatuses[2][0] = 0; // cellStatuses is updated.
                systemPlayed = true; // system has played.
            } else if (cellStatuses[1][1] == cellStatuses[2][0] && cellStatuses[0][2] == -1 &&
                    cellStatuses[1][1] == 0) { /* In the right-to-left diagonal, if the second and
                         last cells in the diagonal have been played by the system with the first
                         cell free.*/
                buttons2D[0][2].setText("O"); // the free cell is played.
                cellStatuses[0][2] = 0; // cellStatuses is updated.
                systemPlayed = true; // system has played.
            } else if (cellStatuses[0][2] == cellStatuses[2][0] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][2] == 0) { /* In the right-to-left diagonal, if the first and
                        last cells in the diagonal have been played by the system with the second
                        cell free.*/
                buttons2D[1][1].setText("O"); // the free cell is played.
                cellStatuses[1][1] = 0; // cellStatuses is updated.
                systemPlayed = true; // system has played.
            } else if (cellStatuses[0][0] == cellStatuses[1][1] && cellStatuses[2][2] == -1 &&
                    cellStatuses[0][0] == 1) { /* In the left-to-right diagonal, if the first and
                         second cells in the diagonal have been played by the opponent with the last
                         cell free.*/
                buttons2D[2][2].setText("O"); // the free cell is played.
                cellStatuses[2][2] = 0; // cellStatuses is updated.
                systemPlayed = true;// system has played.
            } else if (cellStatuses[1][1] == cellStatuses[2][2] && cellStatuses[0][0] == -1 &&
                    cellStatuses[1][1] == 1) { /* In the left-to-right diagonal, if the second and
                    last cells in the diagonal have been played by the opponent with the first cell
                    free.*/
                buttons2D[0][0].setText("O"); // the free cell is played.
                cellStatuses[0][0] = 0; // cellStatuses is updated.
                systemPlayed = true; // system has played.
            } else if (cellStatuses[0][0] == cellStatuses[2][2] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][0] == 1) { /* In the left-to-right diagonal, if the first and
                    last cells in the diagonal have been played by the opponent with the second cell
                    free.*/
                buttons2D[1][1].setText("O"); // the free cell is played.
                cellStatuses[1][1] = 0; // cellStatuses is updated.
                systemPlayed = true; // system has played.
            } else if (cellStatuses[0][2] == cellStatuses[1][1] && cellStatuses[2][0] == -1 &&
                    cellStatuses[0][2] == 1) { /* In the right-to-left diagonal, if the first and
                        second cells in the diagonal have been played by the opponent with the last
                        cell free.*/
                buttons2D[2][0].setText("O"); // the free cell is played.
                cellStatuses[2][0] = 0; // cellStatuses is updated.
                systemPlayed = true;// system has played.
            } else if (cellStatuses[1][1] == cellStatuses[2][0] && cellStatuses[0][2] == -1 &&
                    cellStatuses[1][1] == 1) { /* In the right-to-left diagonal, if the second and
                         last cells in the diagonal have been played by the opponent with the first
                         cell free.*/
                buttons2D[0][2].setText("O"); // the free cell is played.
                cellStatuses[0][2] = 0; // cellStatuses is updated.
                systemPlayed = true;// system has played.
            } else if (cellStatuses[0][2] == cellStatuses[2][0] && cellStatuses[1][1] == -1 &&
                    cellStatuses[0][2] == 1) { /* In the right-to-left diagonal, if the first and
                        last cells in the diagonal have been played by the opponent with the second
                        cell free.*/
                buttons2D[1][1].setText("O"); // the free cell is played.
                cellStatuses[1][1] = 0; // cellStatuses is updated.
                systemPlayed = true; // system has played.
            } else { // the three rows and column is checked for two plays to block the opponent.
                for (int index = 0; index < 3; index++) {
                    if (cellStatuses[index][0] == cellStatuses[index][1] &&
                            cellStatuses[index][2] == -1 && cellStatuses[index][0] == 1) {
                        /* In each row if the first and second cells have been played by the
                        opponent with the last cell free*/
                        buttons2D[index][2].setText("O"); // the free cell is played.
                        cellStatuses[index][2] = 0; // cellStatuses is updated.
                        systemPlayed = true; // system has played.
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[index][1] == cellStatuses[index][2] &&
                            cellStatuses[index][0] == -1 && cellStatuses[index][1] == 1) {
                        /* Else in each row if the second and last cells have been played by
                        opponent with the first cell free*/
                        buttons2D[index][0].setText("O"); // the free cell is played.
                        cellStatuses[index][0] = 0; // cellStatuses is updated.
                        systemPlayed = true; // system has played
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[index][0] == cellStatuses[index][2] &&
                            cellStatuses[index][1] == -1 && cellStatuses[index][0] == 1) {
                        /* Else in each row if the first and last cells have been played by opponent
                        with the second cell free.*/
                        buttons2D[index][1].setText("O"); // the free cell is played.
                        cellStatuses[index][1] = 0; // cellStatuses is updated.
                        systemPlayed = true; // system has played.
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[0][index] == cellStatuses[1][index] &&
                            cellStatuses[2][index] == -1 && cellStatuses[0][index] == 1) {
                        /* In each column if the first and second cells have been played by the
                        opponent with the last cell free. */
                        buttons2D[2][index].setText("O");  // the free cell is played.
                        cellStatuses[2][index] = 0; // cellStatuses is updated.
                        systemPlayed = true; // system has played.
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[1][index] == cellStatuses[2][index] &&
                            cellStatuses[0][index] == -1 && cellStatuses[1][index] == 1) {
                        /* Else in each column if the second and last cells have been played by the
                        opponent with the first cell free. */
                        buttons2D[0][index].setText("O"); // the free cell is played.
                        cellStatuses[0][index] = 0; // cellStatuses is updated.
                        systemPlayed = true; // system has played
                        break; // breaks out of the for loop.
                    } else if (cellStatuses[0][index] == cellStatuses[2][index] &&
                            cellStatuses[1][index] == -1 && cellStatuses[0][index] == 1) {
                        /* Else in each column if the first and last cells have been played by the
                        opponent with the second cell free.*/
                        buttons2D[1][index].setText("O"); // the free cell is played.
                        cellStatuses[1][index] = 0; // cellStatuses is updated.
                        systemPlayed = true; // system has played.
                        break; // breaks out of the for loop.
                    }
                }
            }
        }
    }

    /**
     * Implements methods checkForTwoXAndPlayToWinOrBlockTwoO() and
     * checkFroTwoOAndPlayToWinOrBlockTwoX().
     */
    private void checkForTwoAndPlay() {

        if (playX) {// if system's turn plays X
            checkForTwoXAndPlayToWinOrBlockTwoO();
        } else {// if system's turn plays O
            checkForTwoOAndPlayToWinOrBlockTwoX();
        }
    }

    /**
     * Checks through each row, column and each diagonal if system has played one cell with two free
     * cells in the same line and plays a random cell of the two.
     */
    private void checkForOneAndPlay() {
        // buttons2D is a 2D array stores Buttons objects of the 3 by 3 game board.
        Button[][] buttons2D = {{button11, button12, button13}, {button21, button22, button23},
                {button31, button32, button33}};
        if (playX) { // if system's turn plays X
            for (int index = 0; index < 3; index++) {
		/*checking through the 3 rows and 3 columns if system has played 1 cell with 2 free
		cells on the line to play and move closer to a win.*/
                if (cellStatuses[index][0] == cellStatuses[index][1] && cellStatuses[index][0] ==
                        -1 && cellStatuses[index][2] == 1) { /* In each row if the first and second
                        cells are free with the last cell played by the system.*/
                    int[] freeCellsColumnIndicesArray = {0, 1}; /* array stores the column indices
                    of the free cells on the row.*/
                    int randomIndex = (int) (Math.random() * 2); /* a random index between 0 and 1
                    is generated and stored in randomIndex integer variable.*/
                    /* the generated randomIndex is used to get a random index of the free cells
                    indices .*/
                    int oneOfFreeCellsColumnIndices = freeCellsColumnIndicesArray[randomIndex];
                    buttons2D[index][oneOfFreeCellsColumnIndices].setText("X");/* System plays the
                    randomly generated cell of the free cells.*/
                    cellStatuses[index][oneOfFreeCellsColumnIndices] = 1; // cellStatuses is updated
                    systemPlayed = true;// system has played.
                    break; // breaks out of the for loop.
                } else if (cellStatuses[index][1] == cellStatuses[index][2] &&
                        cellStatuses[index][1] == -1 && cellStatuses[index][0] == 1) {
                    /* Else in each row if the second and last cells are free with the first cell
                    played by system.*/
                    int[] freeCellsColumnIndicesArray = {1, 2};/* array stores the column indices of
                    the free cells on the row.*/
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    /* the generated randomIndex is used to get a random index of the free cells
                    indices.*/
                    int oneOfFreeCellsColumnIndices = freeCellsColumnIndicesArray[randomIndex];
                    buttons2D[index][oneOfFreeCellsColumnIndices].setText("X");/* System plays the
                    randomly generated cell of the free cells.*/
                    cellStatuses[index][oneOfFreeCellsColumnIndices] = 1;// cellStatuses is updated.
                    systemPlayed = true;// system has played
                    break; // breaks out of the for loop.
                } else if (cellStatuses[index][0] == cellStatuses[index][2] &&
                        cellStatuses[index][0] == -1 && cellStatuses[index][0] == 1) {/* Else in
                        each row if the first and last cells are free with the second cell played by
                        the system.*/
                    int[] freeCellsColumnIndicesArray = {0, 2};/* array stores the column indices of
                    the free cells. */
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsColumnIndices = freeCellsColumnIndicesArray[randomIndex];
                    /* the generated randomIndex is used to get a random index of the free cells
                    indices. */
                    buttons2D[index][oneOfFreeCellsColumnIndices].setText("X");/* System plays the
                    randomly generated cell of the free cells.*/
                    cellStatuses[index][oneOfFreeCellsColumnIndices] = 1;// cellStatuses is updated.
                    systemPlayed = true;// system has played.
                    break; // breaks out of the for loop.
                } else if (cellStatuses[0][index] == cellStatuses[1][index] &&
                        cellStatuses[0][index] == -1 && cellStatuses[2][index] == 1) {
                    /* In each column if the first and second cells are free with the last cell
                    played by the system.*/
                    int[] freeCellsRowIndicesArray = {0, 1};/* array stores the row indices of the
                    free cells. */
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndices = freeCellsRowIndicesArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells indices.*/
                    buttons2D[oneOfFreeCellsRowIndices][index].setText("X");/* System plays the
                    randomly generated cell of the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndices][index] = 1;// cellStatuses is updated.
                    systemPlayed = true;// system has played.
                    break; // breaks out of the for loop.
                } else if (cellStatuses[1][index] == cellStatuses[2][index] &&
                        cellStatuses[1][index] == -1 && cellStatuses[0][index] == 1) {
                    /* Else in each column if the second and last cells are free with the first cell
                     played by system.*/
                    int[] freeCellsRowIndicesArray = {1, 2};/* array stores the row indices of the
                    free cells. */
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndices = freeCellsRowIndicesArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells indices.*/
                    buttons2D[oneOfFreeCellsRowIndices][index].setText("X");/* System plays the
                    randomly generated cell of the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndices][index] = 1; // cellStatuses is updated.
                    systemPlayed = true;// system has played
                    break; // breaks out of the for loop.
                } else if (cellStatuses[0][index] == cellStatuses[2][index] &&
                        cellStatuses[0][index] == -1 && cellStatuses[1][index] == 1) {
                    /* Else in each column if the first and last cells have been played with the
                    second cell free.*/
                    int[] freeCellsRowIndicesArray = {0, 2};/* array stores the row indices of the
                    free cells. */
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndices = freeCellsRowIndicesArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsRowIndices][index].setText("X");/* System plays the
                    randomly generated cell of the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndices][index] = 1; // cellStatuses is updated.
                    systemPlayed = true;// system has played
                    break; // breaks out of the for loop.
                }
            }
            if (!systemPlayed) {// if system has still not played
                if (cellStatuses[0][0] == cellStatuses[1][1] && cellStatuses[0][0] == -1 &&
                        cellStatuses[2][2] == 1) {/* In the left-to-right diagonal, if the first and
                         second cells in the diagonal are free with the last cell played by system*/
                    int[] freeCellsIndicesArray = {0, 1};// array stores indices of the free cells
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsIndices = freeCellsIndicesArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells indices.*/
                    buttons2D[oneOfFreeCellsIndices][oneOfFreeCellsIndices].setText("X");/* System
                    plays the randomly generated cell of the free cells.*/
                    cellStatuses[oneOfFreeCellsIndices][oneOfFreeCellsIndices] = 1;/* cellStatuses
                    is updated. */
                    systemPlayed = true;// system has played
                } else if (cellStatuses[1][1] == cellStatuses[2][2] && cellStatuses[1][1] == -1 &&
                        cellStatuses[0][0] == 1) {/*In the left-to-right diagonal, if the second and
                        last cells in the diagonal are free with the first cell played by system.*/
                    int[] freeCellsIndicesArray = {1, 2};// array stores indices of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsIndices = freeCellsIndicesArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells indices.*/
                    buttons2D[oneOfFreeCellsIndices][oneOfFreeCellsIndices].setText("X");/* System
                    plays the randomly generated cell of the free cells.*/
                    cellStatuses[oneOfFreeCellsIndices][oneOfFreeCellsIndices] = 1;/* cellStatuses
                    is updated. */
                    systemPlayed = true;// system has played
                } else if (cellStatuses[0][0] == cellStatuses[2][2] && cellStatuses[0][0] == -1 &&
                        cellStatuses[1][1] == 1) {/* In the left-to-right diagonal, if the first and
                        last cells in the diagonal are free with the second cell played by system.*/
                    int[] freeCellsIndicesArray = {0, 2};// array stores indices of the free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsIndex = freeCellsIndicesArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells indices.*/
                    buttons2D[oneOfFreeCellsIndex][oneOfFreeCellsIndex].setText("X");/* System plays
                    the randomly generated cell of the free cells.*/
                    cellStatuses[oneOfFreeCellsIndex][oneOfFreeCellsIndex] = 1;/* cellStatuses is
                    updated. */
                    systemPlayed = true;// system has played
                } else if (cellStatuses[0][2] == cellStatuses[1][1] && cellStatuses[2][0] == -1 &&
                        cellStatuses[0][2] == 1) {/* In the right-to-left diagonal, if the first and
                        second cells in the diagonal are free with the last cell played by system.*/
                    int[] freeCellsRowIndicesArray = {0, 1};//array stores row indices of free cells
                    int[] freeCellsColumnIndicesArray = {2, 1};/* array store column indices of the
                    free cells. */
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    /* the generated randomIndex is used to get a random row index of free cells
                    indices.*/
                    int oneOfFreeCellsRowIndices = freeCellsRowIndicesArray[randomIndex];
                    /* the generated randomIndex is used to get a random column index of the free
                    cells indices.*/
                    int oneOfFreeCellsColumnIndices = freeCellsColumnIndicesArray[randomIndex];
                    // system plays the randomly generated cell of the free cells.
                    buttons2D[oneOfFreeCellsRowIndices][oneOfFreeCellsColumnIndices].setText("X");
                    // cellStatuses is updated.
                    cellStatuses[oneOfFreeCellsRowIndices][oneOfFreeCellsColumnIndices] = 1;
                    systemPlayed = true;// system has played.
                } else if (cellStatuses[1][1] == cellStatuses[2][0] && cellStatuses[1][1] == -1 &&
                        cellStatuses[0][2] == 1) {/* In the right-to-left diagonal, if second and
                         last cells in the diagonal are free with the first cell played by system.*/
                    int[] freeCellsRowIndicesArray = {1, 2};//array stores row indices of free cells
                    int[] freeCellsColumnIndicesArray = {1, 0};/* array store the column indices of
                    the free cells. */
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndices = freeCellsRowIndicesArray[randomIndex];/* the
                    generated randomIndex is used to get a random row index of the free cells
                    indices.*/
                    /* the generated randomIndex is used to get a random column index of the free
                    cells indices.*/
                    int oneOfFreeCellsColumnIndices = freeCellsColumnIndicesArray[randomIndex];
                    // system plays the randomly generated cell of the free cells.
                    buttons2D[oneOfFreeCellsRowIndices][oneOfFreeCellsColumnIndices].setText("X");
                    // cellStatuses is updated.
                    cellStatuses[oneOfFreeCellsRowIndices][oneOfFreeCellsColumnIndices] = 1;
                    systemPlayed = true;// system has played.
                } else if (cellStatuses[0][2] == cellStatuses[2][0] && cellStatuses[0][2] == -1 &&
                        cellStatuses[1][1] == 1) {/* In the right-to-left diagonal, if the first and
                        last cells in the diagonal are free with the second cell played by system.*/
                    int[] freeCellsRowIndicesArray = {0, 2};//array stores row indices of free cells
                    int[] freeCellsColumnIndicesArray = {2, 0};/* array stores the column indices of
                    the free cells. */
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    /* the generated randomIndex is used to get a random row index of the free cells
                    indices.*/
                    int oneOfFreeCellsRowIndices = freeCellsRowIndicesArray[randomIndex];
                    /* the generated randomIndex is used to get a random column index of the free
                    cells indices.*/
                    int oneOfFreeCellsColumnIndices = freeCellsColumnIndicesArray[randomIndex];
                    // system plays the randomly generated cell of the free cells.
                    buttons2D[oneOfFreeCellsRowIndices][oneOfFreeCellsColumnIndices].setText("X");
                    // cellStatuses is updated.
                    cellStatuses[oneOfFreeCellsRowIndices][oneOfFreeCellsColumnIndices] = 1;
                    systemPlayed = true;// system has played.
                }
            }
        } else {// if system's turn plays O
            for (int index = 0; index < 3; index++) {
		/*checking through the 3 rows and 3 columns if system has played 1 cell with 2 free
		cells on the line to play and move closer to a win.*/
                if (cellStatuses[index][0] == cellStatuses[index][1] && cellStatuses[index][0] ==
                        -1 && cellStatuses[index][2] == 0) {/* In each row if the first and second
                        cells are free with the last cell played by system.*/
                    int[] freeCellsColumnIndicesArray = {0, 1};//array stores indices of free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsColumnIndices = freeCellsColumnIndicesArray[randomIndex];/*the
                    generated randomIndex is used to get a random index of the free cells indices.*/
                    buttons2D[index][oneOfFreeCellsColumnIndices].setText("O");/* system plays the
                    randomly generated cell of the free cells.*/
                    cellStatuses[index][oneOfFreeCellsColumnIndices] = 0;// cellStatuses updated.
                    systemPlayed = true;// system has played.
                    break; // breaks out of the for loop.
                } else if (cellStatuses[index][1] == cellStatuses[index][2] &&
                        cellStatuses[index][1] == -1 && cellStatuses[index][0] == 0) {/* Else in
                        each row if the second and last cells are free with the first cell played
                        by system.*/
                    int[] freeCellsColumnIndicesArray = {1, 2};//array stores indices of free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsColumnIndices = freeCellsColumnIndicesArray[randomIndex];/*the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[index][oneOfFreeCellsColumnIndices].setText("O");/* system plays the
                    randomly generated cell of the free cells.*/
                    cellStatuses[index][oneOfFreeCellsColumnIndices] = 0;// cellStatuses updated
                    systemPlayed = true;// system has played
                    break; // breaks out of the for loop.
                } else if (cellStatuses[index][0] == cellStatuses[index][2] &&
                        cellStatuses[index][0] == -1 && cellStatuses[index][0] == 0) {/* Else in
                        each row if the first and last cells are free with the second cell played
                        by system.*/
                    int[] freeCellsColumnIndicesArray = {0, 2};/* array stores column indices of
                    free cells.*/
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsColumnIndices = freeCellsColumnIndicesArray[randomIndex];/*the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[index][oneOfFreeCellsColumnIndices].setText("O");/* system plays the
                    // randomly generated cell of the free cells.*/
                    cellStatuses[index][oneOfFreeCellsColumnIndices] = 0;// cellStatuses updated.
                    systemPlayed = true;// system has played.
                    break; // breaks out of the for loop.
                } else if (cellStatuses[0][index] == cellStatuses[1][index] &&
                        cellStatuses[0][index] == -1 && cellStatuses[2][index] == 0) {/* In each
                        column if the first and second cells are free with the last cell played
                        by the system.*/
                    int[] freeCellsRowIndicesArray = {0, 1};//array stores row indices of free cells
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndices = freeCellsRowIndicesArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells indices.*/
                    buttons2D[oneOfFreeCellsRowIndices][index].setText("O");/* system plays the
                    // randomly generated cell of the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndices][index] = 0;// cellStatuses updated.
                    systemPlayed = true;// system has played.
                    break; // breaks out of the for loop.
                } else if (cellStatuses[1][index] == cellStatuses[2][index] &&
                        cellStatuses[1][index] == -1 && cellStatuses[0][index] == 0) {/* Else in
                        each column if the second and last cells are free with the first cell played
                        by system.*/
                    int[] freeCellsRowIndicesArray = {1, 2};//array stores row indices of free cells
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndices = freeCellsRowIndicesArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells indices.*/
                    buttons2D[oneOfFreeCellsRowIndices][index].setText("O");/* system plays the
                    // randomly generated cell of the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndices][index] = 0; // cellStatuses updated
                    systemPlayed = true;// system has played
                    break; // breaks out of the for loop.
                } else if (cellStatuses[0][index] == cellStatuses[2][index] &&
                        cellStatuses[0][index] == -1 && cellStatuses[1][index] == 0) {/* Else in
                        each column if the first and last cells have been played with the second
                        cell free.*/
                    int[] freeCellsRowIndicesArray = {0, 2};//array stores row indices of free cells
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndices = freeCellsRowIndicesArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsRowIndices][index].setText("O");/* system plays the
                    // randomly generated cell of the free cells.*/
                    cellStatuses[oneOfFreeCellsRowIndices][index] = 0; // cellStatuses updated.
                    systemPlayed = true;// system has played
                    break; // breaks out of the for loop.
                }
            }
            if (!systemPlayed) {// if system has still not played
                if (cellStatuses[0][0] == cellStatuses[1][1] && cellStatuses[0][0] == -1 &&
                        cellStatuses[2][2] == 0) {/* In the left-to-right diagonal, if the first and
                         second cells in the diagonal are free with last cell played by system.*/
                    int[] freeCellsIndicesArray = {0, 1};/* array stores the indices of the free
                    cells.*/
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsIndices = freeCellsIndicesArray[randomIndex];/* the generated
                    randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsIndices][oneOfFreeCellsIndices].setText("O");/* system
                    plays the randomly generated cell of the free cells.*/
                    cellStatuses[oneOfFreeCellsIndices][oneOfFreeCellsIndices] = 0;
                    systemPlayed = true;// system has played

                } else if (cellStatuses[1][1] == cellStatuses[2][2] && cellStatuses[1][1] == -1 &&
                        cellStatuses[0][0] == 0) {/* In the left-to-right diagonal, if the second
                        and last cells in the diagonal are free with first cell played by system.*/
                    int[] freeCellsIndicesArray = {1, 2};// array stores the index of the free cells
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsIndices = freeCellsIndicesArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells indices.*/
                    buttons2D[oneOfFreeCellsIndices][oneOfFreeCellsIndices].setText("O");/* system
                    plays the randomly generated cell of the free cells.*/
                    cellStatuses[oneOfFreeCellsIndices][oneOfFreeCellsIndices] = 0;/* cellStatuses
                    updated.*/
                    systemPlayed = true;// system has played
                } else if (cellStatuses[0][0] == cellStatuses[2][2] && cellStatuses[0][0] == -1 &&
                        cellStatuses[1][1] == 0) {/* In the left-to-right diagonal, if the first
                        and last cells in the diagonal are free with the second cell played by
                        system.*/
                    int[] freeCellsIndicesArray = {0, 2};// array stores the index of the free cells
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsIndices = freeCellsIndicesArray[randomIndex];/* the
                    generated randomIndex is used to get a random index of the free cells index.*/
                    buttons2D[oneOfFreeCellsIndices][oneOfFreeCellsIndices].setText("O");/* system
                    plays the randomly generated cell of the free cells.*/
                    cellStatuses[oneOfFreeCellsIndices][oneOfFreeCellsIndices] = 0;/* cellStatuses
                    is updated */
                    systemPlayed = true;// system has played
                } else if (cellStatuses[0][2] == cellStatuses[1][1] && cellStatuses[2][0] == -1 &&
                        cellStatuses[0][2] == 0) {/* In the right-to-left diagonal, if the first and
                        second cells in the diagonal are free with the last cell played by system.*/
                    int[] freeCellsRowIndicesArray = {0, 1};// array store row indices of free cells
                    int[] freeCellsColumnIndicesArray = {2, 1};/* array store column indices of free
                    cells.*/
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndices = freeCellsRowIndicesArray[randomIndex];/* the
                    generated randomIndex is used to get a random row index of free cells indices.*/
                    int oneOfFreeCellsColumnIndices = freeCellsColumnIndicesArray[randomIndex];/*the
                    generated randomIndex is used to get a random column index of free cells
                    indices.*/
                    // system plays the randomly generated cell of the free cells.
                    buttons2D[oneOfFreeCellsRowIndices][oneOfFreeCellsColumnIndices].setText("O");
                    // cellStatuses updated.
                    cellStatuses[oneOfFreeCellsRowIndices][oneOfFreeCellsColumnIndices] = 0;
                    systemPlayed = true;// system has played.
                } else if (cellStatuses[1][1] == cellStatuses[2][0] && cellStatuses[1][1] == -1 &&
                        cellStatuses[0][2] == 0) {/*In the right-to-left diagonal, if the second and
                         last cells in the diagonal are free with the first cell played by system.*/
                    int[] freeCellsRowIndicesArray = {1, 2};//array stores row indices of free cells
                    int[] freeCellsColumnIndicesArray = {1, 0};/* array stores the column indices of
                    the free cells.*/
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndices = freeCellsRowIndicesArray[randomIndex];/* the
                    generated randomIndex is used to get a random row index of free cells indices*/
                    int oneOfFreeCellsColumnIndices = freeCellsColumnIndicesArray[randomIndex];/*the
                    generated randomIndex is used to get a random column index of free cells
                    index.*/
                    // system plays the randomly generated cell of the free cells.
                    buttons2D[oneOfFreeCellsRowIndices][oneOfFreeCellsColumnIndices].setText("O");
                    // cellStatuses updated
                    cellStatuses[oneOfFreeCellsRowIndices][oneOfFreeCellsColumnIndices] = 0;
                    systemPlayed = true;// system has played.
                } else if (cellStatuses[0][2] == cellStatuses[2][0] && cellStatuses[0][2] == -1 &&
                        cellStatuses[1][1] == 0) {/* In the right-to-left diagonal, if the first and
                        last cells in the diagonal are free with the second cell played by system.*/
                    int[] freeCellsRowIndicesArray = {0, 2};// stores row indices of the free cells.
                    int[] freeCellsColumnIndicesArray = {2, 0};// stores column indices of free cells.
                    int randomIndex = (int) (Math.random() * 2);/* a random index between 0 and 1 is
                    generated and saved in randomIndex integer variable.*/
                    int oneOfFreeCellsRowIndices = freeCellsRowIndicesArray[randomIndex];/* the
                    generated randomIndex is used to get a random row index of free cells indices.*/
                    /* the generated randomIndex is used to get a random column index of the free
                    cells index.*/
                    int oneOfFreeCellsColumnIndices = freeCellsColumnIndicesArray[randomIndex];
                    // system plays the randomly generated cell of the free cells.
                    buttons2D[oneOfFreeCellsRowIndices][oneOfFreeCellsColumnIndices].setText("O");
                    // cellStatuses updated.
                    cellStatuses[oneOfFreeCellsRowIndices][oneOfFreeCellsColumnIndices] = 0;
                    systemPlayed = true;// system has played.
                }
            }
        }
    }

    /**
     * Guides the system to check any free cell and play. It checks through rows and columns
     * randomly till it plays.
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
                    buttons2D[randRowIndex][randColIndex].setText("X");/* the cell in the present
                    iteration of the while loop is played.*/
                    cellStatuses[randRowIndex][randColIndex] = 1; // cellStatuses is updated.
                    systemPlayed = true; // system has been played.
                    break; // breaks out of the while loop.
                } else {// if system plays O
                    buttons2D[randRowIndex][randColIndex].setText("O");/* the cell in the present
                    iteration of the for loop is played.*/
                    cellStatuses[randRowIndex][randColIndex] = 0;// cellStatuses is updated.
                    systemPlayed = true; // system has played.
                    break;// breaks out of the while loop.
                }
            }
        }
    }

    /**
     * Checks if the system has played four in a row, column or diagonal on the 5 by 5 game board
     * with a free cell on the line so it plays and wins.*/
    @SuppressWarnings("UnnecessaryReturnStatement")
    private void checkFourSystemPlaysAndPlayFreeCell() {
        // buttons2D5By5 is a 2D array that stores Button objects of the 5 by 5 game board.
        Button[][] buttons2D5By5 = {{button11_5By5, button12_5By5, button13_5By5, button14_5By5,
                button15_5By5}, {button21_5By5, button22_5By5, button23_5By5, button24_5By5,
                button25_5By5}, {button31_5By5, button32_5By5, button33_5By5, button34_5By5,
                button35_5By5}, {button41_5By5, button42_5By5, button43_5By5, button44_5By5,
                button45_5By5}, {button51_5By5, button52_5By5, button53_5By5, button54_5By5,
                button55_5By5}};
        for (int index = 0; index < 5; index++) {
		/*checking through the 5 rows and 5 columns if 3 Xs have been played with 2 free
		cells on the line to play.*/

		/*freeCellsColIndexArray stores column indices of cells that have not been played.
		* freeCellsRowIndexArray stores row indices of cells that have not been played.
		* oCellsColIndexArray stores column indices of cells that have been played by player O.
		* xCellsColIndexArray stores column indices of cells that have been played by player X.
		* oCellsRowIndexArray stores row indices of cells that have been played by player O.
		* xCellsRowIndexArray stores row indices of cells that have been played by player X.*/
            ArrayList<Integer> freeCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> freeCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsRowIndexArray = new ArrayList<>();

            // for each column of a row.
            for (int colIndex = 0; colIndex < 5; colIndex++) {
            /* if the cell referenced by index and colIndex have been played by player X, colIndex
            is stored in the xCellsColIndexArray.*/
                if (cellStatuses5By5[index][colIndex] == 1) xCellsColIndexArray.add(colIndex);
            /* else if the cell referenced by index and colIndex have been played by player O,
            colIndex is stored in the oCellsColIndexArray.*/
                else if (cellStatuses5By5[index][colIndex] == 0) oCellsColIndexArray.add(colIndex);
                // else colIndex is stored in freeCellsColIndexArray.
                else freeCellsColIndexArray.add(colIndex);

                // for each row on a column.
                /* if the row referenced by colIndex as the row index and index as the column index
                * has been played by player X, colIndex is appended to the xCellsRowIndexArray.*/
                if (cellStatuses5By5[colIndex][index] == 1) xCellsRowIndexArray.add(colIndex);
                // Otherwise if it has been played by player O. It's appended to oCellsRowIndexArray
                if (cellStatuses5By5[colIndex][index] == 0) oCellsRowIndexArray.add(colIndex);
                // Otherwise if it has not been played. It is appended to freeCellsRowIndexArray
                if (cellStatuses5By5[colIndex][index] == -1) freeCellsRowIndexArray.add(colIndex);
            }
            if (playX) {// If the system plays as X.
                // If system has played four cells on a row with a free cell.
                if (freeCellsColIndexArray.size() == 1 && xCellsColIndexArray.size() == 4) {
                    // the free cell is played.
                    buttons2D5By5[index][freeCellsColIndexArray.get(0)].setText("X");
                    // cell statuses is updated.
                    cellStatuses5By5[index][freeCellsColIndexArray.get(0)] = 1;
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                } else if (freeCellsRowIndexArray.size() == 1 && xCellsRowIndexArray.size() == 4) {
                    // On each column if there is a free cell and 4 cells played by system already.
                    // The free cell is played.
                    buttons2D5By5[freeCellsRowIndexArray.get(0)][index].setText("X");
                    // cell statuses is updated.
                    cellStatuses5By5[freeCellsRowIndexArray.get(0)][index] = 1;
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                }
            } else {// If the system plays as O.
                // If system has played four cells on a row with a free cell.
                if (freeCellsColIndexArray.size() == 1 && oCellsColIndexArray.size() == 4) {
                    // the free cell is played.
                    buttons2D5By5[index][freeCellsColIndexArray.get(0)].setText("O");
                    // cell statuses is updated.
                    cellStatuses5By5[index][freeCellsColIndexArray.get(0)] = 0;
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                } else if (freeCellsRowIndexArray.size() == 1 && oCellsRowIndexArray.size() == 4) {
                    // On each column if there is a free cell and 4 cells played by system already.
                    // the free cell is played.
                    buttons2D5By5[freeCellsRowIndexArray.get(0)][index].setText("O");
                    // cell statuses is updated.
                    cellStatuses5By5[freeCellsRowIndexArray.get(0)][index] = 0;
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                }
            }
        }
        if (!systemPlayed) {// If system has still not played.
            /* freeCellsRowIndexArray stores row indices of cells that have not been played.
		* oCellsRowIndexArray stores row indices of cells that have been played by player O.
		* xCellsRowIndexArray stores row indices of cells that have been played by player X.*/
            ArrayList<Integer> freeCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsRowIndexArray = new ArrayList<>();
            for (int index = 0; index < 5; index++) {// Checks through the left-to-right diagonal.
                /* If referenced cell has been played by X, its row index is added to
                xCellsRowIndexArray
                 */
                if (cellStatuses5By5[index][index] == 1) xCellsRowIndexArray.add(index);
                /* Else if referenced cell has been played by O, its row index is added to
                oCellsRowIndexArray
                 */
                else if (cellStatuses5By5[index][index] == 0) oCellsRowIndexArray.add(index);
                    /* If the cell has not been played, its row index is added to
                    freeCellsRowIndexArray
                     */
                else freeCellsRowIndexArray.add(index);
            }

            if (playX) {// If system plays as X.
                // If system has played 4 cells in the diagonal with a cell free.
                if (freeCellsRowIndexArray.size() == 1 && xCellsRowIndexArray.size() == 4) {
                    // the free cell is played
                    buttons2D5By5[freeCellsRowIndexArray.get(0)][
                            freeCellsRowIndexArray.get(0)].setText("X");
                    // cell statuses is updated.
                    cellStatuses5By5[freeCellsRowIndexArray.get(0)][freeCellsRowIndexArray.get(0)] =
                            1;
                    systemPlayed = true;// system has played.
                    return;// breaks out of the method.
                }
            } else {// If system plays as O.
                // If system has played 4 cells in a the diagonal with a cell free.
                if (freeCellsRowIndexArray.size() == 1 && oCellsRowIndexArray.size() == 4) {
                    // The free cell is played.
                    buttons2D5By5[freeCellsRowIndexArray.get(0)][
                            freeCellsRowIndexArray.get(0)].setText("O");
                    // cell statuses is updated.
                    cellStatuses5By5[freeCellsRowIndexArray.get(0)][freeCellsRowIndexArray.get(0)] =
                            0;
                    systemPlayed = true;// system has played.
                    return;// breaks out of the method.
                }
            }
            /* Clear all elements of freeCellsRowIndexArray, xCellsRowIndexArray and
            oCellsRowIndexArray
             */
            freeCellsRowIndexArray.clear(); xCellsRowIndexArray.clear(); oCellsRowIndexArray.clear();
            /* freeCellsColIndexArray stores column indices of cells that have not been played.
             * oCellsColIndexArray stores column indices of cells that have been played by player O.
             * xCellsColIndexArray stores column indices of cells that have been played by player X.
             * */
            ArrayList<Integer> freeCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsColIndexArray = new ArrayList<>();
            int[] colIndices = {4, 3, 2, 1, 0};/* Stores the column indices of the right-to-left
            diagonal */
            // Check the right-to-left diagonal.
            for (int index = 0; index < 5; index++) {// for each row
                // If the cell referenced by [index][colIndices[index]] has been played by player X.
                if (cellStatuses5By5[index][colIndices[index]] == 1) {
                    xCellsRowIndexArray.add(index);// Append index to xCellsRowIndexArray.
                    // Append colIndices[index] to xCellsColIndexArray.
                    xCellsColIndexArray.add(colIndices[index]);
                } else if (cellStatuses5By5[index][colIndices[index]] == 0) {/* Else if the
                    referenced cell has been played by player O.
                    */
                    oCellsRowIndexArray.add(index);// Append index to oCellsRowIndexArray
                    // Append colIndices[index] to oCellsColIndexArray.
                    oCellsColIndexArray.add(colIndices[index]);
                } else {// Else if the cell has not been played.
                    freeCellsRowIndexArray.add(index);// Append index to freeCellsRowIndexArray.
                    // Append colIndices[index] to freeCellsColIndexArray.
                    freeCellsColIndexArray.add(colIndices[index]);
                }
            }

            if (playX) {// If system plays as X.
                // If system has played 4 cells in a the diagonal with a cell free.
                if (freeCellsRowIndexArray.size() == 1 && xCellsRowIndexArray.size() == 4) {
                    buttons2D5By5[freeCellsRowIndexArray.get(0)][
                            freeCellsColIndexArray.get(0)].setText("X");// The free cell is played.
                    // cell statuses is updated.
                    cellStatuses5By5[freeCellsRowIndexArray.get(0)][freeCellsColIndexArray.get(0)] =
                            1;
                    systemPlayed = true;// system has played.
                    return;// breaks out of the method.
                }
            } else {// If system plays as O.
                // If system has played 4 cells in the diagonal with a cell free.
                if (freeCellsRowIndexArray.size() == 1 && oCellsRowIndexArray.size() == 4) {
                    buttons2D5By5[freeCellsRowIndexArray.get(0)][
                            freeCellsColIndexArray.get(0)].setText("O");// the free cell is played.
                    // cell statuses is updated.
                    cellStatuses5By5[freeCellsRowIndexArray.get(0)][freeCellsColIndexArray.get(0)] =
                            0;
                    systemPlayed = true;// system has played.
                }
            }
        }
    }


    /** Checks if the opponent has played 4 in a row, column or diagonal with a free cell on the
     * line and plays to block.*/
    @SuppressWarnings("UnnecessaryReturnStatement")
    private void checkFourOpponentPlaysAndPlayFreeCell() {
        Button[][] buttons2D5By5 = {{button11_5By5, button12_5By5, button13_5By5, button14_5By5,
                button15_5By5}, {button21_5By5, button22_5By5, button23_5By5, button24_5By5,
                button25_5By5}, {button31_5By5, button32_5By5, button33_5By5, button34_5By5,
                button35_5By5}, {button41_5By5, button42_5By5, button43_5By5, button44_5By5,
                button45_5By5}, {button51_5By5, button52_5By5, button53_5By5, button54_5By5,
                button55_5By5}};
        for (int index = 0; index < 5; index++) {
		/*checking through the 5 rows and 5 columns if 3 Xs have been played with 2 free
		cells on the line to play.*/

		/*freeCellsColIndexArray stores column indices of cells that have not been played.
		* freeCellsRowIndexArray stores row indices of cells that have not been played.
		* oCellsColIndexArray stores column indices of cells that have been played by player O.
		* xCellsColIndexArray stores column indices of cells that have been played by player X.
		* oCellsRowIndexArray stores row indices of cells that have been played by player O.
		* xCellsRowIndexArray stores row indices of cells that have been played by player X.*/
            ArrayList<Integer> freeCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> freeCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsRowIndexArray = new ArrayList<>();

            for (int colIndex = 0; colIndex < 5; colIndex++) {// for each column of a row.
            /* if the cell referenced by index and colIndex have been played by player X, colIndex
            is stored in the xCellsColIndexArray.*/
                if (cellStatuses5By5[index][colIndex] == 1) xCellsColIndexArray.add(colIndex);
            /* else if the cell referenced by index and colIndex have been played by player O,
            colIndex is stored in the oCellsColIndexArray.
            */
                else if (cellStatuses5By5[index][colIndex] == 0) oCellsColIndexArray.add(colIndex);
                    // else colIndex is stored in freeCellsColIndexArray.
                else freeCellsColIndexArray.add(colIndex);

                // for each row on a column.
                /* if the row referenced by colIndex as the row index and index as the column index
                * has been played by player X, colIndex is appended to the xCellsRowIndexArray.
                * */
                if (cellStatuses5By5[colIndex][index] == 1) xCellsRowIndexArray.add(colIndex);
                // Otherwise if it has been played by player O, it's appended to oCellsRowIndexArray
                if (cellStatuses5By5[colIndex][index] == 0) oCellsRowIndexArray.add(colIndex);
                // Otherwise if it has not been played. It is appended to freeCellsRowIndexArray
                if (cellStatuses5By5[colIndex][index] == -1) freeCellsRowIndexArray.add(colIndex);
            }
            if (playX) {// If the system plays as X.
                // If opponent has played four cells on a row with a free cell.
                if (freeCellsColIndexArray.size() == 1 && oCellsColIndexArray.size() == 4) {
                    // the free cell is played.
                    buttons2D5By5[index][freeCellsColIndexArray.get(0)].setText("X");
                    // cell statuses is updated.
                    cellStatuses5By5[index][freeCellsColIndexArray.get(0)] = 1;
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                } else if (freeCellsRowIndexArray.size() == 1 && oCellsRowIndexArray.size() == 4) {
                    // On each column if there is a free cell and 4 cells played by opponent already
                    buttons2D5By5[freeCellsRowIndexArray.get(0)][index].setText("X");/* the free
                    cell is played.
                    */
                    // cell statuses is updated.
                    cellStatuses5By5[freeCellsRowIndexArray.get(0)][index] = 1;
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                }
            } else {// If the system plays as O.
                // If opponent has played four cells on a row with a free cell.
                if (freeCellsColIndexArray.size() == 1 && xCellsColIndexArray.size() == 4) {
                    // the free cell is played.
                    buttons2D5By5[index][freeCellsColIndexArray.get(0)].setText("O");
                    // cell statuses is updated.
                    cellStatuses5By5[index][freeCellsColIndexArray.get(0)] = 0;
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                } else if (freeCellsRowIndexArray.size() == 1 && oCellsRowIndexArray.size() == 4) {
                    // On each column if there is a free cell and 4 cells played by opponent already
                    // the free cell is played.
                    buttons2D5By5[freeCellsRowIndexArray.get(0)][index].setText("O");
                    // cell statuses is updated.
                    cellStatuses5By5[freeCellsRowIndexArray.get(0)][index] = 0;
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                }
            }
        }
        if (!systemPlayed) {// If system has still not played.
            /* freeCellsRowIndexArray stores row indices of cells that have not been played.
		* oCellsRowIndexArray stores row indices of cells that have been played by player O.
		* xCellsRowIndexArray stores row indices of cells that have been played by player X.*/
            ArrayList<Integer> freeCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsRowIndexArray = new ArrayList<>();
            for (int index = 0; index < 5; index++) {// Checks through the left-to-right diagonal.
                /* If referenced cell has been played by X, its row index is added to
                xCellsRowIndexArray
                */
                if (cellStatuses5By5[index][index] == 1) xCellsRowIndexArray.add(index);
                /* If referenced cell has been played by O, its row index is added to
                oCellsRowIndexArray
                */
                else if (cellStatuses5By5[index][index] == 0) oCellsRowIndexArray.add(index);
                    /* If the cell has not been played, its row index is added to
                    freeCellsRowIndexArray
                    */
                 else freeCellsRowIndexArray.add(index);
            }

            if (playX) {// If system plays as X.
                // If opponent has played 4 cells in the diagonal with a cell free.
                if (freeCellsRowIndexArray.size() == 1 && xCellsRowIndexArray.size() == 4) {
                    // the free cell is played
                    buttons2D5By5[freeCellsRowIndexArray.get(0)][
                            freeCellsRowIndexArray.get(0)].setText("X");
                    // cell statuses is updated.
                    cellStatuses5By5[freeCellsRowIndexArray.get(0)][freeCellsRowIndexArray.get(0)] =
                            1;
                    systemPlayed = true;// system has played.
                    return;
                }
            } else {// If system plays as O.
                // If opponent has played 4 cells in a the diagonal with a cell free.
                if (freeCellsRowIndexArray.size() == 1 && oCellsRowIndexArray.size() == 4) {
                    // The free cell is played.
                    buttons2D5By5[freeCellsRowIndexArray.get(0)][
                            freeCellsRowIndexArray.get(0)].setText("O");
                    // cell statuses is updated.
                    cellStatuses5By5[freeCellsRowIndexArray.get(0)][freeCellsRowIndexArray.get(0)] =
                            0;
                    systemPlayed = true;// system has played.
                    return;
                }
            }
            /* Clear all elements elements of freeCellsRowIndexArray, xCellsRowIndexArray and
            oCellsRowIndexArray
            */
            freeCellsRowIndexArray.clear(); xCellsRowIndexArray.clear();
            oCellsRowIndexArray.clear();
            /* freeCellsColIndexArray stores column indices of cells that have not been played.
             * oCellsColIndexArray stores column indices of cells that have been played by player O.
             * xCellsColIndexArray stores column indices of cells that have been played by player X.
             * */
            ArrayList<Integer> freeCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsColIndexArray = new ArrayList<>();
            int[] colIndices = {4, 3, 2, 1, 0};// Stores row indices of the right-to-left diagonal.
            // Check the right-to-left diagonal.
            for (int index = 0; index < 5; index++) {// for each row
                // If the cell referenced by [index][colIndices[index]] has been played by player X.
                if (cellStatuses5By5[index][colIndices[index]] == 1) {
                    xCellsRowIndexArray.add(index);// Append index to xCellsRowIndexArray.
                    // Append colIndices[index] to xCellsColIndexArray.
                    xCellsColIndexArray.add(colIndices[index]);

                } else if (cellStatuses5By5[index][colIndices[index]] == 0){/* Else if referenced
                cell has been played by O */
                    oCellsRowIndexArray.add(index);// append index to oCellsRowIndexArray
                    // append colIndices[index] to oCellsColIndexArray
                    oCellsColIndexArray.add(colIndices[index]);
                } else {// Else if the cell has not been played,
                    freeCellsRowIndexArray.add(index);// append index to freeCellsRowIndexArray
                    // append colIndices[index] to freeCellsColIndexArray
                    freeCellsColIndexArray.add(colIndices[index]);
                }
            }

            if (playX) {// If system plays as X.
                // If opponent has played 4 cells in the diagonal with a cell free.
                if (freeCellsRowIndexArray.size() == 1 && oCellsRowIndexArray.size() == 4) {
                    // The free cell is played.
                    buttons2D5By5[freeCellsRowIndexArray.get(0)][
                            freeCellsColIndexArray.get(0)].setText("X");
                    // cell statuses is updated.
                    cellStatuses5By5[freeCellsRowIndexArray.get(0)][freeCellsColIndexArray.get(0)] =
                            1;
                    systemPlayed = true;// system has played.
                    return;
                }
            } else {// If system plays as O.
                // If opponent has played 4 cells in the diagonal with a cell free.
                if (freeCellsRowIndexArray.size() == 1 && xCellsRowIndexArray.size() == 4) {
                    // the free cell is played.
                    buttons2D5By5[freeCellsRowIndexArray.get(0)][
                            freeCellsColIndexArray.get(0)].setText("O");
                    // cell statuses is updated.
                    cellStatuses5By5[freeCellsRowIndexArray.get(0)][freeCellsColIndexArray.get(0)] =
                            0;
                    systemPlayed = true;// system has played.
                }
            }
        }
    }


    /**
     * Checks if the system has played 3 Xs in a row, column or diagonal when system plays as X
     * on the 5 by 5 game board and plays one of the free cells.
     */
    @SuppressWarnings("UnnecessaryReturnStatement")
    private void checkThreeSystemPlaysAndPlayAFreeCellOfTwo() {
        Button[][] buttons2D5By5 = {{button11_5By5, button12_5By5, button13_5By5, button14_5By5,
                button15_5By5}, {button21_5By5, button22_5By5, button23_5By5, button24_5By5,
                button25_5By5}, {button31_5By5, button32_5By5, button33_5By5, button34_5By5,
                button35_5By5}, {button41_5By5, button42_5By5, button43_5By5, button44_5By5,
                button45_5By5}, {button51_5By5, button52_5By5, button53_5By5, button54_5By5,
                button55_5By5}};
        for (int index = 0; index < 5; index++) {
		/*checking through the 5 rows and 5 columns if 3 Xs have been played with 2 free
		cells on the line to play.*/

		/*freeCellsColIndexArray stores column indices of cells that have not been played.
		* freeCellsRowIndexArray stores row indices of cells that have not been played.
		* oCellsColIndexArray stores column indices of cells that have been played by player O.
		* xCellsColIndexArray stores column indices of cells that have been played by player X.
		* oCellsRowIndexArray stores row indices of cells that have been played by player O.
		* xCellsRowIndexArray stores row indices of cells that have been played by player X.*/
            ArrayList<Integer> freeCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> freeCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsRowIndexArray = new ArrayList<>();

            for (int colIndex = 0; colIndex < 5; colIndex++) {// for each column of a row.
            /* if the cell referenced by index and colIndex have been played by player X, colIndex
            is stored in the xCellsColIndexArray.*/
                if (cellStatuses5By5[index][colIndex] == 1) xCellsColIndexArray.add(colIndex);
            /* else if the cell referenced by index and colIndex have been played by player O,
            colIndex is stored in the oCellsColIndexArray.
            */
                else if (cellStatuses5By5[index][colIndex] == 0) oCellsColIndexArray.add(colIndex);
                    // else colIndex is stored in freeCellsColIndexArray.
                else freeCellsColIndexArray.add(colIndex);

                // for each row on a column.
                /* if the row referenced by colIndex as the row index and index as the column index
                * has been played by player X, colIndex is appended to the xCellsRowIndexArray.
                * */
                if (cellStatuses5By5[colIndex][index] == 1) xCellsRowIndexArray.add(colIndex);
                // Otherwise if it has been played by player O, It's appended to oCellsRowIndexArray
                if (cellStatuses5By5[colIndex][index] == 0) oCellsRowIndexArray.add(colIndex);
                // Otherwise if it has not been played. It is appended to freeCellsRowIndexArray
                if (cellStatuses5By5[colIndex][index] == -1) freeCellsRowIndexArray.add(colIndex);
            }
            if (playX) {// If the system plays as X.
                // If system has played three cells on a row with a two free cells.
                if (freeCellsColIndexArray.size() == 2 && xCellsColIndexArray.size() == 3) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsColIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsColIndexArray.size());
                    /* randomColIndex stores an index of freeCellsColIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomColIndex = freeCellsColIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [index][randomColIndex] is played.
                    buttons2D5By5[index][randomColIndex].setText("X");
                    cellStatuses5By5[index][randomColIndex] = 1;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                } else if (freeCellsRowIndexArray.size() == 2 && xCellsRowIndexArray.size() == 3) {
                    // On each column if there 2 free cells and 3 cells played by X already.
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomRowIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomRowIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [randomRowIndex][index] is played.
                    buttons2D5By5[randomRowIndex][index].setText("X");
                    cellStatuses5By5[randomRowIndex][index] = 1;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                }
            } else {// If the system plays as O.
                // If system has played three Os on a row with a two free cells.
                if (freeCellsColIndexArray.size() == 2 && oCellsColIndexArray.size() == 3) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsColIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsColIndexArray.size());
                    /* randomColIndex stores an index of freeCellsColIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                    */
                    int randomColIndex = freeCellsColIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [index][randomColIndex] is played.
                    buttons2D5By5[index][randomColIndex].setText("O");
                    cellStatuses5By5[index][randomColIndex] = 0;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                } else if (freeCellsRowIndexArray.size() == 2 && oCellsRowIndexArray.size() == 3) {
                    // On each column if there 2 free cells and 3 cells played by O already.
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomRowIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomRowIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [randomRowIndex][index] is played.
                    buttons2D5By5[randomRowIndex][index].setText("O");
                    cellStatuses5By5[randomRowIndex][index] = 0;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                }
            }
        }
        if (!systemPlayed) {// If system has still not played.
            /* freeCellsRowIndexArray stores row indices of cells that have not been played.
		* oCellsRowIndexArray stores row indices of cells that have been played by player O.
		* xCellsRowIndexArray stores row indices of cells that have been played by player X.*/
            ArrayList<Integer> freeCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsRowIndexArray = new ArrayList<>();
            for (int index = 0; index < 5; index++) {// Checks through the left-to-right diagonal.
                /* If referenced cell has been played by X, its row index is added to
                xCellsRowIndexArray
                */
                if (cellStatuses5By5[index][index] == 1) xCellsRowIndexArray.add(index);
                // Else if played by O it is appended to oCellsRowIndexArray
                else if (cellStatuses5By5[index][index] == 0) oCellsRowIndexArray.add(index);
                // Else it is appended to freeCellsRowIndexArray
                else freeCellsRowIndexArray.add(index);
            }

            if (playX) {// If system plays as X.
                // If system has played 3 Xs in a the diagonal with 2 cells free.
                if (freeCellsRowIndexArray.size() == 2 && xCellsRowIndexArray.size() == 3) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [RandomIndex][randomIndex] is played.
                    buttons2D5By5[randomIndex][randomIndex].setText("X");
                    cellStatuses5By5[randomIndex][randomIndex] = 1;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    return;
                }
            } else {// If system plays as O.
                // If system has played 3 Os in a the diagonal with 2 cells free.
                if (freeCellsRowIndexArray.size() == 2 && oCellsRowIndexArray.size() == 3) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [RandomIndex][randomIndex] is played.
                    buttons2D5By5[randomIndex][randomIndex].setText("O");
                    cellStatuses5By5[randomIndex][randomIndex] = 0;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    return;
                }
            }
            /* Clear all elements elements of freeCellsRowIndexArray, xCellsRowIndexArray and
            oCellsRowIndexArray
             */
            freeCellsRowIndexArray.clear(); xCellsRowIndexArray.clear();
            oCellsRowIndexArray.clear();
            /* freeCellsColIndexArray stores column indices of cells that have not been played.
             * oCellsColIndexArray stores column indices of cells that have been played by player O.
             * xCellsColIndexArray stores column indices of cells that have been played by player X.
             * */
            ArrayList<Integer> freeCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsColIndexArray = new ArrayList<>();
            int[] colIndices = {4, 3, 2, 1, 0};// Stores row indices of the right-to-left diagonal.
            // Check the right-to-left diagonal.
            for (int index = 0; index < 5; index++) {// for each row
                // If the cell referenced by [index][colIndices[index]] has been played by player X.
                if (cellStatuses5By5[index][colIndices[index]] == 1) {
                    xCellsRowIndexArray.add(index);// Append index to xCellsRowIndexArray.
                    // Append colIndices[index] to xCellsColIndexArray.
                    xCellsColIndexArray.add(colIndices[index]);
                } else if (cellStatuses5By5[index][colIndices[index]] == 0) {// If played by O
                    oCellsRowIndexArray.add(index);// append index to oCellsRowIndexArray
                    // append colIndices[index] to oCellsColIndexArray
                    oCellsColIndexArray.add(colIndices[index]);
                } else {// If not played yet
                    freeCellsRowIndexArray.add(index);// append index to freeCellsRowIndexArray
                    // append colIndices[index] to freeCellsColIndexArray
                    freeCellsColIndexArray.add(colIndices[index]);
                }
            }

            if (playX) {// If system plays as X.
                // If system has played 3 Xs in a the diagonal with 2 cells free.
                if (freeCellsRowIndexArray.size() == 2 && xCellsRowIndexArray.size() == 3) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomRowIndex stores an index of freeCellsRowIndexArray referenced by
                     randomIndexOfFreeCellsArray.
                      */
                    int randomRowIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    /* randomColIndex stores an index of freeCellsColIndexArray referenced by
                     randomIndexOfFreeCellsArray.
                      */
                    int randomColIndex = freeCellsColIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [RandomIndex][randomIndex] is played.
                    buttons2D5By5[randomRowIndex][randomColIndex].setText("X");
                    cellStatuses5By5[randomRowIndex][randomColIndex] = 1;// cell statuses is updated
                    systemPlayed = true;// system has played.
                    return;
                }
            } else {// If system plays as O.
                // If system has played 3 Os in a the diagonal with 2 cells free.
                if (freeCellsRowIndexArray.size() == 2 && oCellsRowIndexArray.size() == 3) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomRowIndex stores an index of freeCellsRowIndexArray referenced by
                     randomIndexOfFreeCellsArray.
                      */
                    int randomRowIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    /* randomColIndex stores an index of freeCellsColIndexArray referenced by
                     randomIndexOfFreeCellsArray.
                      */
                    int randomColIndex = freeCellsColIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [RandomIndex][randomIndex] is played.
                    buttons2D5By5[randomRowIndex][randomColIndex].setText("O");
                    cellStatuses5By5[randomRowIndex][randomColIndex] = 0;// cell statuses is updated
                    systemPlayed = true;// system has played.
                }
            }
        }
    }

    /**Checks if opponent has played 3 cells in a line with 2 free cells plays and blocks.*/
    @SuppressWarnings("UnnecessaryReturnStatement")
    private void checkThreeOpponentPlaysAndPlayAFreeCellOfTwo() {
        Button[][] buttons2D5By5 = {{button11_5By5, button12_5By5, button13_5By5, button14_5By5,
                button15_5By5}, {button21_5By5, button22_5By5, button23_5By5, button24_5By5,
                button25_5By5}, {button31_5By5, button32_5By5, button33_5By5, button34_5By5,
                button35_5By5}, {button41_5By5, button42_5By5, button43_5By5, button44_5By5,
                button45_5By5}, {button51_5By5, button52_5By5, button53_5By5, button54_5By5,
                button55_5By5}};
        for (int index = 0; index < 5; index++) {
		/*checking through the 5 rows and 5 columns if 3 Xs or Os have been played with 2 free
		cells on the line to play.*/

		/*freeCellsColIndexArray stores column indices of cells that have not been played.
		* freeCellsRowIndexArray stores row indices of cells that have not been played.
		* oCellsColIndexArray stores column indices of cells that have been played by player O.
		* xCellsColIndexArray stores column indices of cells that have been played by player X.
		* oCellsRowIndexArray stores row indices of cells that have been played by player O.
		* xCellsRowIndexArray stores row indices of cells that have been played by player X.*/
            ArrayList<Integer> freeCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> freeCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsRowIndexArray = new ArrayList<>();

            for (int colIndex = 0; colIndex < 5; colIndex++) {// for each column of a row.
            /* if the cell referenced by index and colIndex have been played by player X, colIndex
            is stored in the xCellsColIndexArray.
            */
                if (cellStatuses5By5[index][colIndex] == 1) xCellsColIndexArray.add(colIndex);
            /* else if the cell referenced by index and colIndex have been played by player O,
            colIndex is stored in the oCellsColIndexArray.
            */
                else if (cellStatuses5By5[index][colIndex] == 0) oCellsColIndexArray.add(colIndex);
             // else colIndex is stored in freeCellsColIndexArray.
                else freeCellsColIndexArray.add(colIndex);

                // for each row of a column.
                /* if the row referenced by colIndex as the row index and index as the column index
                * has been played by player X, colIndex is appended to the xCellsRowIndexArray.
                * */
                if (cellStatuses5By5[colIndex][index] == 1) xCellsRowIndexArray.add(colIndex);
                // Otherwise if it has been played by player O. It's appended to oCellsRowIndexArray
                if (cellStatuses5By5[colIndex][index] == 0) oCellsRowIndexArray.add(colIndex);
                // Otherwise if it has not been played. It is appended to freeCellsRowIndexArray
                if (cellStatuses5By5[colIndex][index] == -1) freeCellsRowIndexArray.add(colIndex);
            }
            if (playX) {// If the system plays as X.
                // If opponent has played three cells on a row with a two free cells.
                if (freeCellsColIndexArray.size() == 2 && oCellsColIndexArray.size() == 3) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsColIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsColIndexArray.size());
                    /* randomColIndex stores an index of freeCellsColIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomColIndex = freeCellsColIndexArray.get(randomIndexOfFreeCellsArray);
                    /* the cell referenced by [index][randomColIndex] is played.*/
                    buttons2D5By5[index][randomColIndex].setText("X");
                    cellStatuses5By5[index][randomColIndex] = 1;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                } else if (freeCellsRowIndexArray.size() == 2 && oCellsRowIndexArray.size() == 3) {
                    // On each column if there 2 free cells and 3 cells played by X already.
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomRowIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomRowIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [randomRowIndex][index] is played.
                    buttons2D5By5[randomRowIndex][index].setText("X");
                    cellStatuses5By5[randomRowIndex][index] = 1;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                }
            } else {// If the system plays as O.
                // If opponent has played three Os on a row with a two free cells.
                if (freeCellsColIndexArray.size() == 2 && xCellsColIndexArray.size() == 3) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsColIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsColIndexArray.size());
                    /* randomColIndex stores an index of freeCellsColIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomColIndex = freeCellsColIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [index][randomColIndex] is played.
                    buttons2D5By5[index][randomColIndex].setText("O");
                    cellStatuses5By5[index][randomColIndex] = 0;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                } else if (freeCellsRowIndexArray.size() == 2 && xCellsRowIndexArray.size() == 3) {
                    // On each column if there 2 free cells and 3 cells played by O already.
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomRowIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomRowIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [randomRowIndex][index] is played.
                    buttons2D5By5[randomRowIndex][index].setText("O");
                    cellStatuses5By5[randomRowIndex][index] = 0;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                }
            }
        }
        if (!systemPlayed) {// If system has still not played.

		/* freeCellsRowIndexArray stores row indices of cells that have not been played.
		* oCellsRowIndexArray stores row indices of cells that have been played by player O.
		* xCellsRowIndexArray stores row indices of cells that have been played by player X.*/
            ArrayList<Integer> freeCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> freeCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsRowIndexArray = new ArrayList<>();
            for (int index = 0; index < 5; index++) {// Checks through the left-to-right diagonal.
                /* If referenced cell has been played by X, its row index is added to
                xCellsRowIndexArray
                 */
                if (cellStatuses5By5[index][index] == 1) xCellsRowIndexArray.add(index);
                // Else if played by O, its row index is added to oCellsRowIndexArray
                 else if (cellStatuses5By5[index][index] == 0) oCellsRowIndexArray.add(index);
                 // Else if  not played, its row index is added to freeCellsRowIndexArray.
                 else freeCellsRowIndexArray.add(index);
            }

            if (playX) {// If system plays as X.
                // If  has played 3 Xs in a the diagonal with 2 cells free.
                if (freeCellsRowIndexArray.size() == 2 && oCellsRowIndexArray.size() == 3) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [RandomIndex][randomIndex] is played.
                    buttons2D5By5[randomIndex][randomIndex].setText("X");
                    cellStatuses5By5[randomIndex][randomIndex] = 1;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    return;
                }
            } else {// If system plays as O.
                // If system has played 3 Os in a the diagonal with 2 cells free.
                if (freeCellsRowIndexArray.size() == 2 && xCellsRowIndexArray.size() == 3) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [RandomIndex][randomIndex] is played.
                    buttons2D5By5[randomIndex][randomIndex].setText("O");
                    cellStatuses5By5[randomIndex][randomIndex] = 0;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    return;
                }
            }
            /* Clear all elements elements of freeCellsRowIndexArray, xCellsRowIndexArray and
            oCellsRowIndexArray
             */
            freeCellsRowIndexArray.clear(); xCellsRowIndexArray.clear();
            oCellsRowIndexArray.clear();
            /*freeCellsColIndexArray stores column indices of cells that have not been played.
            * oCellsColIndexArray stores column indices of cells that have been played by player O.
		    * xCellsColIndexArray stores column indices of cells that have been played by player X.
		    * */
            ArrayList<Integer> oCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsColIndexArray = new ArrayList<>();
            int[] colIndices = {4, 3, 2, 1, 0};// Stores row indices of the right-to-left diagonal.
            // Check the right-to-left diagonal.
            for (int index = 0; index < 5; index++) {// for each row
                // If the cell referenced by [index][colIndices[index]] has been played by player X.
                if (cellStatuses5By5[index][colIndices[index]] == 1) {
                    xCellsRowIndexArray.add(index);// Append index to xCellsRowIndexArray.
                    // Append colIndices[index] to xCellsColIndexArray.
                    xCellsColIndexArray.add(colIndices[index]);
                } else if (cellStatuses5By5[index][colIndices[index]] == 0) {// If played by O
                    oCellsRowIndexArray.add(index);// Append index to oCellsRowIndexArray.
                    // Append colIndices[index] to oCellsColIndexArray.
                    oCellsColIndexArray.add(colIndices[index]);
                } else {// If not played
                    // Append index to freeCellsRowIndexArray.
                    freeCellsRowIndexArray.add(index);
                    // Append colIndices[index] to freeCellsColIndexArray.
                    freeCellsColIndexArray.add(colIndices[index]);
                }
            }

            if (playX) {// If system plays as X.
                // If system has played 3 Xs in a the diagonal with 2 cells free.
                if (freeCellsRowIndexArray.size() == 2 && oCellsRowIndexArray.size() == 3) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomRowIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomRowIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    /* randomColIndex stores an index of freeCellsColIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomColIndex = freeCellsColIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [RandomIndex][randomIndex] is played.
                    buttons2D5By5[randomRowIndex][randomColIndex].setText("X");
                    cellStatuses5By5[randomRowIndex][randomColIndex] = 1;// cell statuses is updated
                    systemPlayed = true;// system has played.
                    return;
                }
            } else {// If system plays as O.
                // If system has played 3 Os in a the diagonal with 2 cells free.
                if (freeCellsRowIndexArray.size() == 2 && xCellsRowIndexArray.size() == 3) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomRowIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomRowIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    /* randomColIndex stores an index of freeCellsColIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomColIndex = freeCellsColIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [RandomIndex][randomIndex] is played.
                    buttons2D5By5[randomRowIndex][randomColIndex].setText("O");
                    cellStatuses5By5[randomRowIndex][randomColIndex] = 0;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                }
            }
        }
    }


    /**
     * Checks if the system has played 3 Xs in a row, column or diagonal when system plays as X
     * and plays one of the free cells.
     */
    @SuppressWarnings("UnnecessaryReturnStatement")
    private void playConsecutiveFreeCellsApproachWin() {
        Button[][] buttons2D5By5 = {{button11_5By5, button12_5By5, button13_5By5, button14_5By5,
                button15_5By5}, {button21_5By5, button22_5By5, button23_5By5, button24_5By5,
                button25_5By5}, {button31_5By5, button32_5By5, button33_5By5, button34_5By5,
                button35_5By5}, {button41_5By5, button42_5By5, button43_5By5, button44_5By5,
                button45_5By5}, {button51_5By5, button52_5By5, button53_5By5, button54_5By5,
                button55_5By5}};
        for (int index = 0; index < 5; index++) {
		/*checking through the 5 rows and 5 columns if at least one X or O have been played with
		free cells on the line to play that sums up, with the played cells, to 5.*/

		/*freeCellsColIndexArray stores column indices of cells that have not been played.
		* freeCellsRowIndexArray stores row indices of cells that have not been played.
		* oCellsColIndexArray stores column indices of cells that have been played by player O.
		* xCellsColIndexArray stores column indices of cells that have been played by player X.
		* oCellsRowIndexArray stores row indices of cells that have been played by player O.
		* xCellsRowIndexArray stores row indices of cells that have been played by player X.*/
            ArrayList<Integer> freeCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> freeCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsRowIndexArray = new ArrayList<>();

            for (int colIndex = 0; colIndex < 5; colIndex++) {// for each column of a row.
            /* if the cell referenced by index and colIndex have been played by player X, colIndex
            is stored in the xCellsColIndexArray.*/
                if (cellStatuses5By5[index][colIndex] == 1) xCellsColIndexArray.add(colIndex);
            /* else if the cell referenced by index and colIndex have been played by player O,
            colIndex is stored in the oCellsColIndexArray.*/
                else if (cellStatuses5By5[index][colIndex] == 0) oCellsColIndexArray.add(colIndex);
                    // else colIndex is stored in freeCellsColIndexArray.
                else freeCellsColIndexArray.add(colIndex);

                // for each row on a column.
                /* if the row referenced by colIndex as the row index and index as the column index
                * has been played by player X, colIndex is appended to the xCellsRowIndexArray.*/
                if (cellStatuses5By5[colIndex][index] == 1) xCellsRowIndexArray.add(colIndex);
                // Otherwise if it has been played by player O. It's appended to oCellsRowIndexArray
                if (cellStatuses5By5[colIndex][index] == 0) oCellsRowIndexArray.add(colIndex);
                // Otherwise if it has not been played. It is appended to freeCellsRowIndexArray
                if (cellStatuses5By5[colIndex][index] == -1) freeCellsRowIndexArray.add(colIndex);
            }
            if (playX) {// If the system plays as X.
                /* In the present iteration of rows, if the system has played at least one cell and
                 * there remains at least one free cell while the size of the two sums up to 5.*/
                if (freeCellsColIndexArray.size() > 0 && xCellsColIndexArray.size() > 0 &&
                        (freeCellsColIndexArray.size() + xCellsColIndexArray.size()) == 5) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsColIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsColIndexArray.size());
                    /* randomColIndex stores an index of freeCellsColIndexArray referenced by
                    ]randomIndexOfFreeCellsArray.
                     */
                    int randomColIndex = freeCellsColIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [index][randomColIndex] is played.
                    buttons2D5By5[index][randomColIndex].setText("X");
                    cellStatuses5By5[index][randomColIndex] = 1;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                } else if (freeCellsRowIndexArray.size() > 0 && xCellsRowIndexArray.size() > 0 &&
                        (freeCellsRowIndexArray.size() + xCellsRowIndexArray.size()) == 5) {
                    /* In present iteration of the columns, if system has played at least one cell
                    * and at least one free cells while the size of both sums up to 5.*/
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomRowIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomRowIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [randomRowIndex][index] is played.
                    buttons2D5By5[randomRowIndex][index].setText("X");
                    cellStatuses5By5[randomRowIndex][index] = 1;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                }
            } else {// If the system plays as O.
                /* In the present iteration of rows, if the system has played at least one cell and
                 * there remains at least one free cell while the size of the two sums up to 5.*/
                if (freeCellsColIndexArray.size() > 0 && oCellsColIndexArray.size() > 0 &&
                        (freeCellsColIndexArray.size() + oCellsColIndexArray.size()) == 5) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsColIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsColIndexArray.size());
                    /* randomColIndex stores an index of freeCellsColIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomColIndex = freeCellsColIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [index][randomColIndex] is played.
                    buttons2D5By5[index][randomColIndex].setText("O");
                    cellStatuses5By5[index][randomColIndex] = 0;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                } else if (freeCellsRowIndexArray.size() > 0 && oCellsRowIndexArray.size() > 0 &&
                        (freeCellsRowIndexArray.size() + oCellsRowIndexArray.size()) == 5) {
                    /* In present iteration of the columns, if the system has played at least one
                    cell and at least one free cells while the size of both sums up to 5.*/
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomRowIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomRowIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [randomRowIndex][index] is played.
                    buttons2D5By5[randomRowIndex][index].setText("O");
                    cellStatuses5By5[randomRowIndex][index] = 0;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    break;// breaks out of the loop.
                }
            }
        }
        if (!systemPlayed) {// If system has still not played.
            /* freeCellsRowIndexArray stores row indices of cells that have not been played.
		* oCellsRowIndexArray stores row indices of cells that have been played by player O.
		* xCellsRowIndexArray stores row indices of cells that have been played by player X.*/
            ArrayList<Integer> freeCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsRowIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsRowIndexArray = new ArrayList<>();
            for (int index = 0; index < 5; index++) {// Checks through the left-to-right diagonal.
                if (cellStatuses5By5[index][index] == 1) {// If referenced cell has been played by X
                    // The reference row index is added to xCellsRowIndexArray
                    xCellsRowIndexArray.add(index);
                } else if (cellStatuses5By5[index][index] == 0) {
                    // The reference row index is added to oCellsRowIndexArray
                    oCellsRowIndexArray.add(index);
                } else {// If the cell has not been played.
                    // The reference row index is added to freeCellsRowIndexArray
                    freeCellsRowIndexArray.add(index);
                }
            }

            if (playX) {// If system plays as X.
                /* In the left-to-right diagonal, if the system has played at least one cell
                    * and at least one free cells while the size of both sums up to 5.*/
                if (freeCellsRowIndexArray.size() > 0 && xCellsRowIndexArray.size() > 0 &&
                        (freeCellsRowIndexArray.size() + xCellsRowIndexArray.size()) == 5) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    buttons2D5By5[randomIndex][randomIndex].setText("X");/* the cell referenced by
                    * [RandomIndex][randomIndex] is played.*/
                    cellStatuses5By5[randomIndex][randomIndex] = 1;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    return;
                }
            } else {// If system plays as O.
                /* In the left-to-right diagonal, if the system has played at least one cell
                    * and at least one free cells while the size of both sums up to 5.*/
                if (freeCellsRowIndexArray.size() > 0 && oCellsRowIndexArray.size() > 0 &&
                        (freeCellsRowIndexArray.size() + oCellsRowIndexArray.size()) == 5) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    buttons2D5By5[randomIndex][randomIndex].setText("O");/* the cell referenced by
                    * [RandomIndex][randomIndex] is played.*/
                    cellStatuses5By5[randomIndex][randomIndex] = 0;// cell statuses is updated.
                    systemPlayed = true;// system has played.
                    return;
                }
            }
            /* Clear all elements elements of freeCellsRowIndexArray, xCellsRowIndexArray and
            oCellsRowIndexArray
             */
            /* freeCellsColIndexArray stores column indices of cells that have not been played.
             * oCellsColIndexArray stores column indices of cells that have been played by player O.
             * xCellsColIndexArray stores column indices of cells that have been played by player X.
             * */
            freeCellsRowIndexArray.clear(); xCellsRowIndexArray.clear();
            oCellsRowIndexArray.clear();
            ArrayList<Integer> freeCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> oCellsColIndexArray = new ArrayList<>();
            ArrayList<Integer> xCellsColIndexArray = new ArrayList<>();
            int[] colIndices = {4, 3, 2, 1, 0};// Stores row indices of the right-to-left diagonal.
            // Check the right-to-left diagonal.
            for (int index = 0; index < 5; index++) {// for each row
                // If the cell referenced by [index][colIndices[index]] has been played by player X.
                if (cellStatuses5By5[index][colIndices[index]] == 1) {
                    xCellsRowIndexArray.add(index);// Append index to xCellsRowIndexArray.
                    // Append colIndices[index] to xCellsColIndexArray.
                    xCellsColIndexArray.add(colIndices[index]);
                } else if (cellStatuses5By5[index][colIndices[index]] == 0) {
                    oCellsRowIndexArray.add(index);
                    oCellsColIndexArray.add(colIndices[index]);
                } else {
                    freeCellsRowIndexArray.add(index);
                    freeCellsColIndexArray.add(colIndices[index]);
                }
            }

            if (playX) {// If system plays as X.
                /* In the right-to-left diagonal, if the system has played at least one cell
                 * and at least one free cells while the size of both sums up to 5.*/
                if (freeCellsRowIndexArray.size() > 0 && xCellsRowIndexArray.size() > 0 &&
                        (freeCellsRowIndexArray.size() + xCellsRowIndexArray.size()) == 5) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomRowIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomRowIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    /* randomColIndex stores an index of freeCellsColIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomColIndex = freeCellsColIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [RandomIndex][randomIndex] is played.
                    buttons2D5By5[randomRowIndex][randomColIndex].setText("X");
                    cellStatuses5By5[randomRowIndex][randomColIndex] = 1;// cell statuses is updated
                    systemPlayed = true;// system has played.
                    return;
                }
            } else {// If system plays as O.
                /* In the right-to-left diagonal, if the system has played at least one cell
                 * and at least one free cells while the size of both sums up to 5.*/
                if (freeCellsRowIndexArray.size() > 0 && oCellsRowIndexArray.size() > 0 &&
                        (freeCellsRowIndexArray.size() + oCellsRowIndexArray.size()) == 5) {
                    // randomIndexOfFreeCellsArray stores a random index of freeCellsRowIndexArray.
                    int randomIndexOfFreeCellsArray =
                            (int) (Math.random() * freeCellsRowIndexArray.size());
                    /* randomRowIndex stores an index of freeCellsRowIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomRowIndex = freeCellsRowIndexArray.get(randomIndexOfFreeCellsArray);
                    /* randomColIndex stores an index of freeCellsColIndexArray referenced by
                    randomIndexOfFreeCellsArray.
                     */
                    int randomColIndex = freeCellsColIndexArray.get(randomIndexOfFreeCellsArray);
                    // the cell referenced by [RandomIndex][randomIndex] is played.
                    buttons2D5By5[randomRowIndex][randomColIndex].setText("O");
                    cellStatuses5By5[randomRowIndex][randomColIndex] = 0;// cell statuses is updated
                    systemPlayed = true;// system has played.
                }
            }
        }
    }

    /**
     * This method guides the system to check any free cell on the 5 by 5 game board and play.
     * It checks each column each row of each row starting from the first.
     */
    @SuppressWarnings("UnnecessaryContinue")
    private void playAnyFreeCell5By5() {
        Button[][] buttons2D_5By5 = {{button11_5By5, button12_5By5, button13_5By5, button14_5By5,
                button15_5By5}, {button21_5By5, button22_5By5, button23_5By5, button24_5By5,
                button25_5By5}, {button31_5By5, button32_5By5, button33_5By5, button34_5By5,
                button35_5By5}, {button41_5By5, button42_5By5, button43_5By5, button44_5By5,
                button45_5By5}, {button51_5By5, button52_5By5, button53_5By5, button54_5By5,
                button55_5By5}};
        while (!systemPlayed) {// while system has not played.
            int randRowIndex = (int) (Math.random() * 5);// generates a random row index.
            int randColIndex = (int) (Math.random() * 5);// generates a random column index.
            if (cellStatuses5By5[randRowIndex][randColIndex] == 0 ||
                    cellStatuses5By5[randRowIndex][randColIndex] == 1) {/* if the selected cell has
                    been played.*/
                continue;// continue to the next iteration of the loop.

            } else {// if the selected cell has not been played.
                if (playX) {// if system plays X
                    // the cell in the present iteration of the for loop is clicked.
                    buttons2D_5By5[randRowIndex][randColIndex].setText("X");
                    cellStatuses5By5[randRowIndex][randColIndex] = 1;
                    systemPlayed = true;
                    break;
                } else {// if system plays O
                    // the cell in the present iteration of the for loop is clicked.
                    buttons2D_5By5[randRowIndex][randColIndex].setText("O");
                    cellStatuses5By5[randRowIndex][randColIndex] = 0;// cellStatus is updated.
                    systemPlayed = true;
                    break;
                }
            }
        }
    }

    /**
     * Method handles click from the play 3 by 3 and play 5 by 5 buttons.
     */
    public void playSize(View view) {
        switch (view.getId()) {/* switch statement checks the id of the clicked button against IDs
        of each play size button.
        */
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