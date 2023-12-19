//[app](../../../../index.md)/[icu.repsaj.android.mytrivia.ui.navigation](../../index.md)/[NavRoutes](../index.md)/[Companion](index.md)/[getNavRouteFromRoute](get-nav-route-from-route.md)

# getNavRouteFromRoute

[androidJvm]\
fun [getNavRouteFromRoute](get-nav-route-from-route.md)(
route: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [NavRoutes](../index.md)

Retrieves the [NavRoutes](../index.md) enum value corresponding to a given route string. If the
route string does not match any known routes, defaults
to [NavRoutes.Categories](../-categories/index.md).

#### Return

The corresponding [NavRoutes](../index.md) value.

#### Parameters

androidJvm

|       |                   |
|-------|-------------------|
| route | The route string. |
