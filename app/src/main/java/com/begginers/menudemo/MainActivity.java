package com.begginers.menudemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> name = new ArrayList<String>();
    String res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing listview
        ListView listView = (ListView) findViewById(R.id.listView);
        name.add("Shahariar");
        name.add("Mostafiz");
        name.add("Sagor");
        name.add("Imaran");
        name.add("Sujon");
        name.add("Razu");
        name.add("Rocky");
        name.add("Man");
        name.add("Old");
        name.add("Boy");

        //getting intent
        Intent i = getIntent();
        res=i.getStringExtra("text");
        name.add(res);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        listView.setAdapter(adapter);
        listView.deferNotifyDataSetChanged();
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Select an action");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String contactName = name.get(info.position);
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Detail's about "+contactName,Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Delete "+contactName,Toast.LENGTH_LONG).show();
                break;
            default:
                return true;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item3:
                startActivity(new Intent(this,OptionMenu.class));
                break;
            case R.id.item4:
                startActivity(new Intent(this,OptionMenu.class));
                break;
            default:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
