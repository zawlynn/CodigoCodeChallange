package com.zawlynn.codigo.assignment.di.component


import com.zawlynn.codigo.assignment.di.module.ApplicationContextModule
import com.zawlynn.codigo.assignment.di.module.RetrofitModule
import com.zawlynn.codigo.assignment.di.module.RoomModule
import com.zawlynn.codigo.assignment.ui.main.viewmodel.MainActivityViewmodel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, ApplicationContextModule::class, RoomModule::class])
interface DataComponent {
    fun inject(viewModel: MainActivityViewmodel)
}