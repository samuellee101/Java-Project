package com.example.cost_database_ui;

public class Credentials {
    private String username = " ";
    private String password = " ";

    Credentials(String UserName, String Password)
    {
        username = UserName;
        password = Password;
    }

    public void setPassword(String PassWord){
        password = PassWord;
    }

    public void setUsername(String USERNAME){
        username = USERNAME;
    }

    public  String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
