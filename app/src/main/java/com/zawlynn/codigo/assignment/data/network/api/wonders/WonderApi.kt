package com.zawlynn.codigo.assignment.data.network.api.wonders

import com.zawlynn.codigo.assignment.data.database.dao.wonder.Wonder
import com.zawlynn.codigo.assignment.data.network.response.ApiResponse
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface WonderApi{
    @GET("bins/13g69v")
    fun getDataFromApi(): Flowable<Response<ApiResponse>>
}