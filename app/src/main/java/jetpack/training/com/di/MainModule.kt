package jetpack.training.com.di

import jetpack.training.com.repository.CuriosityRepository
import jetpack.training.com.repository.Repository
import jetpack.training.com.ui.CuriosityViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val mainModule = applicationContext {
    bean { CuriosityRepository(get()) as Repository }
    viewModel { CuriosityViewModel(get()) }
}