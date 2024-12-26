package benhamida.jassem.mvvmapplication.repository

import androidx.paging.PagingSource
import androidx.paging.map
import benhamida.jassem.mvvmapplication.common.listOfMovies
import benhamida.jassem.mvvmapplication.domain.model.Movie
import benhamida.jassem.mvvmapplication.domain.repository.MovieRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test


class MovieRepositoryUnitTest {

    @Test
    fun `getTopRatedMovies emits PagingData with expected items`() = runTest {
        val repository = mockk<MovieRepository>()
        coEvery { repository.getTopRatedMovies() } returns flow {
            PagingSource.LoadResult.Page(
                listOfMovies, 1, 1
            )
        }

        val collectedItems = mutableListOf<Movie>()
        repository.getTopRatedMovies().collect { pagingData ->

            pagingData.map { item ->
                collectedItems.add(item)
            }

            assertNotNull(collectedItems)
            assertEquals(3, collectedItems.size)
        }
    }

    @Test
    fun `getTopRatedMovies emits PagingData with empty data`() = runTest {
        val repository = mockk<MovieRepository>()
        coEvery { repository.getTopRatedMovies() } returns flow {
            PagingSource.LoadResult.Page(
                listOf(), 1, 1
            )
        }

        val collectedItems = mutableListOf<Movie>()
        repository.getTopRatedMovies().collect { pagingData ->

            pagingData.map { item ->
                collectedItems.add(item)
            }

            assertNotNull(collectedItems)
            assertEquals(0, collectedItems.size)
        }
    }
}