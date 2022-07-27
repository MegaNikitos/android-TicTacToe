package com.example.tictactoe

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun setActiveFragments (view : View){
        var fragment : Fragment? = null

        when (view.getId()){
            R.id.viewGameboardBtn -> fragment = GameboardFragment()
            R.id.viewWinnerBtn -> fragment = WinnerViewFragment()
            else -> {}
        }

        val fragmentManager : FragmentManager = getSupportFragmentManager()
        var fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        if (fragment != null) {
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.commit()
        }
    }
}