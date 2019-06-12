package com.example.bookstore.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookstore.DetailActivity;
import com.example.bookstore.R;
import com.example.bookstore.model.Product;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class adt_rv_cardview extends RecyclerView.Adapter<adt_rv_cardview.ViewHolder> {
    private List<Product> lst;
    private Context ctx;


    public adt_rv_cardview() {
        lst = new ArrayList<Product>();

        Product p = new Product();
        p.setTitle("ลูฟี่");
        p.setDescription("ราชาโจรสลัด");
        p.setCover(R.mipmap.a);
        lst.add(p);

        p = new Product();
        p.setTitle("โซโล");
        p.setDescription("นักดาบที่เก่งที่สุดในโลก");
        p.setCover(R.mipmap.b);
        lst.add(p);

        p = new Product();
        p.setTitle("ซันจิ");
        p.setDescription("เชฟที่เก่งที่สุดในโลก");
        p.setCover(R.mipmap.c);
        lst.add(p);

        p = new Product();
        p.setTitle("ช็อปเปอร์");
        p.setDescription("หมอที่เก่งที่สุดในโลก");
        p.setCover(R.mipmap.e);
        lst.add(p);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_card, parent, false);
        ctx = parent.getContext();
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvProduct;
        private ImageView imgCover;
        private TextView tvTitle;
        private TextView tvDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            cvProduct = itemView.findViewById(R.id.cvProduct);
            imgCover = itemView.findViewById(R.id.imgCover);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }


    @Override
    public void onBindViewHolder(adt_rv_cardview.ViewHolder holder, final int position) {
        Product p = lst.get(position);
        holder.imgCover.setImageResource(p.getCover());
        holder.tvTitle.setText(p.getTitle());
        holder.tvDescription.setText(p.getDescription());


        holder.cvProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedTitle = lst.get(position).getTitle();
                String selectedDescription = lst.get(position).getDescription();
                int selectedCover = lst.get(position).getCover();
                DetailActivityWithData(selectedTitle, selectedDescription, selectedCover);
            }

        });
    }

    private void DetailActivityWithData(String strTitle, String strDescription, int imgCover) {
        Intent it = new Intent(ctx, DetailActivity.class);
        it.putExtra("selectedCover", imgCover);
        it.putExtra("selectedTitle", strTitle);
        it.putExtra("selectedDescription", strDescription);
        ctx.startActivity(it);
    }

    @Override
    public int getItemCount() {
        return lst.size();
    }
}
