package com.example.tugasabislari

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHero: RecyclerView
    private var list: ArrayList<Musik> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        supportActionBar?.title=("List Musik")

        rvHero = findViewById(R.id.rv_hero)
        rvHero?.setHasFixedSize(true)

        list.addAll (DataMusik.listSong)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvHero.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListSongAdapter(list)
        rvHero.adapter = listHeroAdapter
    }

    private fun showSelectedHero(hero: Musik) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }
}