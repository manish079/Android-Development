package com.example.sql_lite_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText name,email,phone;
 Mydp_helper helper;
    ArrayList<String> arrayList =  new ArrayList<>();
 ListView listView;
 List<Modalclass> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name =  findViewById(R.id.enter_name);
        listView =findViewById(R.id.listview);
        helper = new Mydp_helper(this);

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              helper.insert(name.getText().toString());

              arrayList.clear();
              getallnode();
            }
        });
        getallnode();

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                helper.updateNote(name.getText().toString(),position);
//                arrayList.clear();
//                getallnode();
//            }
//        });
    }
    public void getallnode()
    {
        list = helper.getallnodes();
        if(list.size() >0)
        {
//            Log.e("xc",list.get(1).getNote());
//            Log.e("count", String.valueOf(helper.getcount()));

            for (Modalclass h :list)
            {
                arrayList.add(h.getNote());
            }

            ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
            listView.setAdapter(arrayAdapter);
        }

    }

}