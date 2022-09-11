package com.example.githubstar.feature.search.data

import com.example.githubstar.feature.search.data.models.*
import retrofit2.http.*

interface SearchGitRepoApi {

    @GET("search/repositories?")
    suspend fun gitTopReposByOrg(
        @Query("q") org: String,
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc",
        @Query("per_page") page: Int = 3
    ): GitTopReposResponse
}