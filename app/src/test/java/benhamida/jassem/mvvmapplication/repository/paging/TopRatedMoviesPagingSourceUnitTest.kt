package benhamida.jassem.mvvmapplication.repository.paging

import androidx.paging.PagingSource
import benhamida.jassem.mvvmapplication.common.listOfMovieEntities
import benhamida.jassem.mvvmapplication.common.listOfMovies
import benhamida.jassem.mvvmapplication.data.datasource.MoviesDataSource
import benhamida.jassem.mvvmapplication.data.repository.paging.TopRatedMoviesPagingSource
import benhamida.jassem.mvvmapplication.data.response.MovieResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class TopRatedMoviesPagingSourceUnitTest {

    @MockK
    private lateinit var movieDataSource: MoviesDataSource
    private lateinit var topRatedMoviesPagingSource: TopRatedMoviesPagingSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        topRatedMoviesPagingSource = TopRatedMoviesPagingSource(movieDataSource)
    }

    @Test
    fun testTopRatedMoviesPagingSource_Positive() = runTest {

        coEvery { movieDataSource.getTopRatedMovies(1) } returns
                MovieResponse(1, 1, 1, listOfMovieEntities)


        val result = topRatedMoviesPagingSource.load(
            PagingSource.LoadParams.Refresh(key = null, loadSize = 1, placeholdersEnabled = false)
        )

        assertTrue(result is PagingSource.LoadResult.Page)
        val pageResult = result as PagingSource.LoadResult.Page
        assertEquals(listOfMovies, pageResult.data)
    }
}