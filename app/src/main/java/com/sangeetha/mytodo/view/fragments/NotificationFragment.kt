package com.sangeetha.mytodo.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sangeetha.mytodo.R
import kotlinx.android.synthetic.main.animated_empty_layout.*
import kotlinx.android.synthetic.main.layout_notification.*
import kotlinx.android.synthetic.main.toolbar.view.*

class NotificationFragment: Fragment(R.layout.layout_notification) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolBar()
        setClickListeners()
        setUpEmptyLayout()
    }

    private fun setupToolBar() {
        toolbar.toolbarTitle.text = resources.getString(R.string.notifications)
    }

    private fun setClickListeners() {
        toolbar.backButton.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun setUpEmptyLayout() {
        emptyTitle.text = getString(R.string.empty_notification)
        emptyImage.setAnimation(R.raw.empty_notification)
    }
}