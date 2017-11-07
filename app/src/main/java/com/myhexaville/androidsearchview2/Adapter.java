package com.myhexaville.androidsearchview2;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Holder> {
    private Context context;
    private List<String> countries;

    public Adapter(Context context, List<String> countries) {
        this.context = context;
        this.countries = countries;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.list_item,
                parent,
                false);

        return new Holder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        String country = countries.get(position);
        holder.binding.text.setText(country);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
        notifyDataSetChanged();
    }
}
