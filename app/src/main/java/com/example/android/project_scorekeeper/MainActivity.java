package com.example.android.project_scorekeeper;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeam1 = 0;
    int scoreTeam2 = 0;
    int lastPoints = 0;
    int lastTeamToScore = 0;
    boolean canUndo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the font's path
        String fontPath = "fonts/BlackOpsOne-Regular.ttf";
        // Load the font as a TypeFace object
        Typeface typeFace = Typeface.createFromAsset(getAssets(), fontPath);
        // Get the customFont TextView for Team 1
        TextView textViewTeam1Score = (TextView) findViewById(R.id.team1Score);
         // Get the customFont TextView for Team 2
        TextView textViewTeam2Score = (TextView) findViewById(R.id.team2Score);
        // Set the extra fancy font in the customFont TextView for Team 1
        textViewTeam1Score.setTypeface(typeFace);
        // Set the extra fancy font in the customFont TextView for Team 2
        textViewTeam2Score.setTypeface(typeFace);
    }

    /* Displays the given score for Team 1 */
    public void displayForTeam1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team1Score);
        scoreView.setText(String.valueOf(score));
    }

    /* Displays the given score for Team 2 */
    public void displayForTeam2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team2Score);
        scoreView.setText(String.valueOf(score));
    }

    /* Displays messages in the message area. For now, just warning if undo is pressed twice in a row */
    public void displayMessage(String messageToDisplay) {
        TextView messageView = (TextView) findViewById(R.id.messageArea);
        messageView.setText(String.valueOf(messageToDisplay));
    }

    /* Adds 6 points to Team 1 score */
    public void team1Add6Points(View view) {
        scoreTeam1 += 6;
        lastTeamToScore = 1;
        lastPoints = 6;
        canUndo = true;
        displayForTeam1(scoreTeam1);
        displayMessage("");
    }

    /* Adds 1 point to Team 1 score */
    public void team1Add1Point(View view) {
        scoreTeam1 += 1;
        lastTeamToScore = 1;
        lastPoints = 1;
        canUndo = true;
        displayForTeam1(scoreTeam1);
        displayMessage("");
    }

    /* Adds 2 points to Team 1 score */
    public void team1Add2Points(View view) {
        scoreTeam1 += 2;
        lastTeamToScore = 1;
        lastPoints = 2;
        canUndo = true;
        displayForTeam1(scoreTeam1);
        displayMessage("");
    }

    /* Adds 3 points to Team 1 score */
    public void team1Add3Points(View view) {
        scoreTeam1 += 3;
        lastTeamToScore = 1;
        lastPoints = 3;
        canUndo = true;
        displayForTeam1(scoreTeam1);
        displayMessage("");
    }

    /* Adds 6 points to Team 2 score */
    public void team2Add6Points(View view) {
        scoreTeam2 += 6;
        lastTeamToScore = 2;
        lastPoints = 6;
        canUndo = true;
        displayForTeam2(scoreTeam2);
        displayMessage("");
    }

    /* Adds 1 point to Team 2 score */
    public void team2Add1Point(View view) {
        scoreTeam2 += 1;
        lastTeamToScore = 2;
        lastPoints = 1;
        canUndo = true;
        displayForTeam2(scoreTeam2);
        displayMessage("");
    }

    /* Adds 2 points to Team 2 score */
    public void team2Add2Points(View view) {
        scoreTeam2 += 2;
        lastTeamToScore = 2;
        lastPoints = 2;
        canUndo = true;
        displayForTeam2(scoreTeam2);
        displayMessage("");
    }

    /* Adds 3 points to Team 2 score */
    public void team2Add3Points(View view) {
        scoreTeam2 += 3;
        lastTeamToScore = 2;
        lastPoints = 3;
        canUndo = true;
        displayForTeam2(scoreTeam2);
        displayMessage("");
    }

    /* Resets both scores to zero */
    public void resetScores(View view) {
        scoreTeam1 = 0;
        scoreTeam2 = 0;
        displayForTeam1(scoreTeam1);
        displayForTeam2(scoreTeam2);
        canUndo = false;
        displayMessage("");
    }

    /* Undoes the last action.
     * Check to see if there is any score to undo and whether last action was undo.
     * (Only one undo supported at a time). Determine which team scored last & how many points.
     * Reduce score of appropriate team by appropriate amount to return to previous state. */
    public void undoLastAction(View view) {
        if (canUndo) {
            if (lastTeamToScore == 1) {
                scoreTeam1 -= lastPoints;
                displayForTeam1(scoreTeam1);
            } else if (lastTeamToScore == 2) {
                scoreTeam2 -= lastPoints;
                displayForTeam2(scoreTeam2);
            }
            canUndo = false;
        } else if (!canUndo && scoreTeam1 == 0 && scoreTeam2 == 0) {
            displayMessage(getString(R.string.main_activity_java_undo_no_scores));
        } else if (!canUndo) {
            displayMessage(getString(R.string.main_activity_java_undo_pushed_twice));
        }
    }

}
