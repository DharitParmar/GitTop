package com.example.githubstar.feature.search.presentation

import android.widget.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.font.FontWeight.Companion
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.*
import com.example.githubstar.feature.search.presentation.SearchViewModel.SearchUiState
import com.example.githubstar.feature.search.data.models.*
import com.example.githubstar.R.*
import com.example.githubstar.core.exception.*
import com.example.githubstar.core.exception.Failure.*
import com.example.githubstar.feature.search.presentation.SearchViewModel.SearchUiState.*


@Composable
fun SearchScreen(viewModel: SearchViewModel = viewModel()) {
    val failure by viewModel.failureLive.observeAsState()
    ObserveFailure(failure = failure)

    val state = remember { mutableStateOf(TextFieldValue("")) }
    RenderSearchView(state, viewModel)

    val liveStatus by viewModel.searchUiState.observeAsState()
    ObserveSearchResult(liveStatus)
}

@Composable
private fun ObserveSearchResult(liveStatus: SearchUiState?) {
    liveStatus?.let { status ->
        when (status) {
            is ReposNotFound ->
                Toast.makeText(
                    LocalContext.current,
                    stringResource(string.git_repo_list_error),
                    Toast.LENGTH_LONG
                ).show()
            is Loading -> {}
            is RepoList -> {
                ListHeading()
                ItemList(status.list)
            }
        }
    }
}

@Composable
private fun ObserveFailure(failure: Failure?) {
    failure?.let {
        when (failure) {
            NetworkError ->
                Toast.makeText(
                    LocalContext.current,
                    stringResource(string.core_network_error_msg),
                    Toast.LENGTH_LONG
                ).show()
            ServerError ->
                Toast.makeText(
                    LocalContext.current,
                    stringResource(string.core_server_error_msg),
                    Toast.LENGTH_LONG
                ).show()
        }
    }
}

@Composable
private fun ListHeading() {
    Text(
        text = "Repo List",
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth(),
        fontSize = 20.sp,
        color = Color.Black,
    )
}

@Composable
private fun Loading() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun ItemList(list: List<TopRepo>) {
    LazyColumn {
        itemsIndexed(list) { index, item ->
            ListItem(item, isLastItem = index == list.size - 1)
        }
    }
}

@Composable
private fun ListItem(item: TopRepo, isLastItem: Boolean = false) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp)
    ) {
        ItemLabel(stringResource(string.git_repo_name, item.name))
        ItemLabel(stringResource(string.git_repo_discription, item.description))
        ItemLabel(stringResource(string.git_repo_score, item.score))

        if (!isLastItem) {
            Divider(
                modifier = Modifier.padding(top = 16.dp),
                color = Color.LightGray,
                thickness = 1.dp
            )
        } else {
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )
        }
    }
}

@Composable
private fun ItemLabel(text: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(24.dp)
            .padding(start = 16.dp, end = 16.dp),
        text = text,
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun RenderSearchView(state: MutableState<TextFieldValue>, viewModel: SearchViewModel) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    TextField(
        placeholder = { Text(text = "Enter organization name")},
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            IconButton(
                onClick = {
                    if (state.value != TextFieldValue("")) {
                        viewModel.loadTopGitRepos(state.value.text)
                        keyboardController?.hide()
                        focusManager.clearFocus(true)
                    }
                },
            ) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp),
                )
            }

        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        state.value =
                            TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp),
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = Color.Red,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}