package com.example.rxjavamvvmnew.view.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
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

import com.example.rxjavamvvmnew.R;
import com.example.rxjavamvvmnew.databinding.FragmentPostBinding;
import com.example.rxjavamvvmnew.model.Model_Posts;
import com.example.rxjavamvvmnew.view.adapter.AdapterPosts;
import com.example.rxjavamvvmnew.viewmodel.ViewModelPost;

import java.util.List;


public class FragmentPost extends Fragment {


    FragmentPostBinding binding;
    NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (binding == null) {
            binding = FragmentPostBinding.inflate(inflater, container, false);
            ViewModelPost viewModelPost = new ViewModelProvider(this).get(ViewModelPost.class);
            viewModelPost.posts();
            viewModelPost.mutableLiveData.observe(requireActivity(), new Observer<List<Model_Posts>>() {
                @Override
                public void onChanged(List<Model_Posts> model_posts) {

                    AdapterPosts adapter = new AdapterPosts(model_posts, new AdapterPosts.OnClickItem() {
                        @Override
                        public void onClick(String id) {

                            Log.e("TAG", id + "");

                            Bundle bundle = new Bundle();
                            bundle.putString("idnum", id);

                            Navigation.findNavController(requireActivity(), R.id.fragment)
                                    .navigate(R.id.action_fragmentPost_to_fragmentDetaileCard, bundle);

                        }
                    });

                    binding.recyclrid.setLayoutManager(new LinearLayoutManager(requireContext()));
                    binding.recyclrid.setAdapter(adapter);

//                Log.e("TAG",model_posts.toString());

                }
            });
        }


        return binding.getRoot();
    }
}