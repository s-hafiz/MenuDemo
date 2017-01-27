package com.begginers.menudemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    ListView listView;
    ArrayAdapter<String> adapter;
    String res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing listview
        listView=(ListView)findViewById(R.id.listViewN);

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


        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
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
                startActivityForResult(new Intent(MainActivity.this,OptionMenu.class),1);
                break;
            case R.id.item4:
                startActivityForResult(new Intent(MainActivity.this,DeleteName.class),2);
                break;
            default:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                //work for add
                res=data.getStringExtra("text");
                name.add(res);
                adapter.notifyDataSetChanged();
                Log.d("taj","worked");
                break;
            case 2:
                //work for delete
                res=data.getStringExtra("delete_name");
                int v = name.indexOf(res);
                name.remove(v);
                adapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
    }
}
