//[app](../../../index.md)/[icu.repsaj.android.mytrivia.network.convertors](../index.md)/[ToStringConverterFactory](index.md)

# ToStringConverterFactory

[androidJvm]\
class [ToStringConverterFactory](index.md) : Converter.Factory

## Constructors

|                                                             |                               |
|-------------------------------------------------------------|-------------------------------|
| [ToStringConverterFactory](-to-string-converter-factory.md) | [androidJvm]<br>constructor() |

## Functions

| Name                                                                  | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
|-----------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [requestBodyConverter](index.md#-1650119157%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [requestBodyConverter](index.md#-1650119157%2FFunctions%2F-912451524)(p0: [Type](https://developer.android.com/reference/kotlin/java/lang/reflect/Type.html), p1: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Annotation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)&gt;, p2: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Annotation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)&gt;, p3: Retrofit): Converter&lt;*, RequestBody&gt;? |
| [responseBodyConverter](response-body-converter.md)                   | [androidJvm]<br>open override fun [responseBodyConverter](response-body-converter.md)(type: [Type](https://developer.android.com/reference/kotlin/java/lang/reflect/Type.html), annotations: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Annotation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)&gt;, retrofit: Retrofit): Converter&lt;ResponseBody, *&gt;?                                                                                                                                                                            |
| [stringConverter](index.md#1793204440%2FFunctions%2F-912451524)       | [androidJvm]<br>open fun [stringConverter](index.md#1793204440%2FFunctions%2F-912451524)(p0: [Type](https://developer.android.com/reference/kotlin/java/lang/reflect/Type.html), p1: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Annotation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-annotation/index.html)&gt;, p2: Retrofit): Converter&lt;*, [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;?                                                                                                                      |
