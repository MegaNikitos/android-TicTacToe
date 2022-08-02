package com.example.tictactoe.ui.main_menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tictactoe.databinding.FragmentMainMenuBinding
import com.example.tictactoe.ui.base.BaseFragment
import com.example.tictactoe.ui.gameboard.GameboardFragment


class MainMenuFragment : BaseFragment() {

    private var binding : FragmentMainMenuBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnHotSit?.setOnClickListener{openFragment(GameboardFragment())}
    }
}