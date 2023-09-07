package com.fikrisandi.domain.pokemon

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fikrisandi.framework.extension.classTag
import com.fikrisandi.model.dto.pokemon.PokemonListDto
import com.fikrisandi.model.dto.pokemon.toDto
import com.fikrisandi.model.local.pokemon.toEntity
import com.fikrisandi.repository.pokemon.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList

class PokemonListPagingSource(
    private val repository: PokemonRepository,
    val options: Map<String, String>
) : PagingSource<Int, PokemonListDto>() {
    override fun getRefreshKey(state: PagingState<Int, PokemonListDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonListDto> {
        var page = params.key ?: 0
        return try {
            val sort = options["sort"].orEmpty().ifEmpty { "DESC" }
            val search = options["search"].orEmpty()

            var entities =
                repository.getAllLocal(params.loadSize, page * params.loadSize, sort, search)

            if (entities.isEmpty()) {
                try {
                    val response = repository.getAll(params.loadSize, page * params.loadSize)
                    response.results.map {
                        val data = it.toEntity()
                        repository.save(data)
                        data
                    }
                    entities = repository.getAllLocal(
                        params.loadSize,
                        page * params.loadSize,
                        sort,
                        search
                    )
                } catch (e: Exception) {
                    Log.e(this.classTag, e.message.orEmpty())
                }
            }


            LoadResult.Page(
                data = entities.asFlow().map { it.toDto() }.flowOn(Dispatchers.IO).toList(),
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (entities.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            Log.e(this.classTag, e.message.orEmpty())
            return LoadResult.Error(e)
        }
    }
}