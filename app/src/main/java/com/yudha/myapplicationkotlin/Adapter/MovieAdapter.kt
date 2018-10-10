package com.yudha.myapplicationkotlin.Adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.yudha.myapplicationkotlin.Capture
import com.yudha.myapplicationkotlin.Data.Movie
import com.yudha.myapplicationkotlin.R
import kotlinx.android.synthetic.main.movie_list.view.*

class MovieAdapter(val movies : List<Movie>, val ctx : Context) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies.get(position))
        holder.setCtx(ctx)

    }

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent, false)
        return MovieViewHolder(view)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var view : View = itemView
        private var movie : Movie? = null
        lateinit var context : Context

        override fun onClick(p0: View?) {
            Toast.makeText(view.context, "Item diklik "+movie!!.title, Toast.LENGTH_LONG).show()


        }

        init {
            itemView.setOnClickListener(this)
        }

        fun setCtx(ctx:Context){
            this.context=ctx
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