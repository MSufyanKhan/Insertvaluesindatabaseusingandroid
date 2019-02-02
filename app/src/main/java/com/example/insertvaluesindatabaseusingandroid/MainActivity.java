package com.example.insertvaluesindatabaseusingandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText editname,editsurname,editmarks;

    Button addButton;

    Button viewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DatabaseHelper(this);


        editname = findViewById(R.id.editname);
        editsurname = findViewById(R.id.editsurname);
        editmarks = findViewById(R.id.editmarks);
        addButton = findViewById(R.id.addButton);

        addData();

    }
    public void addData() {
        addButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = mydb.insertdata(editname.getText().toString(),
                                editsurname.getText().toString(), editmarks.getText().toString());
                        if (isInserted = true)
                            Toast.makeText(MainActivity.this, "Data is Inserted ", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data is not Inserted ", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
}
