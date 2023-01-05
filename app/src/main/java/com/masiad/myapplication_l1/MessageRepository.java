package com.masiad.myapplication_l1;

import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MessageRepository {

    AppRoomDatabase appRoomDatabase;
    MessageDao messageDao;

    private LiveData<List<Message>> listMessages;

    public MessageRepository(Application application){
        appRoomDatabase = AppRoomDatabase.getInstance(application);
        messageDao = appRoomDatabase.messageDao();
        listMessages = messageDao.getAllMessage();
    }

    public LiveData<List<Message>> getListMessages(){
        return listMessages;
    }

    public void insertMessage(Message msg){
        AppRoomDatabase.databaseWriterExecutor.execute(
                () -> messageDao.insertMessage(msg));
    }


}
