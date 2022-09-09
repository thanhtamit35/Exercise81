package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView twFullName, twAddress;
    RadioGroup radioGroup;
    RadioButton rdoButton;
    Button btnAddNew;
    Button btnPrintList;
    private final ArrayList<Employee> employees = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        addListenerOnButtonClick();
    }

    private void addListenerOnButtonClick() {
        btnAddNew.setOnClickListener(view -> {
            String fullName = twFullName.getText().toString();
            String address = twAddress.getText().toString();

            if (fullName.isEmpty() || address.isEmpty()) {
                Toast.makeText(this, "Tên hoặc địa chỉ không được để trống!", Toast.LENGTH_SHORT).show();
                return;
            }

            int selectedId = radioGroup.getCheckedRadioButtonId();
            rdoButton = findViewById(selectedId);

            String gender = rdoButton.getText().toString();
            Employee e = new Employee(fullName, gender, address);
            employees.add(e);

            Toast.makeText(this, "Thêm mới thành công: " + e.getFullName(),
                    Toast.LENGTH_SHORT).show();
        });

        btnPrintList.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
//            intent.putStringArrayListExtra("data", data);
            intent.putExtra("data", employees);
            startActivity(intent);
        });
    }

    private void mapping() {
        btnAddNew = findViewById(R.id.btn_add_new);
        btnPrintList = findViewById(R.id.btn_print_list);
        twFullName = findViewById(R.id.fullname);
        twAddress = findViewById(R.id.address);
        radioGroup = findViewById(R.id.radioGroup);
    }
}