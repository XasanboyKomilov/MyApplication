package com.example.myapplication.ui.dashboard

import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.common.Resourse
import com.example.myapplication.databinding.FragmentDashboardBinding
import com.example.myapplication.ui.dashboard.adapter.EpisodeAdapter

class DashboardFragment : BaseFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {
    private lateinit var adapter: EpisodeAdapter
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[DashboardViewMadel::class.java]
    }

    override fun setupUI() {
        adapter = EpisodeAdapter()
        binding.rvDashboard.adapter = adapter
        viewModel.getEpisode()
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