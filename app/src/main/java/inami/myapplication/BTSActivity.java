package inami.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.anandmuralidhar.simplearandroid.R;

public class BTSActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bts_activity);

        findViewById(R.id.button3).setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(BTSActivity.this,BingoActivity.class);
                        startActivity(intent1);
                    }
                }
        );
    }
}
