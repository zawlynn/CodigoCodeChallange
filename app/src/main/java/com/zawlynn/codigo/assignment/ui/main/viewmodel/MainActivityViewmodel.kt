package com.zawlynn.codigo.assignment.ui.main.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.zawlynn.codigo.assignment.DiApplication
import com.zawlynn.codigo.assignment.data.database.dao.WonderDAO
import com.zawlynn.codigo.assignment.data.database.dao.wonder.Wonder
import com.zawlynn.codigo.assignment.data.network.Resource
import com.zawlynn.codigo.assignment.data.network.api.wonders.WonderApi
import com.zawlynn.codigo.assignment.data.repository.CodigoRepsitory
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class MainActivityViewmodel(application: Application) : AndroidViewModel(application)  {
    @Inject
    lateinit var wonderApi:WonderApi
    @Inject
    lateinit var dao: WonderDAO
    var repository: CodigoRepsitory
    val compositeDisposable = CompositeDisposable()
    var data= MutableLiveData<List<Wonder>>()
    init {
        DiApplication.getInstance().component.inject(this)
        repository= CodigoRepsitory(wonderApi,dao)
        repository.getArticles(application)
            .subscribe {
                it.data?.let {
                    data.postValue(it)
                }
                if (it.status == Resource.Status.LOADING) {
                    Log.d(" REPOSITORY", "LOADING")
                } else if (it.status == Resource.Status.SUCCESS) {
                    Log.d(" REPOSITORY", "SUCCESS")
                } else if (it.status == Resource.Status.ERROR) {
                    Log.d(" REPOSITORY", "ERROR")
                }
            }.addTo(compositeDisposable)
    }
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}