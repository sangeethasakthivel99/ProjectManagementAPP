package com.sangeetha.mytodo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sangeetha.mytodo.R
import com.sangeetha.mytodo.view.fragments.SearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        navigateToSearchFragment()
    }

    private fun navigateToSearchFragment() {
        supportFragmentManager.beginTransaction().apply {
            add(SearchFragment(), "SearchFragment")
            commit()
        }
    }
}