package icu.repsaj.android.mytrivia.network.health

import retrofit2.Response
import retrofit2.http.GET

interface IHealthApiService {
    /**
     * Performs a health check on the API.
     *
     * @return A string containing "pong" if the API is healthy.
     */
    @GET("health/ping")
    suspend fun ping(): Response<String>
}