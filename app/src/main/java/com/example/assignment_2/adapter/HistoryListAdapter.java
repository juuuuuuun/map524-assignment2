package com.example.assignment_2.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_2.HistoryDetailActivity;
import com.example.assignment_2.R;
import com.example.assignment_2.model.History;

import java.util.ArrayList;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ViewHolder> {
    private ArrayList<History> list;
    private History history;

    public HistoryListAdapter(ArrayList<History> list, History history) {
        this.list = list;
        this.history = history;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTView;
        TextView priceTView;
        TextView qtyTView;
        LinearLayout layout;

        ViewHolder(View itemView, Context context) {
            super(itemView) ;

            layout = itemView.findViewById(R.id.history_item_layout);
            nameTView = itemView.findViewById(R.id.history_item_name);
            priceTView = itemView.findViewById(R.id.history_item_price);
            qtyTView = itemView.findViewById(R.id.history_item_qty);

            // listener
            layout.setOnClickListener(view -> {
                // Get the data item for this position
                history = list.get(getAdapterPosition());
                Intent intent = new Intent(context, HistoryDetailActivity.class);
                intent.putExtra("history", history);
                context.startActivity(intent);
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.history_view, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        History history = list.get(position) ;
        holder.nameTView.setText(history.getName());
        holder.priceTView.setText(history.getTotalAmount());
        holder.qtyTView.setText(history.getQty() + "");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}



