package com.example.rxjavamvvmnew.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rxjavamvvmnew.model.ModelAddress;
import com.example.rxjavamvvmnew.repositry.Api;
import com.example.rxjavamvvmnew.repositry.Repositry;

import java.util.List;

public class ViewModelAddress extends ViewModel {

    public MutableLiveData<List<ModelAddress>> mutableLiveData=new MediatorLiveData<>();

    public void post(String id)
    {
        Repositry.INSTANCE.CustomResponse(Api.COMPANIO2.invoke().MODEL_ADDRESS_SINGLE(id),
                new Repositry.Unit() {
                    @Override
                    public void invoke(Object object) {

                        mutableLiveData.setValue((List<ModelAddress>) object);

                    }
                });
    }


}
