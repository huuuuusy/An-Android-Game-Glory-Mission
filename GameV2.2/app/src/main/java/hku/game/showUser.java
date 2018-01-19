package hku.game;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;


public class showUser extends AppCompatActivity {


    private Context context;

    private String user_name;
    private String user_password;
    private String user_id;
    private int user_size;
    private int user_level;
    private userList users = new userList();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_user_main);
        context = getApplicationContext();
        users.loadUsers(context);
        user_size = users.getSize();

        for (int i = 0; i < user_size; i++) {
            user user_show = users.getUser(i);
            user_name = user_show.getUsername();
            user_password = user_show.getPassword();
            user_id = user_show.getId();
            user_level = user_show.getLevel();
            setView1();


        }

    }

    public void setView1() {
        LinearLayout view1 = (LinearLayout) findViewById(R.id.main1);
        TextView tv1 = new TextView(this);
//        tv1.setText("NAME " + user_name + "\n"+"LEVEL "+user_level+"\n");
//        tv1.setTextColor(Color.parseColor("#3F51B5"));

        String text1 = "NAME";
        String text2 = user_name;
        String text3 = "LEVEL";
        int text4 = user_level;
        String text = text1 + "\n" +text2 + "\n" + text3 + "\n" + text4;
        Spannable span = new SpannableString(text);

        span.setSpan(new AbsoluteSizeSpan(50),0,5,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC), 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new ForegroundColorSpan(Color.BLUE), 0,5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        span.setSpan(new AbsoluteSizeSpan(40),5, 5+user_name.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new ForegroundColorSpan(Color.BLACK), 5, 5+user_name.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        span.setSpan(new AbsoluteSizeSpan(50),6+user_name.length(),11+user_name.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC), 6+user_name.length(),11+user_name.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new ForegroundColorSpan(Color.BLUE), 6+user_name.length(),11+user_name.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        span.setSpan(new AbsoluteSizeSpan(40),11+user_name.length(), text.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new ForegroundColorSpan(Color.BLACK), 11+user_name.length(), text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv1.setText(span);

        tv1.setGravity(Gravity.CENTER);
//        tv1.setTextSize(20);
        tv1.setBackgroundResource(R.drawable.txtback);
        view1.addView(tv1);
    }
}



