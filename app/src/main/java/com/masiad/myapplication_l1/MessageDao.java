package com.masiad.myapplication_l1;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface MessageDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMessage(Message msg);

    @Query("SELECT * FROM message_table")
    LiveData<List<Message>> getAllMessage();

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateMessage(Message msg);
}
