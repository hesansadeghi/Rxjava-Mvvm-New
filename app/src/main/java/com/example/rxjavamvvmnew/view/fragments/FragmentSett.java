package com.example.rxjavamvvmnew.view.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rxjavamvvmnew.R;
import com.example.rxjavamvvmnew.databinding.FragmentSettBinding;
import com.example.rxjavamvvmnew.model.ModelAllPrice;
import com.example.rxjavamvvmnew.model.ModelRecord;
import com.example.rxjavamvvmnew.repositry.NavigationUtils;
import com.example.rxjavamvvmnew.repositry.Repositry;
import com.example.rxjavamvvmnew.view.activity.MainActivity;
import com.example.rxjavamvvmnew.view.adapter.AdapterRecord;
import com.example.rxjavamvvmnew.viewmodel.ViewModelSett;

import java.util.List;


public class FragmentSett extends Fragment {

    FragmentSettBinding binding;
    NavController navController;


    public static int index = 1;
    public static int top = 1;
    LinearLayoutManager mLayoutManager;
    Parcelable state;

    MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if (binding == null) {
            binding = FragmentSettBinding.inflate(inflater, container, false);
            navController = Navigation.findNavController(requireActivity(), R.id.fragment);

            ViewModelSett viewModelSett = new ViewModelProvider(requireActivity()).get(ViewModelSett.class);
            viewModelSett.post(Repositry.readToken(requireContext()));
            viewModelSett.mutableLiveData.observe(requireActivity(),
                    new Observer<List<ModelRecord>>() {
                        @Override
                        public void onChanged(List<ModelRecord> modelRecords) {

                            Log.e("TAG", modelRecords.toString());

                            mLayoutManager = new LinearLayoutManager(requireContext());


                            binding.rcylrSellId.setLayoutManager(mLayoutManager);
                            AdapterRecord adapterRecord = new AdapterRecord(modelRecords, getContext(),getActivity(),
                                    new AdapterRecord.ChangePrice() {
                                        @Override
                                        public void change() {
                                            viewModelSett.post(Repositry.readToken(requireContext()));
                                            viewModelSett.mutableLiveDataAllPrice.observe(requireActivity(),
                                                    new Observer<List<ModelAllPrice>>() {
                                                        @Override
                                                        public void onChanged(List<ModelAllPrice> modelAllPrices) {

                                                            Log.e("TAG", modelAllPrices.toString());

                                                            binding.setAllprice(modelAllPrices.get(0));
                                                            state = mLayoutManager.onSaveInstanceState();


                                                        }
                                                    });

                                        }
                                    });
                            mainActivity= (MainActivity) getActivity();
                            mainActivity.getCountCart();


                            binding.rcylrSellId.setAdapter(adapterRecord);
                            mLayoutManager.onRestoreInstanceState(state);


                        }
                    });

            viewModelSett.mutableLiveDataAllPrice.observe(requireActivity(),
                    new Observer<List<ModelAllPrice>>() {
                        @Override
                        public void onChanged(List<ModelAllPrice> modelAllPrices) {

                            Log.e("TAG", modelAllPrices.toString());

                            binding.setAllprice(modelAllPrices.get(0));
                        }
                    });


            binding.btnFinallBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    NavigationUtils.navigateSafe(navController,
                            R.id.action_fragmentSett_to_fragmentAddress,null);

                }
            });



        }

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}