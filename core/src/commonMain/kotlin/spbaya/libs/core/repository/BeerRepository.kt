package spbaya.libs.core.repository

import org.koin.core.annotation.Single
import spbaya.libs.core.model.Beer
import spbaya.libs.core.network.BeerApi

@Single
public class BeerRepository(private val beerApi: BeerApi) {
    public suspend fun getBeers(): List<Beer> = beerApi.getBeers()
    public suspend fun getBeerById(id: Int): Beer = beerApi.getBeerById(id)
    public suspend fun getRandomBeer(): Beer = beerApi.getRandomBeer()
}