package com.dashingqi.dqcomposeapp.ui.screen

/**
 * @desc : 主框架
 * @author : zhangqi
 * @time : 2023/8/26 11:39
 */
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dashingqi.dqcomposeapp.model.entity.BottomNavigationItemEntity
import com.google.accompanist.insets.ProvideWindowInsets

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainFrame() {

    val items by lazy {
        listOf(
            BottomNavigationItemEntity(
                title = "学习", icon = Icons.Default.Home
            ), BottomNavigationItemEntity(
                title = "任务", icon = Icons.Default.DateRange
            ), BottomNavigationItemEntity(
                title = "我的", icon = Icons.Default.Person
            )
        )
    }

    var currentNavigationState by remember {
        mutableIntStateOf(0)
    }
    ProvideWindowInsets {
        Scaffold(bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                modifier = Modifier.navigationBarsPadding()
            ) {
                items.forEachIndexed { index, bottomNavigationItem ->
                    NavigationBarItem(
                        selected = currentNavigationState == index,
                        onClick = {
                            currentNavigationState = index
                        },
                        icon = {
                            Icon(
                                imageVector = bottomNavigationItem.icon, contentDescription = null
                            )
                        },
                        label = {
                            Text(text = bottomNavigationItem.title)
                        },
                        alwaysShowLabel = false,
                    )
                }
            }
        }){
            when (currentNavigationState) {
                0 -> StudyScreen()
                1 -> TaskScreen()
                2 -> MineScreen()
            }
        }
    }
}

@Preview
@Composable
fun MainFramePreview() {
    MainFrame()
}

