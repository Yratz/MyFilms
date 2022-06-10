package com.example.coursework;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import androidx.core.view.MenuItemCompat;
import androidx.cursoradapter.widget.SimpleCursorAdapter;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.coursework.databinding.ActivityListBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class ListActivity extends AppCompatActivity {

    String status = null;
    List<FilmCardFill> items = new LinkedList<>();
    RecyclerView recyclerView;
    DemoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
//        Toast.makeText(getApplicationContext(), "onCreate()", Toast.LENGTH_SHORT).show();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(ListActivity.this, MovieActivity.class);

                        intent.putExtra("id",items.get(position).id - 1);
                        startActivity(intent);
                    }
                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );
        Bundle arguments = getIntent().getExtras();
        if(arguments!=null){
            if (arguments.getString("list").equals("wishlist")) {
                status = "wishlist";
//                fillWishlistMovies(items);
            }
            else if (arguments.getString("list").equals("visible")) {
                status = "visible";
            }
            else {
                status = arguments.getString("list");
                fillItems(items);
                adapter = new DemoAdapter(this, items,status,true);
                recyclerView.setAdapter(adapter);
                // Вставляет новый элемент в конец ресайклера
                // Значит сюда надо установить цикл передачи id от 1 до i
                adapter.notifyItemInserted(items.size() - 1);
                adapter.getFilter().filter("");
            }
        }
        else {
            fillItems(items);
            adapter = new DemoAdapter(this, items,status);
            recyclerView.setAdapter(adapter);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter.notifyItemInserted(items.size() - 1);
//            adapter.getFilter().filter("");
        }

    }


    void fillItems(List<FilmCardFill> items) {
//        items.clear();
        DBhelper dBhelper = new DBhelper(this);
        SQLiteDatabase database = dBhelper.getWritableDatabase();
        Cursor cursor = database.query(DBhelper.TABLE_MOVIES, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {

            do {
                int posterIndex = cursor.getColumnIndex(DBhelper.KEY_POSTER_URL);
                int titleIndex = cursor.getColumnIndex(DBhelper.KEY_TITLE);
                int voteIndex = cursor.getColumnIndex(DBhelper.KEY_VOTE_AVERAGE);
                int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
                int yearIndex = cursor.getColumnIndex(DBhelper.KEY_REALIZE_DATE);
                int genreIndex = cursor.getColumnIndex(DBhelper.KEY_GENRE);
                FilmCardFill cur_card = new FilmCardFill(cursor.getInt(idIndex),cursor.getString(titleIndex),cursor.getFloat(voteIndex),cursor.getString(posterIndex), cursor.getString(yearIndex), cursor.getString(genreIndex));
                items.add(cur_card);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }



    public void fillWishlistMovies(List<FilmCardFill> items) {
        DBhelper dBhelper = new DBhelper(this);
        SQLiteDatabase database = dBhelper.getWritableDatabase();
        items.clear();
        Cursor cursor_wishlist = null;
        if(status.equals("wishlist")) {
            cursor_wishlist = database.query(DBhelper.TABLE_WISHLIST, null, null, null, null, null, null);
        }
        else if(status.equals("visible")) {
            cursor_wishlist = database.query(DBhelper.TABLE_VISIBLE, null, null, null, null, null, null);
        }
        Cursor cursor = database.query(DBhelper.TABLE_MOVIES, null, null, null, null, null, null);

        if (cursor_wishlist.moveToFirst()) {

            do {
                int wayIndex = cursor_wishlist.getColumnIndex(DBhelper.KEY_WAY_TO_MOVIE);
                cursor.moveToPosition(cursor_wishlist.getInt(wayIndex) - 1);
                int posterIndex = cursor.getColumnIndex(DBhelper.KEY_POSTER_URL);
                int titleIndex = cursor.getColumnIndex(DBhelper.KEY_TITLE);
                int voteIndex = cursor.getColumnIndex(DBhelper.KEY_VOTE_AVERAGE);
                int idIndex = cursor.getColumnIndex(DBhelper.KEY_ID);
                int yearIndex = cursor.getColumnIndex(DBhelper.KEY_REALIZE_DATE);
                int genreIndex = cursor.getColumnIndex(DBhelper.KEY_GENRE);
                FilmCardFill cur_card = new FilmCardFill(cursor.getInt(idIndex),cursor.getString(titleIndex),cursor.getFloat(voteIndex),cursor.getString(posterIndex), cursor.getString(yearIndex), cursor.getString(genreIndex));
                items.add(cur_card);
            } while (cursor_wishlist.moveToNext());
        }
        cursor.close();
        cursor_wishlist.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        if (status != null && (status.equals("wishlist") || status.equals("visible"))) {
            fillWishlistMovies(items);
            adapter = new DemoAdapter(this, items, null);
            recyclerView.setAdapter(adapter);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter.notifyItemInserted(items.size() - 1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar_main_page, menu);
        MenuItem item = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) item.getActionView();
        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
//        androidx.appcompat.widget.ShareActionProvider shareActionProvider = (androidx.appcompat.widget.ShareActionProvider) MenuItemCompat.getActionProvider(item);
//        shareActionProvider.setShareIntent(shareIntent);
        return true;
    }
}
