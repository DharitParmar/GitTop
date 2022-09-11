package com.example.githubstar.feature.search.data.models

data class GitTopReposResponse(
    val incomplete_results: Boolean,
    val items: List<TopRepo>,
    val total_count: Int
)