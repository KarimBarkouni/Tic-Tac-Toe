package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {
    private TicTacToeBoard ticTacToeBoard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        Button playAgainBTN = findViewById(R.id.playAgain);
        Button homeBTN = findViewById(R.id.homeButton);
        TextView playerDisplay = findViewById(R.id.playerDisplay);

        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);

        String[] playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        if (playerNames != null){
            playerDisplay.setText(playerNames[0] + "'s turn");
        }

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);

        ticTacToeBoard.setUpGame(playAgainBTN, homeBTN, playerDisplay, playerNames);

    }
    public void playAgainButtononClick (View view){
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }
    public void homeButtononClick (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}