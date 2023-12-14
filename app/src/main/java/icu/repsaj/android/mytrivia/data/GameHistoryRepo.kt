package icu.repsaj.android.mytrivia.data

import icu.repsaj.android.mytrivia.data.database.GameHistoryDao
import icu.repsaj.android.mytrivia.data.database.entities.asDbEntity
import icu.repsaj.android.mytrivia.data.database.entities.asDomainObjects
import icu.repsaj.android.mytrivia.model.HistoryItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface GameHistoryRepo {
    fun getGameHistory(): Flow<List<HistoryItem>>

    suspend fun insertHistoryItem(item: HistoryItem)

    suspend fun deleteHistoryItem(item: HistoryItem)
}

class GameHistoryRepository(
    private val historyDao: GameHistoryDao,
) : GameHistoryRepo {
    override fun getGameHistory(): Flow<List<HistoryItem>> {
        return historyDao.getAll().map {
            it.asDomainObjects()
        }
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        historyDao.insert(item.asDbEntity())
    }

    override suspend fun deleteHistoryItem(item: HistoryItem) {
        historyDao.delete(item.asDbEntity())
    }

}