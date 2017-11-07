package com.myhexaville.androidsearchview2;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.myhexaville.androidsearchview2.databinding.ListItemBinding;

public class Holder extends RecyclerView.ViewHolder {
    public ListItemBinding binding;

    public Holder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }
}
