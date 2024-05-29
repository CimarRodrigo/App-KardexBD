package com.example.app_bd1;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }



    public void initComponents(){
        btn = findViewById(R.id.button);
    }
    public void crear(View v){
        try {

            KardexDBHelper dbHelper = new KardexDBHelper(MainActivity.this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Toast.makeText(MainActivity.this, "BIEN", Toast.LENGTH_LONG).show();
        } catch (Error e){
            Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_LONG).show();
        }
    }


}