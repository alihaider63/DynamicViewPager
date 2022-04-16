package com.haider.dynamicviewpager

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.haider.dynamicviewpager.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user1 = User("https://i.postimg.cc/MHVc1GGg/nordwood-themes-b-Jjs-Kb-To-Y34-unsplash.jpg","Ali haider")
        val user7 = User("https://i.postimg.cc/MHVc1GGg/nordwood-themes-b-Jjs-Kb-To-Y34-unsplash.jpg","Ali haider")
        val user2 = User("https://i.postimg.cc/MHVc1GGg/nordwood-themes-b-Jjs-Kb-To-Y34-unsplash.jpg","Ali haider")
        val user3 = User("https://i.postimg.cc/P5RtrjXD/clement-helardot-95-YRwf6-CNw8-unsplash.jpg","Waseem Khan")
        val user4 = User("https://i.postimg.cc/P5RtrjXD/clement-helardot-95-YRwf6-CNw8-unsplash.jpg","Waseem Khan")
        val user5 = User("https://i.postimg.cc/hPNySZFj/lauren-mancke-a-OC7-TSLb1o8-unsplash.jpg","Mohsin Hassan")
        val user6 = User("https://i.postimg.cc/hPNySZFj/lauren-mancke-a-OC7-TSLb1o8-unsplash.jpg","Mohsin Hassan")
        val userList1 = arrayListOf(user2,user3,user4,user6,user7)
        val userList2 = arrayListOf(user1,user2,user4,user5,user6,user7)
        val userList3 = arrayListOf(user1,user2,user3,user5,user6)
        val userList4 = arrayListOf(user1,user3,user4,user5,user6,user7)
        val whoReactedList = arrayListOf(
            WhoReacted("All",userList1),
            WhoReacted("\uD83D\uDE4C  2",userList1),
            WhoReacted("\uD83D\uDE1B  3",userList2),
            WhoReacted("\uD83E\uDDD1\u200D\uD83D\uDE92 2",userList3),
            WhoReacted("\uD83E\uDD84  2",userList3),
            WhoReacted("\uD83D\uDC4D  1",userList4),
            WhoReacted("\uD83D\uDE10  2",userList3),
            WhoReacted("\uD83D\uDE10  4",userList1),
        )



        binding.btn.setOnClickListener {
            val bottomSheet = WhoReactedBottomSheet.getNewInstance(whoReactedList)
            bottomSheet.show(supportFragmentManager, WhoReactedBottomSheet::class.java.simpleName)
        }
        
        
    }
}