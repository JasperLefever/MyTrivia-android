package icu.repsaj.android.mytrivia.network

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.util.UUID


/**
 * Represents the metadata typically associated with responses from an API.
 * This data class is commonly used for pagination and total item count information.
 *
 * @property page The current page number in a paginated response.
 * @property per The number of items per page.
 * @property total The total number of items available across all pages.
 */
@Serializable
data class Metadata(
    val page: Int,
    val per: Int,
    val total: Int
)

/**
 * A custom serializer for UUIDs, used in conjunction with Kotlin Serialization.
 * This serializer handles the serialization and deserialization of UUIDs to and from strings.
 */
object UUIDSerializer : KSerializer<UUID> {

    /**
     * Describes the type of data that this serializer handles.
     * In this case, it's a UUID represented as a string.
     */
    override val descriptor = PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING)

    /**
     * Deserializes a UUID from a string.
     *
     * @param decoder The decoder instance that handles the deserialization process.
     * @return A UUID instance corresponding to the string provided by the decoder.
     */
    override fun deserialize(decoder: Decoder): UUID {
        return UUID.fromString(decoder.decodeString())
    }

    /**
     * Serializes a UUID to a string.
     *
     * @param encoder The encoder instance that handles the serialization process.
     * @param value The UUID to be serialized.
     */
    override fun serialize(encoder: Encoder, value: UUID) {
        encoder.encodeString(value.toString())
    }
}
