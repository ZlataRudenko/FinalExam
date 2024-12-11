package com.example.finalexam;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        // Инициализация данных
        List<Map<String, String>> data = new ArrayList<>();
        String[] names = {"Zlata", "Alex", "Maria", "John"};
        String[] descriptions = {"Android Developer", "Designer", "Teacher", "Engineer"};

        for (int i = 0; i < names.length; i++) {
            Map<String, String> item = new HashMap<>();
            item.put("name", names[i]);
            item.put("description", descriptions[i]);
            data.add(item);
        }

        // Настройка ListView
        ListView listView = findViewById(R.id.custom_List_view);
        CustomAdapter adapter = new CustomAdapter(this, data);
        listView.setAdapter(adapter);
    }
}
