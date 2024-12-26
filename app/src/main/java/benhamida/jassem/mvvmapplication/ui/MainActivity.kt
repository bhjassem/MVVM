package benhamida.jassem.mvvmapplication.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import benhamida.jassem.mvvmapplication.domain.model.Movie
import benhamida.jassem.mvvmapplication.ui.common.AppLoader
import benhamida.jassem.mvvmapplication.ui.common.AppTopBar
import benhamida.jassem.mvvmapplication.ui.common.MovieItem
import benhamida.jassem.mvvmapplication.ui.theme.MVVMApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp(mainViewModel : HomeViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            AppTopBar()
        },
        modifier = Modifier.fillMaxSize(),
    ) { innerPaddings ->
        Box(
            modifier = Modifier.padding(innerPaddings)
        ) {
            val movieList: LazyPagingItems<Movie> =
                mainViewModel.topRatedMoviesListState.collectAsLazyPagingItems()


            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                if (movieList.loadState.refresh is LoadState.Loading) {
                    AppLoader()
                } else {
                    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                        items(movieList.itemCount) { movieItemIndex ->
                            val movie = movieList[movieItemIndex]
                            val mContext = LocalContext.current
                            movie?.let { current ->
                                MovieItem(movie = current) {
                                    Toast.makeText(mContext, current.title, Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
