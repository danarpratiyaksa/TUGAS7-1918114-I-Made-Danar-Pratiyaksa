package com.example.tugas7_1918114;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_tokocasinghp";
    private static final String tb_tokocasinghp = "tb_tokocasinghp";
    private static final String tb_tokocasinghp_id = "id";
    private static final String tb_tokocasinghp_namacasing = "namacasing";
    private static final String tb_tokocasinghp_harga = "harga";
    private static final String CREATE_TABLE_TOKOCASINGHP = "CREATE TABLE " +
    tb_tokocasinghp +"("
            + tb_tokocasinghp_id + " INTEGER PRIMARY KEY ,"
            + tb_tokocasinghp_namacasing + " TEXT ,"
            + tb_tokocasinghp_harga + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TOKOCASINGHP);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateCasingHP(CasingHP data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_tokocasinghp_id, data.get_id());
        values.put(tb_tokocasinghp_namacasing, data.get_nama_casing());
        values.put(tb_tokocasinghp_harga, data.get_harga());
        db.insert(tb_tokocasinghp, null, values);
        db.close();
    }
    public List<CasingHP> ReadCasingHP() {
        List<CasingHP> listMhs = new ArrayList<CasingHP>();
        String selectQuery = "SELECT * FROM " + tb_tokocasinghp;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                CasingHP data = new CasingHP();
                data.set_id(cursor.getString(0));
                data.set_nama_casing(cursor.getString(1));
                data.set_harga(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdateCasingHP (CasingHP data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_tokocasinghp_namacasing, data.get_nama_casing());
        values.put(tb_tokocasinghp_harga, data.get_harga());
        return db.update(tb_tokocasinghp_id, values, tb_tokocasinghp_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteCasingHP(CasingHP data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_tokocasinghp_id,tb_tokocasinghp_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
