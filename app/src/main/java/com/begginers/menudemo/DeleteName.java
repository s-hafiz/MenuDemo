package com.begginers.menudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteName extends AppCompatActivity implements View.OnClickListener{
    Button btnDelete;
    EditText etDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_name);

        btnDelete= (Button) findViewById(R.id.btnDelete);
        etDelete= (EditText) findViewById(R.id.etSecond);

        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnDelete:
                String resultDelete = etDelete.getText().toString();
                Intent intent2= getIntent();
                intent2.putExtra("delete_name",resultDelete);
                setResult(RESULT_OK,intent2);
                finish();
                break;
        }

    }
}
