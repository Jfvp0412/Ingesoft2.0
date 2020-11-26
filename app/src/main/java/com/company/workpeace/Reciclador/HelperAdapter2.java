package com.company.workpeace.Reciclador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.company.workpeace.R;

import java.util.List;

public class HelperAdapter2 extends RecyclerView.Adapter {

    List<String> fetchData;

    public HelperAdapter2(List<String> fetchData) {
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolderClass viewHolderClass = (ViewHolderClass) holder;
        final String  fetchDataList = fetchData.get(position);

        viewHolderClass.textView.setText(fetchDataList);

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
