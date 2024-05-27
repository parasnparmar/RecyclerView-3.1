package com.example.recyclerviewdemo5

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlin.io.path.fileVisitor

class AdapterImplementation(private var posts: ArrayList<Post>,
                            private var advertisments: ArrayList<Advertisment>):RecyclerView.Adapter<ViewHolder>(){
                                interface OnClickPostListner{
                                        fun onClickPost(position:Int, post:Post)
                                }
            var OnClickPostListner1: OnClickPostListner? = null
            val TYPE_VIEW_POST = 1
            val TYPE_VIEW_ADVERTISMENT = 2

    inner class PostViewHolder(val view: View): RecyclerView.ViewHolder(view){
            var txtUsername : TextView
            var imagePost : ImageView
            var txtPostTitle : TextView
            init{
                txtUsername = view.findViewById(R.id.txtUsername)
                txtPostTitle = view.findViewById(R.id.txtTitle)
                imagePost = view.findViewById(R.id.imagePost)

                imagePost.setOnClickListener{
                    if(OnClickPostListner1!=null){
                        OnClickPostListner1!!.onClickPost(
                            adapterPosition-(adapterPosition)/3,
                            posts[adapterPosition-(adapterPosition)/3]
                        )
                        }
                    }
                }

            }

    interface OnClickAdvertismentListner{
        fun onClickAdvertisment(position:Int, advertisment: Advertisment)
    }
    var OnClickAdvertismentListner1: OnClickAdvertismentListner? = null


    inner class AdvertismentVIewHolder(val view:View): RecyclerView.ViewHolder(view){
        var txtAdvertismentTitle : TextView
        var txtAdvertismentUrl : TextView
        init {
            txtAdvertismentTitle = view.findViewById(R.id.txtAdvertismentTitle)
            txtAdvertismentUrl = view.findViewById(R.id.txtAdvertismentUrl)

            txtAdvertismentTitle.setOnClickListener {
                if(OnClickAdvertismentListner1!=null){
                    OnClickAdvertismentListner1!!.onClickAdvertisment(
                        adapterPosition/3,
                        advertisments[adapterPosition/3]
                    )
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if(viewType == TYPE_VIEW_POST){
            var layoutInflater = LayoutInflater.from(parent.context)
            var postView = layoutInflater.inflate(R.layout.activity_post,parent,false)
            PostViewHolder(postView)
        }else{
            var layoutInflater = LayoutInflater.from(parent.context)
            var advertismentView = layoutInflater.inflate(R.layout.activity_advertisment,parent,false)
            AdvertismentVIewHolder(advertismentView)
        }
    }

    override fun getItemCount(): Int {
        return posts.size + advertisments.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            if(holder is PostViewHolder){
                val post = posts[position-(position)/3]
                holder.txtUsername.text = post.username
                holder.txtPostTitle.text = post.postTitle
                holder.imagePost.setImageResource(post.imageId)
            }
        if(holder is AdvertismentVIewHolder){
            val advertisment = advertisments[position/3]
            holder.txtAdvertismentTitle.text = advertisment.title
            holder.txtAdvertismentUrl.text = advertisment.url
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if((position%3)==2){
                TYPE_VIEW_ADVERTISMENT
        }else{
            TYPE_VIEW_POST
        }
    }
}

