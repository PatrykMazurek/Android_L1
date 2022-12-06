package com.masiad.myapplication_l1;

import android.os.Build;
import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;

public class Message {

    public int id;
    public String name;
    public String lastName;
    public String title;
    public String textMessage;

    public Message(String n, String l, String t, String tm){
        name = n;
        lastName = l;
        title = t;
        textMessage = tm;
    }


}
