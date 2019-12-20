package com.iy.photos_mvvm.api

import com.iy.photos_mvvm.model.Photos
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {

    @GET("list")
    fun getPhotos(): Observable<List<Photos>>
}