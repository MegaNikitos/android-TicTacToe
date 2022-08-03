package com.example.tictactoe.ui.view_winner_menu

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tictactoe.R
import com.example.tictactoe.databinding.FragmentWinnerViewBinding
import com.example.tictactoe.ui.base.BaseFragment
import com.example.tictactoe.ui.main_menu.MainMenuFragment

class WinnerViewFragment : BaseFragment() {

    private var binding : FragmentWinnerViewBinding? = null

    companion object{
        private val DATA = "key"

        fun newInstance(row : String) : WinnerViewFragment{
            val bundle = Bundle()

            bundle.putString(DATA, row)
            val fragment = WinnerViewFragment()
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWinnerViewBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments?.getString(DATA) ?: ""
        binding?.textWinner?.setText("$args")

        binding?.btnReturnMainmenu?.setOnClickListener{openFragment(MainMenuFragment())}
    }
}

