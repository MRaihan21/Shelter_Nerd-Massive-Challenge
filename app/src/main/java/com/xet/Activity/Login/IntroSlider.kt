package com.xet.Activity.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.xet.Adapter.IntroSliderAdapter
import com.xet.Models.IntroSliderModel
import com.xet.R
import com.xet.databinding.ActivityIntroSliderBinding

class IntroSlider : AppCompatActivity() {

    private lateinit var binding: ActivityIntroSliderBinding

    private val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroSliderModel(
                R.drawable.viewpage1,
                "Lots of Interesting Events",
                "There are many events that you can\n take part in"
            ),
            IntroSliderModel(
                R.drawable.viewpage2,
                "Easy to Get Tickets",
                "It's easy and fast get tickets legally"
            ),
            IntroSliderModel(
                R.drawable.viewpage3,
                "Consisting of Various Categories",
                "Consisting of various categories that\n you might like"
            ),
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_slider)
        binding = ActivityIntroSliderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.introSlider.adapter = introSliderAdapter

        binding.btnNextIntro.setOnClickListener{
            if (binding.introSlider.currentItem +1  < introSliderAdapter.itemCount){
                binding.introSlider.currentItem +=1
            } else {
                Intent(applicationContext, LoginActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }

        setupIndicator()
        setCurrentIndicator(0)
        binding.introSlider.registerOnPageChangeCallback(object :
        ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }

        })

    }


    private fun setupIndicator(){
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams( WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
                    this?.layoutParams = layoutParams
                }
                binding.indicator.addView(indicators[i])
            }
        }

    private fun setCurrentIndicator(index : Int ){
        val childCount = binding.indicator.childCount
        for (i in 0 until childCount){
            val imageview = binding.indicator[i] as ImageView
            if (i == index) {
                imageview.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageview.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }

}
