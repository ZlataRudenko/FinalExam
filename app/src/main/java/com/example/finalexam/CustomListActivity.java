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

        List<Map<String, String>> data = new ArrayList<>();
        data.add(createItem("홍길동1", "20 세", "대학생", "lee1.jpg"));
        data.add(createItem("김정", "56 세", "의사", "name2.jpg"));
        data.add(createItem("구승모", "52 세", "교사", "lee2.jpg"));
        data.add(createItem("오동우", "42 세", "회사원", "name5.jpg"));
        data.add(createItem("한민국", "60 세", "자영업", "name6.jpg"));

        ListView listView = findViewById(R.id.custom_List_view);
        CustomAdapter adapter = new CustomAdapter(this, data);
        listView.setAdapter(adapter);
    }

    private Map<String, String> createItem(String name, String age, String job, String image) {
        Map<String, String> item = new HashMap<>();
        item.put("name", name);
        item.put("age", age);
        item.put("job", job);
        item.put("image", image);
        return item;
    }
}
