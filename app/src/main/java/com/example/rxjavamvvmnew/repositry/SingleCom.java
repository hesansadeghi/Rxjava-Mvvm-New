package com.example.rxjavamvvmnew.repositry;

import io.reactivex.disposables.CompositeDisposable;

public class SingleCom {

    public static  CompositeDisposable INSTANCE;
    public static final CompositeDisposable com(){

        if (INSTANCE==null){
            INSTANCE=new CompositeDisposable();
        }
        return INSTANCE;
    }

}
