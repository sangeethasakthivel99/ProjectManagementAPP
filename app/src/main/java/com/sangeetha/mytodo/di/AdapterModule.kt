package com.sangeetha.mytodo.di

import com.sangeetha.mytodo.view.adapters.ProjectAdapter
import com.sangeetha.mytodo.view.adapters.TaskAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class AdapterModule {

    @Provides
    fun provideTaskAdapter() = TaskAdapter()

    @Provides
    fun provideProjectAdapter() = ProjectAdapter()
}
