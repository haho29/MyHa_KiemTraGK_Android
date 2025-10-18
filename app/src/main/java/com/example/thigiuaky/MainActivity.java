package com.example.thigiuaky;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge;
    Button btnSend;
    TextView tvResult;

    ActivityResultLauncher<Intent>getResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == Activity.RESULT_OK) {
            Intent data = result.getData();
            if (data != null) {
                String reply = data.getStringExtra("reply");
                tvResult.setText("MSV: " + reply);
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String ageStr = etAge.getText().toString().trim();
                if (name.isEmpty()) {
                    etName.setError("Nhập tên");
                    return;
            }
                if (ageStr.isEmpty()) {
                    etAge.setError("Nhập tuổi");
                    return;
                }
                Intent age = null;
                try {
                    age = Integer.parseInt(ageStr);
                }
                catch ( )


        });
    }
}