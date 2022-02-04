package com.example.list_adapter_example

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.list_adapter_example.adapters.AdapterSport
import com.example.list_adapter_example.databinding.ActivityMainBinding
import com.example.list_adapter_example.interfaces.OnClickListener
import com.example.list_adapter_example.model_data.SportModelData

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var context: Context
    private lateinit var adapterSport: AdapterSport

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initElements()
        context = this

        getAllSports()

        setupRcv()


    }

    private fun initElements () {
        adapterSport = AdapterSport(this)
    }

    private fun setupRcv () {
        binding.rcvSportList.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(context)
            adapter = adapterSport
        }
    }

    private fun sportData (): MutableList<SportModelData> {
        val basketball = SportModelData(1, "Baloncesto", "https://www.muycomputer.com/wp-content/uploads/2020/12/google.png")
        return mutableListOf(basketball)
    }

    private fun getAllSports () {
        val sportData = sportData()
        adapterSport.submitList(sportData)
    }

}