package com.example.rxjavamvvmnew.view.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rxjavamvvmnew.R;
import com.example.rxjavamvvmnew.databinding.FragmentProfileBinding;
import com.example.rxjavamvvmnew.model.ModelOrder;
import com.example.rxjavamvvmnew.model.ModelProfile;
import com.example.rxjavamvvmnew.repositry.NavigationUtils;
import com.example.rxjavamvvmnew.repositry.Repositry;
import com.example.rxjavamvvmnew.view.activity.MainActivity;
import com.example.rxjavamvvmnew.view.adapter.AdapterOrder;
import com.example.rxjavamvvmnew.viewmodel.ViewModelProfile;

import java.util.List;


public class FragmentProfile extends Fragment {

    NavController navController;
    FragmentProfileBinding binding;
    MainActivity mainActivity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        binding=FragmentProfileBinding.inflate(inflater,container,false);
        navController=Navigation.findNavController(requireActivity(),R.id.fragment);


        binding.tvExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean check=Repositry.sharedExit(requireContext());
                if (check)
                {
                    NavigationUtils.navigateSafe(navController
                            ,R.id.action_fragmentProfile_to_fragmentLogIn,null);

                     mainActivity= (MainActivity) getActivity();
                    mainActivity.getCountCart();
                }


            }
        });



        ViewModelProfile viewModelProfile=
                new ViewModelProvider(requireActivity()).get(ViewModelProfile.class);

        viewModelProfile.post(Repositry.readToken(requireContext()));

        viewModelProfile.mutableLiveData.observe(requireActivity(),
                new Observer<List<ModelProfile>>() {
                    @Override
                    public void onChanged(List<ModelProfile> modelProfiles) {

                         mainActivity= (MainActivity) getActivity();
                        mainActivity.getCountCart();

                        Log.e("TAG","id "+Repositry.readToken(requireContext())
                                +"    "+modelProfiles.toString());
                        binding.setData(modelProfiles.get(0));

                    }
                });

        viewModelProfile.mutableLiveDataOrders.observe(requireActivity(),
                new Observer<List<ModelOrder>>() {
                    @Override
                    public void onChanged(List<ModelOrder> modelOrders) {

                        binding.rcylrid.setLayoutManager(new LinearLayoutManager(getContext()));

                        AdapterOrder adapter=new AdapterOrder(modelOrders);

                        binding.rcylrid.setAdapter(adapter);


                        Log.e("TAG","  OrderS  "+modelOrders.toString());

                    }
                });



        return binding.getRoot();
    }
}