package com.waldoms.recyclerviewsort

import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import layout.MyAdapter

@BindingAdapter("setSpacecraftAdapter")
fun setSpacecraftAdapter(recyclerView:RecyclerView, adapter:MyAdapter)
{
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    recyclerView.adapter = adapter
}

class SpacecraftViewModel : ViewModel()
{
    val spacecrafts:ArrayList<String> = ArrayList()
    var adapter:MyAdapter

    var sortAsc:Boolean = true

    init {
        fillSpacecrafts()
        adapter = MyAdapter(this)
    }

    fun sortBtnClick(view:View)
    {
        if(sortAsc) { spacecrafts.sort() }
        else { spacecrafts.reverse() }

        adapter.notifyDataSetChanged()

        sortAsc = !sortAsc
    }

    private fun fillSpacecrafts() {
        spacecrafts.clear();
        spacecrafts.add("Kepler");
        spacecrafts.add("Casini");
        spacecrafts.add("Voyager");
        spacecrafts.add("New Horizon");
        spacecrafts.add("James Web");
        spacecrafts.add("Apollo 15");
        spacecrafts.add("WMAP");
        spacecrafts.add("Enterprise");
        spacecrafts.add("Spitzer");
        spacecrafts.add("Galileo");
        spacecrafts.add("Challenger");
        spacecrafts.add("Atlantis");
        spacecrafts.add("Apollo 19");
        spacecrafts.add("Huygens");
        spacecrafts.add("Hubble");
        spacecrafts.add("Juno");
        spacecrafts.add("Aries");
        spacecrafts.add("Columbia");
    }

}