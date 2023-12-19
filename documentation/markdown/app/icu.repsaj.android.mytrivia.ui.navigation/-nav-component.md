//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.navigation](index.md)/[NavComponent](-nav-component.md)

# NavComponent

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [NavComponent](-nav-component.md)(
navController: [NavHostController](https://developer.android.com/reference/kotlin/androidx/navigation/NavHostController.html),
modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) =
Modifier)

Composable function that sets up the navigation graph for the application. It defines the navigation
routes and associates them with corresponding screens.

#### Parameters

androidJvm

|               |                                                     |
|---------------|-----------------------------------------------------|
| navController | The NavHostController that controls the navigation. |
| modifier      | The Modifier to be applied to the NavHost.          |
