package com.example.finalexam;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class CustomAdapter extends BaseAdapter {
    private final Context context;
    private final List<Map<String, String>> data;

    public CustomAdapter(Context context, List<Map<String, String>> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_list_item, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageView);
            holder.nameTextView = convertView.findViewById(R.id.nameTextView);
            holder.ageTextView = convertView.findViewById(R.id.ageTextView);
            holder.jobTextView = convertView.findViewById(R.id.jobTextView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Map<String, String> item = data.get(position);

        // Установка текста
        holder.nameTextView.setText(item.get("name"));
        holder.ageTextView.setText(item.get("age"));
        holder.jobTextView.setText(item.get("job"));

        // Загрузка изображения из assets
        try {
            InputStream inputStream = context.getAssets().open("images/" + item.get("image"));
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            holder.imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView nameTextView;
        TextView ageTextView;
        TextView jobTextView;
    }
}
