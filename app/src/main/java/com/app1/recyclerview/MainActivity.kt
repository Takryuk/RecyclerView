package com.app1.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayData()
    }

    fun displayData(){
        val foods = ArrayList<Food>()
        foods.add(Food("Android Development", "49", R.drawable.food_item1))
        foods.add(Food("Android Development", "49", R.drawable.food_item2))
        foods.add(Food("Android Development", "49", R.drawable.food_item3))
        val adapter = FoodAdapter(foods, this@MainActivity)

        list__foods.layoutManager = GridLayoutManager(this@MainActivity, 1)
        list__foods.adapter = adapter
    }
}
