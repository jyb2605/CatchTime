package inami.myapplication;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.anandmuralidhar.simplearandroid.R;

public class BodyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.body_activity);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BingoActivity.bingo9.setBackgroundDrawable(ContextCompat.getDrawable(BodyActivity.this,R.drawable.icon_orange07));
                Toast.makeText(BodyActivity.this,"정답입니다!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }


}
