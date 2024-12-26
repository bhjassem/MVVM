package benhamida.jassem.mvvmapplication.data.api

import benhamida.jassem.mvvmapplication.data.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page: Int = 1,
        @Query("api_key") key: String
    ): MovieResponse
}