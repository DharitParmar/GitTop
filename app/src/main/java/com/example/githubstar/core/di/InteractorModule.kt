package com.example.githubstar.core.di

import com.example.githubstar.core.interactor.*
import com.example.githubstar.feature.search.domain.*
import com.example.githubstar.feature.search.data.models.*
import dagger.*
import dagger.hilt.*
import dagger.hilt.android.components.*

@Module
@InstallIn(ViewModelComponent::class)
abstract class InteractorProvideModule {

    @Binds
    abstract fun bindGetGitTopReposBYOrg(
        interactor: GetTopGitRepoByOrg
    ): AsyncUseCase<String, GitTopRepos>
}