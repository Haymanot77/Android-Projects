package com.example.bmi;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bmi.BMI1;
import com.example.bmi.R;

public class MainActivity extends AppCompatActivity {
    EditText editWeight,editHeight;
    TextView editBmi,editStatus;
    Button btnStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editWeight =findViewById(R.id.editTextTextWeight);
        editHeight = findViewById(R.id.editTextTextHeight);
        editBmi  = findViewById(R.id.txtBmi);
        editStatus = findViewById(R.id.txtStatus);
        btnStatus=findViewById(R.id.btnStatus) ;

        StringBuffer summary = new StringBuffer();
        summary.append()




        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String weight = editWeight.getText().toString();
                String height = editHeight.getText().toString();
                BMI1 b=new BMI1();
                b.weight = Double.parseDouble(editWeight.getText().toString());
                b.height = Double.parseDouble(height);
                Double finalBMI = b.calculateBMI(b.weight,b.height);

                editBmi.setText(finalBMI.toString());
                editStatus.setText(healthStatus(finalBMI).toString());
            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public String healthStatus(double bmi) {
        String health ="";
        
        if (bmi < 18.5) {
            health = "Underweight";
        }
        if (bmi > 18.5 && bmi < 27.0)
            health = "Healthy";
        if (bmi > 27) {
            health = "Overweight";
        }
        return health;



    }


}