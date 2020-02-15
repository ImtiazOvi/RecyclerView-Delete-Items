package com.example.recylerviewwithfixedcount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    NameModel model = null;
    NameAdapter adapter;
    ArrayList<NameModel> arrayList = new ArrayList<>();
    Button btnAddMoreOne;
    Button getBtnAddMoreTwo;
    Button getBtnAddMoreThree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        btnAddMoreOne = findViewById(R.id.btn_add_one);
        getBtnAddMoreTwo = findViewById(R.id.btn_add_two);
        getBtnAddMoreThree = findViewById(R.id.btn_add_three);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


        model = new NameModel();
        model.setName("Imtiaz");
        arrayList.add(model);
        Log.d("tag", "is1" + arrayList.size());


        if (arrayList.size() == 0) {
            btnAddMoreOne.setVisibility(View.VISIBLE);
            getBtnAddMoreTwo.setVisibility(View.VISIBLE);
            getBtnAddMoreThree.setVisibility(View.VISIBLE);
        }

        btnAddMoreOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model = new NameModel();
                model.setName("Uddin");
                arrayList.add(model);
                Log.d("tag", "is2" + arrayList.size());
                adapter.notifyDataSetChanged();
                btnAddMoreOne.setVisibility(View.GONE);
            }
        });

        getBtnAddMoreTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model = new NameModel();
                model.setName("Ovi");
                arrayList.add(model);

                Log.d("tag", "is2" + arrayList.size());
                adapter.notifyDataSetChanged();
                getBtnAddMoreTwo.setVisibility(View.GONE);
            }
        });

        adapter = new NameAdapter(MainActivity.this, arrayList);
        recyclerView.setAdapter(adapter);


    }
}
