package com.example.krestikinoliki;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends AppCompatActivity {

    public int[] cells;
    public int currenPlayer;
    public boolean isGameOver = false;
    public int first = 0;
    public int second = 0;
//    public Button sound;

    //life cycle hook
//    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

//        sound = findViewById(R.id.imageButton_0);
//        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.cpok);
//        sound = findViewById(R.id.imageButton_1);
//        final MediaPlayer mediaPlayer1 = MediaPlayer.create(this, R.raw.cpok);
//        sound = findViewById(R.id.imageButton_2);
//        final MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.cpok);
//        sound = findViewById(R.id.imageButton_3);
//        final MediaPlayer mediaPlayer3 = MediaPlayer.create(this, R.raw.cpok);
//        sound = findViewById(R.id.imageButton_4);
//        final MediaPlayer mediaPlayer4 = MediaPlayer.create(this, R.raw.cpok);
//        sound = findViewById(R.id.imageButton_5);
//        final MediaPlayer mediaPlayer5 = MediaPlayer.create(this, R.raw.cpok);
//        sound = findViewById(R.id.imageButton_6);
//        final MediaPlayer mediaPlayer6 = MediaPlayer.create(this, R.raw.cpok);
//        sound = findViewById(R.id.imageButton_7);
//        final MediaPlayer mediaPlayer7 = MediaPlayer.create(this, R.raw.cpok);
//        sound = findViewById(R.id.imageButton_8);
//        final MediaPlayer mediaPlayer8 = MediaPlayer.create(this, R.raw.cpok);
//
//        sound.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mediaPlayer.start();
//            }
//        });
        currenPlayer = 1;
        cells = new int[9];
        for(int i = 0; i < cells.length; i++ ) {
            cells[i] = 0;
        }
    }
    //
    public void onCellClick(View view) {
        if(isGameOver) {
            return;
        }
        int cellId = 0;
        switch (view.getId()) {
            case R.id.imageButton_0: {
                cellId = 0;
                break;
            }
            case R.id.imageButton_1: {
                cellId = 1;
                break;
            }
            case R.id.imageButton_2: {
                cellId = 2;
                break;
            }
            case R.id.imageButton_3: {
                cellId = 3;
                break;
            }
            case R.id.imageButton_4: {
                cellId = 4;
                break;
            }
            case R.id.imageButton_5: {
                cellId = 5;
                break;
            }
            case R.id.imageButton_6: {
                cellId = 6;
                break;
            }
            case R.id.imageButton_7: {
                cellId = 7;
                break;
            }
            case R.id.imageButton_8: {
                cellId = 8;
                break;
            }
        }

        Log.d("HYU", String.valueOf(cells[cellId]));

        if(cells[cellId] != 0) {
            return;
        }
        updateView((ImageView) view, currenPlayer, cellId);
        if(currenPlayer == 1) {
            currenPlayer = 2;
        }
        else{
            currenPlayer = 1;
        }
        if(checkWin() != 0) {
            String result = "";
            TextView textView1 = findViewById(R.id.textView_1);
            TextView textView2 = findViewById(R.id.textView_2);
            if(checkWin() == 1) {
                first = first + 1;
                textView1.setText(String.valueOf(first));
                result = "First Win";
            }
            else{
                second = second + 1;
                textView2.setText(String.valueOf(second));
                result = "Second Win";
            }
            Toast toast = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG);
            toast.show();
           isGameOver = true;
        }
    }

    public void reset() {
        ImageView view = findViewById(R.id.imageButton_0);
        view.setImageResource(R.drawable.i);
        ImageView view1 = findViewById(R.id.imageButton_1);
        view1.setImageResource(R.drawable.ng);
        ImageView view2 = findViewById(R.id.imageButton_2);
        view2.setImageResource(R.drawable.l);
        ImageView view3 = findViewById(R.id.imageButton_3);
        view3.setImageResource(R.drawable.a);
        ImageView view4 = findViewById(R.id.imageButton_4);
        view4.setImageResource(R.drawable.r);
        ImageView view5 = findViewById(R.id.imageButton_5);
        view5.setImageResource(R.drawable.s);
        ImageView view6 = findViewById(R.id.imageButton_6);
        view6.setImageResource(R.drawable.n);
        ImageView view7 = findViewById(R.id.imageButton_7);
        view7.setImageResource(R.drawable.g);
        ImageView view8 = findViewById(R.id.imageButton_8);
        view8.setImageResource(R.drawable.o);

    }
    public int checkWin() {
        if(cells[0] == cells[1] && cells[1] == cells[2] && cells[0] != 0) {
            return cells[0];
        }
        if(cells[0] == cells[3] && cells[3] == cells[6] && cells[0] != 0) {
            return cells[0];
        }
        if(cells[0] == cells[4] && cells[4] == cells[8] && cells[0] != 0) {
            return cells[0];
        }
        if(cells[1] == cells[4] && cells[4] == cells[7] && cells[1] != 0) {
            return cells[1];
        }
        if(cells[2] == cells[5] && cells[5] == cells[8] && cells[2] != 0) {
            return cells[2];
        }
        if(cells[2] == cells[4] && cells[4] == cells[6] && cells[2] != 0) {
            return cells[2];
        }
        if(cells[3] == cells[4] && cells[4] == cells[5] && cells[3] != 0) {
            return cells[3];
        }
        if(cells[6] == cells[7] && cells[7] == cells[8] && cells[6] != 0) {
            return cells[6];
        }
        return 0;
    }


    public void updateView(ImageView view, int currenPlayer, int cellId) {
        cells[cellId] = currenPlayer;
        if(currenPlayer == 1) {
            view.setImageResource(R.drawable.nolikdva);
        }
        else{
            view.setImageResource(R.drawable.krestikdva);
        }
    }

    public void restart(View view) {
        reset();
        isGameOver = false;
        currenPlayer = 1;
        for(int i = 0; i < cells.length; i++ ) {
            cells[i] = 0;
        }
    }
    public void resetScore(View view) {
        TextView textView1 = findViewById(R.id.textView_1);
        TextView textView2 = findViewById(R.id.textView_2);
        first = 0;
        textView1.setText(String.valueOf(first));
        second = 0;
        textView2.setText(String.valueOf(second));
    }
}