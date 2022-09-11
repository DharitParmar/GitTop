package com.example.githubstar.core.exception

sealed class Failure() {
    object NetworkError: Failure()
    object ServerError: Failure()
}