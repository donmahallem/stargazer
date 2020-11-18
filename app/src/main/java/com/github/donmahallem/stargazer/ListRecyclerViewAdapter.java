package com.github.donmahallem.stargazer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class ListRecyclerViewAdapter
        extends RecyclerView.Adapter<ListRecyclerViewAdapter.ViewHolder> {

    private final OnItemSelectListener mItemClickListener;

    public ListRecyclerViewAdapter(OnItemSelectListener onItemSelectListener) {
        this.mItemClickListener = onItemSelectListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view,this.mItemClickListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = DataContainer.ITEMS[position];
        holder.mIdView.setText("" + DataContainer.ITEMS[position].id);
        holder.mContentView.setText(DataContainer.ITEMS[position].title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListRecyclerViewAdapter.this.mItemClickListener
                        .onItemSelected(DataContainer.ITEMS[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return DataContainer.ITEMS.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public DataContainer.ListItem mItem;
        private final OnItemSelectListener mItemSelectListener;

        public ViewHolder(View view,OnItemSelectListener itemSelectListener) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.title);
            mContentView = (TextView) view.findViewById(R.id.content);
            this.itemView.setOnClickListener(this);
            this.mItemSelectListener=itemSelectListener;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

        @Override
        public void onClick(View v) {
            this.mItemSelectListener.onItemSelected(this.mItem);
        }
    }
}