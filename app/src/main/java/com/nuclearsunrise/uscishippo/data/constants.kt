package com.nuclearsunrise.uscishippo.data

class constants {
    companion object {
        const val STR_BASE_URL = "https://egov.uscis.gov/processing-times/api/"
        const val STR_FORMS_URI = "forms"
        const val STR_OFFICES_URI = "formoffices/{office_code}"
        const val STR_TIMES_URI = "processingtime/{form}/{office_code}"
    }
}