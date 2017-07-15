package inami.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.anandmuralidhar.simplearandroid.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Handler hd = new Handler();
//        hd.postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                finish();
//                startActivity(new Intent(MainActivity.this, SimpleARActivity.class));
//            }
//        }, 1000);
    }
}
