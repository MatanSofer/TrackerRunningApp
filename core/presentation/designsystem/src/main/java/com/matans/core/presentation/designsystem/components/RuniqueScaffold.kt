package com.matans.core.presentation.designsystem.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RuniqueScaffold(
    modifier: Modifier = Modifier,
    widthGradient: Boolean = true,
    topAppBar: @Composable () -> Unit ={},
    floatingActionButton: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold (
        topBar = topAppBar,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = FabPosition.Center,
        modifier = modifier
    ){padding ->
        if(widthGradient){
            GradientBackground {
                content(padding)
            }
        } else {
            content(padding)
        }

    }
}