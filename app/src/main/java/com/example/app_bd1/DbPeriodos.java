package com.example.app_bd1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbPeriodos extends KardexDBHelper{
    Context context;

    public DbPeriodos(Context context){
        super(context);
        this.context = context;
    }

    public long insertPeriodo(String codigo, String descripcion){
        long id = 0;
        try {
            KardexDBHelper dbHelper = new KardexDBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put("codigo", codigo);
            values.put("descripcion", descripcion);
            id = db.insert("periodos", null, values);

        } catch (Error e){
            e.toString();
        }

        return id;
    }

    public String listar(){
        KardexDBHelper dbHelper = new KardexDBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] data = new String[] {"codigo", "descripcion"};
        Cursor c = db.query("periodos", data, null, null, null, null, null);
        String res = "";

        int i1 = c.getColumnIndex("codigo");
        int i2 = c.getColumnIndex("descripcion");

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext() ){
            res = res + c.getString(i1) + " " + c.getString(i2) + "\n";
        }

        return res;
    }
}
