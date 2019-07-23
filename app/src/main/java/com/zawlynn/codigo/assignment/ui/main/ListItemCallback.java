package com.zawlynn.codigo.assignment.ui.main;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.zawlynn.codigo.assignment.data.database.dao.wonder.Wonder;

public class ListItemCallback extends  DiffUtil.ItemCallback<Wonder>{
    public boolean areItemsTheSame(@NonNull Wonder oldItem, @NonNull Wonder newItem) {
        return oldItem.getLocation().equals(newItem.getLocation());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Wonder oldItem, @NonNull Wonder newItem) {
        return oldItem.equals(newItem);
    }
}
