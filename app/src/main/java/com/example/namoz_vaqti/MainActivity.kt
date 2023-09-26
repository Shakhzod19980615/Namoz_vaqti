package com.example.namoz_vaqti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

import com.example.namoz_vaqti.databinding.ActivityMainBinding
import com.example.namoz_vaqti.ui.SplashFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fragmentContainerViewTag
        if (savedInstanceState == null) {
            replaceFragment(SplashFragment())
        }


    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.commit {
            replace(R.id.fragment_container_view_tag,fragment)
        }
    }


}