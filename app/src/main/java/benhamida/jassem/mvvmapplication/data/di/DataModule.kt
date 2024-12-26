package benhamida.jassem.mvvmapplication.data.di

import benhamida.jassem.mvvmapplication.data.datasource.MoviesDataSource
import benhamida.jassem.mvvmapplication.data.datasource.MoviesDataSourceImpl
import benhamida.jassem.mvvmapplication.data.repository.MovieRepositoryImpl
import benhamida.jassem.mvvmapplication.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsMoviesDataSource(moviesDataSourceImpl: MoviesDataSourceImpl)
            : MoviesDataSource

    @Binds
    abstract fun bindsMoviesRepository(movieRepositoryImpl: MovieRepositoryImpl)
            : MovieRepository

}