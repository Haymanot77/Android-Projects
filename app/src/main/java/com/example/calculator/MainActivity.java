package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txtnum1,txtnum2,txtsum;
    Button btnAdd,btnSubstract,btnMultiply,btnDivide;
    Integer x,y,tsum,multiply,substract;
    Double xdiv,ydiv,divide;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        txtnum1 = findViewById(R.id.txtNum1);
        txtnum2 = findViewById(R.id.txtNum2);
        txtsum = findViewById(R.id.txtSum);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubstract = findViewById(R.id.btnSubstract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        txtResult = findViewById(R.id.textResult);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){
                x  = Integer.parseInt(txtnum1.getText().toString());
                y  = Integer.parseInt(txtnum2.getText().toString());
                tsum = x+y;
                txtsum.setText(tsum.toString());
                txtResult.setText("Sum");
                Toast.makeText(getApplicationContext(),"Congratulations on your first program",Toast.LENGTH_LONG).show();
            }

        });
       btnMultiply.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){
                x  = Integer.parseInt(txtnum1.getText().toString());
                y  = Integer.parseInt(txtnum2.getText().toString());
                multiply = x*y;
                txtsum.setText(multiply.toString());
                txtResult.setText("Multiplication");

            }

        });

       btnSubstract.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){
                x  = Integer.parseInt(txtnum1.getText().toString());
                y  = Integer.parseInt(txtnum2.getText().toString());
               substract = x-y;
                txtsum.setText(substract.toString());
                txtResult.setText("Substraction");

            }

        });


        btnDivide.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){
                xdiv  = Double.parseDouble(txtnum1.getText().toString());
                ydiv  = Double.parseDouble(txtnum2.getText().toString());
                divide =  (xdiv/ydiv);
                txtsum.setText(divide.toString());
                txtResult.setText("Division");

            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}