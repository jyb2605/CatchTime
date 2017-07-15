package inami.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.anandmuralidhar.simplearandroid.R;

public class BingoActivity extends AppCompatActivity {
    Button bingo1;
    Button bingo2;
    Button bingo3;
    Button bingo4;
    Button bingo5;
    Button bingo6;
    Button bingo7;
    Button bingo8;
    Button bingo9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bingo_activity);

        findViewById(R.id.bingo1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );
        findViewById(R.id.bingo2).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );
        findViewById(R.id.bingo3).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );

        findViewById(R.id.bingo4).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );
        findViewById(R.id.bingo5).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );
        findViewById(R.id.bingo6).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );
        findViewById(R.id.bingo7).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );
        findViewById(R.id.bingo8).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );
        findViewById(R.id.bingo9).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );


    }
}
