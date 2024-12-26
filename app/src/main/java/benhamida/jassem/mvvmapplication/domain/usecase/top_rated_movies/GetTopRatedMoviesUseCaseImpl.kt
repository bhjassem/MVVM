package benhamida.jassem.mvvmapplication.domain.usecase.top_rated_movies

import androidx.paging.PagingData
import benhamida.jassem.mvvmapplication.domain.model.Movie
import benhamida.jassem.mvvmapplication.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopRatedMoviesUseCaseImpl @Inject constructor(
    private val repository: MovieRepository
) : GetTopRatedMoviesUseCase {
    override suspend fun invoke(): Flow<PagingData<Movie>> {
        return repository.getTopRatedMovies()
    }
}