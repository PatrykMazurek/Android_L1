package com.masiad.myapplication_l1;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

@Entity(tableName = "message_table")
public class Message {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;
    public String name;
    public String lastName;
    public String title;
    public String textMessage;

    public Message(){
        id = 0;
        name = "";
        lastName = "";
        title = "";
        textMessage = "";
    }

    public Message(String n, String l, String t, String tm){
        name = n;
        lastName = l;
        title = t;
        textMessage = tm;
    }


}
