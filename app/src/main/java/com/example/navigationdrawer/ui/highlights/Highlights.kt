package com.example.navigationdrawer.ui.highlights

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.navigationdrawer.databinding.FragmentHighlightsBinding


class Highlights : Fragment() {

    private var _binding: FragmentHighlightsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val galleryViewModel =
            ViewModelProvider(this).get(HighlightsViewModel::class.java)


        _binding = FragmentHighlightsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHighLight
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}