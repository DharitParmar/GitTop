package com.example.githubstar.feature.search.presentation

import androidx.lifecycle.*
import com.example.githubstar.core.platform.*
import com.example.githubstar.feature.search.presentation.SearchViewModel.SearchUiState.ReposNotFound
import com.example.githubstar.feature.search.presentation.SearchViewModel.SearchUiState.Loading
import com.example.githubstar.feature.search.presentation.SearchViewModel.SearchUiState.RepoList
import com.example.githubstar.feature.search.domain.*
import com.example.githubstar.feature.search.data.models.*
import dagger.hilt.android.lifecycle.*
import kotlinx.coroutines.*
import javax.inject.*

@HiltViewModel
class SearchViewModel @Inject constructor(
    val getTopGitRepoByOrg: GetTopGitRepoByOrg
): BaseViewModel() {

    val searchUiState: LiveData<SearchUiState> =
        MutableLiveData()

    fun loadTopGitRepos(text: String) {
        viewModelScope.launch {
            searchUiState.postValue(Loading)

            getTopGitRepoByOrg(text).fold(::handleFailure, ::handleSearchResult)
        }
    }

    private fun handleSearchResult(gitTopRepos: GitTopRepos) {
        if(gitTopRepos.list.isEmpty()) {
            ReposNotFound
        } else {
            RepoList(gitTopRepos.list)
        }.also {  searchUiState.postValue(it) }
    }

    sealed class SearchUiState {
        object Loading: SearchUiState()
        object ReposNotFound: SearchUiState()
        data class RepoList(val list: List<TopRepo>): SearchUiState()
    }
}
