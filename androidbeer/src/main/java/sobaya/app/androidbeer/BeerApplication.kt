package sobaya.app.androidbeer

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module
import spbaya.libs.core.NetworkModule

class BeerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                NetworkModule().module
            )
        }
    }
}