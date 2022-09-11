package com.example.githubstar.feature.search.data

import com.example.githubstar.core.exception.Failure
import com.example.githubstar.core.functional.*
import com.example.githubstar.feature.search.data.models.*

interface SearchRepository {

    suspend fun getTopGitRepoByOrg(org: String): Either<Failure, GitTopRepos>

}