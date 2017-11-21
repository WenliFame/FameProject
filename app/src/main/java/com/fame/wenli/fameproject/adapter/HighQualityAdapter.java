package com.fame.wenli.fameproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fame.wenli.fameproject.R;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by wenli on 2017/11/21.
 */

public class HighQualityAdapter extends RecyclerView.Adapter<HighQualityAdapter.ViewHolder> {
    private List<String> mList;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.high_quality_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public HighQualityAdapter(List<String> mList) {
        this.mList = mList;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String text = mList.get(position);
        holder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = ButterKnife.findById(itemView,R.id.high_quality_text);
        }
    }
}
