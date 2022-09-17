package com.example.quizz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomizer();


    }
    public String random_elem(String[] arr){
        return arr[(int) Math.floor(Math.random() * arr.length)];
    }
    public void randomizer(){
        int score = 0;
        String[] colors = {"white", "black", "yellow", "red", "green", "blue"};
        String main_elem = random_elem(colors);
        String sec_elem = random_elem(colors);
        while(Objects.equals(sec_elem, main_elem)){
            sec_elem = random_elem(colors);
        }
        TextView score_text = findViewById(R.id.score_text);
        LinearLayout color_block = findViewById(R.id.color_block);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);

        int a = (int) Math.floor(Math.random() * 2) + 1;
        if(a == 1){
            btn1.setText(main_elem);
            btn2.setText(sec_elem);
        }else{
            btn2.setText(main_elem);
            btn1.setText(sec_elem);
        }
        //only part that is working bad
        if(main_elem == "yellow"){
            color_block.setBackgroundColor(Color.YELLOW);
        }else if(main_elem == "black"){
            color_block.setBackgroundColor(Color.BLACK);
        }else if(main_elem == "white"){
            color_block.setBackgroundColor(Color.WHITE);
        }else if(main_elem == "red"){
            color_block.setBackgroundColor(Color.RED);
        }else if(main_elem == "green"){
            color_block.setBackgroundColor(Color.GREEN);
        }else if(main_elem == "blue"){
            color_block.setBackgroundColor(Color.BLUE);
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(main_elem == btn1.getText()){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "True!", Toast.LENGTH_SHORT);
                    toast.show();
                    randomizer();
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Wrong!", Toast.LENGTH_SHORT);
                    toast.show();
                    randomizer();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(main_elem == btn2.getText()){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "True!", Toast.LENGTH_SHORT);
                    toast.show();
                    randomizer();
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Wrong!", Toast.LENGTH_SHORT);
                    toast.show();
                    randomizer();
                }
            }
        });
    }
}