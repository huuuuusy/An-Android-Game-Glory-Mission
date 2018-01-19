package hku.game;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class LoginPage extends AppCompatActivity {
    private Button btn_start;
    private Button btn_grade;
    private Button btn_edit;
    ImageView iv;
    AnimationDrawable animationDrawable;
    MediaPlayer mediaPlayer1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        btn_start = (Button) findViewById(R.id.btn1);
        btn_start.setOnClickListener(new MyonclickListener());
        btn_grade = (Button) findViewById(R.id.btn2);
        btn_grade.setOnClickListener(new MyonclickListener());
        btn_edit = (Button) findViewById(R.id.btn3);
        btn_edit.setOnClickListener(new MyonclickListener());
        iv=(ImageView)findViewById(R.id.running);
        animationDrawable=(AnimationDrawable)iv.getDrawable();
        animationDrawable.start();
        mediaPlayer1=MediaPlayer.create(this,R.raw.main);
        mediaPlayer1.start();
        mediaPlayer1.setLooping(true);

    }

    public class MyonclickListener implements OnClickListener {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn1:
                    Intent intent1 = new Intent(LoginPage.this, chooseActor.class);
                    mediaPlayer1.stop();
                    startActivity(intent1);
                    break;
                case R.id.btn2:
                    Intent intent2 = new Intent(LoginPage.this, showUser.class);
                    mediaPlayer1.stop();
                    startActivity(intent2);
                    break;
                case R.id.btn3:
                    Intent intent3 = new Intent(LoginPage.this, editUser.class);
                    mediaPlayer1.stop();
                    startActivity(intent3);
                    break;

            }

        }
    }

}