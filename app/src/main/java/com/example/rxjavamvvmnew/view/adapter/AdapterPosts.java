package com.example.rxjavamvvmnew.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavamvvmnew.R;
import com.example.rxjavamvvmnew.databinding.ItemspostBinding;
import com.example.rxjavamvvmnew.model.Model_Posts;

import java.util.List;

public class AdapterPosts extends RecyclerView.Adapter<AdapterPosts.ViewHolder> {

    ItemspostBinding binding;
    List<Model_Posts> list;
    OnClickItem onClickItem;


    public AdapterPosts(List<Model_Posts> list,OnClickItem onClickItem) {
        this.list = list;
        this.onClickItem=onClickItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        binding=DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.itemspost,parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Model_Posts model_posts=list.get(position);

        holder.binding.setData(model_posts);

        holder.binding.carditem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickItem.onClick(model_posts.getId());

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ItemspostBinding binding;
        public ViewHolder(ItemspostBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    public interface OnClickItem
    {
         void onClick(String id);
    }




}
