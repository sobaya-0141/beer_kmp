package spbaya.libs.core

import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import spbaya.libs.core.network.BeerApi

private val ktorFit  = Ktorfit
    .Builder()
    .baseUrl("https://api.punkapi.com/v2/")
    .httpClient(
        HttpClient {
            install(ContentNegotiation) {
                json(Json { isLenient = true; ignoreUnknownKeys = true })
            }
        }
    )
    .build()
@Single
internal fun beerApi() = ktorFit.create<BeerApi>()

@Module
@ComponentScan
public class NetworkModule