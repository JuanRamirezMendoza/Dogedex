package com.jsrm.dogedex.dogList

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jsrm.dogedex.Dog
import com.jsrm.dogedex.R
import com.jsrm.dogedex.databinding.ActivityDogListBinding
import com.jsrm.dogedex.dogDetail.DogDetailActivity
import com.jsrm.dogedex.dogDetail.DogDetailActivity.Companion.DOG_KEY
import com.jsrm.dogedex.internetConection.ResponseStatus


private const val GRID_SPAN_COUNT = 3
class DogListActivity : AppCompatActivity() {

    private  val dogListViewModel:DogListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loadingWheel = binding.loadingWheel


        val recycler = binding.dogRecycler
        recycler.layoutManager = GridLayoutManager(this,GRID_SPAN_COUNT)

        val adapter = DogAdapter()

        adapter.setOnItemClickListener {
            //Pasar el dog a dogDetailActivity
            val intent = Intent(this, DogDetailActivity::class.java)
            intent.putExtra(DOG_KEY, it)
            startActivity(intent)
        }

        recycler.adapter = adapter

        dogListViewModel.dogList.observe(this){
            dogList ->
            adapter.submitList(dogList)
        }

        dogListViewModel.status.observe(this){
            status ->
            when(status){
                is ResponseStatus.Error -> {
                    loadingWheel.visibility = View.GONE
                    //hide progress bar
                    Toast.makeText(this,status.message, Toast.LENGTH_SHORT).show()
                }
                is ResponseStatus.Loading -> loadingWheel.visibility = View.VISIBLE

                is ResponseStatus.Success -> loadingWheel.visibility = View.GONE

            }
        }

    }
}