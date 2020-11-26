package com.company.workpeace.Reciclador;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.company.workpeace.R;

import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter {


    List<FetchData> fetchData;

    public HelperAdapter(List<FetchData> fetchData) {

        this.fetchData = fetchData;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);

        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ViewHolderClass viewHolderClass = (ViewHolderClass)holder;
        final FetchData fetchDataList = fetchData.get(position);
        viewHolderClass.textView.setText(fetchDataList.getName());
        viewHolderClass.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SecondActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("key",fetchDataList);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fetchData.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder{

        TextView textView;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.primerTexto);
        }
    }
}
