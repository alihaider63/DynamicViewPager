package com.haider.dynamicviewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ReactorsListAdapter(private val users: ArrayList<User>, private val context: Context): RecyclerView.Adapter<DynamicViewHolder>() {

    override fun onBindViewHolder(holder: DynamicViewHolder, position: Int) {
        holder.bind(users[position], context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DynamicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view_who_reacted_user, parent,false)
        return DynamicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

}

class DynamicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val userDp: ImageView = itemView.findViewById(R.id.user_dp)
    private val userName: TextView = itemView.findViewById(R.id.user_name)

    fun bind(user: User, context: Context) {
        Glide.with(context).load(user.userDp).into(userDp)
        userName.text = user.userName
    }
}