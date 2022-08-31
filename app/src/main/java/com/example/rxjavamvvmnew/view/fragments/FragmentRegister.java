package com.example.rxjavamvvmnew.view.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rxjavamvvmnew.R;
import com.example.rxjavamvvmnew.databinding.FragmentRegisterBinding;
import com.example.rxjavamvvmnew.model.Status;
import com.example.rxjavamvvmnew.repositry.NavigationUtils;
import com.example.rxjavamvvmnew.repositry.Repositry;
import com.example.rxjavamvvmnew.viewmodel.ViewModelRegister;

public class FragmentRegister extends Fragment {

    FragmentRegisterBinding binding;
    NavController navController;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_register,container,false);
//        binding=FragmentRegisterBinding.inflate(inflater,container,false);
        navController=Navigation.findNavController(requireActivity(),R.id.fragment);

        ViewModelRegister viewModelRegister=
                new ViewModelProvider(requireActivity()).get(ViewModelRegister.class);
        binding.setData(viewModelRegister);


        viewModelRegister.mutableLiveData.observe(requireActivity(), new Observer<Status>() {
            @Override
            public void onChanged(Status status) {

                if (status.getStatus().equals("ok"))
                {
                    Toast.makeText(requireActivity(), "ok", Toast.LENGTH_SHORT).show();
                    Repositry.writeToken(requireContext(), String.valueOf(status.getUserId()));
//                    navController.navigate(R.id.action_to_fragmentProfile);
                    NavigationUtils.navigateSafe(navController, R.id.action_to_fragmentProfile, null);

                }else {
                    Toast.makeText(requireActivity(), "error", Toast.LENGTH_SHORT).show();

                }

            }
        });


        binding.btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NavigationUtils.navigateSafe(navController,
                        R.id.action_fragmentRegister_to_fragmentLogIn,null);
//                navController.navigate(R.id.action_fragmentRegister_to_fragmentLogIn);
            }
        });


        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}