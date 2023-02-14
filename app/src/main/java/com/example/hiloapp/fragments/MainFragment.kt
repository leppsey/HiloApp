package com.example.hiloapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.hiloapp.R
import com.example.hiloapp.adapters.VpAdapter
import com.example.hiloapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val fList= listOf(EnterPlayerFragment.newInstance())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init()= with(binding){
        val adapter=VpAdapter(activity as FragmentActivity,fList)
        vp.adapter=adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}