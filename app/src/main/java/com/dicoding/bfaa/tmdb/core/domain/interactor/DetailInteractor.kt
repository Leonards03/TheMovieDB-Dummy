package com.dicoding.bfaa.tmdb.core.domain.interactor

import com.dicoding.bfaa.tmdb.core.domain.model.Movie
import com.dicoding.bfaa.tmdb.core.domain.model.TvShow
import com.dicoding.bfaa.tmdb.core.domain.repository.Repository
import com.dicoding.bfaa.tmdb.core.domain.usecase.DetailUseCase
import javax.inject.Inject

class DetailInteractor @Inject constructor(
    private val repository: Repository,
) : DetailUseCase {
    override fun getMovieDetails(id: Int) = repository.fetchMovie(id)
    override fun getTvShowDetails(id: Int) = repository.fetchTvShow(id)

    override fun setFavorite(movie: Movie, state: Boolean) = repository.setFavorite(movie, state)

    override fun setFavorite(tvShow: TvShow, state: Boolean) {

    }
}