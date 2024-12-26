package benhamida.jassem.mvvmapplication.domain.usecase.top_rated_movies

import androidx.paging.PagingData
import benhamida.jassem.mvvmapplication.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface GetTopRatedMoviesUseCase {
    suspend fun invoke(): Flow<PagingData<Movie>>
}