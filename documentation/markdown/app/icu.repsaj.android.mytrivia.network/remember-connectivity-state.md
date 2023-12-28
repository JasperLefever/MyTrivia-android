//[app](../../index.md)/[icu.repsaj.android.mytrivia.network](index.md)/[rememberConnectivityState](remember-connectivity-state.md)

# rememberConnectivityState

[androidJvm]\

@ExperimentalCoroutinesApi

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [rememberConnectivityState](remember-connectivity-state.md)(): [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)
&lt;[NetworkConnectionState](-network-connection-state/index.md)&gt;

A composable function that remembers the current network connectivity state.

It creates and observes a Flow of network connection states and provides
a [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html) that
can be used in Compose UI components.

#### Return

A [State](https://developer.android.com/reference/kotlin/androidx/compose/runtime/State.html)
of [NetworkConnectionState](-network-connection-state/index.md) representing the current network
state.
