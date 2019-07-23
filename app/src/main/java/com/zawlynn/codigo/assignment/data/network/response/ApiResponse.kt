package com.zawlynn.codigo.assignment.data.network.response

import com.google.gson.annotations.SerializedName
import com.zawlynn.codigo.assignment.data.database.dao.wonder.Wonder

data class ApiResponse(
    @SerializedName("wonders")
    val results:List<Wonder>
)