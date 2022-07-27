package com.example.tictactoe.ui.view_winner_menu

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tictactoe.R
import com.example.tictactoe.databinding.FragmentWinnerViewBinding
import com.example.tictactoe.ui.gameboard.GameboardFragment
import com.example.tictactoe.ui.main_menu.MainMenuFragment

class WinnerViewFragment : Fragment() {

    private var binding : FragmentWinnerViewBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWinnerViewBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnReturnMainmenu?.setOnClickListener{openFragment(MainMenuFragment())}
    }

    private fun openFragment(fragment : Fragment){
        val fm = fragmentManager ?: return
        val fragmentTransaction = fm.beginTransaction()

        fragmentTransaction.replace(R.id.container_fragments, fragment)
        fragmentTransaction.commit()
    }
}