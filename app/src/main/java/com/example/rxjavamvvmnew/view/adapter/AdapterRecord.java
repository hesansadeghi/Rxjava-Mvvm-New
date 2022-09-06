package com.example.rxjavamvvmnew.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.rxjavamvvmnew.R;
import com.example.rxjavamvvmnew.databinding.ItemsRecordBinding;
import com.example.rxjavamvvmnew.model.ModelDelCart;
import com.example.rxjavamvvmnew.model.ModelMinAdd;
import com.example.rxjavamvvmnew.model.ModelRecord;
import com.example.rxjavamvvmnew.repositry.Api;
import com.example.rxjavamvvmnew.repositry.Repositry;
import com.example.rxjavamvvmnew.view.activity.MainActivity;

import java.util.List;

public class AdapterRecord extends RecyclerView.Adapter<AdapterRecord.ViewHolder> {

    List<ModelRecord> list;
    ItemsRecordBinding binding;
    Context context;
    Activity activity;
    ChangePrice changePrice;

    public AdapterRecord(List<ModelRecord> list, Context context,Activity activity,    ChangePrice changePrice) {
        this.list = list;
        this.context = context;
        this.activity=activity;
        this.changePrice=changePrice;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.items_record,
                parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelRecord modelRecord = list.get(position);

        holder.binding.setData(modelRecord);
        holder.binding.tvTitle.setText(modelRecord.getTitle());
        holder.binding.tvSum.setText(modelRecord.getCount());
        holder.binding.tvPrc.setText(modelRecord.getPrice());

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.basket)
                .error(R.drawable.basket);
        Glide.with(context).load(modelRecord.getImageurl())
                .apply(options).into(binding.ivPost);

        holder.binding.btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addOrRemoveCard("add",String.valueOf(modelRecord.getIduser())
                        ,String.valueOf(modelRecord.getIdproduct()),"1");

            }
        });

        holder.binding.btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addOrRemoveCard("m",String.valueOf(modelRecord.getIduser())
                        ,String.valueOf(modelRecord.getIdproduct()),"1");

            }
        });


        holder.binding.tvDltCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Repositry.INSTANCE.CustomResponse(Api.COMPANIO2.invoke()
                                .DEL_CART_SINGLE(String.valueOf(modelRecord.getId())),
                        new Repositry.Unit() {
                            @Override
                            public void invoke(Object object) {

                                ModelDelCart modelDelCart= (ModelDelCart) object;
                                if (modelDelCart.getStatus().equals("ok"))
                                {
                                    changePrice.change();

//                                    list.remove(position);
//                                    notifyItemRemoved(position);
//                                    notifyItemRangeChanged(position,list.size());
//
//                                    MainActivity mainActivity= (MainActivity) activity;
//                                            mainActivity.getCountCart();

                                }

                            }
                        });

            }
        });



    }

    public void addOrRemoveCard(String check, String userId, String productId,
                                String count) {

        Log.e("TAG","check : "+ check+" userId : "+userId+
                " productId : "+productId+" count : "+count);

        Repositry.INSTANCE.CustomResponse(Api.COMPANIO2.invoke()
                        .ADD_MIN_CARD_SINGLE(check, userId, productId, count),
                new Repositry.Unit() {
                    @Override
                    public void invoke(Object object) {

                        ModelMinAdd modelMinAdd= (ModelMinAdd) object;
                        if (modelMinAdd.getStatus().equals("ok"))
                        {
                            changePrice.change();
                        }



                        Log.e("TAG","  m_add"+object.toString());
                    }
                });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemsRecordBinding binding;

        public ViewHolder(ItemsRecordBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface ChangePrice{

        public void change();

    }


}
