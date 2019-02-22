package com.example.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int n;
    int[] arr = new int[9];
    boolean gameOver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        n = 1;
        gameOver = false;
        arr = new int[]{0,0,0,0,0,0,0,0,0};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imagePiece1 = findViewById(R.id.piece1);
        ImageView imagePiece2 = findViewById(R.id.piece2);
        ImageView imagePiece3 = findViewById(R.id.piece3);
        ImageView imagePiece4 = findViewById(R.id.piece4);
        ImageView imagePiece5 = findViewById(R.id.piece5);
        ImageView imagePiece6 = findViewById(R.id.piece6);
        ImageView imagePiece7 = findViewById(R.id.piece7);
        ImageView imagePiece8 = findViewById(R.id.piece8);
        ImageView imagePiece9 = findViewById(R.id.piece9);
        imagePiece1.setOnClickListener(this);
        imagePiece2.setOnClickListener(this);
        imagePiece3.setOnClickListener(this);
        imagePiece4.setOnClickListener(this);
        imagePiece5.setOnClickListener(this);
        imagePiece6.setOnClickListener(this);
        imagePiece7.setOnClickListener(this);
        imagePiece8.setOnClickListener(this);
        imagePiece9.setOnClickListener(this);
    }


    public void winGame(int value){
        if (value==1) {
            Toast.makeText(MainActivity.this, "Red Player Wins!", Toast.LENGTH_LONG).show();
        }
        else if (value==2) {
            Toast.makeText(MainActivity.this, "Yellow Player Wins!", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Oops! This wasn't supposed to happen!", Toast.LENGTH_LONG).show();
        }
        gameOver = true;
    }

    public void gameCheck(){

        for(int i=0;i<7;i=i+3) {
            if(arr[i]==arr[i+1] && arr[i+1]==arr[i+2] && arr[i]!=0) {
                winGame(arr[i]);
            }
        }
        for(int i=0;i<3;i=i+1) {
            if(arr[i]==arr[i+3] && arr[i+3]==arr[i+6] && arr[i]!=0) {
                winGame(arr[i]);
            }
        }
        if(arr[0]==arr[4] && arr[4]==arr[8] && arr[0]!=0) {
            winGame(arr[0]);
        }
        else if(arr[2]==arr[4] && arr[4]==arr[6] && arr[2]!=0) {
            winGame(arr[2]);
        }
        else if(n==10) {
            Toast.makeText(MainActivity.this, "It's a Draw!", Toast.LENGTH_LONG).show();
            gameOver = true;
        }

    }

    public void playPiece(ImageView piece) {
        if(piece.getAlpha()==1f) {
            return;
        }
        if (gameOver) {
            Toast.makeText(MainActivity.this, "The game is over!", Toast.LENGTH_LONG).show();
            return;
        }
        String name = piece.getResources().getResourceName(piece.getId());
        int num = Character.getNumericValue(name.charAt(29)) - 1;
        if(n%2==1) {
            piece.setAlpha(1f);
            arr[num] = 1;
        }
        else {
            piece.setImageResource(R.drawable.yellow);
            piece.setAlpha(1f);
            arr[num] = 2;
        }
        n++;
        gameCheck();
    }

    @Override
    public void onClick(View v) {
        playPiece((ImageView)v);
    }



}
