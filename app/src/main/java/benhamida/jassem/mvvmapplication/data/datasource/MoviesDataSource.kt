package benhamida.jassem.mvvmapplication.data.datasource

import benhamida.jassem.mvvmapplication.data.response.MovieResponse

interface MoviesDataSource {

    suspend fun getTopRatedMovies(page: Int): MovieResponse
}