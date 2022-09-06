package com.example.rxjavamvvmnew.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavamvvmnew.R;
import com.example.rxjavamvvmnew.databinding.ItemAddressBinding;
import com.example.rxjavamvvmnew.model.ModelAddress;

import java.util.List;

public class AdapterAddress extends RecyclerView.Adapter<AdapterAddress.ViewHolder> {

    List<ModelAddress> list;
    ItemAddressId itemAddressId;

    public AdapterAddress(List<ModelAddress> list, ItemAddressId itemAddressId) {
        this.itemAddressId = itemAddressId;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemAddressBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.item_address, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelAddress modelAddress = list.get(position);
        holder.binding.setData(modelAddress);

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemAddressId.getItem(modelAddress.getId());

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemAddressBinding binding;

        public ViewHolder(ItemAddressBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    public interface ItemAddressId {
        void getItem(String adrsId);
    }


}
