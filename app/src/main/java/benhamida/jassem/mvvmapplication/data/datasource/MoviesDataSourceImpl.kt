package benhamida.jassem.mvvmapplication.data.datasource

import benhamida.jassem.mvvmapplication.BuildConfig
import benhamida.jassem.mvvmapplication.data.api.MovieApi
import benhamida.jassem.mvvmapplication.data.response.MovieResponse
import javax.inject.Inject

const val PAGING_LIMIT = 20

class MoviesDataSourceImpl @Inject constructor(
    private val api: MovieApi
) : MoviesDataSource {

    override suspend fun getTopRatedMovies(page: Int): MovieResponse {
        return api.getTopRatedMovies(
            page = page,
            BuildConfig.API_KEY
        )
    }
}