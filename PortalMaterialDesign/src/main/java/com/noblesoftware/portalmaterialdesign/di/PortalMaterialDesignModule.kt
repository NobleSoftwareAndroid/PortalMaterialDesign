package com.noblesoftware.portalmaterialdesign.di

import android.content.Context
import com.noblesoftware.portalmaterialdesign.util.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PortalMaterialDesignModule {
    @Singleton
    @Provides
    fun provideNetworkHelper(@ApplicationContext context: Context): NetworkHelper =
        NetworkHelper(context)
}