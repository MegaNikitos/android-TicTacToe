package com.example.tictactoe.ui.gameboard

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tictactoe.R
import com.example.tictactoe.databinding.FragmentGameboardBinding
import com.example.tictactoe.ui.view_winner_menu.WinnerViewFragment

class GameboardFragment : Fragment() {

    private var binding : FragmentGameboardBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGameboardBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        object : CountDownTimer(2000, 1000) {

            override fun onTick(millisUntilFinished: Long) { }

            override fun onFinish() {
                openFragment(WinnerViewFragment())
            }
        }.start()
    }

    private fun openFragment(fragment : Fragment){
        val fm = fragmentManager ?: return
        val fragmentTransaction = fm.beginTransaction()

        fragmentTransaction.replace(R.id.container_fragments, fragment)
        fragmentTransaction.commit()
    }
}