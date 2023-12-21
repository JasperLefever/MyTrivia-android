package icu.repsaj.android.mytrivia.data

import icu.repsaj.android.mytrivia.data.database.GameHistoryDao
import icu.repsaj.android.mytrivia.data.database.entities.asDbEntity
import icu.repsaj.android.mytrivia.data.database.entities.asDomainObjects
import icu.repsaj.android.mytrivia.model.HistoryItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Repository interface for handling game history data operations.
 */
interface IGameHistoryRepo {
    /**
     * Retrieves the game history as a list of [HistoryItem].
     *
     * @return A [Flow] emitting a list of [HistoryItem], representing the game history.
     */
    fun getGameHistory(): Flow<List<HistoryItem>>

    /**
     * Inserts a new [HistoryItem] into the game history.
     *
     * @param item The [HistoryItem] to be inserted.
     */
    suspend fun insertHistoryItem(item: HistoryItem)

    /**
     * Deletes a [HistoryItem] from the game history.
     *
     * @param item The [HistoryItem] to be deleted.
     */
    suspend fun deleteHistoryItem(item: HistoryItem)
}

/**
 * Concrete implementation of [IGameHistoryRepo], handling game history data operations.
 *
 * @property historyDao The DAO for accessing the game history data from the database.
 */
class GameHistoryRepository(
    private val historyDao: GameHistoryDao,
) : IGameHistoryRepo {

    /**
     * Retrieves all game history items from the database, converting them to domain objects.
     *
     * @return A [Flow] emitting a list of [HistoryItem]s.
     */
    override fun getGameHistory(): Flow<List<HistoryItem>> {
        return historyDao.getAll().map {
            it.asDomainObjects()
        }
    }

    /**
     * Inserts a new game history item into the database.
     *
     * @param item The [HistoryItem] to be inserted, converted to a database entity.
     */
    override suspend fun insertHistoryItem(item: HistoryItem) {
        historyDao.insert(item.asDbEntity())
    }

    /**
     * Deletes a game history item from the database.
     *
     * @param item The [HistoryItem] to be deleted, converted to a database entity.
     */
    override suspend fun deleteHistoryItem(item: HistoryItem) {
        historyDao.delete(item.asDbEntity())
    }
}
