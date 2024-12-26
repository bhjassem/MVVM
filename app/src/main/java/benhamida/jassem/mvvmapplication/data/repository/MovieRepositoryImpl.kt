package benhamida.jassem.mvvmapplication.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import benhamida.jassem.mvvmapplication.data.datasource.PAGING_LIMIT
import benhamida.jassem.mvvmapplication.data.repository.paging.TopRatedMoviesPagingSource
import benhamida.jassem.mvvmapplication.domain.model.Movie
import benhamida.jassem.mvvmapplication.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private const val PREFETCH_DISTANCE = 50
class MovieRepositoryImpl @Inject constructor(
    private val topRatedMoviesPagingSource: TopRatedMoviesPagingSource
) : MovieRepository {

    override suspend fun getTopRatedMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = PAGING_LIMIT, prefetchDistance = PREFETCH_DISTANCE),
            pagingSourceFactory = {
                topRatedMoviesPagingSource
            }
        ).flow
    }
}