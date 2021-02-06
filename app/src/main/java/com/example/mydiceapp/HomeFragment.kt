package com.example.mydiceapp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mydiceapp.fragments.FaceCrossFragment
import com.example.mydiceapp.fragments.NormalDiceFragment
import com.example.mydiceapp.fragments.RolDiceFragment
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home.*

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myAdapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> {
                        FaceCrossFragment()
                    }
                    1 -> {
                        NormalDiceFragment()
                    }
                    2 -> {
                        RolDiceFragment()
                    }
                    else -> {
                        RolDiceFragment()
                    }
                }
            }

            override fun getItemCount(): Int {
                return 3
            }
        }
        mainViewPager.adapter = myAdapter

        TabLayoutMediator(mainTabLayout, mainViewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "CaraCruz"
                    tab.icon = activity?.getDrawable(R.drawable.ic_baseline_monetization_on_24)
                }
                1 -> {
                    tab.text = "Normal Dice"
                    tab.icon = activity?.getDrawable(R.drawable.ic_baseline_filter_6_24)
                }
                2 -> {
                    tab.text = "Rol"
                    tab.icon = activity?.getDrawable(R.drawable.ic_baseline_videogame_asset_24)
                }
            }
        }.attach()


    }



}