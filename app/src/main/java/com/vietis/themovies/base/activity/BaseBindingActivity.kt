package com.vietis.themovies.base.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.vietis.themovies.R
import com.vietis.themovies.util.context.showToast
import dagger.android.support.DaggerAppCompatActivity
import java.lang.IllegalStateException
import javax.inject.Inject

abstract class BaseBindingActivity<T : ViewDataBinding?, V : ViewModel?> :
    DaggerAppCompatActivity() {
    private var _viewModel: V? = null
    private var _binding: T? = null
    protected val binding: T
        get() = _binding ?: throw IllegalStateException(EXCEPTION_BINDING)

    protected val viewModel: V
        get() = _viewModel ?: throw IllegalStateException(EXCEPTION_VIEWMODEL)
    private lateinit var mReceiver: BroadcastReceiver

    @JvmField
    @Inject
    var viewModelFactory: ViewModelProvider.Factory? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
        setContentView(_binding?.root)
        _viewModel = viewModelClass()?.let { ViewModelProviders.of(this, viewModelFactory)[it] }
        setupView()
    }

    override fun onResume() {
        super.onResume()
        createBroadcastReceiverNetwork()
    }

    override fun onPause() {
        super.onPause()
        if (mReceiver != null) {
            unregisterReceiver(mReceiver)
        }
    }

    private fun createBroadcastReceiverNetwork() {
        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        mReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent) {
                val cm =
                    context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val networkInfo = cm.activeNetworkInfo
                if (!(networkInfo != null && networkInfo.isConnected)) {
                    showToast(resources.getString(R.string.toast_error_internet))
                }
            }
        }
        registerReceiver(mReceiver, intentFilter)
    }

    abstract fun setupView()
    abstract fun getViewBinding(): T
    protected abstract fun viewModelClass(): Class<V>?

    companion object {
        private const val EXCEPTION_BINDING = "Binding only is valid after onCreate"
        private const val EXCEPTION_VIEWMODEL = "ViewModel only is valid after onCreate"
    }
}