package hku.game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static hku.game.loginUser.playerLevel;

public class chooseActor extends AppCompatActivity {
    Button btn_men,btn_women;
    TextView TXT;
    MediaPlayer mediaPlayer1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_actor);
        btn_men=(Button)findViewById(R.id.men);
        btn_women=(Button)findViewById(R.id.women);
        Integer qian=R.drawable.qian,zuo=R.drawable.zuo,you=R.drawable.you,hou=R.drawable.hou;
        Integer qianzuo=R.drawable.qianzuo,qianyou=R.drawable.qianyou;
        Integer zuozuo=R.drawable.zuozuo,zuoyou=R.drawable.zuoyou;
        Integer houzuo=R.drawable.houzuo,houyou=R.drawable.houyou;
        mediaPlayer1=MediaPlayer.create(this,R.raw.main);
        mediaPlayer1.start();
        mediaPlayer1.setLooping(true);
        btn_men.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mediaPlayer1.stop();
                Integer qian=R.drawable.qian,zuo=R.drawable.zuo,you=R.drawable.you,hou=R.drawable.hou;
                Integer qianzuo=R.drawable.qianzuo,qianyou=R.drawable.qianyou;
                Integer zuozuo=R.drawable.zuozuo,zuoyou=R.drawable.zuoyou;
                Integer youzuo=R.drawable.youzuo,youyou=R.drawable.youyou;
                Integer houzuo=R.drawable.houzuo,houyou=R.drawable.houyou;

                switch (playerLevel){
                    case 0:
                    case 1:
                        Intent intent1 = new Intent(chooseActor.this, layer1.class);
                        intent1.putExtra("qian",qian);
                        intent1.putExtra("zuo",zuo);
                        intent1.putExtra("you",you);
                        intent1.putExtra("hou",hou);
                        intent1.putExtra("qianzuo",qianzuo);
                        intent1.putExtra("qianyou",qianyou);
                        intent1.putExtra("zuozuo",zuozuo);
                        intent1.putExtra("zuoyou",zuoyou);
                        intent1.putExtra("youzuo",youzuo);
                        intent1.putExtra("youyou",youyou);
                        intent1.putExtra("houyou",houyou);
                        intent1.putExtra("houzuo",houzuo);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(chooseActor.this, layer3.class);
                        intent2.putExtra("qian",qian);
                        intent2.putExtra("zuo",zuo);
                        intent2.putExtra("you",you);
                        intent2.putExtra("hou",hou);
                        intent2.putExtra("qianzuo",qianzuo);
                        intent2.putExtra("qianyou",qianyou);
                        intent2.putExtra("zuozuo",zuozuo);
                        intent2.putExtra("zuoyou",zuoyou);
                        intent2.putExtra("youzuo",youzuo);
                        intent2.putExtra("youyou",youyou);
                        intent2.putExtra("houyou",houyou);
                        intent2.putExtra("houzuo",houzuo);
                        startActivity(intent2);
                        break;

                }



            }
        });
        btn_women.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent intent=new Intent(chooseActor.this,layer1.class);
                Integer qian=R.drawable.womenqian,zuo=R.drawable.womenzuo,you=R.drawable.womenyou,hou=R.drawable.womenhou;
                Integer qianzuo=R.drawable.womenqianzuo,qianyou=R.drawable.womenqianyou;
                Integer zuozuo=R.drawable.womenzuozuo,zuoyou=R.drawable.womenzuoyou;
                Integer youzuo=R.drawable.womenyouzuo,youyou=R.drawable.womenyouyou;
                Integer houzuo=R.drawable.womenhouzuo,houyou=R.drawable.womenhouyou;
                mediaPlayer1.stop();
                switch (playerLevel){
                    case 0:
                    case 1:
                        Intent intent1 = new Intent(chooseActor.this, layer1.class);
                        intent1.putExtra("qian",qian);
                        intent1.putExtra("zuo",zuo);
                        intent1.putExtra("you",you);
                        intent1.putExtra("hou",hou);
                        intent1.putExtra("qianzuo",qianzuo);
                        intent1.putExtra("qianyou",qianyou);
                        intent1.putExtra("zuozuo",zuozuo);
                        intent1.putExtra("zuoyou",zuoyou);
                        intent1.putExtra("youzuo",youzuo);
                        intent1.putExtra("youyou",youyou);
                        intent1.putExtra("houyou",houyou);
                        intent1.putExtra("houzuo",houzuo);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(chooseActor.this, layer3.class);
                        intent2.putExtra("qian",qian);
                        intent2.putExtra("zuo",zuo);
                        intent2.putExtra("you",you);
                        intent2.putExtra("hou",hou);
                        intent2.putExtra("qianzuo",qianzuo);
                        intent2.putExtra("qianyou",qianyou);
                        intent2.putExtra("zuozuo",zuozuo);
                        intent2.putExtra("zuoyou",zuoyou);
                        intent2.putExtra("youzuo",youzuo);
                        intent2.putExtra("youyou",youyou);
                        intent2.putExtra("houyou",houyou);
                        intent2.putExtra("houzuo",houzuo);
                        startActivity(intent2);
                        break;

                }


            }
        });
    }
}