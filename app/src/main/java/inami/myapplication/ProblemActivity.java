package inami.myapplication;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.anandmuralidhar.simplearandroid.R;

public class ProblemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Problem_activity);
        EditText et = (EditText) findViewById(R.id.problem);
        int color= Color.parseColor("#a662ee");
        et.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }


}
