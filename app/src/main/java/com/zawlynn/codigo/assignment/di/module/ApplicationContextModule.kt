package com.zawlynn.codigo.assignment.di.module


import com.zawlynn.codigo.assignment.DiApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationContextModule(app: DiApplication) {
    val applicaiton:DiApplication
    init {
        this.applicaiton= app
    }
    @Provides
    @Singleton
    fun provideApplicatioln():DiApplication{
        return applicaiton
    }
}