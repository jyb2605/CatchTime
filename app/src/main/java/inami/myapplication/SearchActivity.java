package inami.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.anandmuralidhar.simplearandroid.R;

import static com.anandmuralidhar.simplearandroid.R.layout.search_activity;

public class SearchActivity extends AppCompatActivity {
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(search_activity);


        findViewById(R.id.button3).setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {

                        dialog = ProgressDialog.show(SearchActivity.this, "", "로딩중 입니다.", true);
                        dialog.show();


                        EndDialog endDialog = new EndDialog();
                        endDialog.start();
                        /*
                        Intent intent1 = new Intent(SearchActivity.this,BTSActivity.class);
                        startActivity(intent1);
                        */
                    }
                }
        );

    }


    private Handler DialogHandler = new Handler (){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            dialog.dismiss();
            Intent intent=new Intent(SearchActivity.this,BTSActivity.class);
            startActivity(intent);
//            startActivity(intent);
        }
    };

    private class EndDialog extends Thread {
        public void run(){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            DialogHandler.sendEmptyMessage(0);
        }
    }

}

