package com.example.rick_and_morty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.rick_and_morty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment =
            // as for type casts
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)



        setupAppBarConfiguration(navController)
    }

    private fun setupAppBarConfiguration(navController: NavController) {
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.characterListFragment,
                R.id.episodeListFragment,
                R.id.locationListFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}