package com.jsrm.dogedex.dogDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import coil.load
import com.jsrm.dogedex.Dog
import com.jsrm.dogedex.R
import com.jsrm.dogedex.databinding.ActivityDogDetailBinding

class DogDetailActivity : AppCompatActivity() {

    companion object{
        const val DOG_KEY = "dog"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dog = intent.extras?.getParcelable<Dog>(DOG_KEY)

        if (dog == null){
            Toast.makeText(this,R.string.show_error_dog_not_fund, Toast.LENGTH_SHORT).show()
            return
        }

        binding.dogIndex.text = getString(R.string.dog_index_format, dog.index)
        binding.lifeExpectancy.text = getString(R.string.dog_life_expectancy_format, dog.lifeExpectancy)
        binding.dog = dog
        binding.dogImage.load(dog.imgUrl)
        binding.closeButton.setOnClickListener {
            finish()
        }
    }
}