package icu.repsaj.android.mytrivia.data

import icu.repsaj.android.mytrivia.network.health.IHealthApiService

/**
 * Repository interface for the api health.
 */
interface IHealthRepo {

    /**
     * Performs a health check on the API.
     *
     * @return A boolean indicating whether the API is running.
     */
    suspend fun ping(): Boolean
}


/**
 * Repository implementation for accessing the api health via an API.
 * This repository fetches the api health from a remote data source.
 *
 * @property healthService The API service for accessing the api health.
 */
class APIHealthRepo(
    private val healthService: IHealthApiService
) : IHealthRepo {

    /**
     * Performs a health check on the API.
     *
     * @return A boolean indicating whether the API is running.
     */
    override suspend fun ping(): Boolean {
        return try {
            val response = healthService.ping()
            response.isSuccessful && response.body()?.let {
                it.contains("pong")
            } ?: false
        } catch (e: Exception) {
            false
        }
    }
}
