package com.zawlynn.codigo.assignment.ui.main


import android.view.ViewGroup

import androidx.annotation.NonNull
import androidx.recyclerview.widget.ListAdapter
import com.zawlynn.codigo.assignment.data.database.dao.wonder.Wonder
import com.zawlynn.codigo.assignment.ui.main.viewholder.MyViewHolder
import com.zawlynn.codigo.assignment.utils.OnitemClick


class RecAdapter(val listener:OnitemClick): ListAdapter<Wonder, MyViewHolder>(ListItemCallback()) {
    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, i: Int): MyViewHolder {
        return MyViewHolder(parent)
    }

    override fun onBindViewHolder(@NonNull holder: MyViewHolder, i: Int) {
        holder.bind(getItem(i),listener)
    }

}
