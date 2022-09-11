package com.example.githubstar.feature.search.data

import com.example.githubstar.core.exception.*
import com.example.githubstar.core.exception.Failure.ServerError
import com.example.githubstar.core.functional.*
import com.example.githubstar.core.functional.Either.Left
import com.example.githubstar.core.functional.Either.Right
import com.example.githubstar.feature.search.data.models.*
import retrofit2.*
import timber.log.*
import javax.inject.*

class DefaultSearchRepository @Inject constructor(
    private val retrofit: Retrofit
): SearchRepository {

    private val api by lazy {  retrofit.create(SearchGitRepoApi::class.java) }

    override suspend fun getTopGitRepoByOrg(org: String): Either<Failure,GitTopRepos> {
        runCatching {
            val apiResult = api.gitTopReposByOrg("org:$org")
            return Right(GitTopRepos(apiResult.items))
        }.onFailure { throwable ->
            Timber.e(throwable)
        }
        return Left(ServerError)
    }
}