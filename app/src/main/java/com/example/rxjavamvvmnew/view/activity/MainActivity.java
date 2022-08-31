package com.example.rxjavamvvmnew.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.rxjavamvvmnew.R;


import com.example.rxjavamvvmnew.databinding.ActivityMainBinding;
import com.example.rxjavamvvmnew.model.Model_Posts;
import com.example.rxjavamvvmnew.repositry.Repositry;
import com.example.rxjavamvvmnew.viewmodel.ViewModelPost;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


import java.util.List;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;


    NavController navController;
    AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        appBarConfiguration = new AppBarConfiguration.Builder(
                R.navigation.nav_list).build();
        NavHostFragment navhost = (NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.fragment);
        assert navhost!=null;
        navController=navhost.getNavController();

        navController = Navigation.findNavController(this, R.id.fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.btnnav, navController);


        binding.btnnav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.fragmentProfile :
                        if (Repositry.readToken(MainActivity.this).equals("-1")) {
                            navController.navigate(R.id.fragmentLogIn);
                        } else {
                            navController.navigate(R.id.fragmentProfile);
                        }
                    break;

                    case R.id.fragmentPost:

                        navController.navigate(R.id.fragmentPost);

                        break;

                    case R.id.fragmentSett :

                        navController.navigate(R.id.fragmentSett);

                        break;


                }

                return true;
            }
        });


        getSupportActionBar().hide();


    }


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }
}