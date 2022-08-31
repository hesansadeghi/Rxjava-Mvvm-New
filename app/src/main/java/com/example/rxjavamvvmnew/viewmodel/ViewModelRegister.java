package com.example.rxjavamvvmnew.viewmodel;

import android.app.Application;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rxjavamvvmnew.model.Status;
import com.example.rxjavamvvmnew.repositry.Api;
import com.example.rxjavamvvmnew.repositry.Repositry;
import com.example.rxjavamvvmnew.repositry.SingleCom;

public class ViewModelRegister extends AndroidViewModel {

    public MutableLiveData<Status> mutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> mutableLiveDataCheckReg = new MutableLiveData<>();
    public String name, mobile, email, pass;
    Application application;


    public ViewModelRegister(@NonNull Application application) {
        super(application);
        this.application=application;

    }

    public void onClickRegister(View view) {
        if (name == null || mobile == null || email == null || pass == null) {

            Toast.makeText(application.getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();

        } else {
            Repositry.INSTANCE.CustomResponse(Api.COMPANIO2.invoke().STATUS_REG_SINGLE(name, mobile, email, pass),
                    new Repositry.Unit() {
                @Override
                public void invoke(Object object) {

                    mutableLiveData.setValue((Status) object);
                }
            });
        }
    }




    @Override
    protected void onCleared() {
        super.onCleared();
        SingleCom.com().clear();
    }

}
