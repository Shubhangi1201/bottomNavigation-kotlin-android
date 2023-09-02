package com.example.myapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController : NavController
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btmNav = findViewById<BottomNavigationView>(R.id.bottomNavigationId)
        btmNav.setOnItemReselectedListener {
            when(it.itemId){
                R.id.firstFragment ->{
                    loadFragment(FirstFragment())
                    true
                }

                R.id.secondFragment ->{
                    loadFragment(SecondFragment())
                    true
                }

                R.id.thirdFragment ->{
                    loadFragment(ThirdFragment())
                    true
                }
            }
        }


    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}