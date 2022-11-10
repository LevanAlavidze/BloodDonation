package com.example.blood;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoClass {


    @Insert
    void insertAllData(UserModel model);


    @Query("select * from user")
    List<UserModel> getAllData();


    @Query("SELECT * FROM user WHERE bloodtype = :bloodtype")
    List<UserModel> blody(String bloodtype);



    }

