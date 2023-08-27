package com.dashingqi.dqcomposeapp.model.entity

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * @desc :
 * @author : zhangqi
 * @time : 2023/8/26 11:40
 */
data class BottomNavigationItemEntity(
    /** 标题*/
    val title: String,
    /** 图标*/
    val icon: ImageVector
)
