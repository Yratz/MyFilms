package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import jp.wasabeef.picasso.transformations.BlurTransformation;
import jp.wasabeef.picasso.transformations.GrayscaleTransformation;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;
import jp.wasabeef.picasso.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.SepiaFilterTransformation;

public class MovieActivity extends AppCompatActivity {

    Integer idForSave;
    TextView title;
    TextView rate;
    TextView year;
    TextView overview;
    TextView lang;
    TextView genre;
    TextView voteAverage;
    TextView popularity;
    ImageView poster;
    ImageView favorite_button;
    ImageView visibility_button;
    ImageView posterFone;
    RatingBar ratingBar;
    Button button_rate;
    TextView titleRate;
    EditText reviewEditText;
    TextView reviewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Bundle arguments = getIntent().getExtras();
        title = findViewById(R.id.txt_title_fllm);
        rate = findViewById(R.id.txt_rating_film);
        year = findViewById(R.id.txt_year_film);
        overview = findViewById(R.id.txt_overview);
        lang = findViewById(R.id.txt_language);
        genre = findViewById(R.id.txt_genre);
        voteAverage = findViewById(R.id.txt_vote_average);
        popularity = findViewById(R.id.txt_popularity);
        poster = findViewById(R.id.poster_film);
        favorite_button = findViewById(R.id.btn_favorite);
        visibility_button = findViewById(R.id.btn_visibility);
        posterFone = findViewById(R.id.posterFone);
        ratingBar = findViewById(R.id.ratingBar);
        button_rate = findViewById(R.id.btn_rate);
        titleRate = findViewById(R.id.txt_person_stars);
        reviewEditText = findViewById(R.id.txt_review_edit);
        reviewText = findViewById(R.id.txt_review);
        if(arguments!=null) {
            idForSave = arguments.getInt("id");
        }
        fillFromDatabase();
        favorite_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickToWishList();
            }
        });
        visibility_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickToVisible();
            }
        });
        button_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickToRate();
            }
        });
    }
    public void fillFromDatabase() {
        DBhelper dBhelper = new DBhelper(this);
        SQLiteDatabase database = dBhelper.getWritableDatabase();
        Cursor cursor = database.query(DBhelper.TABLE_MOVIES, null, null, null, null, null, null);

        if (cursor.moveToPosition(idForSave)) {
            int posterIndex = cursor.getColumnIndex(DBhelper.KEY_POSTER_URL);
            int titleIndex = cursor.getColumnIndex(DBhelper.KEY_TITLE);
            int rateIndex = cursor.getColumnIndex(DBhelper.KEY_VOTE_AVERAGE);
            int yearIndex = cursor.getColumnIndex(DBhelper.KEY_REALIZE_DATE);
            int genreIndex = cursor.getColumnIndex(DBhelper.KEY_GENRE);
            int overviewIndex = cursor.getColumnIndex(DBhelper.KEY_OVERVIEW);
            int voteCountIndex = cursor.getColumnIndex(DBhelper.KEY_VOTE_COUNT);
            int langIndex = cursor.getColumnIndex(DBhelper.KEY_ORIGINAL_LANGUAGE);
            int popularityIndex = cursor.getColumnIndex(DBhelper.KEY_POPULARITY);
            int wishListIndex = cursor.getColumnIndex(DBhelper.KEY_WISHLIST);
            int visibilityIndex = cursor.getColumnIndex(DBhelper.KEY_VISIBLE);
            int userRateIndex = cursor.getColumnIndex(DBhelper.USER_RATE);
            int userReviewIndex = cursor.getColumnIndex(DBhelper.USER_REVIEW);

            final int radius = 30;
            final int margin = 30;
            final Transformation transformation = new RoundedCornersTransformation(radius, margin);

            Picasso.get().load(cursor.getString(posterIndex)).transform(transformation).into(poster);
            Picasso.get().load(cursor.getString(posterIndex)).transform(new BlurTransformation(this, 25, 3)).transform(new BrightnessFilterTransformation(this,-0.4f)).into(posterFone);
            title.setText(cursor.getString(titleIndex));
            rate.setText(cursor.getString(rateIndex));
            year.setText(cursor.getString(yearIndex));
            genre.setText(cursor.getString(genreIndex));
            overview.setText(cursor.getString(overviewIndex));
            voteAverage.setText(cursor.getString(voteCountIndex));
            lang.setText(cursor.getString(langIndex));
            popularity.setText(cursor.getString(popularityIndex));
            ratingBar.setRating(cursor.getFloat(userRateIndex));
            if(cursor.getFloat(userRateIndex) != -1) {
                button_rate.setText("Change");
                ratingBar.setIsIndicator(true);
                titleRate.setText("Your review");
                reviewText.setVisibility(View.VISIBLE);
                reviewText.setText(cursor.getString(userReviewIndex));
                reviewEditText.setText(reviewText.getText());
                reviewEditText.setVisibility(View.INVISIBLE);
            }
            if (cursor.getInt(wishListIndex) == 0) {
                favorite_button.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_favorite_nonfill_24));
            }
            else {
                favorite_button.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_favorite_24));
            }
            if (cursor.getInt(visibilityIndex) == 0) {
                visibility_button.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_visibility_24));
            }
            else {
                visibility_button.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_visibility_off_24));
            }
        }
        cursor.close();
    }

    public void clickToWishList() {
        DBhelper dBhelper = new DBhelper(this);
        SQLiteDatabase database = dBhelper.getWritableDatabase();
        Cursor cursor = database.query(DBhelper.TABLE_MOVIES, null, null, null, null, null, null);

        Integer newId = idForSave + 1;
        if (cursor.moveToPosition(idForSave)) {
            int wishListIndex = cursor.getColumnIndex(DBhelper.KEY_WISHLIST);
            if (cursor.getInt(wishListIndex) == 0) {
                favorite_button.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_favorite_24));
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBhelper.KEY_WISHLIST, 1);
                database.update(DBhelper.TABLE_MOVIES,contentValues,"_id=" + newId, null);

                ContentValues contentValues1 = new ContentValues();
                contentValues1.put(DBhelper.KEY_WAY_TO_MOVIE, idForSave + 1);
                database.insert(DBhelper.TABLE_WISHLIST,null, contentValues1);
            }
            else {
                favorite_button.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_favorite_nonfill_24));
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBhelper.KEY_WISHLIST, 0);
                database.update(DBhelper.TABLE_MOVIES,contentValues,"_id=" + newId, null);
                database.delete(DBhelper.TABLE_WISHLIST,DBhelper.KEY_WAY_TO_MOVIE + "=" + newId,null);
            }
        }
        cursor.close();
    }

    public void clickToVisible() {
        DBhelper dBhelper = new DBhelper(this);
        SQLiteDatabase database = dBhelper.getWritableDatabase();
        Cursor cursor = database.query(DBhelper.TABLE_MOVIES, null, null, null, null, null, null);

        Integer newId = idForSave + 1;
        if (cursor.moveToPosition(idForSave)) {
            int visibilityIndex = cursor.getColumnIndex(DBhelper.KEY_VISIBLE);
            if (cursor.getInt(visibilityIndex) == 0) {
                visibility_button.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_visibility_off_24));
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBhelper.KEY_VISIBLE, 1);
                database.update(DBhelper.TABLE_MOVIES,contentValues,"_id=" + newId, null);

                ContentValues contentValues1 = new ContentValues();
                contentValues1.put(DBhelper.KEY_WAY_TO_MOVIE, idForSave + 1);
                database.insert(DBhelper.TABLE_VISIBLE,null, contentValues1);
            }
            else {
                visibility_button.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_visibility_24));
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBhelper.KEY_VISIBLE, 0);
                database.update(DBhelper.TABLE_MOVIES,contentValues,"_id=" + newId, null);
                database.delete(DBhelper.TABLE_VISIBLE,DBhelper.KEY_WAY_TO_MOVIE + "=" + newId,null);
            }
        }
        cursor.close();
    }

    public void clickToRate() {
        DBhelper dBhelper = new DBhelper(this);
        SQLiteDatabase database = dBhelper.getWritableDatabase();
        Cursor cursor = database.query(DBhelper.TABLE_MOVIES, null, null, null, null, null, null);
        Integer newId = idForSave + 1;
        if (cursor.moveToPosition(idForSave)) {
            // Если еще не оценено
            if (!ratingBar.isIndicator()) {
                int rateIndex = cursor.getColumnIndex(DBhelper.USER_RATE);
                ContentValues contentValues = new ContentValues();
                contentValues.put(DBhelper.USER_RATE, ratingBar.getRating());
                contentValues.put(DBhelper.USER_REVIEW, String.valueOf(reviewEditText.getText()));
                database.update(DBhelper.TABLE_MOVIES,contentValues,"_id=" + newId, null);
                ratingBar.setIsIndicator(true);
                button_rate.setText("Change");
                titleRate.setText("Your review");
                reviewText.setText(reviewEditText.getText());
                reviewEditText.setText(reviewEditText.getText());
                reviewText.setVisibility(View.VISIBLE);
                reviewEditText.setVisibility(View.INVISIBLE);
            }
            else {
                ratingBar.setIsIndicator(false);
                button_rate.setText("Rate!");
                titleRate.setText("Rate this film");
                reviewText.setVisibility(View.INVISIBLE);
                reviewEditText.setVisibility(View.VISIBLE);
            }
        }
        cursor.close();
    }

}
