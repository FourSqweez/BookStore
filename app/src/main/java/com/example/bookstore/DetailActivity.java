package com.example.bookstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookstore.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent it = this.getIntent();
        int CurrentCover = it.getExtras().getInt("selectedCover");
        String CurrentTitle = it.getExtras().getString("selectedTitle");
        String CurrentDescription = (String) it.getExtras().get("selectedDescription");

        ImageView imgCurrentCover = findViewById(R.id.imgCurrentCover);
        imgCurrentCover.setImageResource(CurrentCover);
        TextView tvCurrentTitle = findViewById(R.id.tvCurrentTitle);
        tvCurrentTitle.setText(CurrentTitle);
        TextView tvCurrentDescription = findViewById(R.id.tvCurrentDescription);
        tvCurrentDescription.setText(CurrentDescription);
    }
}
