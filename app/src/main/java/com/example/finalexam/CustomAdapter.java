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
            holder.textView = convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Установка текста
        holder.textView.setText(data.get(position).get("name"));

        // Загрузка изображения
        try {
            String imageName = data.get(position).get("image"); // Ключ "image" для имени файла
            InputStream inputStream = context.getAssets().open(imageName);
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            holder.imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
            holder.imageView.setImageResource(R.drawable.default_image); // Ресурс по умолчанию
        }

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
