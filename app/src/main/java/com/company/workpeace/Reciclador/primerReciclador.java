package com.company.workpeace.Reciclador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.company.workpeace.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class primerReciclador extends AppCompatActivity {

    //TextView main;
    RecyclerView recyclerView;

    List<FetchData> fetchData;
    HelperAdapter helperAdapter;
    DatabaseReference databaseReference;
    Button button;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primer_reciclador);
        //main = findViewById(R.id.primerTexto);

        recyclerView = findViewById(R.id.primerReciclador);
        floatingActionButton = findViewById(R.id.miremos);

        button = findViewById(R.id.holaaaa);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchData = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("ejemplo");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){
                    FetchData fetchDataList = ds.getValue(FetchData.class);
                    fetchData.add(fetchDataList);
                }

                helperAdapter = new HelperAdapter(fetchData);
                recyclerView.setAdapter(helperAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(primerReciclador.this,primerReciclador.class);
                startActivity(intent);
            }
        });



    }
}