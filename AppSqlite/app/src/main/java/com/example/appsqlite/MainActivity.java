package com.example.appsqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText name,contact,dob;
Button insert,update,delete,view;
DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        name =findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        dob = findViewById(R.id.dob);

        insert =findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);

        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTxt = name.getText().toString();
                String contactTxt = contact.getText().toString();
                String dobTxt = dob.getText().toString();

                Boolean checkInsertData =DB.insertuserdata(nameTxt,contactTxt,dobTxt);
                if(checkInsertData == true){
                    Toast.makeText(MainActivity.this,"New Entry Inserted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"New Entry not  Inserted",Toast.LENGTH_SHORT).show();

                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTxt = name.getText().toString();
                String contactTxt = contact.getText().toString();
                String dobTxt = dob.getText().toString();

                Boolean checkupdateData =DB.updateuserdata(nameTxt,contactTxt,dobTxt);
                if(checkupdateData == true){
                    Toast.makeText(MainActivity.this,"Entry Updated",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"New Entry not  Updated",Toast.LENGTH_SHORT).show();

                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTxt = name.getText().toString();

                Boolean checkDeleteData =DB.deleteuserdata(nameTxt);
                if(checkDeleteData == true){
                    Toast.makeText(MainActivity.this,"Entry deleted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Entry not Deleted",Toast.LENGTH_SHORT).show();

                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this,"No Entry Exist",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :" + res.getString(0)+"\n");
                    buffer.append("Contact :" + res.getString(1)+"\n");
                    buffer.append("Date of Birth :" + res.getString(2)+"\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();


            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}