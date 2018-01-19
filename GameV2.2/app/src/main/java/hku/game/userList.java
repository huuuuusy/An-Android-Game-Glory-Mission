package hku.game;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class userList {

    private static ArrayList<user> users;
    private String FILENAME = "user_file.sav";

    public userList() {
        users = new ArrayList<user>();
    }

    public void setUsers(ArrayList<user> user_list) {
        users = user_list;
    }

    public ArrayList<user> getUsers() {
        return users;
    }

    public ArrayList<String> getAllUsernames(){
        ArrayList<String> username_list = new ArrayList<String>();
        for (user u : users){
            username_list.add(u.getUsername());
        }
        return username_list;
    }

    public void addUser(user user) {
        users.add(user);
    }

    public void removeUser(user user) {
        users.remove(user);
    }

    public user getUser(int index) {
        return users.get(index);
    }

    public int getSize() {
        return users.size();
    }

    public user getUserByUsername( String username){
        for (user u : users){
            if (u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }

    public boolean hasUser(user user) {
        for (user u : users) {
            if (user.getId().equals(u.getId())) {
                return true;
            }
        }
        return false;
    }

    public int getIndex(user user) {
        int pos = 0;
        for (user u : users) {
            if (user.getId().equals(u.getId())) {
                return pos;
            }
            pos = pos+1;
        }
        return -1;
    }

    public boolean isUsernameAvailable(String username){
        for (user u : users) {
            if (u.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public void loadUsers(Context context) {

        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<user>>() {}.getType();
            users = gson.fromJson(isr, listType); // temporary
            fis.close();
        } catch (FileNotFoundException e) {
            users = new ArrayList<user>();
        } catch (IOException e) {
            users = new ArrayList<user>();
        }
    }

    public void saveUsers(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, 0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(users, osw);
            osw.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
