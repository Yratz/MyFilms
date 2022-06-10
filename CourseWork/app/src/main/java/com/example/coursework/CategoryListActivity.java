package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class CategoryListActivity extends AppCompatActivity {



    TextView more1;
    TextView more2;
    TextView more3;
    TextView more4;
    TextView more5;
    TextView more6;
    TextView more7;
    TextView more8;
    TextView more9;
    TextView more10;
    TextView more11;
    TextView more12;
    TextView more13;
    TextView more14;
    TextView more15;
    TextView more16;
    TextView more17;
    TextView more18;
    TextView more19;
    TextView more20;

    DemoAdapter adapter1;
    DemoAdapter adapter2;
    DemoAdapter adapter3;
    DemoAdapter adapter4;
    DemoAdapter adapter5;
    DemoAdapter adapter6;
    DemoAdapter adapter7;
    DemoAdapter adapter8;
    DemoAdapter adapter9;
    DemoAdapter adapter10;
    DemoAdapter adapter11;
    DemoAdapter adapter12;
    DemoAdapter adapter13;
    DemoAdapter adapter14;
    DemoAdapter adapter15;
    DemoAdapter adapter16;
    DemoAdapter adapter17;
    DemoAdapter adapter18;
    DemoAdapter adapter19;

    String status;
    List<FilmCardFill> items = new LinkedList<>();

    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    RecyclerView recyclerView4;
    RecyclerView recyclerView5;
    RecyclerView recyclerView6;
    RecyclerView recyclerView7;
    RecyclerView recyclerView8;
    RecyclerView recyclerView9;
    RecyclerView recyclerView10;
    RecyclerView recyclerView11;
    RecyclerView recyclerView12;
    RecyclerView recyclerView13;
    RecyclerView recyclerView14;
    RecyclerView recyclerView15;
    RecyclerView recyclerView16;
    RecyclerView recyclerView17;
    RecyclerView recyclerView18;
    RecyclerView recyclerView19;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        fillItems(items);
//        Toast.makeText(getApplicationContext(), "onCreate()", Toast.LENGTH_SHORT).show();

        // First recycle
        {
            List<FilmCardFill> items_1 = new LinkedList<>();
            for (int i = 0; i < 100; ++i)
                items_1.add(items.get(i));
            recyclerView1 = findViewById(R.id.recycle_view_1);
            recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView1.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView1, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", items_1.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter1 = new DemoAdapter(this, items_1, "action");
            recyclerView1.setAdapter(adapter1);
            adapter1.notifyItemInserted(items_1.size() - 1);
            adapter1.getFilter().filter("");
            more1 = findViewById(R.id.txt_more_1);
            more1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "action");
                    startActivity(intent);
                }
            });
        }

        // 2 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 100; i++)
                first_items.add(items.get(i));
            recyclerView2 = findViewById(R.id.recycle_view_2);
            recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView2.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView2, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter2 = new DemoAdapter(this, first_items, "animation");
            recyclerView2.setAdapter(adapter2);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter2.notifyItemInserted(first_items.size() - 1);
            adapter2.getFilter().filter("");
            more2 = findViewById(R.id.txt_more_2);
            more2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "animation");
                    startActivity(intent);
                }
            });
        }
        // 3 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 100; i++)
                first_items.add(items.get(i+200));
            recyclerView3 = findViewById(R.id.recycle_view_3);
            recyclerView3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView3.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView3, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter3 = new DemoAdapter(this, first_items, "adventure");
            recyclerView3.setAdapter(adapter3);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter3.notifyItemInserted(first_items.size() - 1);
            adapter3.getFilter().filter("");
            more3 = findViewById(R.id.txt_more_3);
            more3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "adventure");
                    startActivity(intent);
                }
            });
        }
        // 4 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 100; i++)
                first_items.add(items.get(i+300));
            recyclerView4 = findViewById(R.id.recycle_view_4);
            recyclerView4.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView4.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView4, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter4 = new DemoAdapter(this, first_items, "crime");
            recyclerView4.setAdapter(adapter4);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter4.notifyItemInserted(first_items.size() - 1);
            adapter4.getFilter().filter("");
            more4 = findViewById(R.id.txt_more_4);
            more4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "crime");
                    startActivity(intent);
                }
            });
        }
        // 5 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 100; i++)
                first_items.add(items.get(i+400));
            recyclerView5 = findViewById(R.id.recycle_view_5);
            recyclerView5.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView5.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView5, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter5 = new DemoAdapter(this, first_items, "mystery");
            recyclerView5.setAdapter(adapter5);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter5.notifyItemInserted(first_items.size() - 1);
            adapter5.getFilter().filter("");
            more5 = findViewById(R.id.txt_more_5);
            more5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "mystery");
                    startActivity(intent);
                }
            });
        }
        // 6 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 100; i++)
                first_items.add(items.get(i+500));
            recyclerView6 = findViewById(R.id.recycle_view_6);
            recyclerView6.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView6.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView6, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter6 = new DemoAdapter(this, first_items, "thriller");
            recyclerView6.setAdapter(adapter6);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter6.notifyItemInserted(first_items.size() - 1);
            adapter6.getFilter().filter("");
            more6 = findViewById(R.id.txt_more_6);
            more6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "thriller");
                    startActivity(intent);
                }
            });
        }
        // 7 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 100; i++)
                first_items.add(items.get(i+600));
            recyclerView7 = findViewById(R.id.recycle_view_7);
            recyclerView7.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView7.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView7, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter7 = new DemoAdapter(this, first_items, "science fiction");
            recyclerView7.setAdapter(adapter7);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter7.notifyItemInserted(first_items.size() - 1);
            adapter7.getFilter().filter("");
            more7 = findViewById(R.id.txt_more_7);
            more7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "science fiction");
                    startActivity(intent);
                }
            });
        }
        // 8 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 100; i++)
                first_items.add(items.get(i+700));
            recyclerView8 = findViewById(R.id.recycle_view_8);
            recyclerView8.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView8.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView8, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter8 = new DemoAdapter(this, first_items, "comedy");
            recyclerView8.setAdapter(adapter8);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter8.notifyItemInserted(first_items.size() - 1);
            adapter8.getFilter().filter("");
            more8 = findViewById(R.id.txt_more_8);
            more8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "comedy");
                    startActivity(intent);
                }
            });
        }
        // 9 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 100; i++)
                first_items.add(items.get(i+800));
            recyclerView9 = findViewById(R.id.recycle_view_9);
            recyclerView9.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView9.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView9, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter9 = new DemoAdapter(this, first_items, "family");
            recyclerView9.setAdapter(adapter9);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter9.notifyItemInserted(first_items.size() - 1);
            adapter9.getFilter().filter("");
            more9 = findViewById(R.id.txt_more_9);
            more9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "family");
                    startActivity(intent);
                }
            });
        }
        // 10 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 100; i++)
                first_items.add(items.get(i+900));
            recyclerView10 = findViewById(R.id.recycle_view_10);
            recyclerView10.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView10.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView10, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter10 = new DemoAdapter(this, first_items, "fantasy");
            recyclerView10.setAdapter(adapter10);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter10.notifyItemInserted(first_items.size() - 1);
            adapter10.getFilter().filter("");
            more10 = findViewById(R.id.txt_more_10);
            more10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "fantasy");
                    startActivity(intent);
                }
            });
        }
        // 11 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 300; i++)
                first_items.add(items.get(i+1000));
            recyclerView11 = findViewById(R.id.recycle_view_11);
            recyclerView11.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView11.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView11, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter11 = new DemoAdapter(this, first_items, "documentary");
            recyclerView11.setAdapter(adapter11);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter11.notifyItemInserted(first_items.size() - 1);
            adapter11.getFilter().filter("");
            more11 = findViewById(R.id.txt_more_11);
            more11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "documentary");
                    startActivity(intent);
                }
            });
        }
        // 12 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 100; i++)
                first_items.add(items.get(i+1100));
            recyclerView12 = findViewById(R.id.recycle_view_12);
            recyclerView12.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView12.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView12, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter12 = new DemoAdapter(this, first_items, "war");
            recyclerView12.setAdapter(adapter12);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter12.notifyItemInserted(first_items.size() - 1);
            adapter12.getFilter().filter("");
            more12 = findViewById(R.id.txt_more_12);
            more12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "war");
                    startActivity(intent);
                }
            });
        }
        // 13 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 100; i++)
                first_items.add(items.get(i+1200));
            recyclerView13 = findViewById(R.id.recycle_view_13);
            recyclerView13.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView13.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView13, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter13 = new DemoAdapter(this, first_items, "horror");
            recyclerView13.setAdapter(adapter13);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter13.notifyItemInserted(first_items.size() - 1);
            adapter13.getFilter().filter("");
            more13 = findViewById(R.id.txt_more_13);
            more13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "horror");
                    startActivity(intent);
                }
            });
        }
        // 14 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 100; i++)
                first_items.add(items.get(i+1300));
            recyclerView14 = findViewById(R.id.recycle_view_14);
            recyclerView14.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView14.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView14, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter14 = new DemoAdapter(this, first_items, "drama");
            recyclerView14.setAdapter(adapter14);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter14.notifyItemInserted(first_items.size() - 1);
            adapter14.getFilter().filter("");
            more14 = findViewById(R.id.txt_more_14);
            more14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "drama");
                    startActivity(intent);
                }
            });
        }
        // 15 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 100; i++)
                first_items.add(items.get(i+1400));
            recyclerView15 = findViewById(R.id.recycle_view_15);
            recyclerView15.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView15.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView15, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter15 = new DemoAdapter(this, first_items, "music");
            recyclerView15.setAdapter(adapter15);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter15.notifyItemInserted(first_items.size() - 1);
            adapter15.getFilter().filter("");
            more15 = findViewById(R.id.txt_more_15);
            more15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "music");
                    startActivity(intent);
                }
            });
        }
        // 16 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 100; i++)
                first_items.add(items.get(i+1600));
            recyclerView16 = findViewById(R.id.recycle_view_16);
            recyclerView16.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView16.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView16, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter16 = new DemoAdapter(this, first_items, "romance");
            recyclerView16.setAdapter(adapter16);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter16.notifyItemInserted(first_items.size() - 1);
            adapter16.getFilter().filter("");
            more16 = findViewById(R.id.txt_more_16);
            more16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "romance");
                    startActivity(intent);
                }
            });
        }
        // 17 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 200; i++)
                first_items.add(items.get(i+1700));
            recyclerView17 = findViewById(R.id.recycle_view_17);
            recyclerView17.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView17.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView17, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter17 = new DemoAdapter(this, first_items, "western");
            recyclerView17.setAdapter(adapter17);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter17.notifyItemInserted(first_items.size() - 1);
            adapter17.getFilter().filter("");
            more17 = findViewById(R.id.txt_more_17);
            more17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "western");
                    startActivity(intent);
                }
            });
        }
        // 18 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 200; i++)
                first_items.add(items.get(i+1800));
            recyclerView18 = findViewById(R.id.recycle_view_18);
            recyclerView18.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView18.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView18, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter18 = new DemoAdapter(this, first_items, "history");
            recyclerView18.setAdapter(adapter18);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter18.notifyItemInserted(first_items.size() - 1);
            adapter18.getFilter().filter("");
            more18 = findViewById(R.id.txt_more_18);
            more18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "history");
                    startActivity(intent);
                }
            });
        }
        // 19 recycle
        {
            List<FilmCardFill> first_items = new LinkedList<>();
            for (int i = 0; i < 200; i++)
                first_items.add(items.get(i+1800));
            recyclerView19 = findViewById(R.id.recycle_view_19);
            recyclerView19.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            recyclerView19.addOnItemTouchListener(
                    new RecyclerItemClickListener(this, recyclerView19, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Intent intent = new Intent(CategoryListActivity.this, MovieActivity.class);

                            intent.putExtra("id", first_items.get(position).id - 1);
                            startActivity(intent);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    })
            );
            adapter19 = new DemoAdapter(this, first_items, "tv movie");
            recyclerView19.setAdapter(adapter19);
            // Вставляет новый элемент в конец ресайклера
            // Значит сюда надо установить цикл передачи id от 1 до i
            adapter19.notifyItemInserted(first_items.size() - 1);
            adapter19.getFilter().filter("");
            more19 = findViewById(R.id.txt_more_19);
            more19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    intent.putExtra("list", "tv movie");
                    startActivity(intent);
                }
            });
        }
        // 20 recycle
        {
            more20 = findViewById(R.id.txt_more_20);
            more20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(CategoryListActivity.this, ListActivity.class);
                    startActivity(intent);
                }
            });
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



    @Override
    protected void onResume() {
        super.onResume();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_bar_main_page, menu);
//        MenuItem item = menu.findItem(R.id.action_search);
////        SearchView searchView = (SearchView) item.getActionView();
//        androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) item.getActionView();
//
//        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                adapter.getFilter().filter(s);
//                return false;
//            }
//        });
////        androidx.appcompat.widget.ShareActionProvider shareActionProvider = (androidx.appcompat.widget.ShareActionProvider) MenuItemCompat.getActionProvider(item);
////        shareActionProvider.setShareIntent(shareIntent);
//        return true;
//    }
}