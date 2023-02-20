package com.example.android

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
import android.view.View
//import android.view.ViewGroup
import com.example.android.databinding.FragmentListBinding

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    lateinit var frag: FragAcitivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragAcitivity) frag = context
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentListBinding.inflate(inflater, container, false)
//        return binding.root
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            arguments?.apply {
                txtTitle.text = getString("key1")
                txtValue.text = "${getInt("key2")}"
            }
            btnNext.setOnClickListener {
                frag.goDetail()
            }
        }
    }

    fun setValue(value:String) {
        binding.fromText.text = value
    }
}