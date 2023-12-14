package icu.repsaj.android.mytrivia.data.database.entities


import androidx.room.Entity
import androidx.room.PrimaryKey
import icu.repsaj.android.mytrivia.model.TriviaQuestion
import java.util.UUID

@Entity(tableName = "questions")
data class DbQuestion(
    @PrimaryKey
    val id: UUID,
    val question: String,
    val categoryId: UUID,
)

fun DbQuestion.asDomainObject(): TriviaQuestion {
    return TriviaQuestion(
        id = this.id,
        question = this.question,
        answers = listOf()
    )
}

fun TriviaQuestion.asDbEntity(): DbQuestion {
    return DbQuestion(
        id = this.id,
        question = this.question,
        categoryId = UUID.randomUUID()//TODO fix categoryid
    )
}

fun List<DbQuestion>.asDomainObjects(): List<TriviaQuestion> {
    return this.map { it.asDomainObject() }
}
