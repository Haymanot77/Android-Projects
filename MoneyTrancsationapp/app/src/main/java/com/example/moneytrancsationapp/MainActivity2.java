package com.example.moneytrancsationapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
EditText editTextPhoneNumber,editTextAmount;
Button btnSendMoney;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        editTextPhoneNumber = findViewById(R.id.editTexPhoneNumber);
        editTextAmount = findViewById(R.id.editTextAmout);
        btnSendMoney = findViewById(R.id.btnSendMoney);

        btnSendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = editTextPhoneNumber.getText().toString();
                int amount  =Integer.parseInt(editTextAmount.getText().toString());
                if(phone.equals("0700490514") && amount <= 10000){

                    Toast.makeText(getApplicationContext(), "Successfully sent", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Transaction can not takes place", Toast.LENGTH_SHORT).show();

            }
        });






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}