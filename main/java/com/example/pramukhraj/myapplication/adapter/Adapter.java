package com.example.pramukhraj.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pramukhraj.myapplication.acitvity.OnClickRecycleItem;
import com.example.pramukhraj.myapplication.model.NewRes;
import com.example.pramukhraj.myapplication.R;

import java.util.ArrayList;

/**
 * Created by PramukhRaj on 4/22/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.Myview> {
    ArrayList<NewRes> newRes;
    Context context;
    OnClickRecycleItem onClickRecycle;

    public Adapter(ArrayList<NewRes> newRes, Context context,OnClickRecycleItem onClickRecycle ) {
        this.newRes = newRes;
        this.context = context;
        this.onClickRecycle = onClickRecycle;
    }

    @Override
    public Adapter.Myview onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);

        return new Myview(view);
    }

    @Override
    public void onBindViewHolder(Adapter.Myview holder, final int position) {

        holder.tv_main.setText(newRes.get(position).getContacts().get(position).getName());
        holder.tv_main2.setText(newRes.get(position).getContacts().get(position).getPhone().getMobile());
        holder.tv_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRecycle.resultclick(newRes.get(position).getContacts(),position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newRes.size();
    }

    public class Myview extends RecyclerView.ViewHolder {
        TextView tv_main;
        TextView tv_main2;

        public Myview(View itemView) {
            super(itemView);
            tv_main = (TextView) itemView.findViewById(R.id.tv_main);
            tv_main2 = (TextView) itemView.findViewById(R.id.tv_main2);
        }
    }
}
