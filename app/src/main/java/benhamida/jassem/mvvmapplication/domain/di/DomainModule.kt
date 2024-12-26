package benhamida.jassem.mvvmapplication.domain.di

import benhamida.jassem.mvvmapplication.domain.usecase.top_rated_movies.GetTopRatedMoviesUseCase
import benhamida.jassem.mvvmapplication.domain.usecase.top_rated_movies.GetTopRatedMoviesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsGetTopRatedMoviesUseCase(getMovieListUseCaseImpl: GetTopRatedMoviesUseCaseImpl): GetTopRatedMoviesUseCase
}