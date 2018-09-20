package jetpack.training.com

import android.app.Application
import jetpack.training.com.di.mainModule
import jetpack.training.com.di.networkModule
import org.koin.android.ext.android.startKoin

class RoverApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(mainModule, networkModule))
    }

}