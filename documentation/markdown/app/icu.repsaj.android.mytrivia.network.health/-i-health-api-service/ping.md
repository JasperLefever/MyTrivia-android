//[app](../../../index.md)/[icu.repsaj.android.mytrivia.network.health](../index.md)/[IHealthApiService](index.md)/[ping](ping.md)

# ping

[androidJvm]\

@GET(value = &quot;health/ping&quot;)

abstract suspend fun [ping](ping.md)():
Response&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;

Performs a health check on the API.

#### Return

A string containing &quot;pong&quot; if the API is healthy.
