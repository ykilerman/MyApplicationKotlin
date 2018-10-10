package com.yudha.myapplicationkotlin.Data

import com.google.gson.annotations.SerializedName

class Movie(@SerializedName("image") val image : String?,
                 @SerializedName("kota") val kota : String?,
                 @SerializedName("start") val start : String?,
                 @SerializedName("end") val end : String?,
                 @SerializedName("id") val id : Int?,
                 @SerializedName("title") val title : String?,
                 @SerializedName("desc") val desc : String?)

//class Movie {
//
//    var id : Int = 0
//    var title : String? = null
//    var year : String? = null
//    var genre : String? = null
//    var poster : String? = null
//}

//class Movie {
//    val image: String?=null
//    val kota: String?=null
//    val start: String?=null
//    val end: String?=null
//    val id: Int?=null
//    val title: String?=null
//    val desc: String?=null
//}

//class Movie {
//    val status: String?=null
//}