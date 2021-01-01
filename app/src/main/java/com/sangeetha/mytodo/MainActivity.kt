package com.sangeetha.mytodo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sangeetha.mytodo.view.fragments.FolderFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav.apply {
            background = null
            menu.getItem(2).isEnabled = false
        }
        bottomNav.setOnNavigationItemSelectedListener {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.container, FolderFragment(), "folderFragment")
                commit()
            }
           return@setOnNavigationItemSelectedListener true
        }
    }
}
