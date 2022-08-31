package com.example.rxjavamvvmnew.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rxjavamvvmnew.model.Model_Posts;
import com.example.rxjavamvvmnew.repositry.Api;
import com.example.rxjavamvvmnew.repositry.Repositry;
import com.example.rxjavamvvmnew.repositry.SingleCom;

import java.util.List;

public class ViewModelPost extends ViewModel {


    public MutableLiveData<List<Model_Posts>> mutableLiveData=new MutableLiveData<>();
    public void posts()
    {
        Repositry.INSTANCE.CustomResponse(Api.COMPANIO2.invoke().LIST_SINGLE(), new Repositry.Unit() {
            @Override
            public void invoke(Object object) {

                mutableLiveData.setValue((List<Model_Posts>) object);

            }
        });


    }


    @Override
    protected void onCleared() {
        super.onCleared();
        SingleCom.com().clear();
    }
}
