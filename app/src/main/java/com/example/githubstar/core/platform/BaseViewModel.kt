package com.example.githubstar.core.platform

import androidx.lifecycle.*
import com.example.githubstar.core.exception.*

open class BaseViewModel: ViewModel() {

    protected fun <T> LiveData<T>.postValue(value: T) {
        when (this) {
            is MutableLiveData<T> -> postValue(value)
            else -> throw ExceptionInInitializerError("Not using mutablelivedata")
        }
    }

    val failureLive: LiveData<Failure> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        failureLive.postValue(failure)
    }
}