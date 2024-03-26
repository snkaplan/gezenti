package com.gezenti.app.navigation

import com.gezenti.app.R
import com.gezenti.designsystem.icon.AppIcons
import com.gezenti.designsystem.icon.Icon
import com.gezenti.home.navigation.HomeNavigationRoute

enum class TopLevelDestination(
    val route: String,
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val titleTextId: Int,
) {
    HOME(
        route = HomeNavigationRoute,
        selectedIcon = Icon.ImageVectorIcon(AppIcons.Home),
        unselectedIcon = Icon.ImageVectorIcon(AppIcons.HomeOutlined),
        titleTextId = R.string.nav_home_title,
    ),
}
