package com.github.donmahallem.stargazer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements OnItemSelectListener {

    private Fragment primaryFragment,secondaryFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        this.primaryFragment=fragmentManager.findFragmentById(R.id.frame_layout);
        this.secondaryFragment=fragmentManager.findFragmentById(R.id.frame_layout2);
        if(!(this.primaryFragment instanceof ListFragment)) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ListFragment fragment = new ListFragment();
            fragmentTransaction.replace(R.id.frame_layout, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment instanceof ListFragment){
            ((ListFragment)fragment).setOnItemSelectListener((OnItemSelectListener) this);
        }
    }

    @Override
    public void onItemSelected(DataContainer.ListItem item) {
        DetailFragment detailFragment=DetailFragment.newInstance(item.id);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if(this.findViewById(R.id.frame_layout2)!=null){
            fragmentTransaction.replace(R.id.frame_layout2, detailFragment);
        }
        else{
            fragmentTransaction.replace(R.id.frame_layout, detailFragment);
            fragmentTransaction.addToBackStack("details");
        }
        fragmentTransaction.commit();
    }
}