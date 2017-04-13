package com.example.sdonath.dndattributedice;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class AttributeDice extends AppCompatActivity {


    private TextView[] rollResults = new TextView[7];
    private Button[] rollButtons = new Button[7];
    private int[] scores = new int[7];
    private int[][] dice = new int[7][4];
    private Random rand;

    private ArrayList<ImageView> diceImageViews = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute_dice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        //setze alle scores auf 0
    /*for(int i = 0; i<7;i++){
        scores[i] = 0;
    }*/
        rollResults[0] = (TextView) findViewById(R.id.textViewRollDice1);
        rollResults[1] = (TextView) findViewById(R.id.textViewRollDice2);
        rollResults[2] = (TextView) findViewById(R.id.textViewRollDice3);
        rollResults[3] = (TextView) findViewById(R.id.textViewRollDice4);
        rollResults[4] = (TextView) findViewById(R.id.textViewRollDice5);
        rollResults[5] = (TextView) findViewById(R.id.textViewRollDice6);
        rollResults[6] = (TextView) findViewById(R.id.textViewRollDice7);

        rollButtons[0] = (Button) findViewById(R.id.buttonDice1);
        rollButtons[1] = (Button) findViewById(R.id.buttonDice2);
        rollButtons[2] = (Button) findViewById(R.id.buttonDice3);
        rollButtons[3] = (Button) findViewById(R.id.buttonDice4);
        rollButtons[4] = (Button) findViewById(R.id.buttonDice5);
        rollButtons[5] = (Button) findViewById(R.id.buttonDice6);
        rollButtons[6] = (Button) findViewById(R.id.buttonDice7);

        rand = new Random();

        ImageView die11Image = (ImageView) findViewById(R.id.die11Image);
        ImageView die12Image = (ImageView) findViewById(R.id.die12Image);
        ImageView die13Image = (ImageView) findViewById(R.id.die13Image);
        ImageView die14Image = (ImageView) findViewById(R.id.die14Image);
        ImageView die21Image = (ImageView) findViewById(R.id.die21Image);
        ImageView die22Image = (ImageView) findViewById(R.id.die22Image);
        ImageView die23Image = (ImageView) findViewById(R.id.die23Image);
        ImageView die24Image = (ImageView) findViewById(R.id.die24Image);
        ImageView die31Image = (ImageView) findViewById(R.id.die31Image);
        ImageView die32Image = (ImageView) findViewById(R.id.die32Image);
        ImageView die33Image = (ImageView) findViewById(R.id.die33Image);
        ImageView die34Image = (ImageView) findViewById(R.id.die34Image);
        ImageView die41Image = (ImageView) findViewById(R.id.die41Image);
        ImageView die42Image = (ImageView) findViewById(R.id.die42Image);
        ImageView die43Image = (ImageView) findViewById(R.id.die43Image);
        ImageView die44Image = (ImageView) findViewById(R.id.die44Image);
        ImageView die51Image = (ImageView) findViewById(R.id.die51Image);
        ImageView die52Image = (ImageView) findViewById(R.id.die52Image);
        ImageView die53Image = (ImageView) findViewById(R.id.die53Image);
        ImageView die54Image = (ImageView) findViewById(R.id.die54Image);
        ImageView die61Image = (ImageView) findViewById(R.id.die61Image);
        ImageView die62Image = (ImageView) findViewById(R.id.die62Image);
        ImageView die63Image = (ImageView) findViewById(R.id.die63Image);
        ImageView die64Image = (ImageView) findViewById(R.id.die64Image);
        ImageView die71Image = (ImageView) findViewById(R.id.die71Image);
        ImageView die72Image = (ImageView) findViewById(R.id.die72Image);
        ImageView die73Image = (ImageView) findViewById(R.id.die73Image);
        ImageView die74Image = (ImageView) findViewById(R.id.die74Image);

        diceImageViews.add(die11Image);
        diceImageViews.add(die12Image);
        diceImageViews.add(die13Image);
        diceImageViews.add(die14Image);
        diceImageViews.add(die21Image);
        diceImageViews.add(die22Image);
        diceImageViews.add(die23Image);
        diceImageViews.add(die24Image);
        diceImageViews.add(die31Image);
        diceImageViews.add(die32Image);
        diceImageViews.add(die33Image);
        diceImageViews.add(die34Image);
        diceImageViews.add(die41Image);
        diceImageViews.add(die42Image);
        diceImageViews.add(die43Image);
        diceImageViews.add(die44Image);
        diceImageViews.add(die51Image);
        diceImageViews.add(die52Image);
        diceImageViews.add(die53Image);
        diceImageViews.add(die54Image);
        diceImageViews.add(die61Image);
        diceImageViews.add(die62Image);
        diceImageViews.add(die63Image);
        diceImageViews.add(die64Image);
        diceImageViews.add(die71Image);
        diceImageViews.add(die72Image);
        diceImageViews.add(die73Image);
        diceImageViews.add(die74Image);
    }
    public int roll(Random r){
        return r.nextInt(6)+1;
    }
    public void rollDice(View v){
        int buttonTag = Integer.parseInt(v.getTag().toString());
        int diceResultInt =0;
        int lowestRollScore = 24;
        int lowestRollNum=1;
        for (int i = 0; i<4;i++){
            dice[buttonTag-1][i] = roll(rand);
            diceResultInt += dice[buttonTag-1][i];
            String imageName = "die_" + dice[buttonTag-1][i] + ".png";
            try{
                InputStream stream = getAssets().open(imageName);
                Drawable d = Drawable.createFromStream(stream,null);
                //die liste ist 4*7 28 felder groß, mit geti bekomme ich felder 0-3, aber nicht felder 4-27
                if(buttonTag == 1)
                    diceImageViews.get(i).setImageDrawable(d);
                else if(buttonTag==2)
                    diceImageViews.get(i+4).setImageDrawable(d);
                else if(buttonTag==3)
                    diceImageViews.get(i+8).setImageDrawable(d);
                else if(buttonTag==4)
                    diceImageViews.get(i+12).setImageDrawable(d);
                else if(buttonTag==5)
                    diceImageViews.get(i+16).setImageDrawable(d);
                else if(buttonTag==6)
                    diceImageViews.get(i+20).setImageDrawable(d);
                else if(buttonTag==7)
                    diceImageViews.get(i+24).setImageDrawable(d);
                stream.close();
            }catch (IOException e){
                e.printStackTrace();
            }

            int temp = dice[buttonTag-1][i];
            if(lowestRollScore>temp){
                lowestRollScore = temp;
                lowestRollNum = i;
            }
        }
        //lowestResult abziehen
        diceResultInt -=lowestRollScore;
        String imageNameF = "die_" + dice[buttonTag-1][lowestRollNum]+"f.png";
        try{
            InputStream stream = getAssets().open(imageNameF);
            Drawable d = Drawable.createFromStream(stream,null);
            //die liste ist 4*7 28 felder groß, mit geti bekomme ich felder 0-3, aber nicht felder 4-27
            if(buttonTag == 1)
                diceImageViews.get(lowestRollNum).setImageDrawable(d);
            else if(buttonTag==2)
                diceImageViews.get(lowestRollNum+4).setImageDrawable(d);
            else if(buttonTag==3)
                diceImageViews.get(lowestRollNum+8).setImageDrawable(d);
            else if(buttonTag==4)
                diceImageViews.get(lowestRollNum+12).setImageDrawable(d);
            else if(buttonTag==5)
                diceImageViews.get(lowestRollNum+16).setImageDrawable(d);
            else if(buttonTag==6)
                diceImageViews.get(lowestRollNum+20).setImageDrawable(d);
            else if(buttonTag==7)
                diceImageViews.get(lowestRollNum+24).setImageDrawable(d);
            stream.close();
        }catch (IOException e){
            e.printStackTrace();
        }



        //int diceResultInt = dice[buttonTag-1][0] + dice[buttonTag-1][1] + dice[buttonTag-1][2] + dice[buttonTag-1][3];
        String diceResultString = Integer.toString(diceResultInt);
        scores[buttonTag-1] =diceResultInt;
        rollResults[buttonTag-1].setText(diceResultString);

    }
    public void rollAllDice(View v){
        for(int i = 0; i<7; i++){ //gehe von 0 bis 6
            v.setTag(i+1);
            rollDice(v);
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

