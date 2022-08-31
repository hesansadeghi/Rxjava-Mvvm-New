package com.example.rxjavamvvmnew.repositry;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public final class Repositry {
      public static final Repositry INSTANCE;
          public  void CustomResponse(Single api,final Unit unit){
              SingleCom.com().add((Disposable)
              api.subscribeOn(Schedulers.newThread())
                      .observeOn(AndroidSchedulers.mainThread())
                      .subscribeWith(new DisposableSingleObserver() {
                          @Override
                          public void onSuccess(Object object) {

                              unit.invoke(object);
                              Log.e("TAG","Repository  "+object.toString());

                          }

                          @Override
                          public void onError(Throwable e) {

                              Log.e("TAG","Error  "+e.toString());

                          }
                      }));
          }

          static {
              Repositry repositry=new Repositry();
              INSTANCE=repositry;
          }

          public interface Unit
          {
              void invoke(Object object);
          }


          public static void writeToken(Context context,String token)
          {
              SharedPreferences sharedPreferences=
                      context.getSharedPreferences("shrfprf",Context.MODE_PRIVATE);

              SharedPreferences.Editor editor= sharedPreferences.edit();
              editor.putString("token",token);
              editor.apply();
          }

    public static String readToken(Context context)
    {
        SharedPreferences sharedPreferences
                =context.getSharedPreferences("shrfprf",Context.MODE_PRIVATE);

        String token=sharedPreferences.getString("token","-1");

       return token;
    }

    }
