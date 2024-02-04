package spbaya.libs.core.network

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query
import spbaya.libs.core.model.Beer

interface BeerApi {
    @GET("beers")
    suspend fun getBeers(): List<Beer>

    @GET("beers/{id}")
    suspend fun getBeerById(@Query id: Int): Beer

    @GET("beers/random")
    suspend fun getRandomBeer(): Beer
}