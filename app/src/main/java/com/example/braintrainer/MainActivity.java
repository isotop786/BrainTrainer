package com.example.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private TextView txtSum,txtTimer,txtPoint,txtCorrect;
    private Random rand = new Random();

    private Button button,button1,button2,button3;

    ArrayList<Integer> answers = new ArrayList<Integer>();

    int locationOfCorrectAnswer;

    public void start(View view){

        btnStart.setVisibility(View.INVISIBLE);

    }

    public void choseBtn(View view){
//        Log.i("Tag",(String)view.getTag());
//    txtCorrect.setText(view.getTag().toString());

        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            txtCorrect.setText("Correct!");
        }else{
            txtCorrect.setText("Incorrect");

        }




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        txtSum= findViewById(R.id.txtSum);
        txtTimer=findViewById(R.id.txtTimer);
        txtPoint=findViewById(R.id.txtPoint);
        txtCorrect=findViewById(R.id.txtResult);

        button=findViewById(R.id.button);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);



        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        txtSum.setText(Integer.toString(a)+"+"+Integer.toString(b));

        int inCorrectAnswer;

        locationOfCorrectAnswer = rand.nextInt(4);

        for (int i=0;i<4;i++){
            if(i==locationOfCorrectAnswer){
                answers.add(a+b);
            }else{
                inCorrectAnswer =rand.nextInt(41);
                while(inCorrectAnswer==a+b){
                    inCorrectAnswer=rand.nextInt(41);
                }

                answers.add(inCorrectAnswer);
            }
        }

        button.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));



    }
}
