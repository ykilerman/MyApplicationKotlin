package com.yudha.myapplicationkotlin.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.yudha.myapplicationkotlin.Data.Movie
import com.yudha.myapplicationkotlin.R
import kotlinx.android.synthetic.main.movie_list.view.*

internal class MovieAdapter(val movies : List<Movie>,val listener: (Movie) -> Unit ) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies.get(position))
    }

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent, false)
        return MovieViewHolder(view)
    }

    internal inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var view : View = itemView
        private var movie : Movie? = null

        override fun onClick(p0: View?) {
            listener(movie!!)
        }

        init {
            itemView.setOnClickListener(this)
        }


        fun bind(movie: Movie) {
            this.movie = movie
            val imageUrl = StringBuilder()
            imageUrl.append("").append(movie.image)
            if (imageUrl.isNotEmpty()) {
                Glide.with(view.context).load(imageUrl.toString()).into(view.bannerEvent)
            }
            view.txtEventTitle.setText(movie.title);
            view.txtEventDescription.setText(movie.desc);
            view.txtEventTanggal.setText(movie.start);

        }
    }
}