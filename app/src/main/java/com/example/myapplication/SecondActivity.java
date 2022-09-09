package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lwEmployee;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mapping();

        Intent intent = getIntent();
        ArrayList<Employee> data = (ArrayList<Employee>) intent.getSerializableExtra("data");
        DataAdapter adapter = new DataAdapter(this, data);
        lwEmployee.setAdapter(adapter);
    }

    private void mapping() {
        lwEmployee = findViewById(R.id.employee_list);
    }
}
