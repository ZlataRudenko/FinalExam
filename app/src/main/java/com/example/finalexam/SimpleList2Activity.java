package com.example.finalexam;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleList2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list2);

        ListView listView = findViewById(R.id.listView);

        List<Map<String, String>> data = new ArrayList<>();
        String[] names = {"Zlata", "Alex", "Maria", "John"};
        String[] descriptions = {"Android Developer", "Designer", "Teacher", "Engineer"};

        for (int i = 0; i < names.length; i++) {
            Map<String, String> item = new HashMap<>();
            item.put("name", names[i]);
            item.put("description", descriptions[i]);
            data.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                android.R.layout.simple_list_item_2,
                new String[]{"name", "description"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );

        listView.setAdapter(adapter);
    }
}

