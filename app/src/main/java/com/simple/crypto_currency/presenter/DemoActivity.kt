package com.simple.crypto_currency.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.simple.crypto_currency.R
import com.simple.crypto_currency.databinding.ActivityDemoBinding
import com.simple.crypto_currency.domain.entities.CurrencyInfo

class DemoActivity : AppCompatActivity(), ICurrencyListFragment {

    companion object {
        private const val CURRENCY_LIST_FRAGMENT = "CURRENCY_LIST_FRAGMENT"
    }

    private lateinit var binding: ActivityDemoBinding
    private var fragment: CurrencyListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_demo)

        if (savedInstanceState == null) {
            fragment = CurrencyListFragment.newInstance(this)
            fragment?.run { replaceFragment(R.id.fragmentContainer, this, CURRENCY_LIST_FRAGMENT) }
        }

        binding.btnShowData.setOnClickListener {
            binding.fragmentContainer.isVisible = true
        }

        binding.btnSort.setOnClickListener {
            fragment?.reverseListData()
        }
    }

    private fun replaceFragment(frameLayoutId: Int, fragment: Fragment, tag: String? = null) {
        try {
            if (isDestroyed) return
            supportFragmentManager
                .beginTransaction()
                .replace(frameLayoutId, fragment, tag)
                .commitAllowingStateLoss()
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    override fun onItemClick(view: View, currencyInfo: CurrencyInfo) {
        Toast.makeText(applicationContext, getString(R.string.item_click, currencyInfo.symbol), Toast.LENGTH_SHORT).show()
    }
}
