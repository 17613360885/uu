package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author xts
 *         Created by asus on 2019/9/11.
 */

public class RlvCarAdapter extends RecyclerView.Adapter {
    private ArrayList<Car> mCars;

    public RlvCarAdapter(ArrayList<Car> cars) {
        mCars = cars;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_time, null);
        return new CarVH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CarVH carVH = (CarVH) holder;
        carVH.mTv.setText(mCars.get(position).brand);
    }

    @Override
    public int getItemCount() {
        return mCars.size();
    }

    class CarVH extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_time)
        TextView mTv;
        public CarVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
