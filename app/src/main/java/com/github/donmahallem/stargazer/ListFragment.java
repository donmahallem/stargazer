package com.github.donmahallem.stargazer;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListFragment extends Fragment {

    public static final String ARG_ID = "id";

    private OnItemSelectListener mOnSelectItemListener;


    public ListFragment() {
    }

    public void setOnItemSelectListener(OnItemSelectListener onItemSelectListener){
        this.mOnSelectItemListener=onItemSelectListener;
    }

    public static ListFragment newInstance(int id) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new ListRecyclerViewAdapter(new OnItemSelectListener() {
                @Override
                public void onItemSelected(DataContainer.ListItem item) {
                    if(ListFragment.this.mOnSelectItemListener!=null){
                        ListFragment.this.mOnSelectItemListener.onItemSelected(item);
                    }
                }
            }));
        }
        return view;
    }

}