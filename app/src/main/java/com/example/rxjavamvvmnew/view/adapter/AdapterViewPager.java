package com.example.rxjavamvvmnew.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.rxjavamvvmnew.R;
import com.example.rxjavamvvmnew.databinding.ItemsSliderBinding;
import com.example.rxjavamvvmnew.model.Slider;

import java.util.List;

public class AdapterViewPager extends PagerAdapter {

    List<Slider> sliderList;



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public AdapterViewPager(List<Slider> sliderList) {
        this.sliderList = sliderList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ItemsSliderBinding binding= DataBindingUtil.inflate(LayoutInflater.from(container.getContext())
                ,R.layout.items_slider,container,false);

        binding.setData(sliderList.get(position));
        container.addView(binding.getRoot());
        return binding.getRoot();
    }

    @Override
    public int getCount() {
        return sliderList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.95f;
    }
}
