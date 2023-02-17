package com.example.hiloapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiloapp.MainActivity
import com.example.hiloapp.MainViewModel
import com.example.hiloapp.PlayerItem
import com.example.hiloapp.R
import com.example.hiloapp.adapters.PlayerEnterAdapter
import com.example.hiloapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: PlayerEnterAdapter
    private val model: MainViewModel by activityViewModels()
    private var counter=0
    lateinit var list: ArrayList<PlayerItem>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentMainBinding.inflate(inflater, container, false)
        val list=ArrayList<PlayerItem>()

        binding.AddButton.setOnClickListener {
            counter++
            list.add(PlayerItem(binding.editTextPersonName.text.toString(),0,counter))
            model.liveDataCountOfPlayers.value=PlayerItem(binding.editTextPersonName.text.toString(),0,counter)
            model.liveDataList.value=list
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        println("start")
        val list=ArrayList<PlayerItem>()
//        var i=0
//        while (i<model.liveDataList.value.size)
        println(model.liveDataList.value.isNullOrEmpty())
        binding.startButton.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_mainFragment_to_gameFragment)
        }

    }

    override fun onResume() {
        super.onResume()
        println("resume")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateCurrentCard()
    }

    private fun updateCurrentCard()= with(binding){
        model.liveDataCountOfPlayers.observe(viewLifecycleOwner){
            binding.playerCountTextview.text=it.id.toString()
        }
        model.liveDataList.observe(viewLifecycleOwner){
            initRcView()
            adapter.submitList(it)
        }
    }


    private fun initRcView()= with(binding){
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter= PlayerEnterAdapter()
        rcView.adapter=adapter

    }


    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}