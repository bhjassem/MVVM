package benhamida.jassem.mvvmapplication.ui

import androidx.paging.PagingSource
import androidx.paging.map
import benhamida.jassem.mvvmapplication.common.listOfMovies
import benhamida.jassem.mvvmapplication.domain.model.Movie
import benhamida.jassem.mvvmapplication.domain.usecase.top_rated_movies.GetTopRatedMoviesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class HomeViewModelTest {

    @Test
    fun `getTopRatedMovies emits PagingData with expected items`() = runTest {
        val useCase = mockk<GetTopRatedMoviesUseCase>()
        coEvery { useCase.invoke() } returns flow {
            PagingSource.LoadResult.Page(
                listOfMovies, 1, 1
            )
        }

        val collectedItems = mutableListOf<Movie>()
        useCase.invoke().collect { pagingData ->

            pagingData.map { item ->
                collectedItems.add(item)
            }

            assertNotNull(collectedItems)
            assertEquals(3, collectedItems.size)
        }
    }

    @Test
    fun `getTopRatedMovies emits PagingData with empty data`() = runTest {
        val useCase = mockk<GetTopRatedMoviesUseCase>()
        coEvery { useCase.invoke() } returns flow {
            PagingSource.LoadResult.Page(
                listOf(), 1, 1
            )
        }

        val collectedItems = mutableListOf<Movie>()
        useCase.invoke().collect { pagingData ->

            pagingData.map { item ->
                collectedItems.add(item)
            }

            assertNotNull(collectedItems)
            assertEquals(0, collectedItems.size)
        }
    }
}