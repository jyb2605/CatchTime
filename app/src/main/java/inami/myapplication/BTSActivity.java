package inami.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.anandmuralidhar.simplearandroid.R;

public class BTSActivity extends AppCompatActivity {
    Fragment cur_fragment = new Fragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bts_activity);

        ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(new adapter(getSupportFragmentManager()));

        findViewById(R.id.button3).setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(BTSActivity.this,BingoActivity.class);
                        startActivity(intent1);
                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    }
                }
        );

    }


    private class adapter extends FragmentPagerAdapter {
        public adapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            if(position<0 || 3<=position)
                return null;
            switch (position){
                case 0:
                    cur_fragment = new Viewpager_Page1();
                    break;
                case 1:
                    cur_fragment = new Viewpager_Page2();
                    break;
                case 2:
                    cur_fragment = new Viewpager_Page3();
                    break;
            }
            return cur_fragment;
        }
        @Override
        public int getCount() {
            return 3;
        }
    }


}
