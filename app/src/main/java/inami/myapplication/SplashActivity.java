package inami.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.anandmuralidhar.simplearandroid.R;

public class SplashActivity extends AppCompatActivity{
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        layout = (LinearLayout) findViewById(R.id.layout);

        final Animation animTransfadeout = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.fadein);
        layout.startAnimation(animTransfadeout);
        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {

            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        }, 1000);
    }
}
