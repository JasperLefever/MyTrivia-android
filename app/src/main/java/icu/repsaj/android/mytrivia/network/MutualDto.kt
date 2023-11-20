package icu.repsaj.android.mytrivia.network

//static var baseUrl
public var baseUrl = "http://10.0.2.2:8080"

data class Metadata(
    val page: Int,
    val per: Int,
    val total: Int
)