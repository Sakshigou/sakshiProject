package com.example.cropregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "MyDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table farmer(name1 Text primary key,fname1 Text, address1 Text,email1 Text,phone1 Text,sgid1 Text,bankname1 Text,branch1 Text,account1 Text,ifsccode1 Text,landhactere1 Text,cropname1 Text,block1 Text,district1 Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public Boolean insetUserData(String name1, String fname1, String address1,
                                 String email1, String phone1, String sgid1, String bankname1,
                                 String branch1, String account1, String ifsccode1, String landhactere1,
                                 String cropname1, String block1, String district1) {

        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name1", name1);
        contentValues.put("fname1", fname1);
        contentValues.put("address1", address1);
        contentValues.put("email1", email1);
        contentValues.put("phone1", phone1);
        contentValues.put("sgid1", sgid1);
        contentValues.put("bankname1", bankname1);
        contentValues.put("branch1", branch1);
        contentValues.put("account1", account1);
        contentValues.put("ifsccode1", ifsccode1);
        contentValues.put("landhactere1", landhactere1);
        contentValues.put("cropname1", cropname1);
        contentValues.put("block1", block1);
        contentValues.put("district1", district1);

        Long result = MyDB.insert("farmer", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}


