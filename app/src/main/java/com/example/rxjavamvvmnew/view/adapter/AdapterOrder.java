package com.example.rxjavamvvmnew.view.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavamvvmnew.R;
import com.example.rxjavamvvmnew.databinding.ItemsListOrderBinding;
import com.example.rxjavamvvmnew.model.ModelOrder;

import java.util.List;

public class AdapterOrder extends RecyclerView.Adapter<AdapterOrder.ViewHolder> {

    List<ModelOrder> modelOrderList;
    ItemsListOrderBinding binding;

    public AdapterOrder(List<ModelOrder> modelOrderList ) {
        this.modelOrderList = modelOrderList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        binding=DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.items_list_order,parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelOrder modelOrder=modelOrderList.get(position);

        if (modelOrder.getStatus()==0)
        {
            holder.binding.tvStatus.setText("پرداخت ناموفق");
            holder.binding.tvStatus.setBackgroundColor(Color.RED);
        }else
        {
            holder.binding.tvStatus.setText("پرداخت موفق");
            holder.binding.tvStatus.setBackgroundColor(Color.GREEN);
        }
        holder.binding.setData(modelOrder);

    }

    @Override
    public int getItemCount() {
        return modelOrderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ItemsListOrderBinding binding;
        public ViewHolder(ItemsListOrderBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }


}
