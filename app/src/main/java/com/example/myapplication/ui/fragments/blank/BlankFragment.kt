package com.example.myapplication.ui.fragments.blank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentBlankBinding
import com.example.myapplication.model.Model
import com.example.myapplication.ui.adapter.Adapter

class BlankFragment : Fragment() {

    private var viewModel: BlankViewModel? = null
    private val list = mutableListOf<Model>()
    private lateinit var binding: FragmentBlankBinding
    private var adapter = Adapter(this::onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[BlankViewModel::class.java]
        setUpListeners()
        clear()
        initialization()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel?.getListOfCatHTP()?.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }
    }

    private fun setUpListeners() {
        binding.btnOpen.setOnClickListener {
            binding.btnOpen.isInvisible = true
            binding.rvB.isInvisible = false
        }
    }

    private fun clear() {
        list.clear()
    }

    private fun initialization() {
        binding.rvB.adapter = adapter
    }

    private fun onItemClick(model: Model) {
        findNavController().navigate(
            BlankFragmentDirections.actionBlankFragmentToDetailFragment(
                model.name,
                model.image
            )
        )
    }
}