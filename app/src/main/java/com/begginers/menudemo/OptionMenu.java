package com.begginers.menudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OptionMenu extends AppCompatActivity implements View.OnClickListener{
    Button btnAdd,btnDelete;
    EditText etAdd,etDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);

        //Initialize buttons
        btnAdd= (Button) findViewById(R.id.btnAdd);
        btnDelete= (Button) findViewById(R.id.btnDelete);

        //Initialize views
        etAdd= (EditText) findViewById(R.id.etFirst);
        etDelete= (EditText) findViewById(R.id.etSecond);
        //Event Handling
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAdd:
                String resultAdd = etAdd.getText().toString();
                Intent intent = new Intent(this,MainActivity.class);
                intent.putExtra("text",resultAdd);
                startActivity(intent);
                break;
            case R.id.btnDelete:
                String resultDelete = etDelete.getText().toString();
                break;
        }
    }
}
