package com.example.tictactoe.ui.gameboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.tictactoe.R
import com.example.tictactoe.databinding.FragmentGameboardBinding
import com.example.tictactoe.ui.base.BaseFragment
import com.example.tictactoe.ui.view_winner_menu.WinnerViewFragment
import java.util.concurrent.atomic.AtomicBoolean

class GameboardFragment : BaseFragment() {

    private var binding : FragmentGameboardBinding? = null

    private lateinit var conditions: Array<CellState>
    private lateinit var currentState: CellState

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGameboardBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startGame()

        binding?.cell1?.setOnClickListener{onCellClick(1)}
        binding?.cell2?.setOnClickListener{onCellClick(2)}
        binding?.cell3?.setOnClickListener{onCellClick(3)}
        binding?.cell4?.setOnClickListener{onCellClick(4)}
        binding?.cell5?.setOnClickListener{onCellClick(5)}
        binding?.cell6?.setOnClickListener{onCellClick(6)}
        binding?.cell7?.setOnClickListener{onCellClick(7)}
        binding?.cell8?.setOnClickListener{onCellClick(8)}
        binding?.cell9?.setOnClickListener{onCellClick(9)}
    }

    private fun startGame() {
        conditions = Array<CellState>(10){ CellState.None }
        currentState = CellState.Zero

        switchPlayer()
    }

    fun onCellClick(index : Int){
        conditions[index] = currentState
        currentState = if (currentState == CellState.Cross) CellState.Zero else CellState.Cross
        when (index) {
            1 -> {
                if(currentState == CellState.Zero) binding?.cell1?.setImageResource(R.drawable.image_zero)
                else binding?.cell1?.setImageResource(R.drawable.image_cross)
            }

            2 -> {
                if(currentState == CellState.Zero) binding?.cell2?.setImageResource(R.drawable.image_zero)
                else binding?.cell2?.setImageResource(R.drawable.image_cross)
            }

            3 -> {
                if(currentState == CellState.Zero) binding?.cell3?.setImageResource(R.drawable.image_zero)
                else binding?.cell3?.setImageResource(R.drawable.image_cross)
            }

            4 -> {
                if(currentState == CellState.Zero) binding?.cell4?.setImageResource(R.drawable.image_zero)
                else binding?.cell4?.setImageResource(R.drawable.image_cross)
            }

            5 -> {
                if(currentState == CellState.Zero) binding?.cell5?.setImageResource(R.drawable.image_zero)
                else binding?.cell5?.setImageResource(R.drawable.image_cross)
            }

            6 -> {
                if(currentState == CellState.Zero) binding?.cell6?.setImageResource(R.drawable.image_zero)
                else binding?.cell6?.setImageResource(R.drawable.image_cross)
            }

            7 -> {
                if(currentState == CellState.Zero) binding?.cell7?.setImageResource(R.drawable.image_zero)
                else binding?.cell7?.setImageResource(R.drawable.image_cross)
            }

            8 -> {
                if(currentState == CellState.Zero) binding?.cell8?.setImageResource(R.drawable.image_zero)
                else binding?.cell8?.setImageResource(R.drawable.image_cross)
            }

            9 -> {
                if(currentState == CellState.Zero) binding?.cell9?.setImageResource(R.drawable.image_zero)
                else binding?.cell9?.setImageResource(R.drawable.image_cross)
            }
        }

        switchPlayer()
    }

    private fun switchPlayer(){
        if(currentState == CellState.Zero) {
            binding?.textUpperMove?.setText("Ходит Крестик!")
            binding?.textLowerMove?.setText("Ходит Крестик!")
        }

        if(currentState == CellState.Cross) {
            binding?.textUpperMove?.setText("Ходит Нолик!")
            binding?.textLowerMove?.setText("Ходит Нолик!")
        }
    }
}

enum class CellState(@DrawableRes val icon: Int, val isClicable : Boolean) {
    None(0, true),
    Zero(R.drawable.image_zero, false),
    Cross(R.drawable.image_cross, false)
}