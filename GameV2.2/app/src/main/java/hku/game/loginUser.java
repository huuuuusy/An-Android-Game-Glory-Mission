package hku.game;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class loginUser extends AppCompatActivity {

    private userList user_list = new userList();
    private Context context;

    private EditText username;
    private EditText password;

    public static String playerName;
    public static int playerLevel;
    public static String playerPassword;
    public static String playerId;
    Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_user);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        context = getApplicationContext();
        user_list.loadUsers(context);
        btn_back=(Button)findViewById(R.id.back_button);

        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(loginUser.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }



    public void checkUser(View view) {

        String username_str = username.getText().toString();
        String password_str = password.getText().toString();


        if (!user_list.isUsernameAvailable(username_str)){
            user user = user_list.getUserByUsername(username_str);

            playerName = user.getUsername();
            playerLevel = user.getLevel();
            playerId = user.getId();
            playerPassword = user.getPassword();

//            userNow user1 = new userNow(user.getUsername(),1);


            String truePassword = user.getPassword();

            if (password_str.equals(truePassword))
            {
                Intent intent1 = new Intent(loginUser.this, LoginPage.class);
                        startActivity(intent1);

            }
            else{
                password.setError("Wrong password!");
            }

        }else
        {
            username.setError("Wrong username!");
        }


        // End AddUserActivity
        finish();
    }
}
