package com.example.tictactoe.ui.view_winner_menu

import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tictactoe.R
import com.example.tictactoe.databinding.FragmentWinnerViewBinding
import com.example.tictactoe.ui.base.BaseFragment
import com.example.tictactoe.ui.gameboard.CellState
import com.example.tictactoe.ui.main_menu.MainMenuFragment

class WinnerViewFragment : BaseFragment() {

    private var binding : FragmentWinnerViewBinding? = null

    companion object{
        private val CURRENTSTATE = "CurrentState"
        private val VICTORYOPTION = "VictoryOption"

        fun newInstance(currentCellState: CellState? = null, victoryOption : Array<Int>? = null) : WinnerViewFragment{
            val bundle = Bundle()

            bundle.putSerializable(CURRENTSTATE, currentCellState)
            bundle.putSerializable(VICTORYOPTION, victoryOption)
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

        val currentState = arguments?.getSerializable(CURRENTSTATE) as? CellState
        val victoryOption = arguments?.getSerializable(VICTORYOPTION) as? Array<Int>

        when(currentState) {
            CellState.Cross -> {
                binding?.textWinner?.setText("Победил Крестик!")
            }

            CellState.Zero -> {
                binding?.textWinner?.setText("Победил Нолик!")
            }

            CellState.None -> {
                binding?.textWinner?.setText("Ничья!")
            }
        }

        if(currentState != CellState.None){
            var indexed = 0

            for(index in victoryOption?.withIndex()!!) {
                indexed = index.value
                when (indexed) {
                    0 -> {
                        if(currentState == CellState.Zero) binding?.cell1?.setImageResource(R.drawable.image_zero)
                        else binding?.cell1?.setImageResource(R.drawable.image_cross)
                    }

                    1 -> {
                        if(currentState == CellState.Zero) binding?.cell2?.setImageResource(R.drawable.image_zero)
                        else binding?.cell2?.setImageResource(R.drawable.image_cross)
                    }

                    2 -> {
                        if(currentState == CellState.Zero) binding?.cell3?.setImageResource(R.drawable.image_zero)
                        else binding?.cell3?.setImageResource(R.drawable.image_cross)
                    }

                    3 -> {
                        if(currentState == CellState.Zero) binding?.cell4?.setImageResource(R.drawable.image_zero)
                        else binding?.cell4?.setImageResource(R.drawable.image_cross)
                    }

                    4 -> {
                        if(currentState == CellState.Zero) binding?.cell5?.setImageResource(R.drawable.image_zero)
                        else binding?.cell5?.setImageResource(R.drawable.image_cross)
                    }

                    5 -> {
                        if(currentState == CellState.Zero) binding?.cell6?.setImageResource(R.drawable.image_zero)
                        else binding?.cell6?.setImageResource(R.drawable.image_cross)
                    }

                    6 -> {
                        if(currentState == CellState.Zero) binding?.cell7?.setImageResource(R.drawable.image_zero)
                        else binding?.cell7?.setImageResource(R.drawable.image_cross)
                    }

                    7 -> {
                        if(currentState == CellState.Zero) binding?.cell8?.setImageResource(R.drawable.image_zero)
                        else binding?.cell8?.setImageResource(R.drawable.image_cross)
                    }

                    8 -> {
                        if(currentState == CellState.Zero) binding?.cell9?.setImageResource(R.drawable.image_zero)
                        else binding?.cell9?.setImageResource(R.drawable.image_cross)
                    }
                }
            }
        }
        else{
            binding?.cell1?.setImageResource(R.drawable.image_zero)
            binding?.cell2?.setImageResource(R.drawable.image_cross)
            binding?.cell3?.setImageResource(R.drawable.image_zero)

            binding?.cell4?.setImageResource(R.drawable.image_cross)
            binding?.cell5?.setImageResource(R.drawable.image_zero)
            binding?.cell6?.setImageResource(R.drawable.image_cross)

            binding?.cell7?.setImageResource(R.drawable.image_zero)
            binding?.cell8?.setImageResource(R.drawable.image_cross)
            binding?.cell9?.setImageResource(R.drawable.image_zero)
        }

        binding?.btnReturnMainmenu?.setOnClickListener{openFragment(MainMenuFragment())}
    }
}

