package hku.game;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Add a new contact
 */
public class addUser extends AppCompatActivity {
    private userList user_list = new userList();
    private Context context;
    private EditText username;
    private EditText password;
    Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        context = getApplicationContext();
        user_list.loadUsers(context);
        btn_back=(Button)findViewById(R.id.back_button);
        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(addUser.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void saveUser(View view) {

        String username_str = username.getText().toString();
        String password_str = password.getText().toString();

        if (username_str.equals("")) {
            username.setError("Empty field!");
            return;
        }

        if (password_str.equals("")) {
            password.setError("Empty field!");
            return;
        }

        if (password.length()<6){
            password.setError("At least 6 characters!");
            return;
        }

        if (!user_list.isUsernameAvailable(username_str)){
            username.setError("Username already taken!");
            return;
        }
        user user = new user(username_str, password_str, null, 1);
        user_list.addUser(user);
        user_list.saveUsers(context);
        // End AddUserActivity
        finish();
    }
}
