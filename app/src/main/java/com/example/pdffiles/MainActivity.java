package com.example.pdffiles;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView pdfListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pdfListView = (ListView)findViewById(R.id.myPDFList);

        String [] pdfFiles = { "Assignment1","Assignment2","CD","GIS","lec6","MTS_advt","NSS","Syllabus","EX1","EX2","EX3","EX4"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,pdfFiles){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

               View view =  super.getView(position, convertView, parent);
                TextView myText = (TextView)findViewById(android.R.id.text1);


                return view ;


            }
        };
        pdfListView.setAdapter(adapter);

       pdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String item = pdfListView.getItemAtPosition(position).toString();
               Intent intent = new Intent(getApplicationContext(),PDFOpener.class);
               intent.putExtra("pdfFileName",item);
               startActivity(intent);

           }
       });


    }
}
