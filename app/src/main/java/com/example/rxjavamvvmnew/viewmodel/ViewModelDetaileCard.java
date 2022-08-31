package com.example.rxjavamvvmnew.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rxjavamvvmnew.model.ModelDetails;
import com.example.rxjavamvvmnew.model.Model_Posts;
import com.example.rxjavamvvmnew.repositry.Api;
import com.example.rxjavamvvmnew.repositry.Repositry;
import com.example.rxjavamvvmnew.repositry.SingleCom;

import java.util.List;

public class ViewModelDetaileCard extends ViewModel {

    public MutableLiveData<ModelDetails> mutableLiveData=new MutableLiveData<>();

    public void post(String id)
    {
        Log.e("TAG","viewmodel  id "+id);
        Repositry.INSTANCE.CustomResponse(Api.COMPANIO2.invoke().MODEL_DETAILS_SINGLE(id), new Repositry.Unit() {
            @Override
            public void invoke(Object object) {


                Log.e("TAG","viewmodel ModelDetails "+((ModelDetails) object).toString());
                Log.e("TAG","viewmodel object "+object.toString());
                mutableLiveData.setValue((ModelDetails) object);

            }
        });
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        SingleCom.com().clear();
    }


}
