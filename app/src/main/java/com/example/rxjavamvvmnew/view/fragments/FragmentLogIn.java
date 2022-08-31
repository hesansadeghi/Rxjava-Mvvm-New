package com.example.rxjavamvvmnew.view.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rxjavamvvmnew.R;
import com.example.rxjavamvvmnew.databinding.FragmentLogInBinding;
import com.example.rxjavamvvmnew.model.Status;
import com.example.rxjavamvvmnew.repositry.NavigationUtils;
import com.example.rxjavamvvmnew.repositry.Repositry;
import com.example.rxjavamvvmnew.viewmodel.ViewModelLogIn;

public class FragmentLogIn extends Fragment {

    FragmentLogInBinding binding;
    NavController navController;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_log_in,container,false);
//        binding = FragmentLogInBinding.inflate(inflater, container, false);
        navController = Navigation.findNavController(requireActivity(), R.id.fragment);


        ViewModelLogIn viewModelLogIn = new ViewModelProvider(this).get(ViewModelLogIn.class);

        binding.setData(viewModelLogIn);


        viewModelLogIn.mutableLiveData.observe(requireActivity(), new Observer<Status>() {
            @Override
            public void onChanged(Status status) {

                if (status.getStatus().equals("ok")) {
                    Toast.makeText(requireActivity(), "ok", Toast.LENGTH_SHORT).show();
                    Repositry.writeToken(requireContext(), String.valueOf(status.getUserId()));
//                    navController.navigate(R.id.action_to_fragmentProfile);
                    NavigationUtils.navigateSafe(navController, R.id.action_to_fragmentProfile, null);
                } else {
                    Toast.makeText(requireActivity(), "error", Toast.LENGTH_SHORT).show();

                }

            }
        });


        binding.btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_fragmentLogIn_to_fragmentRegister);

            }
        });


        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}