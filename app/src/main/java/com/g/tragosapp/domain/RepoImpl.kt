package com.g.tragosapp.domain

import com.g.tragosapp.data.DefaultCocktailDataSource
import com.g.tragosapp.data.model.Cocktail
import com.g.tragosapp.data.model.FavoritesEntity
import com.g.tragosapp.vo.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Gastón Saillén on 03 July 2020
 */

@ExperimentalCoroutinesApi
class RepoImpl @Inject constructor(
    private val defaultDataSource: DefaultCocktailDataSource
) : Repo {

    override suspend fun getCocktailList(cocktailName: String): Flow<Resource<List<Cocktail>>?> {
        return defaultDataSource.getCocktailByName(cocktailName)
    }

    override suspend fun getFavoriteCocktails(): Resource<List<Cocktail>> {
        return defaultDataSource.getFavoritesCocktails()
    }

    override suspend fun saveCocktail(cocktail: FavoritesEntity) {
        defaultDataSource.saveFavoriteCocktail(cocktail)
    }

    override suspend fun deleteCocktail(cocktail: FavoritesEntity): Resource<List<Cocktail>> {
        defaultDataSource.deleteCocktail(cocktail)
        return getFavoriteCocktails()
    }
}