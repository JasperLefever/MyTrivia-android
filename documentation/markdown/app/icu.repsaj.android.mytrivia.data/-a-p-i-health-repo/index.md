//[app](../../../index.md)/[icu.repsaj.android.mytrivia.data](../index.md)/[APIHealthRepo](index.md)

# APIHealthRepo

[androidJvm]\
class [APIHealthRepo](index.md)(
healthService: [IHealthApiService](../../icu.repsaj.android.mytrivia.network.health/-i-health-api-service/index.md)) : [IHealthRepo](../-i-health-repo/index.md)

Repository implementation for accessing the api health via an API. This repository fetches the api
health from a remote data source.

## Constructors

|                                        |                                                                                                                                                  |
|----------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|
| [APIHealthRepo](-a-p-i-health-repo.md) | [androidJvm]<br>constructor(healthService: [IHealthApiService](../../icu.repsaj.android.mytrivia.network.health/-i-health-api-service/index.md)) |

## Functions

| Name            | Summary                                                                                                                                                                                |
|-----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [ping](ping.md) | [androidJvm]<br>open suspend override fun [ping](ping.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Performs a health check on the API. |
