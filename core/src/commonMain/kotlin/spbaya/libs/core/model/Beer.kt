package spbaya.libs.core.model

data class Beer(
    val id: Int,
    val name: String,
    val tagline: String,
    val first_brewed: String,
    val description: String,
    val image_url: String?,
    val abv: Double,
    val ibu: Double?,
    val target_fg: Int,
    val target_og: Int,
    val ebc: Int?,
    val srm: Int?,
    val ph: Double?,
    val attenuation_level: Double,
    val volume: Volume,
    val boil_volume: Volume,
    val method: Method,
    val ingredients: Ingredients,
    val food_pairing: List<String>,
    val brewers_tips: String,
    val contributed_by: String
)

data class Volume(
    val value: Int,
    val unit: String
)

data class Method(
    val mash_temp: List<MashTemp>,
    val fermentation: Fermentation,
    val twist: String?
)

data class MashTemp(
    val temp: Volume, // Reusing Volume class for temperature as it has the same structure
    val duration: Int?
)

data class Fermentation(
    val temp: Volume
)

data class Ingredients(
    val malt: List<Malt>,
    val hops: List<Hop>,
    val yeast: String
)

data class Malt(
    val name: String,
    val amount: Volume
)

data class Hop(
    val name: String,
    val amount: Volume,
    val add: String,
    val attribute: String
)
