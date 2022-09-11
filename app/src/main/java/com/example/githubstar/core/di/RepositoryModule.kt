package com.example.githubstar.core.di

import com.example.githubstar.feature.search.data.*
import dagger.*
import dagger.hilt.*
import dagger.hilt.android.components.*

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindSearchRepository(
        repository: DefaultSearchRepository
    ): SearchRepository
}