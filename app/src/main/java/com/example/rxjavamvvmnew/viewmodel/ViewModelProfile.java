package com.example.rxjavamvvmnew.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rxjavamvvmnew.model.ModelOrder;
import com.example.rxjavamvvmnew.model.ModelProfile;
import com.example.rxjavamvvmnew.repositry.Api;
import com.example.rxjavamvvmnew.repositry.Repositry;
import com.example.rxjavamvvmnew.repositry.SingleCom;

import java.util.List;

public class ViewModelProfile extends ViewModel {

    public MutableLiveData<List<ModelProfile>> mutableLiveData=new MutableLiveData<>();
    public MutableLiveData<List<ModelOrder>> mutableLiveDataOrders=new MutableLiveData<>();

    public void post(String id)
    {
        Repositry.INSTANCE.CustomResponse(Api.COMPANIO2.invoke().MODEL_PROFILE_SINGLE(id),
                new Repositry.Unit() {
            @Override
            public void invoke(Object object) {

                mutableLiveData.setValue((List<ModelProfile>) object);

            }
        });
        Repositry.INSTANCE.CustomResponse(Api.COMPANIO2.invoke().MODEL_ORDERS_SINGLE(id),
                new Repositry.Unit() {
                    @Override
                    public void invoke(Object object) {

                        mutableLiveDataOrders.setValue((List<ModelOrder>) object);

                    }
                });
    }



    @Override
    protected void onCleared() {
        super.onCleared();
        SingleCom.com().clear();
    }
}
