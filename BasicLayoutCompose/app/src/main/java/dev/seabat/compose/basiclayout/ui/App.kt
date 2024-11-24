package dev.seabat.compose.basiclayout.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import dev.seabat.compose.basiclayout.ui.theme.BasicLayoutComposeTheme

@Composable
fun App(windowSize: WindowSizeClass) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            AppPortrait()
        }
        WindowWidthSizeClass.Expanded -> {
            AppLandscape()
        }
    }
}

@Composable
fun AppPortrait() {
    BasicLayoutComposeTheme {
        Scaffold(
            bottomBar = { BottomNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

@Composable
fun AppLandscape() {
    BasicLayoutComposeTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                NavigationRail()
                HomeScreen()
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_7)
@Composable
fun AppPortraitPreview() {
    AppPortrait()
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun AppPortraitSmallPreview() {
    AppPortrait()
}

@Preview(device = Devices.PIXEL_TABLET)
@Composable
fun AppLandscapePreview() {
    AppLandscape()
}