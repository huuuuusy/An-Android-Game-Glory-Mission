package hku.game;

import java.util.UUID;


public class user {
    private String username;
    private String password;
    private String id;
    private int level;

    user(String username, String password, String id, int level) {
        this.username = username;
        this.password = password;
        this.level = level;

        if (id == null){
            setId();
        } else {
            updateId(id);
        }
    }

    public String getId(){
        return this.id;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString();
    }

    public void updateId(String id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel(){ return this.level;}

    public void setLevel(int level){ this.level=level;}
}


