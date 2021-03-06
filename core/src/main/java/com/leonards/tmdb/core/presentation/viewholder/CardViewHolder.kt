package com.leonards.tmdb.core.presentation.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.leonards.tmdb.core.databinding.ItemRowLayoutBinding
import com.leonards.tmdb.core.domain.model.Movie
import com.leonards.tmdb.core.domain.model.TvShow
import com.leonards.tmdb.core.extension.glideImageWithOptions
import com.leonards.tmdb.core.utils.ImageSize

class CardViewHolder(private val binding: ItemRowLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie, imageSize: ImageSize, onItemClick: (movie: Movie) -> Unit) =
        with(binding) {
            tvTitle.text = movie.title
            imgPoster.glideImageWithOptions(movie.getPosterUrl(imageSize))

            cvItem.setOnClickListener { onItemClick(movie) }
            ratingBar.rating = movie.voteAverage.toFloat().div(2)
            tvRating.text = movie.voteAverage.toString()
            tvDate.text = movie.releaseDate
        }

    fun bind(tvShow: TvShow, imageSize: ImageSize, onItemClick: (tvShow: TvShow) -> Unit) =
        with(binding) {
            tvTitle.text = tvShow.title
            imgPoster.glideImageWithOptions(tvShow.getPosterUrl(imageSize))
            cvItem.setOnClickListener { onItemClick(tvShow) }
            ratingBar.rating = tvShow.voteAverage.toFloat().div(2)
            tvRating.text = tvShow.voteAverage.toString()
            tvDate.text = tvShow.firstAirDate
        }
}