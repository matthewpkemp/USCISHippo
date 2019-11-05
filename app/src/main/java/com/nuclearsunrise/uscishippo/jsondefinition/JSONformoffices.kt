package com.nuclearsunrise.uscishippo.jsondefinition

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JSONformoffices(
    var data: JSONformofficesData,
    var message: String
)

@JsonClass(generateAdapter = true)
data class JSONformofficesData(
    var form_offices: FormOffices
)

@JsonClass(generateAdapter = true)
data class FormOffices(
    var form_name: String,
    var offices: List<Office>
)

@JsonClass(generateAdapter = true)
data class Office(
    var office_code: String,
    var office_description: String
)