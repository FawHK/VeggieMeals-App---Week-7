package de.syntax_institut.theveggieapp.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Object that provides access to the API service for veggie meals.
 *
 * This object initializes Retrofit with Moshi for JSON parsing and defines a lazy-initialized
 * `retrofitService` that can be used to make API calls related to veggie meals.
 * [Api](https://www.themealdb.com/api.php)
 */
object VeggieMealAPI {
    private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()
    val retrofitService: APIService by lazy { retrofit.create(APIService::class.java) }
}