package com.g.tragosapp.data.local

import com.g.tragosapp.data.DataSource
import com.g.tragosapp.data.model.*
import com.g.tragosapp.domain.local.CocktailDao
import com.g.tragosapp.vo.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

/**
 * Created by Gastón Saillén on 10 August 2020
 */

@ExperimentalCoroutinesApi
class LocalDataSourceImpl @Inject constructor(private val cocktailDao: CocktailDao) : DataSource {

    override suspend fun saveFavoriteCocktail(cocktail: FavoritesEntity) {
        return cocktailDao.saveFavoriteCocktail(cocktail)
    }

    override suspend fun getFavoritesCocktails(): Resource<List<Cocktail>> {
        return Resource.Success(cocktailDao.getAllFavoriteDrinks().asDrinkList())
    }

    override suspend fun deleteCocktail(cocktail: FavoritesEntity) {
        return cocktailDao.deleteFavoriteCoktail(cocktail)
    }

    override suspend fun saveCocktail(cocktail: CocktailEntity) {
        cocktailDao.saveCocktail(cocktail)
    }

    override suspend fun getCachedCocktails(cocktailName: String): Resource<List<Cocktail>>? {
        return Resource.Success(cocktailDao.getCocktails(cocktailName).asCocktailList())
    }

    override suspend fun getCocktailByName(cocktailName: String): Flow<Resource<List<Cocktail>>?> {
        TODO("not implemented")
    }
}