//[app](../../index.md)/[icu.repsaj.android.mytrivia.ui.categoryOverview](index.md)/[AnimatedCategoryCard](-animated-category-card.md)

# AnimatedCategoryCard

[androidJvm]\

@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)

fun [AnimatedCategoryCard](-animated-category-card.md)(
name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html),
enabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html),
onClickPlay: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html),
modifier: [Modifier](https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier.html) =
Modifier,
icon: [ImageVector](https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/vector/ImageVector.html) =
Icons.Filled.QuestionMark)

A card that displays a category's name and icon. The card is animated when it is first displayed.

#### Parameters

androidJvm

|             |                                                      |
|-------------|------------------------------------------------------|
| name        | The name of the category.                            |
| enabled     | Whether the card is enabled or not.                  |
| onClickPlay | The callback to be invoked when the card is clicked. |
| modifier    | The modifier to be applied to the card.              |
| icon        | The icon to be displayed on the card.                |
