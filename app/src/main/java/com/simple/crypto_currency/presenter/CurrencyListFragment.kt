package com.simple.crypto_currency.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simple.crypto_currency.R
import com.simple.crypto_currency.databinding.FragmentCurrencyListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CurrencyListFragment: Fragment() {

    companion object {
        private const val CURRENCY_LIST_FRAGMENT_LISTENER = "CURRENCY_LIST_FRAGMENT_LISTENER"
        fun newInstance(listener: ICurrencyListFragment): CurrencyListFragment {
            return CurrencyListFragment().apply {
                arguments = Bundle().also {
                    it.putSerializable(CURRENCY_LIST_FRAGMENT_LISTENER, listener)
                }
            }
        }
    }

    private lateinit var binding: FragmentCurrencyListBinding
    private val listener by lazy { arguments?.getSerializable(CURRENCY_LIST_FRAGMENT_LISTENER) as? ICurrencyListFragment }

    private val viewModel: CurrencyListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_currency_list, container, false)
        return binding.root
    }

    private val adapter = CurrencyAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listCurrency.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.listCurrency.adapter = adapter
        binding.listCurrency.setHasFixedSize(true)

        viewModel.data.observe(viewLifecycleOwner) {
            adapter.submitList(it) { (view, currencyInfo) ->
                listener?.onItemClick(view, currencyInfo)
            }
        }
    }

    fun reverseListData() {
        viewModel.reverseListData()
    }
}
