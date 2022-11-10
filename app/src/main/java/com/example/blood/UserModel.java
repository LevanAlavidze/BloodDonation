package com.example.blood;




import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "user")
public class UserModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int key;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "mobile")
    private String mobile;

    @ColumnInfo(name = "location")
    private String location;

    @ColumnInfo(name = "bloodtype")
    private String bloodtype;

    @ColumnInfo(name = "nextdate")
    private String nextdate;

    @ColumnInfo(name = "healthIssue")
    private String healthIssue;





    public void setKey(int key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public void setNextdate(String nextdate) {
        this.nextdate = nextdate;
    }

    public void setHealthIssue(String healthIssue) {
        this.healthIssue = healthIssue;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getLocation() {
        return location;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public String getNextdate() {
        return nextdate;
    }

    public String getHealthIssue() {
        return healthIssue;
    }
}
