package com.example.githubstar.core.interactor

import com.example.githubstar.core.exception.*
import com.example.githubstar.core.functional.*
import kotlinx.coroutines.*

abstract class AsyncUseCase<in InputParams, out FinalResult>(
    private val dispatcher: CoroutineDispatcher
) where InputParams : Any, FinalResult : Any {

    abstract suspend fun execute(params: InputParams): Either<Failure, FinalResult>

    suspend operator fun invoke(
        params: InputParams
    ): Either<Failure, FinalResult> =
        withContext(dispatcher) {
            execute(params)
        }

}