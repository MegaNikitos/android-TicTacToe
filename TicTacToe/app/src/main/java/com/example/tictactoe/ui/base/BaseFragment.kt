package com.example.tictactoe.ui.base

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tictactoe.R
import com.example.tictactoe.databinding.BaseFragmentBinding

abstract class BaseFragment : Fragment() {

    private lateinit var viewModel: BaseViewModel
    private var binding : BaseFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = BaseFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BaseViewModel::class.java)
    }

    open fun openFragment(fragment : Fragment){
        val fm = fragmentManager ?: return
        val fragmentTransaction = fm.beginTransaction()

        fragmentTransaction.replace(R.id.container_fragments, fragment)
        fragmentTransaction.commit()
    }

}