package com.dashingqi.dqcomposeapp.ui.components

/**
 * @desc :
 * @author : zhangqi
 * @time : 2023/8/26 13:00
 */
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dashingqi.dqcomposeapp.ui.theme.Blue200
import com.dashingqi.dqcomposeapp.ui.theme.Blue700
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/** 标题栏高度*/
private val AppBarHeight = 56.dp


@Composable
fun DQTopAppbar(modifier: Modifier = Modifier,content: @Composable () -> Unit) {
    // 状态栏高度
    val statusBarHeightDP = with(LocalDensity.current) {
        20.dp
    }
    val systemUIController = rememberSystemUiController()
    LaunchedEffect(key1 = Unit) {
        //设置状态栏为透明
        systemUIController.setStatusBarColor(Color.Transparent)
    }
    Row(
        modifier = Modifier
            .background(Brush.linearGradient(listOf(Blue700, Blue200)))
            .fillMaxWidth()
            .height(AppBarHeight + statusBarHeightDP)
            .padding(top = statusBarHeightDP)
            .then(modifier),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Preview
@Composable
fun DQTopAppbarPreview() {
    DQTopAppbar() {
        Text(text = "标题")
    }
}

