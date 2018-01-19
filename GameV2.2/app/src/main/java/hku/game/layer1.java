package hku.game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static hku.game.R.drawable.hole;
import static hku.game.R.drawable.hole2;
import static hku.game.loginUser.playerId;
import static hku.game.loginUser.playerName;
import static hku.game.loginUser.playerPassword;


public class layer1 extends AppCompatActivity {
    ImageView image1, image2,image3;
    Button left, right, ahead, back, restart;
    TextView txt;
    static int r = 0, h=0, l=0, b=0;
    int i = 0;
    Integer i1 = 0;
    Integer i2 = 0;
    static int[] row, line;
    public count count;
   MediaPlayer mediaPlayer2;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layer1);
        image1 = (ImageView) findViewById(R.id.human);
        left = (Button) findViewById(R.id.btnleft);
        right = (Button) findViewById(R.id.btnright);
        ahead = (Button) findViewById(R.id.btnahead);
        back = (Button) findViewById(R.id.btnback);
        restart = (Button) findViewById(R.id.restart2);
        txt = (TextView) findViewById(R.id.txt);
        i = R.id.image11;
        mediaPlayer2=MediaPlayer.create(layer1.this,R.raw.backgroundmusic1);
        mediaPlayer2.start();
        mediaPlayer2.setLooping(true);
        RelativeLayout.LayoutParams par
                = (RelativeLayout.LayoutParams) image1.getLayoutParams();
        Integer y = par.leftMargin, x = par.topMargin;
        String text1 = "NAME: ";
        String text2 = playerName;
        String text3 = "LEVEL: 1 LAYER: 1";
        String text = text1 +text2 + "\n" + text3;
        Spannable span = new SpannableString(text);
        span.setSpan(new AbsoluteSizeSpan(25),0,6+playerName.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC),0,6+playerName.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new ForegroundColorSpan(Color.BLUE), 0,6+playerName.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new AbsoluteSizeSpan(25),6+playerName.length(),text.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC),6+playerName.length(),text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new ForegroundColorSpan(Color.BLACK), 6+playerName.length(),text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        txt.setText(span);
        count.addImages(0);
        final Integer QIAN,ZUO,YOU,HOU,QIANZUO,QIANYOU,HOUZUO,HOUYOU,ZUOZUO,ZUOYOU,YOUYOU,YOUZUO;
        Intent intent=getIntent();
        QIAN=intent.getIntExtra("qian",0);
        HOU=intent.getIntExtra("hou",0);
        ZUO=intent.getIntExtra("zuo",0);
        YOU=intent.getIntExtra("you",0);
        QIANYOU=intent.getIntExtra("qianyou",0);
        QIANZUO=intent.getIntExtra("qianzuo",0);
        HOUZUO=intent.getIntExtra("houzuo",0);
        HOUYOU=intent.getIntExtra("houyou",0);
        ZUOZUO=intent.getIntExtra("zuozuo",0);
        ZUOYOU=intent.getIntExtra("zuoyou",0);
        YOUYOU=intent.getIntExtra("youyou",0);
        YOUZUO=intent.getIntExtra("youzuo",0);
        image1.setImageResource(QIAN);
        restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count.cleanImages();
                Intent intent2 = new Intent(layer1.this, layer1.class);
                intent2.putExtra("qian",QIAN);
                intent2.putExtra("zuo",ZUO);
                intent2.putExtra("you",YOU);
                intent2.putExtra("hou",HOU);
                intent2.putExtra("qianzuo",QIANZUO);
                intent2.putExtra("qianyou",QIANZUO);
                intent2.putExtra("zuozuo",ZUOZUO);
                intent2.putExtra("zuoyou",ZUOYOU);
                intent2.putExtra("youzuo",YOUZUO);
                intent2.putExtra("youyou",YOUYOU);
                intent2.putExtra("houyou",HOUYOU);
                intent2.putExtra("houzuo",HOUZUO);
                mediaPlayer2.stop();
                startActivity(intent2);
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {//设置向左走的按钮
                h = 0;//初始位置
                l = 0;
                b = 0;
                image1.setImageResource(ZUO);//设置初始向左的图像
                RelativeLayout.LayoutParams par
                        = (RelativeLayout.LayoutParams) image1.getLayoutParams();
                Integer y = par.leftMargin, x = par.topMargin;

                Integer y1 = y / 60, x1 = x / 60;
                if(y1 == 2 && x1 ==1){}
                else{if (y1 == 4 && x1 ==1){}
                else{if (y1 == 1 && x1 ==3){}
                else{if (y1 == 3 && x1 ==3){}
                else{if (y1 == 4 && x1 ==2){}
                //if(y1 == 4 && x1 ==2) {}
                else{
                    if (y1 == 3 && x1 == 2){
                        cleandata();
                        Intent intent =  new Intent(getBaseContext(),layer2.class);
                        int po;
                        po=mediaPlayer2.getCurrentPosition();
                        intent.putExtra("position",po);
                        mediaPlayer2.stop();
                        startActivity(intent);
                        finish();
                    }else{
                        if (par.leftMargin - 60 > -1) {
                            i = i + y1 + x1 * 5;
                            i1 = y1-1 + x1 * 5;
                            count.addImages(i1);
                            i2 = count.getImages(i1);

                            if (i2 == 1) {
                                image2 = (ImageView) findViewById(i);//设置洞
                                image2.setImageResource(hole);
                            } else {
                                image2 = (ImageView) findViewById(i-1);
                                image2.setImageResource(hole2);
                                image1.setVisibility(View.INVISIBLE);
//                                txt.setText("Game Over!");
                                count.cleanImages();
                                saveGame();
                                Intent intent1 = new Intent(layer1.this, LoginPage.class);
                                mediaPlayer2.stop();
                                startActivity(intent1);
                            }
                            if (r == 0) {//向左第一步
                                par.leftMargin -= 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(ZUOZUO);
                                r = 1;
                            } else if (r == 1) {//向左第二步
                                par.leftMargin -= 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(ZUO);
                                r = 2;
                            } else if (r == 2) {//向左第三步
                                par.leftMargin -= 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(ZUOYOU);
                                r = 3;
                            } else if (r == 3) {//向左第四步，和第一步一样的图
                                par.leftMargin -= 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(ZUO);
                                r = 0;
                            }
                        }
                        i = R.id.image11;
                    }
                }
                }}}}}});
        right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                r = 0;
                h = 0;
                b = 0;
                image1.setImageResource(YOU);
                RelativeLayout.LayoutParams par
                        = (RelativeLayout.LayoutParams) image1.getLayoutParams();
                Integer y = par.leftMargin, x = par.topMargin;

                Integer y1 = y / 60, x1 = x / 60;
                if (y1 == 0 && x1 == 1) {}
                else{if (y1 == 3 && x1 ==1){}
                else{if (y1 == 0 && x1 ==3){}
                else{if (y1 == 2 && x1 ==3){}
                else{if (y1 == 2 && x1 ==0){}
                else{if (y1 == 3 && x1 ==4){}
                else{
                    if (y1 == 1 && x1 == 2){
                        cleandata();
                        Intent intent =  new Intent(layer1.this,layer2.class);
                        intent.putExtra("qian",QIAN);
                        intent.putExtra("zuo",ZUO);
                        intent.putExtra("you",YOU);
                        intent.putExtra("hou",HOU);
                        intent.putExtra("qianzuo",QIANZUO);
                        intent.putExtra("qianyou",QIANZUO);
                        intent.putExtra("zuozuo",ZUOZUO);
                        intent.putExtra("zuoyou",ZUOYOU);
                        intent.putExtra("youzuo",YOUZUO);
                        intent.putExtra("youyou",YOUYOU);
                        intent.putExtra("houyou",HOUYOU);
                        intent.putExtra("houzuo",HOUZUO);
                        Integer po;
                        po=mediaPlayer2.getCurrentPosition();
                        intent.putExtra("position",po);
                        mediaPlayer2.stop();
                        startActivity(intent);
                        finish();
                    }else{
                        if (par.leftMargin + 60 < 241) {

                            i = i + y1 + x1 * 5;
                            i1 = y1+1 + x1 * 5;
                            count.addImages(i1);
                            i2 = count.getImages(i1);

                            if (i2 == 1) {
                                image2 = (ImageView) findViewById(i);
                                image2.setImageResource(hole);
                            } else {
                                image2 = (ImageView) findViewById(i+1);
                                image2.setImageResource(hole2);
                                image1.setVisibility(View.INVISIBLE);
//                                txt.setText("Game Over!");

                                saveGame();

                                count.cleanImages();
                                Intent intent1 = new Intent(layer1.this, LoginPage.class);
                                mediaPlayer2.stop();
                                startActivity(intent1);
                            }
                            if (l == 0) {
                                par.leftMargin += 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(YOUZUO);
                                l = 1;
                            } else if (l == 1) {
                                par.leftMargin += 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(YOU);
                                l = 2;
                            } else if (l == 2) {
                                par.leftMargin += 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(YOUYOU);
                                l = 3;
                            } else if (l == 3) {
                                par.leftMargin += 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(YOU);
                                l = 0;
                            }
                        }
                        i = R.id.image11;

                    }
                }
                }}}}}}});
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                r = 0;
                l = 0;
                b = 0;
                image1.setImageResource(QIAN);
                RelativeLayout.LayoutParams par
                        = (RelativeLayout.LayoutParams) image1.getLayoutParams();
                Integer y = par.leftMargin, x = par.topMargin;

                Integer y1 = y / 60, x1 = x / 60;
                if (y1 == 1 && x1 == 0) {}
                else{if (y1 == 0 && x1 ==2){}
                else{if (y1 == 1 && x1 ==3){}
                else{if (y1 == 3 && x1 ==1){}
                else{if (y1 == 4 && x1 ==3){}
                else{
                    if (y1 == 2 && x1 == 1){
                        cleandata();
                        Intent intent =  new Intent(layer1.this,layer2.class);
                        intent.putExtra("qian",QIAN);
                        intent.putExtra("zuo",ZUO);
                        intent.putExtra("you",YOU);
                        intent.putExtra("hou",HOU);
                        intent.putExtra("qianzuo",QIANZUO);
                        intent.putExtra("qianyou",QIANZUO);
                        intent.putExtra("zuozuo",ZUOZUO);
                        intent.putExtra("zuoyou",ZUOYOU);
                        intent.putExtra("youzuo",YOUZUO);
                        intent.putExtra("youyou",YOUYOU);
                        intent.putExtra("houyou",HOUYOU);
                        intent.putExtra("houzuo",HOUZUO);
                        Integer po;
                        po=mediaPlayer2.getCurrentPosition();
//                        txt.setText(po.toString());
                        intent.putExtra("position",po);
                        mediaPlayer2.stop();
                        startActivity(intent);
                        finish();
                    }else{
                        if (par.topMargin + 60 < 241) {
                            i = i + y1 + x1 * 5;
                            i1 = y1 + (x1+1)* 5;
                            count.addImages(i1);
                            i2 = count.getImages(i1);

                            if (i2 == 1) {
                                image2 = (ImageView) findViewById(i);
                                image2.setImageResource(hole);
                            } else {
                                image2 = (ImageView) findViewById(i+5);
                                image2.setImageResource(hole2);
                                image1.setVisibility(View.INVISIBLE);
//                                txt.setText("Game Over!");

                                saveGame();

                                count.cleanImages();
                                Intent intent1 = new Intent(layer1.this, LoginPage.class);
                                mediaPlayer2.stop();
                                startActivity(intent1);
                            }
                            if (h == 0) {
                                par.topMargin += 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(QIANZUO);
                                h = 1;
                            } else if (h == 1) {
                                par.topMargin += 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(QIAN);
                                h = 2;
                            } else if (h == 2) {
                                par.topMargin += 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(QIANYOU);
                                h = 3;
                            } else if (h == 3) {
                                par.topMargin += 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(QIAN);
                                h = 0;
                            }
                        }
                        i = R.id.image11;
                    }
                }
                }}}}}});
        ahead.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                h = 0;
                l = 0;
                r = 0;
                image1.setImageResource(HOU);
                RelativeLayout.LayoutParams par
                        = (RelativeLayout.LayoutParams) image1.getLayoutParams();
                Integer y = par.leftMargin, x = par.topMargin;
                Integer y1 = y / 60, x1 = x / 60;
                if (y1 == 1 && x1 == 2) {}
                else{if (y1 == 0 && x1 ==3){}
                else{if (y1 == 1 && x1 ==4){}
                else{if (y1 == 2 && x1 ==3){}
                else{if (y1 == 3 && x1 ==3){}
                else{if (y1 == 4 && x1 ==1){
                    cleandata();
                    Intent intent =  new Intent(layer1.this,layer3.class);
                    intent.putExtra("qian",QIAN);
                    intent.putExtra("zuo",ZUO);
                    intent.putExtra("you",YOU);
                    intent.putExtra("hou",HOU);
                    intent.putExtra("qianzuo",QIANZUO);
                    intent.putExtra("qianyou",QIANZUO);
                    intent.putExtra("zuozuo",ZUOZUO);
                    intent.putExtra("zuoyou",ZUOYOU);
                    intent.putExtra("youzuo",YOUZUO);
                    intent.putExtra("youzuo",YOUYOU);
                    intent.putExtra("houyou",HOUYOU);
                    intent.putExtra("houzuo",HOUZUO);
                    mediaPlayer2.stop();
                    startActivity(intent);
                    finish();
                }
                else{
                    if (y1 == 2 && x1 == 3){
                        cleandata();
                        Intent intent =  new Intent(layer1.this,layer2.class);
                        startActivity(intent);
                        finish();
                    }else{
                        if (par.topMargin - 60 > -1) {

                            i = i + y1 + x1 * 5;
                            i1 = y1 + (x1-1) * 5;
                            count.addImages(i1);
                            i2 = count.getImages(i1);

                            if (i2 == 1) {
                                image2 = (ImageView) findViewById(i);
                                image2.setImageResource(hole);
                            } else {
                                image2 = (ImageView) findViewById(i-5);
                                image2.setImageResource(hole2);
                                image1.setVisibility(View.INVISIBLE);
//                                txt.setText("Game Over!");

                                saveGame();

                                count.cleanImages();
                                Intent intent1 = new Intent(layer1.this, LoginPage.class);
                                mediaPlayer2.stop();
                                startActivity(intent1);
                            }
                            if (b == 0) {
                                par.topMargin -= 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(HOUZUO);
                                b = 1;
                            } else if (b == 1) {

                                par.topMargin -= 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(HOU);
                                b = 2;
                            } else if (b == 2) {

                                par.topMargin -= 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(HOUYOU);
                                b = 3;
                            } else if (b == 3) {
                                par.topMargin -= 60;
                                image1.setLayoutParams(par);
                                image1.setImageResource(HOU);
                                b = 0;
                            }
                        }
                        i = R.id.image11;
                    }
                }
                }}}}}}});

    }
    public void cleandata(){
        r = 0;
        h=0; l=0; b=0;
        i = 0;
        i1 = 0;
        i2 = 0;

    }

    public void saveGame(){
        userList user_list = new userList();
        context = getApplicationContext();
        user_list.loadUsers(context);

        user olduser = user_list.getUserByUsername(playerName);
        user_list.removeUser(olduser);

        user player= new user(playerName, playerPassword, playerId,1);
        user_list.addUser(player);
        user_list.saveUsers(context);




    }
}