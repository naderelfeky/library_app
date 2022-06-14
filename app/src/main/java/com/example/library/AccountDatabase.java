package com.example.library;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AccountDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME="LIBRARY";
    public static final String TABLE_NAME="ACCOUNT";
    public static final String COL_USERNAME="USERNAME";
    public static final String COL_PASSWORD="PASSWORD";
    public static final String COL_ID="ID";
    public static final int DB_VERSION=1;


      public AccountDatabase(Context context){
            super(context,DB_NAME,null,DB_VERSION);
        }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME +" ("+COL_ID+" TEXT PRIMARY KEY, "
                +COL_USERNAME+" TEXT UNIQUE ,"+COL_PASSWORD+" TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
      onCreate(sqLiteDatabase);
    }
    public boolean insertAccount(Account account){
          SQLiteDatabase dp=getWritableDatabase();
          ContentValues values=new ContentValues();
            values.put(COL_ID,account.getID());
            values.put(COL_USERNAME,account.getUserName());
            values.put(COL_PASSWORD,account.getPassword());
           long result =dp.insert(TABLE_NAME,null,values);
        return (result!=-1);

    }
    public boolean selectUniqueAccount(Account account){
        SQLiteDatabase dp=getWritableDatabase();
        String selectAccount []={account.getUserName()+"",account.getPassword()+""};
        Cursor cursor=dp.rawQuery("SELECT * FROM "+TABLE_NAME +" WHERE "+COL_USERNAME+"=? and "+COL_PASSWORD+"=?", selectAccount);
        if(cursor!=null&&cursor.moveToFirst())  return true;
        else return false;
    }
    public boolean selectUniqueID(Account account){
        SQLiteDatabase dp=getWritableDatabase();
        String selectAccount []={account.getID()+""};
        Cursor cursor=dp.rawQuery("SELECT * FROM "+TABLE_NAME +" WHERE "+COL_ID+"=?", selectAccount);
        if(cursor!=null&&cursor.moveToFirst())  return true;
        else return false;
    }
}
