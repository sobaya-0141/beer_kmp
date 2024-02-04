package spbaya.libs.core

import de.jensklingenberg.ktorfit.Ktorfit
import spbaya.libs.core.network.BeerApi

private val ktorFit  = Ktorfit.Builder().baseUrl("https://api.punkapi.com/v2/").build()
val beerApi = ktorFit.create<BeerApi>()