package com.github.donmahallem.stargazer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class DetailFragment extends Fragment {

    public static final String ARG_ID = "id";
private int mItemId;

    public DetailFragment() {
    }


    public static DetailFragment newInstance(int id) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            this.mItemId=this.getArguments().getInt(ARG_ID,0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);
        TextView tvTitle=view.findViewById(R.id.title);
        tvTitle.setText(DataContainer.ITEMS[this.mItemId].title);
        TextView tvDescription=view.findViewById(R.id.content);
        tvDescription.setText(DataContainer.ITEMS[this.mItemId].details);
        return view;
    }

}