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
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

class GameboardFragment : BaseFragment() {

    private var binding : FragmentGameboardBinding? = null

    private lateinit var conditions : Array<CellState>
    private lateinit var currentState : CellState

    private val victoryOptions = arrayOf(
        arrayOf(0,1,2),
        arrayOf(0,4,8),
        arrayOf(0,3,6),
        arrayOf(1,4,7),
        arrayOf(2,5,8),
        arrayOf(2,4,6),
        arrayOf(3,4,5),
        arrayOf(6,7,8)
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGameboardBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startGame()

        binding?.cell1?.setOnClickListener{onCellClicked(0)}
        binding?.cell2?.setOnClickListener{onCellClicked(1)}
        binding?.cell3?.setOnClickListener{onCellClicked(2)}
        binding?.cell4?.setOnClickListener{onCellClicked(3)}
        binding?.cell5?.setOnClickListener{onCellClicked(4)}
        binding?.cell6?.setOnClickListener{onCellClicked(5)}
        binding?.cell7?.setOnClickListener{onCellClicked(6)}
        binding?.cell8?.setOnClickListener{onCellClicked(7)}
        binding?.cell9?.setOnClickListener{onCellClicked(8)}
    }

    private fun startGame() {
        conditions = Array<CellState>(9){ CellState.None }
        currentState = CellState.Zero

        switchPlayer()
    }

    private fun onCellClicked(index : Int){

        if(conditions[index] == CellState.None){
            conditions[index] = currentState
            currentState = if (currentState == CellState.Cross) CellState.Zero else CellState.Cross

            when (index) {
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

            if(checkVictory() != null){
                openFragment(WinnerViewFragment.newInstance("TEEEEXT"))
            }
            else if(checkNone()){
                openFragment(WinnerViewFragment.newInstance("None"))
            }

            switchPlayer()
        }
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

    private fun checkVictory() : Array<Int>? {
        victoryOptions.forEach {
            if(checkVictoryLine(it)) return it
        }

        return null
    }

    private fun checkVictoryLine(row : Array<Int>) : Boolean {
        val firstElement = conditions[row[0]]
        if(firstElement == CellState.None) return false

        row.forEach {
            if(firstElement != conditions[it]) return false
        }

        return true
    }

    private fun checkNone() : Boolean {
        return !conditions.contains(CellState.None)
    }
}

enum class CellState(@DrawableRes val icon: Int, val isClicable : Boolean) {
    None(0, true),
    Zero(R.drawable.image_zero, false),
    Cross(R.drawable.image_cross, false)
}