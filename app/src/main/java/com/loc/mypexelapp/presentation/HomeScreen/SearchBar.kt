package com.loc.mypexelapp.presentation.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loc.mypexelapp.R
import com.loc.mypexelapp.ui.theme.MyPexelAppTheme
import com.loc.mypexelapp.ui.theme.Typography2

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit
) {
    val focusManager = LocalFocusManager.current

    var actualeQuery by remember {
        mutableStateOf("")
    }

    TextField(
        value = actualeQuery,
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.extraLarge),
        textStyle = MaterialTheme.typography.bodySmall,
        onValueChange = { newValue ->
            actualeQuery = newValue
            onQueryChange(newValue)
        },
        placeholder = {
            Text("Search", style = MaterialTheme.typography.bodySmall)
        },
        leadingIcon = {
            Icon(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .size(19.dp),
                tint = Color.Unspecified,
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Search Icon"
            )
        },
        trailingIcon = {
            if (actualeQuery.isNotEmpty()) {
                IconButton(onClick = {
                    actualeQuery = ""
                    onQueryChange("")
                    onSearch()
                }) {
                    Icon(painter = painterResource(R.drawable.ic_close), contentDescription = "Clear Search")
                }
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch()
                focusManager.clearFocus()
            }
        ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        interactionSource = remember { MutableInteractionSource() },
        singleLine = true
    )
}

@Preview
@Composable
private fun Test() {
    MyPexelAppTheme {
        //SearchBar("", {}, {})
    }
}