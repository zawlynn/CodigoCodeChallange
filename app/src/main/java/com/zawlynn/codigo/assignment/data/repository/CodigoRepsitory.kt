package com.zawlynn.codigo.assignment.data.repository

import android.annotation.SuppressLint
import android.content.Context

import com.zawlynn.codigo.assignment.data.database.dao.WonderDAO
import com.zawlynn.codigo.assignment.data.network.NetworkBoundResource
import com.zawlynn.codigo.assignment.data.network.Resource
import com.zawlynn.codigo.assignment.data.network.api.wonders.WonderApi
import com.zawlynn.codigo.assignment.data.network.response.ApiResponse

import com.zawlynn.codigo.assignment.data.database.dao.wonder.Wonder


import io.reactivex.Flowable
import io.reactivex.functions.Function

import retrofit2.Response


class CodigoRepsitory(val repoRemoteSource: WonderApi, val repoLocalSource: WonderDAO) {

    @SuppressLint("CheckResult")
    fun getArticles(context: Context): Flowable<Resource<List<Wonder>>> {
        return object : NetworkBoundResource<List<Wonder>, ApiResponse>(context) {
            override fun saveCallResult(request: ApiResponse) {
                repoLocalSource.saveAllData(request.results)
            }
            override fun loadFromDb(): Flowable<List<Wonder>> {
                return repoLocalSource.getAllData()
            }

            override fun createCall(): Flowable<Response<ApiResponse>> {
                return repoRemoteSource.getDataFromApi()
            }

        }.asFlowable()

    }

}