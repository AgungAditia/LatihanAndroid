package com.agungaditia.latihanandroid.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.agungaditia.latihanandroid.R
import com.agungaditia.latihanandroid.databinding.FragmentHomeNavBinding


class HomeNavFragment : Fragment() {

    private var _binding: FragmentHomeNavBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home_nav, container, false)
        _binding = FragmentHomeNavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnCategory.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeNavFragment_to_categoryNavFragment)
        }

        binding.btnProfile.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_homeNavFragment_to_profileNavActivity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}