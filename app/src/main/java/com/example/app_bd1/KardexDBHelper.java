package com.example.app_bd1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class KardexDBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "kardex.db";
    private static final String T_K = "kardex";
    private static final String T_M = "materias";
    private static final String T_P = "periodos";
    private static final String T_E = "estudiantes";
    private static final String T_D = "docentes";
    // tabla kardex
    public static final String CAR = "carnet";
    public static final String MAT = "materia";
    public static final String DOC = "docente";
    public static final String PER = "periodo";
    public static final String NOT = "nota";
    public static final String OBS = "observacion";


    // tabla materias
    public static final String SIG = "sigla";
    public static final String DES = "descripcion";

    // tabla periodos
    public static final String COD = "codigo";

    // tabla estudiantes
    public static final String APP = "paterno";
    public static final String APM = "materno";
    public static final String NOM = "nombres";


    public KardexDBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + T_M + "(" +
                "sigla TEXT primary key," +
                "descripcion TEXT);");

        db.execSQL("CREATE TABLE " + T_E + "(" +
                "carnet INTEGER primary key," +
                "paterno TEXT," +
                "materno TEXT," +
                "nombres TEXT);");

        db.execSQL("CREATE TABLE " + T_D + "(" +
                "carnet INTEGER primary key," +
                "paterno TEXT," +
                "materno TEXT," +
                "nombres TEXT);");

        db.execSQL("CREATE TABLE " + T_P + "(" +
                "codigo TEXT primary key," +
                "descripcion TEXT);");

        db.execSQL("CREATE TABLE " + T_K + "(" +
                "carnet INTEGER," +
                "materia TEXT," +
                "docente INTEGER," +
                "periodo TEXT," +
                "nota INTEGER," +
                "observacion TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + T_M + ";");
        db.execSQL("DROP TABLE IF EXISTS " + T_E + ";");
        db.execSQL("DROP TABLE IF EXISTS " + T_D + ";");
        db.execSQL("DROP TABLE IF EXISTS " + T_P + ";");
        db.execSQL("DROP TABLE IF EXISTS " + T_K + ";");
        onCreate(db);
    }


}
