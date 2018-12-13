package com.waldoms.recyclerviewsort

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout

import kotlinx.android.synthetic.main.activity_main.*
import layout.MyAdapter
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var rv:RecyclerView
    lateinit var adapter: MyAdapter
    lateinit var sortBtn:Button

    private var ascending:Boolean = true

    companion object {
        private var spacecrafts:ArrayList<String> = ArrayList();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        initialzieView()

        fillSpacecrafts()
    }

    fun initialzieView() {
        rv = findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        sortBtn = findViewById<Button>(R.id.sortBtn)

        sortBtn.setOnClickListener { view ->
            sortData(ascending)
            ascending = !ascending
        }
    }

    private fun sortData(asc:Boolean)
    {
        if(asc) { Collections.sort(spacecrafts) }
        else { Collections.reverse(spacecrafts) }

        rv.adapter = adapter
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

        adapter = MyAdapter(this, spacecrafts)
        rv.adapter = adapter
    }
}
