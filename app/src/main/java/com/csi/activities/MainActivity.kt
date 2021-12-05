package com.csi.activities

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.csi.R
import com.csi.databinding.MainActivityBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.main_nav_host) //Initialising navController

        appBarConfiguration = AppBarConfiguration.Builder(R.id.homeFragment) //Pass the ids of fragments from nav_graph which you d'ont want to show back button in toolbar
            .setOpenableLayout(binding.mainDrawerLayout) //Pass the drawer layout id from activity xml
            .build()
        setSupportActionBar(binding.mainToolbar)

        setupActionBarWithNavController(navController, appBarConfiguration) //Setup toolbar with back button and drawer icon according to appBarConfiguration
        setNavigationViewListener()

    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.main_layout_id)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exit_drawer_id -> this.finish()
        }
        return true
    }

    private fun setNavigationViewListener() {
        val navigationView = binding.mainNavigationView
        navigationView.setNavigationItemSelectedListener(this)
    }


}
