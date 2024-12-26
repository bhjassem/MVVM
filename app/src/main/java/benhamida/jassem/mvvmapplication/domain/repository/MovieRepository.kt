package benhamida.jassem.mvvmapplication.domain.repository

import androidx.paging.PagingData
import benhamida.jassem.mvvmapplication.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getTopRatedMovies(): Flow<PagingData<Movie>>
}