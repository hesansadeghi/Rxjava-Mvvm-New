package com.example.rxjavamvvmnew.repositry;

import com.example.rxjavamvvmnew.model.ModelDetails;
import com.example.rxjavamvvmnew.model.Model_Posts;
import com.example.rxjavamvvmnew.model.Status;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    Api.Companion2 COMPANIO2 = Api.Companion2.$$Instance;

    @GET("index.php")
    Single<List<Model_Posts>> LIST_SINGLE();

    @FormUrlEncoded
    @POST("postdetails.php")
    Single<ModelDetails> MODEL_DETAILS_SINGLE(@Field("id") String id);

    @FormUrlEncoded
    @POST("Reg.php")
    Single<Status> STATUS_REG_SINGLE(@Field("name") String name, @Field("mobile") String mobile
            , @Field("email") String email, @Field("pass") String pass);

    @FormUrlEncoded
    @POST("login.php")
    Single<Status> STATUS_LOGIN_SINGLE(@Field("mobile") String mobile, @Field("pass") String pass);


    public static final class Companion2 {

        static final Api.Companion2 $$Instance;

        public final Api invoke() {
            Object object = (new Retrofit.Builder()
                    .baseUrl("http://192.168.1.102/shop/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(Api.class));
            return (Api) object;
        }

        static {

            Api.Companion2 api = new Companion2();
            $$Instance = api;
        }

    }


}
