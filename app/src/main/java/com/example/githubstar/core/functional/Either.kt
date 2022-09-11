package com.example.githubstar.core.functional

sealed class Either<out L, out R> {
    // failure
    data class Left<out L>(val lv: L): Either<L, Nothing>()
    //success
    data class Right<out R>(val rv: R): Either<Nothing, R>()

    fun fold(fnLeft: (L) -> Any, fnRight: (R) -> Any) {
        when (this) {
            is Left -> fnLeft(lv)
            is Right -> fnRight(rv)
        }
    }
}