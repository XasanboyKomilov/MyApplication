package com.example.myapplication.ui.notifications

import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.common.Resourse
import com.example.myapplication.databinding.FragmentNotificationsBinding
import com.example.myapplication.ui.notifications.adapter.LocationAdapter

class NotificationsFragment : BaseFragment<FragmentNotificationsBinding>(FragmentNotificationsBinding::inflate) {
    private lateinit var adapter: LocationAdapter
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[NotificationViewMadel::class.java]
    }

    override fun setupUI() {
        adapter = LocationAdapter()
        binding.rvLocation.adapter = adapter
        viewModel.getLocation()
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