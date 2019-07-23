package com.zawlynn.codigo.assignment.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.zawlynn.codigo.assignment.R
import com.zawlynn.codigo.assignment.constants.Constants
import com.zawlynn.codigo.assignment.data.database.dao.wonder.Wonder
import com.zawlynn.codigo.assignment.ui.detail.DetailActivity
import com.zawlynn.codigo.assignment.ui.main.viewmodel.MainActivityViewmodel
import com.zawlynn.codigo.assignment.utils.OnitemClick
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , LifecycleOwner,OnitemClick {

    lateinit var viewModel: MainActivityViewmodel
    lateinit var adapter:RecAdapter

    private lateinit var lifecycleRegistry: LifecycleRegistry
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)
        adapter=RecAdapter(this)
        recWonder.adapter=adapter
        recWonder.layoutManager=LinearLayoutManager(applicationContext)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewmodel::class.java)
        viewModel.data.observe(this, Observer {
            if (!it.isNullOrEmpty()) {
                adapter.submitList(it)
            }
        })
    }
    override fun onClick(data: Wonder) {
        val intent= Intent(this@MainActivity,DetailActivity::class.java)
        intent.putExtra(Constants.DATA,data)
        startActivity(intent)
    }
    public override fun onStart() {
        super.onStart()
        lifecycleRegistry.markState(Lifecycle.State.STARTED)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}
