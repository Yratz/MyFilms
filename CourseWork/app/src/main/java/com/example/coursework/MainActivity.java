package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    DBhelper dBhelper;
    Button button_films;
    Button button_wishlist;
    Button button_visible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            readCSV();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        button_films = findViewById(R.id.btn_films);
        button_wishlist = findViewById(R.id.btn_wishlist);
        button_visible = findViewById(R.id.btn_visible);
        button_wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("list","wishlist");
                startActivity(intent);
            }
        });
        button_films.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Передаем обшее кол-во записей в бд
                Intent intent = new Intent(MainActivity.this, CategoryListActivity.class);
                startActivity(intent);
            }
        });
        button_visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("list","visible");
                startActivity(intent);
            }
        });
    }

//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_bar_main_page, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    public void readCSV() throws IOException, CsvValidationException {


        dBhelper = new DBhelper(this);
        SQLiteDatabase database = dBhelper.getWritableDatabase();
//        database.delete(DBhelper.TABLE_MOVIES, null, null);
        ContentValues contentValues = new ContentValues();
        Cursor cursor = database.query(DBhelper.TABLE_MOVIES, null, null, null, null, null, null);

        // If DB is empty
        if (!cursor.moveToFirst()) {

            try (CSVReader reader = new CSVReader(new InputStreamReader(MainActivity.class.getResourceAsStream("/assets/mymoviedb.csv"), StandardCharsets.UTF_8))
            ) {
                String[] line;
                while ((line = reader.readNext()) != null) {
                    String[] finalLine = line;
                    contentValues.put(DBhelper.KEY_REALIZE_DATE, finalLine[0]);
                    contentValues.put(DBhelper.KEY_TITLE, finalLine[1]);
                    contentValues.put(DBhelper.KEY_OVERVIEW, finalLine[2]);
                    contentValues.put(DBhelper.KEY_POPULARITY, finalLine[3]);
                    contentValues.put(DBhelper.KEY_VOTE_COUNT, finalLine[4]);
                    contentValues.put(DBhelper.KEY_VOTE_AVERAGE,Float.parseFloat(finalLine[5]));
                    contentValues.put(DBhelper.KEY_ORIGINAL_LANGUAGE, finalLine[6]);
                    contentValues.put(DBhelper.KEY_GENRE, finalLine[7]);
                    contentValues.put(DBhelper.KEY_POSTER_URL, finalLine[8]);
                    contentValues.put(DBhelper.KEY_WISHLIST, 0);
                    contentValues.put(DBhelper.KEY_VISIBLE, 0);
                    contentValues.put(DBhelper.USER_RATE, -1);
                    contentValues.put(DBhelper.USER_REVIEW, "");

                    database.insert(DBhelper.TABLE_MOVIES, null, contentValues);
                }

//                database.execSQL("SELECT COUNT(*) FROM TABLE_MOVIES");

//                Cursor cursor_1 = database.query(DBhelper.TABLE_MOVIES, null, null, null, null, null, null);
//                Integer x = cursor_1.getCount();
//                Log.d("MyTag", x.toString());
//
//                if (cursor_1.moveToFirst()) {
//                    int idIndex = cursor_1.getColumnIndex(DBhelper.KEY_ID);
//                    int nameIndex = cursor_1.getColumnIndex(DBhelper.KEY_TITLE);
//                    int emailIndex = cursor_1.getColumnIndex(DBhelper.KEY_OVERVIEW);
//                    do {
//                        Log.d("mLog", "ID = " + cursor_1.getInt(idIndex));
//                    } while (cursor_1.moveToNext());
//                } else
//                    Log.d("mLog","0 rows");
//
//                cursor_1.close();
            }
        }
        cursor.close();
    }
}