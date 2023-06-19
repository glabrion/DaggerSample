package com.example.daggersample.screens.main

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.daggersample.appComponent
import com.example.daggersample.databinding.FragmentMainBinding
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels {
        factory.create(1)
    }

    @Inject
    lateinit var factory: MainViewModelFactory.Factory

    private val adapter: PhotosAdapter = PhotosAdapter()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.fmRvList?.adapter = adapter
        viewModel.getPhotos()
        viewLifecycleOwner.lifecycle.coroutineScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.photos.collect {
                    adapter.setData(it)
                }
            }
        }
    }

    companion object {
        const val TAG = "MainFragmentTag"
        const val PAGE_KEY = "PAGE_KEY"
    }
}
