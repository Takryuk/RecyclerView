package com.app1.recyclerview

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.cardview.widget.CardView
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(foods: ArrayList<Food>,var context: Context) : RecyclerView.Adapter<FoodAdapter.viewHolder>() {

    var foods:ArrayList<Food>

    init {
        this.foods = foods
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        println("recyclerview:" + R.id.list__foods) // recyclerview:2131165297
        println("context:" + context) // context:com.app1.recyclerview.MainActivity@e29ef0a
        println("parent:" + parent) //parent:androidx.recyclerview.widget.RecyclerView{28a9a9d VFED..... ......ID 0,0-1080,1731 #7f070071 app:id/list__foods}
//        println("ViewGroup:" + ViewGroup)
        println("viewType:" + viewType) //viewType:0



        var layout:View
        println("R.layout.food_item:" + R.layout.food_item) // R.id.food_item:2131361823
        println("R.layout.food_item+1:" + (R.layout.food_item+1)) // R.id.food_item:2131361824
        layout = LayoutInflater.from(context).inflate(R.layout.food_item, parent, false)

        println("layout:" + layout) // layout:androidx.cardview.widget.CardView{2666496 V.E...... ......I. 0,0-0,0 #7f07005b app:id/food_card}
        return viewHolder(layout)
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val itemData  = foods[position]

        println("position:" + position) //position:1
        println("holder:" + holder) //holder:viewHolder{b66da3f position=1 id=-1, oldPos=-1, pLpos:-1 no parent}

        holder.title.text = itemData.title
        holder.price.text = itemData.price
        holder.image.setImageResource(itemData?.image!!)
        holder.card.setOnClickListener{
            val alert = Dialog(context)
            alert.setContentView(R.layout.food_alert)

            val title = alert.findViewById<TextView>(R.id.alert_title)
            val price = alert.findViewById<TextView>(R.id.alert_price)
            val image = alert.findViewById<ImageView>(R.id.alert_image)
            val close = alert.findViewById<Button>(R.id.alert_close)


            title.text = itemData.title
            price.text = itemData.price
            image.setImageResource(itemData?.image!!)

            alert.show()

            close.setOnClickListener{
                alert.hide()
            }
        }

    }


    class viewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        val title: TextView
        val price:TextView
        val image: ImageView
        val card: CardView

        init{
            title = itemView.findViewById(R.id.food_title)
            price = itemView.findViewById(R.id.food_price)
            image = itemView.findViewById(R.id.food_image)
            card = itemView.findViewById(R.id.food_card)
        }
    }

}
