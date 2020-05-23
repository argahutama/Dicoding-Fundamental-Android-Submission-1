package com.dicoding.arga.fundamentalandroid.submission1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUserActivity : AppCompatActivity() {
    companion object{
        const val DATA = "DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val user = intent.getParcelableExtra(DATA) as User
        img_user.setImageResource(user.avatar)
        txt_username.text = user.username
        txt_name.text = user.name
        txt_company.text = user.company
        txt_location.text = user.location
        txt_repository.text = user.repository
        txt_followers.text = user.followers
        txt_following.text = user.following
    }
}