package com.example.kotlinfundamentels.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinfundamentels.R
import com.example.kotlinfundamentels.model.posts.PostsModel
import com.example.kotlinfundamentels.model.posts.PostsModelItem

class PostsAdapter(val postModel:PostsModel):RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {








 class PostsViewHolder( view:View):RecyclerView.ViewHolder(view){

  val postTitle = view.findViewById<TextView>(R.id.postTitle)
  val postBody= view.findViewById<TextView>(R.id.postBody)



  fun setPost(postsModelItem: PostsModelItem){

   postTitle.text = postsModelItem.title
   postBody.text = postsModelItem.body




  }





 }

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {

  val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item,parent,false)

  return PostsViewHolder(view)
 }

 override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
  val postModels = postModel.get(position)

  holder.setPost(postModels)


 }

 override fun getItemCount(): Int {
  return postModel.size
 }
}