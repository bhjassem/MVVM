package benhamida.jassem.mvvmapplication.ui.common

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import benhamida.jassem.mvvmapplication.R
import benhamida.jassem.mvvmapplication.ui.theme.MVVMApplicationTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(stringResource(id = R.string.app_name), maxLines = 1, overflow = TextOverflow.Ellipsis)
        },
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}

@Preview(apiLevel = 34)
@Composable
fun AppTopBarPreview() {
    MVVMApplicationTheme {
        AppTopBar()
    }
}