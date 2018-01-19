package hku.game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_login;
    private Button btn_signup;
    MediaPlayer mediaPlayer1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = (Button) findViewById(R.id.btn2);
        btn_login.setOnClickListener(new MyonclickListener());
        btn_signup = (Button) findViewById(R.id.btn1);
        btn_signup.setOnClickListener(new MyonclickListener());
        mediaPlayer1=MediaPlayer.create(MainActivity.this,R.raw.main);
        if(!mediaPlayer1.isPlaying())
        mediaPlayer1.start();
        mediaPlayer1.setLooping(true);

    }

    public class MyonclickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn1:
                    Intent intent1 = new Intent(MainActivity.this, addUser.class);
                    startActivity(intent1);
                    mediaPlayer1.stop();
                    break;
                case R.id.btn2:
                    Intent intent2 = new Intent(MainActivity.this, loginUser.class);
                    startActivity(intent2);
                    mediaPlayer1.stop();
                    break;
            }

        }
    }

}