package com.example.customadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter : RecyclerView.Adapter<PostAdapter.ViewHolder>(){

    interface OnClickPostListener{
        fun removeItem()
    }
  /*  private lateinit var listener : OnClickPostListener

    fun setListener(listener: OnClickPostListener){
        this.listener = listener
    }*/

    var postList = mutableListOf<PostData>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post,parent,false)
        return ViewHolder(view)
    }

    fun addPost(postData: PostData){
        postList.add(postData)
        notifyDataSetChanged()
    }

    fun removePost(itemPosition:Int){
        postList.removeAt((itemPosition))
        notifyItemRemoved(itemPosition)
        notifyItemRangeChanged(itemPosition,postList.size)
    }

    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(postList[position])
    }

   inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(postData: PostData){
            itemView.tvTitulo.text = postData.titulo
            itemView.tvFecha_publicacion.text = postData.fecha_pub

            itemView.tvFecha_publicacion.setOnClickListener {
                onClickDeletePost(adapterPosition)
            }

        }

        private fun onClickDeletePost(position:Int){
            removePost(position)
        }
    }
}