package com.example.recylerviewwithfixedcount;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {

    Context mContext;
    ArrayList<NameModel> arrayList;
    LayoutInflater inflater;

    public NameAdapter(Context mContext, ArrayList<NameModel> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NameViewHolder(inflater.inflate(R.layout.row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, final int position) {

        holder.txtName.setText(arrayList.get(position).getName());
        holder.txtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("tagg","clicked");
                arrayList.remove(position);
                notifyItemRemoved(position);
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtClose;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtClose = itemView.findViewById(R.id.txt_close);
        }
    }
}
