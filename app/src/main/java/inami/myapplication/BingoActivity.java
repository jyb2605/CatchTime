package inami.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.anandmuralidhar.simplearandroid.R;
import com.anandmuralidhar.simplearandroid.SimpleARActivity;

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

        bingo1 = (Button)findViewById(R.id.bingo1);
        bingo1.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        bingo1.setBackgroundDrawable(ContextCompat.getDrawable(BingoActivity.this,R.drawable.icon_orange09));
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );

        bingo2 = (Button)findViewById(R.id.bingo2);
        bingo2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        bingo2.setBackgroundDrawable(ContextCompat.getDrawable(BingoActivity.this,R.drawable.icon_orange02));
                        Intent intent1 = new Intent(BingoActivity.this,BodyActivity.class);

                        startActivity(intent1);
                    }
                }
        );


        bingo3 = (Button)findViewById(R.id.bingo3);
        bingo3.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        bingo3.setBackgroundDrawable(ContextCompat.getDrawable(BingoActivity.this,R.drawable.icon_orange03));
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );

        bingo4 = (Button)findViewById(R.id.bingo4);
        bingo4.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        bingo4.setBackgroundDrawable(ContextCompat.getDrawable(BingoActivity.this,R.drawable.icon_orange04));
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );


        bingo5 = (Button)findViewById(R.id.bingo5);
        bingo5.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        bingo5.setBackgroundDrawable(ContextCompat.getDrawable(BingoActivity.this,R.drawable.icon_orange05));
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );


        bingo6 = (Button)findViewById(R.id.bingo6);
        bingo6.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        bingo6.setBackgroundDrawable(ContextCompat.getDrawable(BingoActivity.this,R.drawable.icon_orange06));
                        Intent intent1 = new Intent(BingoActivity.this,SimpleARActivity.class);
                        startActivity(intent1);
                    }
                }
        );


        bingo7 = (Button)findViewById(R.id.bingo7);
        bingo7.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        bingo7.setBackgroundDrawable(ContextCompat.getDrawable(BingoActivity.this,R.drawable.icon_orange01));
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );


        bingo8 = (Button)findViewById(R.id.bingo8);
        bingo8.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        bingo8.setBackgroundDrawable(ContextCompat.getDrawable(BingoActivity.this,R.drawable.icon_orange08));
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );


        bingo9 = (Button)findViewById(R.id.bingo9);
        bingo9.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        bingo9.setBackgroundDrawable(ContextCompat.getDrawable(BingoActivity.this,R.drawable.icon_orange07));
                        Intent intent1 = new Intent(BingoActivity.this,ProblemActivity.class);
                        startActivity(intent1);
                    }
                }
        );
    }
}
