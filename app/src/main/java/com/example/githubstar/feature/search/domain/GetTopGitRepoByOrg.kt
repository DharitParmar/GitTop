package com.example.githubstar.feature.search.domain

import com.example.githubstar.core.exception.Failure
import com.example.githubstar.core.functional.*
import com.example.githubstar.core.interactor.*
import com.example.githubstar.feature.search.data.*
import com.example.githubstar.feature.search.data.models.*
import kotlinx.coroutines.*
import javax.inject.*

class GetTopGitRepoByOrg @Inject constructor(
    private val searchRepository: SearchRepository,
    dispatcher: CoroutineDispatcher
): AsyncUseCase<String, GitTopRepos>(dispatcher) {

    override suspend fun execute(params: String): Either<Failure, GitTopRepos> {
        return searchRepository.getTopGitRepoByOrg(params)
    }
}