package com.trongdeptrai.girlmvparchitech.screen.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.trongdeptrai.girlmvparchitech.R;
import com.trongdeptrai.girlmvparchitech.data.model.Girl;
import java.util.ArrayList;

public class GirlAdapter extends RecyclerView.Adapter<GirlAdapter.ViewHolder> {
    private ArrayList<Girl> mGirls;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_girl, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        setView(viewHolder, position);
    }

    @Override
    public int getItemCount() {
        return mGirls != null ? mGirls.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAvatar;
        private TextView txtName, txtAge;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            txtName = itemView.findViewById(R.id.txtName);
            txtAge = itemView.findViewById(R.id.txtAge);
        }
    }

    private void setView(ViewHolder viewHolder, int position) {
        Girl girl = mGirls.get(position);
        viewHolder.txtName.setText(girl.getName());
        viewHolder.txtAge.setText(String.valueOf(girl.getAge()));
        if (position % 2 == 0) {
            viewHolder.imgAvatar.setImageResource(R.drawable.girl_one);
        } else {
            viewHolder.imgAvatar.setImageResource(R.drawable.girl_two);
        }
    }

    public void updateData(ArrayList<Girl> girls){
        mGirls = girls;
        notifyDataSetChanged();
    }
}
