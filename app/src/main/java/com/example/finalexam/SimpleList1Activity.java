package com.example.finalexam;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SimpleList1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list1);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new SimpleListFragment())
                    .commit();
        }
    }
}
