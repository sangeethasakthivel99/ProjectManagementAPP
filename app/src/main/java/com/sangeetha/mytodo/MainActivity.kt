package com.sangeetha.mytodo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sangeetha.mytodo.view.fragments.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alignBottomNavigation()
        addDashBoardFragment()
        setupBottomNavigation()
        setOnClickListeners()
    }

    private fun alignBottomNavigation() {
        bottomNav.apply {
            background = null
            menu.getItem(2).isEnabled = false
        }
    }

    private fun addDashBoardFragment() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, DashboardFragment(), "DashboardFragment")
            commit()
        }
    }

    private fun setupBottomNavigation() {
        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_home -> changeFragment(DashboardFragment())
                R.id.projects -> changeFragment(ProjectsFragment())
                R.id.starred -> changeFragment(StarredFragment())
                R.id.notification -> changeFragment(NotificationFragment())
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment, "$fragment")
            commit()
        }
    }

    private fun setOnClickListeners() {
        fab.setOnClickListener {
            navigateToCreateProject()
        }
    }

    private fun navigateToCreateProject() {
        startActivity(Intent(this, CreateProjectActivity::class.java))
    }

}
