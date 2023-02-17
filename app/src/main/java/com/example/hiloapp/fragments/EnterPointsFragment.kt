package com.example.hiloapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import com.example.hiloapp.MainViewModel
import com.example.hiloapp.adapters.PlayerAdapter
import com.example.hiloapp.databinding.FragmentEnterPointsBinding

class EnterPointsFragment(): DialogFragment() {
    private lateinit var binding: FragmentEnterPointsBinding
    private lateinit var adapter: PlayerAdapter
    private val model: MainViewModel by activityViewModels()
    private var i=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEnterPointsBinding.inflate(inflater, container, false)
        adapter= PlayerAdapter()
        adapter.submitList(model.liveDataList.value)

        nextPlayer()
        binding.EnterPointsButton.setOnClickListener {
            model.liveDataList.value!![i].points+=binding.editTextNumber.text.toString().toInt()
            i++


            if(i==adapter.itemCount){
                val result = "result"
                setFragmentResult("requestKey", bundleOf("bundleKey" to result))
                dismiss()
                }
            else{
                    nextPlayer()
                }

           }


        return binding.root
    }

    private fun nextPlayer(){
        binding.PlayerNameTextView.text=adapter.currentList[i].name

    }

    companion object {
        @JvmStatic
        fun newInstance() = EnterPointsFragment()
    }
}