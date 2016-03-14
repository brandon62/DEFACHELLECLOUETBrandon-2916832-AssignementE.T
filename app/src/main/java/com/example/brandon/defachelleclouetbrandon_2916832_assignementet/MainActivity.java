package com.example.brandon.defachelleclouetbrandon_2916832_assignementet;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private Button bt;
    private EditText et;
    private ListView listview;
    private ArrayAdapter adapter;
    private boolean HasBeenClickedByOther = true;

    private ArrayList<String> listTasksNames = new ArrayList<String>();
    private ArrayList<Boolean> listChecked = new ArrayList<Boolean>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button)findViewById(R.id.bt_add);
        et = (EditText) findViewById(R.id.tx_add);


        listview = (ListView) findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked, listTasksNames);
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
            {
                if (!HasBeenClickedByOther)
                {
                    final String Name = listview.getAdapter().getItem(arg2).toString();
                    CheckedTextView textview = (CheckedTextView) arg1;
                    textview.setChecked(!textview.isChecked());
                }
                HasBeenClickedByOther=false;
            }});


        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           final int arg2, long arg3) {
                listTasksNames.remove(arg2);
                adapter.notifyDataSetChanged();
                HasBeenClickedByOther = true;
                return true;
            }
        });
        bt.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v)
    {
        if(v.getId() == bt.getId())
        {
            String newTaskName = (et.getText().toString()).trim();
            if(!newTaskName.equals("")) {
                listTasksNames.add(newTaskName);
                adapter.notifyDataSetChanged();
            }
            et.setText("");
        }
    }
}

