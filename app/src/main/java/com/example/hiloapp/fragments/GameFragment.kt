package com.example.hiloapp.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiloapp.MainViewModel
import com.example.hiloapp.adapters.PlayerAdapter
import com.example.hiloapp.databinding.FragmentGameBinding


class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private lateinit var adapter: PlayerAdapter
    private val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        //initRcView()
        binding.EndRoundbutton.setOnClickListener {
            val dialog = EnterPointsFragment()
            dialog.show(parentFragmentManager,"f")
        }
        setFragmentResultListener("requestKey") { requestKey, bundle ->
            bundle.getString("bundleKey")
            updateData()
        }
        binding.Refreshbutton.setOnClickListener {
            var i = 0
            while (i < adapter.itemCount) {
                model.liveDataList.value!![i].points=0
                i++
            }

            updateData()
        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateData()
    }

    private fun updateData() {
        model.liveDataList.observe(viewLifecycleOwner) {
            initRcView()
            adapter.submitList(it)

        }
    }

    private fun initRcView() = with(binding) {
        rcView2.layoutManager = LinearLayoutManager(activity)
        adapter = PlayerAdapter()
        rcView2.adapter = adapter

    }

    companion object {

        @JvmStatic
        fun newInstance() = GameFragment()
    }
}