package com.example.myapplication.ui.home

import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.common.Resourse
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.home.adapter.CharacterAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private lateinit var adapter: CharacterAdapter
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[HomeViewModel::class.java]
    }

    override fun setupUI() {
        adapter = CharacterAdapter()
        binding.rvHome.adapter = adapter
        viewModel.getCharacter()
    }

    override fun setupObserver() {
        super.setupObserver()
        viewModel.liveDate.observe(viewLifecycleOwner) {
            when (it.status) {
                Resourse.Status.SUCCESS -> {
                    binding.progressBar.isGone = true
                    it.date?.results?.let { it1 -> adapter.setList(it1) }
                }
                Resourse.Status.LOADING -> binding.progressBar.isInvisible = true
                Resourse.Status.ERROR -> {
                    binding.progressBar.isInvisible = true
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}