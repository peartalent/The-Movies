package com.vietis.themovies.base.fragment

import android.content.BroadcastReceiver
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.vietis.themovies.util.context.showToast
import dagger.android.support.DaggerFragment
import java.lang.IllegalStateException
import javax.inject.Inject

abstract class BaseBindingFragment<T : ViewDataBinding?, V : ViewModel?> : DaggerFragment() {
    @LayoutRes
    abstract fun getLayoutResId(): Int

    @JvmField
    @Inject
    var viewModelFactory: ViewModelProvider.Factory? = null
    private var _viewModel: V? = null
    private var _binding: T? = null
    protected val binding: T
        get() = _binding ?: throw IllegalStateException(EXCEPTION_BINDING)

    protected val viewModel: V
        get() = _viewModel ?: throw IllegalStateException(EXCEPTION_VIEWMODEL)
    private lateinit var mReceiver: BroadcastReceiver

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewModel = viewModelClass()?.let { ViewModelProviders.of(this, viewModelFactory)[it] }
        return DataBindingUtil
            .inflate<T>(inflater, getLayoutResId(), container, false)
            .apply { _binding = this }?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun showToast(msg: String) = requireContext().showToast(msg)

    protected abstract fun viewModelClass(): Class<V>?
    abstract fun setupView()

    companion object {
        private const val EXCEPTION_BINDING = "Binding only is valid after onCreateView"
        private const val EXCEPTION_VIEWMODEL = "ViewModel only is valid after onCreateView"
    }
}