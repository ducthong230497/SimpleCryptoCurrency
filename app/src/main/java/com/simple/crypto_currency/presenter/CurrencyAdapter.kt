package com.simple.crypto_currency.presenter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.simple.crypto_currency.R
import com.simple.crypto_currency.databinding.LayoutCurrencyItemBinding
import com.simple.crypto_currency.domain.entities.CurrencyInfo

class CurrencyAdapter: RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {
    private var listCurrency: List<CurrencyInfo> = emptyList()
    private var onItemClickListener: ((pair: Pair<View, CurrencyInfo>) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutCurrencyItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.layout_currency_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currencyInfo = listCurrency[position]
        holder.binding.itemName.text = currencyInfo.name
        holder.binding.itemSymbol.text = currencyInfo.symbol
        holder.binding.itemContainer.setOnClickListener {
            onItemClickListener?.invoke(Pair(it, currencyInfo))
        }
    }

    override fun getItemCount() = listCurrency.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(listCurrency: List<CurrencyInfo>, onItemClickListener: ((pair: Pair<View, CurrencyInfo>) -> Unit)) {
        this.listCurrency = listCurrency
        this.onItemClickListener = onItemClickListener
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: LayoutCurrencyItemBinding): RecyclerView.ViewHolder(binding.root)
}
