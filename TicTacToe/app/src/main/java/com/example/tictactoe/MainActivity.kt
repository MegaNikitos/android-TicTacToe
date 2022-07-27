package com.example.tictactoe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tictactoe.databinding.ActivityMainBinding
import com.example.tictactoe.ui.main_menu.MainMenuFragment

class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        openFragment(MainMenuFragment())
    }

    private fun openFragment(fragment : Fragment){
        val fragmentManager = getSupportFragmentManager()
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.container_fragments, fragment)
        fragmentTransaction.commit()
    }
}