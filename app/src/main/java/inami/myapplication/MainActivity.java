package inami.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.anandmuralidhar.simplearandroid.R;
import com.anandmuralidhar.simplearandroid.SimpleARActivity;

public class MainActivity extends AppCompatActivity {


    ImageButton logbtn1;
    ImageButton logbtn2;
    ImageButton logbtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage_activity);

        findViewById(R.id.logbtn1).setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(MainActivity.this,SplashActivity.class);
                        startActivity(intent1);
                    }
                }
        );

        findViewById(R.id.logbtn2).setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(MainActivity.this,SplashActivity.class);
                        startActivity(intent1);
                    }
                }
        );

        findViewById(R.id.logbtn3).setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(MainActivity.this,SplashActivity.class);
                        startActivity(intent1);
                    }
                }
        );

        findViewById(R.id.skipbtn).setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(MainActivity.this,SplashActivity.class);
                        startActivity(intent1);
                    }
                }
        );
    }
}
