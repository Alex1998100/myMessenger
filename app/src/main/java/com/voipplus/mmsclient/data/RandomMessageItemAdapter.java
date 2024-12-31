package com.voipplus.mmsclient.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.voipplus.mmsclient.R;

import java.util.List;
public class RandomMessageItemAdapter extends RecyclerView.Adapter<RandomMessageItemAdapter.ViewHolder> {

    private final List<RandomMessageItem> items;

    public RandomMessageItemAdapter(List<RandomMessageItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {RandomMessageItem item = items.get(position);
        holder.iconView.setImageResource(item.getIcon());
        holder.textView.setText(item.getText());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView iconView;
        public final TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconView = itemView.findViewById(R.id.icon);
            textView = itemView.findViewById(R.id.text);
        }
    }
}