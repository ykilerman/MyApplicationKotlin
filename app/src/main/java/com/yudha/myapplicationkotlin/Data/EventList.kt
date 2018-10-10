package com.yudha.myapplicationkotlin.Data

import com.google.gson.annotations.SerializedName


//class EventList{
//    lateinit var list_event : List<Movie>
//}
data class EventList(
        @SerializedName("list_event") var list_event : List<Movie>?)