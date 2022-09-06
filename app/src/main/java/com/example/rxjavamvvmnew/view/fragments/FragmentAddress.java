package com.example.rxjavamvvmnew.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rxjavamvvmnew.R;
import com.example.rxjavamvvmnew.databinding.FragmentAddressBinding;
import com.example.rxjavamvvmnew.model.ModelAddress;
import com.example.rxjavamvvmnew.repositry.Repositry;
import com.example.rxjavamvvmnew.view.adapter.AdapterAddress;
import com.example.rxjavamvvmnew.viewmodel.ViewModelAddress;

import java.util.List;


public class FragmentAddress extends Fragment {


    FragmentAddressBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentAddressBinding.inflate(inflater,container,false);

        ViewModelAddress viewModelAddress=
                new ViewModelProvider(requireActivity()).get(ViewModelAddress.class);

        viewModelAddress.post(Repositry.readToken(requireContext()));
        viewModelAddress.mutableLiveData.observe(requireActivity(), new Observer<List<ModelAddress>>() {
            @Override
            public void onChanged(List<ModelAddress> modelAddresses) {


                Log.e("TAG",modelAddresses.toString());

                binding.rcyclradrsid.setLayoutManager(new LinearLayoutManager(requireContext()));

                AdapterAddress adapterAddress=new AdapterAddress(modelAddresses, new AdapterAddress.ItemAddressId() {
                    @Override
                    public void getItem(String adrsId) {


                    }
                });

                binding.rcyclradrsid.setAdapter(adapterAddress);

            }
        });



        return binding.getRoot();
    }
}