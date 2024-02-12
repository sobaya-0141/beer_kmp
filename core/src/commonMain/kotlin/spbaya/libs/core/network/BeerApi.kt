package spbaya.libs.core.network

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query
import org.koin.core.annotation.Singleton
import spbaya.libs.core.model.Beer

public interface BeerApi {
    @GET("beers")
    public suspend fun getBeers(): List<Beer>

    @GET("beers/{id}")
    public suspend fun getBeerById(@Query id: Int): Beer

    @GET("beers/random")
    public suspend fun getRandomBeer(): Beer
}