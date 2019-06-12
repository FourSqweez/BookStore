package com.example.bookstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.bookstore.adapter.adt_rv_cardview;

public class MainActivity extends AppCompatActivity {
    private  static final String URL_DATA = "http://www.json-generator.com/api/json/get/cenyGIkzhe?indent=2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.recyclerview);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(lm);
        RecyclerView.Adapter adt = new adt_rv_cardview();
        rv.setAdapter(adt);

    }
}
