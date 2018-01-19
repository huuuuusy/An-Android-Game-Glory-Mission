package hku.game;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import static hku.game.loginUser.playerName;

public class editUser extends AppCompatActivity {

    private userList user_list = new userList();
    private user user;
    private EditText password;
    private EditText username;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_user);

        context = getApplicationContext();
        user_list.loadUsers(context);
//        int index = user_list.getSize()-1;
        Intent intent = getIntent();
//        int pos = intent.getIntExtra("position", index);

        user = user_list.getUserByUsername(playerName);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        username.setText(user.getUsername());
        password.setText(user.getPassword());
    }

    public void saveUser(View view) {

        String password_str = password.getText().toString();

        if (password_str.equals("")) {
            password.setError("Empty field!");
            return;
        }

        if (password.length()<6){
            password.setError("At least 6 characters!");
            return;
        }

        String username_str = username.getText().toString();
        int level = user.getLevel();
        String id = user.getId();

        user_list.removeUser(user);

        // Check that username is unique AND username is changed (Note: if username was not changed
        // then this should be fine, because it was already unique.)
        if (!user_list.isUsernameAvailable(username_str) && !(user.getUsername().equals(username_str))) {
            username.setError("Username already taken!");
            return;
        }

        user updated_user = new user(username_str, password_str, id, level);

        user_list.addUser(updated_user);
        user_list.saveUsers(context);

        // End EditUserActivity
        finish();
    }

    public void deleteUser(View view) {

        user_list.removeUser(user);
        user_list.saveUsers(context);

        // End EditUserActivity
        finish();
    }
}
