package com.begginers.menudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OptionMenu extends AppCompatActivity implements View.OnClickListener{
    Button btnAdd;
    EditText etAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);

        //Initialize buttons
        btnAdd= (Button) findViewById(R.id.btnAdd);

        //Initialize views
        etAdd= (EditText) findViewById(R.id.etFirst);
        //Event Handling
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAdd:
                String resultAdd = etAdd.getText().toString();
                Intent intent = getIntent();
                intent.putExtra("text",resultAdd);
                this.setResult(RESULT_OK,intent);
                finish();
                break;
        }
    }
}
