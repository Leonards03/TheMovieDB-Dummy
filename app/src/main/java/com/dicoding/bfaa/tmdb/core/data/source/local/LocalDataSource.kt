package com.dicoding.bfaa.tmdb.core.data.source.local

import com.dicoding.bfaa.tmdb.core.data.mapper.mapToDomain
import com.dicoding.bfaa.tmdb.core.data.source.local.dao.TMDBDao
import com.dicoding.bfaa.tmdb.core.data.source.local.entity.MovieEntity
import com.dicoding.bfaa.tmdb.core.data.source.local.entity.TvShowEntity
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val tmdbDao: TMDBDao,
) {
    fun getFavoriteMovies() = tmdbDao.getFavoriteMovies()

    fun getFavoriteTvShows() = tmdbDao.getFavoriteTvShows()

    fun getFavoriteMovie(id: Int) =
        tmdbDao.getFavoriteMovie(id)
            .map { it?.mapToDomain() }

    fun getFavoriteTvShow(id: Int) = tmdbDao.getFavoriteTvShow(id)

    suspend fun addToFavorite(movie: MovieEntity) = tmdbDao.addToFavorite(movie)

    suspend fun addToFavorite(tvShow: TvShowEntity) = tmdbDao.addToFavorite(tvShow)

    suspend fun removeFromFavorite(movie: MovieEntity) = tmdbDao.removeFromFavorite(movie)

    suspend fun removeFromFavorite(tvShow: TvShowEntity) = tmdbDao.removeFromFavorite(tvShow)
}