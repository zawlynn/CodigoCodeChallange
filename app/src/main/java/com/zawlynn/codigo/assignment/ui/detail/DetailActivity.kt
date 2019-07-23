package com.zawlynn.codigo.assignment.ui.detail

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.zawlynn.codigo.assignment.R
import com.zawlynn.codigo.assignment.constants.Constants
import com.zawlynn.codigo.assignment.data.database.dao.wonder.Wonder
import com.zawlynn.codigo.assignment.utils.GlideApp
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item.*
import kotlinx.android.synthetic.main.item.imgview
import kotlinx.android.synthetic.main.item.tv_desc
import android.content.Intent
import android.net.Uri


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val data=intent.getParcelableExtra<Wonder>(Constants.DATA)
        tv_desc.setText(data.description)
        GlideApp.with(this)
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
            .into(imgview)
        btnNavigate.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:"+data.lat+","+data.lng)
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            }
        }
    }
}
