package icu.repsaj.android.mytrivia.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import icu.repsaj.android.mytrivia.model.TriviaAnswer
import java.util.UUID

@Entity(tableName = "answers")
data class DbAnswer(
    @PrimaryKey
    var id: UUID,
    var answer: String = "",
    var isCorrect: Boolean,
    var questionId: UUID,
)

fun DbAnswer.asDomainObject(): TriviaAnswer {
    return TriviaAnswer(
        id = this.id,
        answer = this.answer,
        isCorrect = this.isCorrect
    )
}

fun TriviaAnswer.asDbEntity(): DbAnswer {
    return DbAnswer(
        id = this.id,
        answer = this.answer,
        isCorrect = this.isCorrect,
        questionId = UUID.randomUUID()//TODO fix questionid
    )
}

fun List<DbAnswer>.asDomainObjects(): List<TriviaAnswer> {
    return this.map { it.asDomainObject() }
}
