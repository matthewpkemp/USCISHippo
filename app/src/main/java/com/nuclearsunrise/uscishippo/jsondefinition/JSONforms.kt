package com.nuclearsunrise.uscishippo.jsondefinition

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JSONforms(
    var data: JSONformsData,
    var message: String

)

@JsonClass(generateAdapter = true)
data class JSONformsData (
    var forms: Forms
)

@JsonClass(generateAdapter = true)
data class Forms (
    @Json(name="forms") var form: List<Form>
)

@JsonClass(generateAdapter = true)
data class Form (
    var form_description_en: String,
    var form_description_es: String,
    var form_name: String
)