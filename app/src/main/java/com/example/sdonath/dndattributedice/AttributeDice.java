package com.example.sdonath.dndattributedice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AttributeDice extends AppCompatActivity {


    private TextView[] rollResults = new TextView[10];
    private Button[] rollButtons = new Button[10];
    private int[] scores = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute_dice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //setze alle scores auf 0
    /*for(int i = 0; i<7;i++){
        scores[i] = 0;
    }*/
        rollResults[0] = (TextView) findViewById(R.id.textViewDiceScore1);
        rollResults[1] = (TextView) findViewById(R.id.textViewDiceScore2);
        rollResults[2] = (TextView) findViewById(R.id.textViewDiceScore3);
        rollResults[3] = (TextView) findViewById(R.id.textViewDiceScore4);
        rollResults[4] = (TextView) findViewById(R.id.textViewDiceScore5);
        rollResults[5] = (TextView) findViewById(R.id.textViewDiceScore6);
        rollResults[6] = (TextView) findViewById(R.id.textViewDiceScore7);

        rollButtons[0] = (Button) findViewById(R.id.buttonDice1);
        rollButtons[1] = (Button) findViewById(R.id.buttonDice2);
        rollButtons[2] = (Button) findViewById(R.id.buttonDice3);
        rollButtons[3] = (Button) findViewById(R.id.buttonDice4);
        rollButtons[4] = (Button) findViewById(R.id.buttonDice5);
        rollButtons[5] = (Button) findViewById(R.id.buttonDice6);
        rollButtons[6] = (Button) findViewById(R.id.buttonDice7);
    }
    public void rollDice(View v){
        int buttonTag = Integer.parseInt(v.getTag().toString());
        rollResults[buttonTag-1].setText("clicked");
    }
    public void rollAllDice(View v){
        for(int i = 0; i<7; i++){
            rollResults[i].setText("clicked");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_attribute_dice, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

