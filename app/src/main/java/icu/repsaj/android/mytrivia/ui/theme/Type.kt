package icu.repsaj.android.mytrivia.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import icu.repsaj.android.mytrivia.R

val robotoFamily = FontFamily(
    Font(resId = R.font.robotothin, weight = FontWeight.Thin, style = FontStyle.Normal),
    Font(resId = R.font.robotothinitalic, weight = FontWeight.Thin, style = FontStyle.Italic),
    Font(resId = R.font.robotolight, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(resId = R.font.robotolightitalic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(resId = R.font.robotoregular, weight = FontWeight.Normal, style = FontStyle.Normal),
    Font(resId = R.font.robotomedium, weight = FontWeight.Medium, style = FontStyle.Normal),
    Font(resId = R.font.robotomediumitalic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(resId = R.font.robotobold, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(resId = R.font.robotobolditalic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(resId = R.font.robotoblack, weight = FontWeight.Black, style = FontStyle.Normal),
    Font(resId = R.font.robotoblackitalic, weight = FontWeight.Black, style = FontStyle.Italic),
)


// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        letterSpacing = 0.15.sp,
        textAlign = TextAlign.Start
    ), displayMedium = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 0.15.sp,
        textAlign = TextAlign.Start
    ), displaySmall = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp,
        textAlign = TextAlign.Start
    ), headlineLarge = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        letterSpacing = 0.15.sp,
        textAlign = TextAlign.Start
    ), headlineMedium = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp,
        textAlign = TextAlign.Start
    ), headlineSmall = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 0.15.sp,
        textAlign = TextAlign.Start
    ), titleLarge = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        letterSpacing = 0.15.sp,
        textAlign = TextAlign.Start
    ), titleMedium = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp,
        textAlign = TextAlign.Start
    ), titleSmall = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 0.15.sp,
        textAlign = TextAlign.Start
    ), bodyLarge = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Start
    ), bodyMedium = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Start
    ), bodySmall = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Start
    ), labelLarge = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 1.25.sp,
        textAlign = TextAlign.Start
    ), labelMedium = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 1.25.sp,
        textAlign = TextAlign.Start
    ), labelSmall = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 1.25.sp,
        textAlign = TextAlign.Start
    )
)

