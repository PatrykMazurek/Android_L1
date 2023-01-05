package com.masiad.myapplication_l1;

import android.app.Application;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Message.class}, version = 1, exportSchema = false)
public abstract class AppRoomDatabase extends RoomDatabase {

    public abstract MessageDao messageDao();

    private static volatile AppRoomDatabase appRoomDatabase;
    private static final int THREAD_NUMBER = 4;
    static final ExecutorService databaseWriterExecutor =
            Executors.newFixedThreadPool(THREAD_NUMBER);

    static AppRoomDatabase getInstance(final Context context){
        if(appRoomDatabase == null){
            synchronized (AppRoomDatabase.class){
                appRoomDatabase = Room.databaseBuilder(context,
                        AppRoomDatabase.class,
                        "app_database").build();
            }
        }
        return appRoomDatabase;
    }
}
