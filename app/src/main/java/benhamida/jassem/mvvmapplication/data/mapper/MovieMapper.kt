package benhamida.jassem.mvvmapplication.data.mapper

import benhamida.jassem.mvvmapplication.data.entity.MovieEntity
import benhamida.jassem.mvvmapplication.domain.model.Movie

object MovieMapper : Mapper<MovieEntity, Movie> {
    override fun map(data: MovieEntity): Movie = Movie(
        id = data.id,
        adult = data.adult,
        backdropPath = data.backdropPath,
        genreIds = data.genreIds,
        originalLanguage = data.originalLanguage,
        originalTitle = data.originalTitle,
        overview = data.overview,
        popularity = data.popularity,
        posterPath = data.posterPath,
        releaseDate = data.releaseDate,
        title = data.title,
        video = data.video,
        voteAverage = data.voteAverage,
        voteCount = data.voteCount
    )
}