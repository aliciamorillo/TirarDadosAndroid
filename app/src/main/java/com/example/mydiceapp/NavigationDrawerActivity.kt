package com.example.mydiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_navigation_drawer.*

class NavigationDrawerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        initDrawer()
        initHome()
    }

    private fun initHome() {
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()
    }

    private fun initDrawer() {
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        val navigation: NavigationView = findViewById(R.id.nav_view)
        drawer.addDrawerListener(toggle)
        navigation.setNavigationItemSelectedListener {
            var title = ""

            when (it.itemId) {
                R.id.nav_share -> title = "Send"
                R.id.nav_share2 -> title = "Share"
                R.id.nav_send2 -> title = "Send2"

                else -> {
                }
            }
            Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
            setTitle(title)
            it.isChecked = true
            drawer.closeDrawer(GravityCompat.START)
            true
        }
        toggle.syncState()
    }
}