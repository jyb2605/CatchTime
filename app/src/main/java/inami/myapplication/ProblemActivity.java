package inami.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.anandmuralidhar.simplearandroid.R;

public class ProblemActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.problem_activity);
        Button btn = (Button) findViewById(R.id.button);
        EditText et = (EditText) findViewById(R.id.problem);
        int color= Color.parseColor("#a662ee");
        et.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_IN);


       btn.setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
//                        Intent intent1 = new Intent(ProblemActivity.this,BingoActivity.class);
//                        startActivity(intent1);
                        finish();
                    }
                }
        );
    }


}
