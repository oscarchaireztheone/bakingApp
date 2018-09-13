package com.example.android.bakingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.bakingapp.model.Recipe;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    final private ListItemClickListener mOnClickListener;

    public interface  ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    private int mNumberItems;
    private ArrayList mList;

    public ListAdapter(ArrayList list, ListItemClickListener listener) {
        mOnClickListener = listener;
        mList = list;
        mNumberItems = list.size();
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.master_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediatly = false;
        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediatly);
        ListViewHolder viewHolder = new ListViewHolder(view, context);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.bind(position);
    }

    class ListViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        TextView listTV;
        Context mContext;
        public ListViewHolder(View itemView, Context context) {
            super(itemView);
            mContext = context;
            itemView.setOnClickListener(this);
            //++++
            listTV = (TextView) itemView.findViewById(R.id.tv_recipe);
        }
        void bind (int listIndex) {
           if (mList.get(listIndex) instanceof Recipe) {
               Recipe recipe = (Recipe) mList.get(listIndex);
               listTV.setText(recipe.getName());
           }
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
