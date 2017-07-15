package inami.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anandmuralidhar.simplearandroid.R;

public class Viewpager_Page2 extends android.support.v4.app.Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LinearLayout linearLayout = (LinearLayout)inflater.inflate(R.layout.viewpager_child,container,false);

        ImageView tutorial = (ImageView) linearLayout.findViewById(R.id.img_tutorial);
        TextView text = (TextView) linearLayout.findViewById(R.id.textView);
        tutorial.setImageResource(R.drawable.ticket_02);
        text.setText("소녀시대 콘서트\n2017.07.16");
        return linearLayout;
    }
}