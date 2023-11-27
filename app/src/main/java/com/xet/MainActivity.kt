package com.xet

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.xet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main2)

        navController.addOnDestinationChangedListener{_, navDestination, _, ->
            Handler(Looper.getMainLooper()).post {
                when(navDestination.id){
                    R.id.navigation_home, R.id.navigation_explorer, R.id.navigation_tiket, R.id.navigation_profile -> {
                        binding.navView.visibility = View.VISIBLE
                    } else ->
                    binding.navView.visibility = View.GONE
                }
            }
        }

        binding.navView.setupWithNavController(navController)
    }
}