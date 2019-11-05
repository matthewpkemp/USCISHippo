package com.nuclearsunrise.uscishippo.jsondefinition

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JSONprocessingtime (
    var data: JSONprocessingtimeData,
    var message: String
)

@JsonClass(generateAdapter = true)
data class JSONprocessingtimeData(
    var processing_time: ProcessingTime
)

@JsonClass(generateAdapter = true)
data class ProcessingTime
    (
    var form_info_en: String,
    var form_info_es: String,
    var form_name: String,
    var form_note_en: String?,
    var form_note_es: String?,
    var office_code: String,
    var range: String?,
    var subtypes: List<Subtype>

)

@JsonClass(generateAdapter = true)
data class Subtype(
    var form_type: String,
    var publication_date: String,
    var range: List<Range>,
    var service_request_date: String,
    var service_request_date_en: String,
    var service_request_date_es : String,
    var subtype_info_en : String,
    var subtype_info_es : String,
    var subtype_note_en : String?,
    var subtype_note_es : String?
)

@JsonClass(generateAdapter = true)
data class Range(
    var unit: String,
    var unit_en: String,
    var unit_es: String,
    var value: Double
)