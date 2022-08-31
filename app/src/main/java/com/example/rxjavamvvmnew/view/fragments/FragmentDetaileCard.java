package com.example.rxjavamvvmnew.view.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rxjavamvvmnew.R;
import com.example.rxjavamvvmnew.databinding.FragmentDetaileCardBinding;
import com.example.rxjavamvvmnew.model.ModelDetails;
import com.example.rxjavamvvmnew.view.adapter.AdapterViewPager;
import com.example.rxjavamvvmnew.viewmodel.ViewModelDetaileCard;


public class FragmentDetaileCard extends Fragment {

    FragmentDetaileCardBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_detaile_card,container,false);

        ViewModelDetaileCard viewModelDetaileCard=
                new ViewModelProvider(this).get(ViewModelDetaileCard.class);

        viewModelDetaileCard.post(getArguments().getString("idnum"));
//        viewModelDetaileCard.post("1");

        viewModelDetaileCard.mutableLiveData.observe(requireActivity(), new Observer<ModelDetails>() {
            @Override
            public void onChanged(ModelDetails modelDetails) {

                Log.e("TAG","fragment  "+modelDetails.toString());

                binding.setData(modelDetails.modeLposts.get(0));
                binding.btnPrice.setText(" افزودن به سبد خرید "+modelDetails.modeLposts.get(0).getPrice());

                AdapterViewPager adapterVp=new AdapterViewPager(modelDetails.sliderList);
                binding.vpager.setAdapter(adapterVp);
                binding.vpager.setPageMargin(25);
                binding.vpager.setPadding(45,0,15,0);
                binding.vpager.setCurrentItem(1);

            }
        });

        binding.btnPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });



        return binding.getRoot();
    }
}