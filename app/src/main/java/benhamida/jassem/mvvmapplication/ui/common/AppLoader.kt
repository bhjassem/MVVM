package benhamida.jassem.mvvmapplication.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import benhamida.jassem.mvvmapplication.R
import benhamida.jassem.mvvmapplication.ui.theme.MVVMApplicationTheme

@Composable
fun AppLoader() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(id = R.string.loading),
            fontSize = 16.sp,
            fontWeight = FontWeight.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        CircularProgressIndicator(
            modifier = Modifier.width(32.dp),
        )
    }
}

@Preview(apiLevel = 34)
@Composable
fun AppLoaderPreview() {
    MVVMApplicationTheme {
        AppLoader()
    }
}