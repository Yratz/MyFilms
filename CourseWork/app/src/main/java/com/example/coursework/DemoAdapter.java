package com.example.coursework;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class DemoAdapter extends RecyclerView.Adapter<DemoViewHolder> implements Filterable {


    List<FilmCardFill> items;
    List<FilmCardFill> itemsFull;
    int id;
    String genre = null;
    boolean flag = false;

    public DemoAdapter(Context context, List<FilmCardFill> items, String genre) {
        this.items = items;
        itemsFull = new ArrayList<>(items);
        this.genre = genre;
    }
    public DemoAdapter(Context context, List<FilmCardFill> items, String genre, boolean flag) {
        this.items = items;
        itemsFull = new ArrayList<>(items);
        this.genre = genre;
        this.flag = flag;
    }


    // Вызывает класс конкртной карточки(нужно передать id)
    @NonNull
    @Override
    public DemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (genre == null || flag == true) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_horizontal_card, parent, false);
        }
        return new DemoViewHolder(view, genre, flag).linkAdapter(this);
    }


    // Устанавливать значения для полей карточки
    @Override
    public void onBindViewHolder(@NonNull DemoViewHolder holder, int position) {

        if(genre == null || flag == true) {

            holder.title.setText(items.get(position).title);
    //        holder.vote.setText(items.get(position).vote);
            final int radius = 5;
            final int margin = 5;
            final Transformation transformation = new RoundedCornersTransformation(radius, margin);
            Picasso.get().load(items.get(position).poster).resize(468,693).transform(transformation).into(holder.poster);
            holder.year.setText(items.get(position).year);
            holder.genre.setText(items.get(position).genre);
            holder.ratingBar.setRating((items.get(position).vote)/2);
            holder.ratingBar.setIsIndicator(true);
        }
        else {
            Picasso.get().load(items.get(position).poster).resize(468,693).into(holder.poster);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public Filter getFilter() {
        return neededFilter;
    }

    private Filter neededFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<FilmCardFill> filteredList = new ArrayList<>();

            if ((charSequence == null || charSequence.length() == 0) && (genre == null)) {
                filteredList.addAll(itemsFull);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (FilmCardFill item : itemsFull) {
                    if (item.title.toLowerCase().contains(filterPattern)) {
                        if(genre == null || item.genre.toLowerCase().contains(genre))
                            filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            items.clear();
            items.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };
}


//этот класс касается одной модели
class DemoViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    ImageView poster;
    TextView year;
    TextView genre;
    RatingBar ratingBar;


    private DemoAdapter adapter;

    //онструктор одной карточки
    public DemoViewHolder(@NonNull View itemView, String genre, boolean flag) {
        super(itemView);
        if (genre == null || flag == true) {
            this.title = itemView.findViewById(R.id.title_film_card);
            this.poster = itemView.findViewById(R.id.img_film_card);
            this.year = itemView.findViewById(R.id.year_film_card);
            this.genre = itemView.findViewById(R.id.genre_film_card);
            this.ratingBar = itemView.findViewById(R.id.rating_bar_on_card);
        } else {
            this.poster = itemView.findViewById(R.id.poster_horizontal);
        }



    }


    public DemoViewHolder linkAdapter(DemoAdapter adapter){
        this.adapter = adapter;
        return this;
    }
}

