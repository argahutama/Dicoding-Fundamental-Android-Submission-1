package com.dicoding.arga.fundamentalandroid.submission1

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
        private lateinit var adapter: UserAdapter
        private lateinit var username:Array<String>
        private lateinit var name:Array<String>
        private lateinit var location:Array<String>
        private lateinit var repository:Array<String>
        private lateinit var company:Array<String>
        private lateinit var followers:Array<String>
        private lateinit var following:Array<String>
        private lateinit var avatar:TypedArray
        private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listview : ListView = findViewById(R.id.lv_list)
        adapter = UserAdapter(this)
        listview.adapter = adapter

        prepare()
        init()

        listview.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intentWithExtraData = Intent(this@MainActivity, DetailUserActivity::class.java)
            intentWithExtraData.putExtra(DetailUserActivity.DATA,users[position])
            startActivity(intentWithExtraData)
        }
    }

    private fun prepare(){
        avatar = resources.obtainTypedArray(R.array.avatar)
        username = resources.getStringArray(R.array.username)
        name = resources.getStringArray(R.array.name)
        company = resources.getStringArray(R.array.company)
        location = resources.getStringArray(R.array.location)
        repository = resources.getStringArray(R.array.repository)
        followers = resources.getStringArray(R.array.followers)
        following = resources.getStringArray(R.array.following)
    }

    private fun init() {
        for (position in name.indices){
            val user = User(
                avatar.getResourceId(position, -1),
                username[position],
                name[position],
                company[position],
                location[position],
                repository[position],
                followers[position],
                following[position]
            )
            users.add(user)
        }
        adapter.users = users
    }
}