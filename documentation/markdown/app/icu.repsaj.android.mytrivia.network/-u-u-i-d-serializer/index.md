//[app](../../../index.md)/[icu.repsaj.android.mytrivia.network](../index.md)/[UUIDSerializer](index.md)

# UUIDSerializer

[androidJvm]\
object [UUIDSerializer](index.md) :
KSerializer&lt;[UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)&gt;

A custom serializer for UUIDs, used in conjunction with Kotlin Serialization. This serializer
handles the serialization and deserialization of UUIDs to and from strings.

## Properties

| Name                        | Summary                                                                                                                                                                                        |
|-----------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [descriptor](descriptor.md) | [androidJvm]<br>open override val [descriptor](descriptor.md): SerialDescriptor<br>Describes the type of data that this serializer handles. In this case, it's a UUID represented as a string. |

## Functions

| Name                          | Summary                                                                                                                                                                                             |
|-------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [deserialize](deserialize.md) | [androidJvm]<br>open override fun [deserialize](deserialize.md)(decoder: Decoder): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)<br>Deserializes a UUID from a string. |
| [serialize](serialize.md)     | [androidJvm]<br>open override fun [serialize](serialize.md)(encoder: Encoder, value: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html))<br>Serializes a UUID to a string.  |
