package com.zawlynn.codigo.assignment.ui.main.viewholder

import android.content.Context
import android.graphics.drawable.Drawable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.zawlynn.codigo.assignment.R
import com.zawlynn.codigo.assignment.data.database.dao.wonder.Wonder
import com.zawlynn.codigo.assignment.utils.GlideApp
import com.zawlynn.codigo.assignment.utils.OnitemClick
import kotlinx.android.synthetic.main.item.view.*


 class MyViewHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)) {
    private val tv_desc = itemView.tv_desc
    private val tv_title = itemView.tv_header
    private val image=itemView.imgview
    private val context: Context

    init {
        context = parent.context
    }

    fun bind(data: Wonder,listener:OnitemClick) {
        tv_title.setText(data.location)
        tv_desc.setText(data.description)
        GlideApp.with(context)
            .load(data.image).override(300, 300)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    @Nullable e: GlideException?, model: Any,
                    target: Target<Drawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: Target<Drawable>,
                    dataSource: com.bumptech.glide.load.DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }
            })
            .into(image)
        image.setOnClickListener {
            listener.onClick(data)
        }
    }
}