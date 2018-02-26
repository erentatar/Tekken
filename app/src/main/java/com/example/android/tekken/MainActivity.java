package com.example.android.tekken;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private int scoreFighterA = 100;
    private int scoreFighterB = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMoveTurn(R.id.layout_fighter_a, true);
        setMoveTurn(R.id.layout_fighter_b, false);
    }

    /**
     * Increase the score for Fighter A by 1 point.
     */
    public void moveForFighterA(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_fighter_a_move_1:
                scoreFighterB -= 15;
                break;
            case R.id.btn_fighter_a_move_2:
                scoreFighterB -= 10;
                break;
            case R.id.btn_fighter_a_move_3:
                scoreFighterB -= 5;
                break;
            default:
                break;
        }

        if (scoreFighterB <= 0) {
            scoreFighterB = 0;

            setMoveTurn(R.id.layout_fighter_a, false);
            setMoveTurn(R.id.layout_fighter_b, false);
            Toast.makeText(this, getString(R.string.fighter_a_name) + " won!", Toast.LENGTH_LONG).show();
        } else {
            setMoveTurn(R.id.layout_fighter_b, true);
            setMoveTurn(R.id.layout_fighter_a, false);
        }

        displayForFighterB(scoreFighterB);
    }

    /**
     * Increase the score for Fighter B by 1 point.
     */
    public void moveForFighterB(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_fighter_b_move_1:
                scoreFighterA -= 15;
                break;
            case R.id.btn_fighter_b_move_2:
                scoreFighterA -= 10;
                break;
            case R.id.btn_fighter_b_move_3:
                scoreFighterA -= 5;
                break;
            default:
                break;
        }

        if (scoreFighterA <= 0) {
            scoreFighterA = 0;

            setMoveTurn(R.id.layout_fighter_a, false);
            setMoveTurn(R.id.layout_fighter_b, false);
            Toast.makeText(this, getString(R.string.fighter_b_name) + " won!", Toast.LENGTH_LONG).show();
        } else {
            setMoveTurn(R.id.layout_fighter_b, false);
            setMoveTurn(R.id.layout_fighter_a, true);
        }

        displayForFighterA(scoreFighterA);
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        scoreFighterA = 100;
        scoreFighterB = 100;
        displayForFighterA(scoreFighterA);
        displayForFighterB(scoreFighterB);
        setMoveTurn(R.id.layout_fighter_a, true);
        setMoveTurn(R.id.layout_fighter_b, false);
    }

    /**
     * Displays the given score for Fighter A.
     */
    public void displayForFighterA(int score) {
        TextView scoreView = findViewById(R.id.txt_fighter_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Fighter B.
     */
    public void displayForFighterB(int score) {
        TextView scoreView = findViewById(R.id.txt_fighter_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Disable or enable the moves for Fighter.
     */
    public void setMoveTurn(int id, boolean activate) {
        LinearLayout layout = findViewById(id);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            child.setEnabled(activate);
        }
    }
}

