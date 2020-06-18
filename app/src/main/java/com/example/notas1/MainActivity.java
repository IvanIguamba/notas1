package com.example.notas1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    static ArrayList<String> notas1 = new ArrayList <>();
    static ArrayAdapter arrayAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView =(ListView) findViewById (R.id.listView);
        notas1.add("Ejemplo");
         arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,notas1);
        listView.setAdapter(arrayAdapter);

        //segunda actividad para cuando hacemos click en una nota
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),editorNotas.class);
                intent.putExtra("nota id ", position );
                startActivity(intent);

            }
        });
    }
}
