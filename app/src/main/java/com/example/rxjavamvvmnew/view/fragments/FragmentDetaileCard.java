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
import com.example.rxjavamvvmnew.databinding.FragmentDetaileCardBinding;
import com.example.rxjavamvvmnew.model.ModelDetails;
import com.example.rxjavamvvmnew.model.ModelMinAdd;
import com.example.rxjavamvvmnew.model.Model_Posts;
import com.example.rxjavamvvmnew.repositry.Api;
import com.example.rxjavamvvmnew.repositry.NavigationUtils;
import com.example.rxjavamvvmnew.repositry.Repositry;
import com.example.rxjavamvvmnew.view.activity.MainActivity;
import com.example.rxjavamvvmnew.view.adapter.AdapterViewPager;
import com.example.rxjavamvvmnew.viewmodel.ViewModelDetaileCard;


public class FragmentDetaileCard extends Fragment {

    FragmentDetaileCardBinding binding;
    NavController navController;
    Model_Posts model_posts;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detaile_card, container, false);
        navController = Navigation.findNavController(requireActivity(), R.id.fragment);


        ViewModelDetaileCard viewModelDetaileCard =
                new ViewModelProvider(this).get(ViewModelDetaileCard.class);

        viewModelDetaileCard.post(getArguments().getString("idnum"));
//        viewModelDetaileCard.post("1");

        viewModelDetaileCard.mutableLiveData.observe(requireActivity(), new Observer<ModelDetails>() {
            @Override
            public void onChanged(ModelDetails modelDetails) {

                Log.e("TAG", "fragment  " + modelDetails.toString());

                model_posts = modelDetails.modeLposts.get(0);
                binding.setData(modelDetails.modeLposts.get(0));
                binding.btnPrice.setText(" افزودن به سبد خرید " + modelDetails.modeLposts.get(0).getPrice());

                AdapterViewPager adapterVp = new AdapterViewPager(modelDetails.sliderList);
                binding.vpager.setAdapter(adapterVp);
                binding.vpager.setPageMargin(25);
                binding.vpager.setPadding(45, 0, 15, 0);
                binding.vpager.setCurrentItem(1);

            }
        });

        binding.btnPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Repositry.readToken(requireContext()).equals("-1")) {
                    NavigationUtils.navigateSafe(navController,
                            R.id.action_fragmentDetaileCard_to_fragmentLogIn, null);
                    Toast.makeText(getContext(), "Register please", Toast.LENGTH_SHORT).show();
                } else {

                    addOrRemoveCard("add", Repositry.readToken(requireContext())
                            , model_posts.getId(), "1");

                }


            }
        });


        return binding.getRoot();
    }

    public void addOrRemoveCard(String check, String userId,
                                String productId, String count) {

        Log.e("TAG", "check : " + check + " userId : " + userId +
                " productId : " + productId + " count : " + count);

        Repositry.INSTANCE.CustomResponse(Api.COMPANIO2.invoke()
                        .ADD_MIN_CARD_SINGLE(check, userId, productId, count),
                new Repositry.Unit() {
                    @Override
                    public void invoke(Object object) {

                        ModelMinAdd modelMinAdd = (ModelMinAdd) object;
                        if (modelMinAdd.getStatus().equals("ok")) {
                            Toast.makeText(getContext(), "done", Toast.LENGTH_SHORT).show();

                            MainActivity mainActivity= (MainActivity) getActivity();
                            mainActivity.getCountCart();


                        }

                        Log.e("TAG", "  m_add" + object.toString());
                    }
                });
    }


}