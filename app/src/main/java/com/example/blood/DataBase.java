package com.example.blood;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserModel.class},version = 1)
public abstract class DataBase extends RoomDatabase {

    public abstract DaoClass getDao();

    private static DataBase instance;


    static DataBase getDataBase(final Context context){

        if(instance == null){
            synchronized (Database.class){
                instance = Room.databaseBuilder(context,DataBase.class, "DATABASE5").allowMainThreadQueries().build();
            }
        }
        return instance;
    }
}
