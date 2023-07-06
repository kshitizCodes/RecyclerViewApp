package com.example.recyclerviewapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class ViewHolderAdapter extends RecyclerView.Adapter<ViewHolderAdapter.ViewHolder> {

    private final ArrayList<String> dataList;

    public ViewHolderAdapter(ArrayList<String> data) {
        dataList = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String str = dataList.get(position);
        holder.bind(str);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_text_view);
        }

        public void bind(String text) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement json = JsonParser.parseString(text);
            text = gson.toJson(json);
            textView.setText(text);
        }
    }
}
