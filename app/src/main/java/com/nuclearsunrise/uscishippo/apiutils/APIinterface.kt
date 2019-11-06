package com.nuclearsunrise.uscishippo.apiutils

import com.nuclearsunrise.uscishippo.data.constants.Companion.STR_FORMS_URI
import com.nuclearsunrise.uscishippo.data.constants.Companion.STR_OFFICES_URI
import com.nuclearsunrise.uscishippo.data.constants.Companion.STR_TIMES_URI
import com.nuclearsunrise.uscishippo.jsondefinition.JSONformoffices
import com.nuclearsunrise.uscishippo.jsondefinition.JSONforms
import com.nuclearsunrise.uscishippo.jsondefinition.JSONprocessingtime
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface APIinterface {
    @GET(STR_FORMS_URI) fun getFormsAsync(): Deferred<Response<JSONforms>>
    @GET(STR_OFFICES_URI) fun getOfficesAsync(): Deferred<Response<JSONformoffices>>
    @GET(STR_TIMES_URI) fun getTimesAsync(): Deferred<Response<JSONprocessingtime>>
}