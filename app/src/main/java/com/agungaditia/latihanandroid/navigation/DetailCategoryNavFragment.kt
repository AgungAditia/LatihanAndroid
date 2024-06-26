package com.agungaditia.latihanandroid.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.agungaditia.latihanandroid.R
import com.agungaditia.latihanandroid.databinding.FragmentDetailCategoryNavBinding


class DetailCategoryNavFragment : Fragment() {

    private var _binding: FragmentDetailCategoryNavBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_detail_category_nav, container, false)
        _binding = FragmentDetailCategoryNavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataName = arguments?.getString(CategoryNavFragment.EXTRA_NAME)
        val dataDescription = arguments?.getLong(CategoryNavFragment.EXTRA_STOCK)

        binding.tvCategoryName.text = dataName
        binding.tvCategoryDescription.text = "Stock : $dataDescription"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}