package com.agungaditia.latihanandroid.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.agungaditia.latihanandroid.R
import com.agungaditia.latihanandroid.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCategory.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_category) {
            val categoryFragment = CategoryFragment()
            val fragmentManager = parentFragmentManager
//            fragmentManager.beginTransaction().apply {
//                replace(
//                    R.id.frame_container,
//                    categoryFragment,
//                    CategoryFragment::class.java.simpleName
//                )
//                addToBackStack(null)
//                commit()
//            }

            // Dengan menggunakan FragmentTransaction / Fragment KTX
            fragmentManager.commit {
                addToBackStack(null)
                replace(
                    R.id.frame_container,
                    categoryFragment,
                    CategoryFragment::class.java.simpleName
                )
            }
        }
    }

}