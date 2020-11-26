package com.company.workpeace.Reciclador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.company.workpeace.R;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    HelperAdapter2 helperAdapter2;
    RecyclerView recyclerViewSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerViewSecond = findViewById(R.id.segundoReciclador);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        FetchData fetchData = (FetchData)bundle.getSerializable("key");
        recyclerViewSecond.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(fetchData.getAge());
        arrayList.add(fetchData.getAddress());
        arrayList.add(fetchData.getName());
        arrayList.add(fetchData.getSkills());
        arrayList.add(fetchData.getLang());
        helperAdapter2 = new HelperAdapter2(arrayList);
        recyclerViewSecond.setAdapter(helperAdapter2);

    }
}