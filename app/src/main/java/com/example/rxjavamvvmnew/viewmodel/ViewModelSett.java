package com.example.rxjavamvvmnew.viewmodel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rxjavamvvmnew.model.ModelAllPrice;
import com.example.rxjavamvvmnew.model.ModelRecord;
import com.example.rxjavamvvmnew.repositry.Api;
import com.example.rxjavamvvmnew.repositry.Repositry;
import com.example.rxjavamvvmnew.repositry.SingleCom;

import java.security.PublicKey;
import java.util.List;

public class ViewModelSett extends ViewModel {

   public MutableLiveData<List<ModelRecord>> mutableLiveData=new MediatorLiveData<>();
   public MutableLiveData<List<ModelAllPrice>> mutableLiveDataAllPrice=new MediatorLiveData<>();

   public void post(String id)
   {
      Repositry.INSTANCE.CustomResponse(Api.COMPANIO2.invoke().MODEL_RECORD_SINGLE(id),
              new Repositry.Unit() {
         @Override
         public void invoke(Object object) {

            mutableLiveData.setValue((List<ModelRecord>) object);

         }
      });

      Repositry.INSTANCE.CustomResponse(Api.COMPANIO2.invoke().LIST_ALLPRICE_SINGLE(id),
              new Repositry.Unit() {
                 @Override
                 public void invoke(Object object) {

                    mutableLiveDataAllPrice.setValue((List<ModelAllPrice>) object);

                 }
              });


   }
   @Override
   protected void onCleared() {
      super.onCleared();
      SingleCom.com().clear();
   }

}
