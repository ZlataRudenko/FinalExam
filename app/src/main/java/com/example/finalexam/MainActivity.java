package com.example.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Привязка кнопок
        Button buttonSimpleList1 = findViewById(R.id.button_simple_list1);
        Button buttonSimpleList2 = findViewById(R.id.button_simple_list2);
        Button buttonCustomList = findViewById(R.id.button_custom_list);

        // Установка действий для кнопок
        buttonSimpleList1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SimpleList1Activity.class);
                startActivity(intent);
            }
        });

        buttonSimpleList2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SimpleList2Activity.class);
                startActivity(intent);
            }
        });

        buttonCustomList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomListActivity.class);
                startActivity(intent);
            }
        });
    }
}
