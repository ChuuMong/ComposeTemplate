package com.chuumong.feature.planet

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import com.chuumong.core.ui.Colors

fun DrawScope.drawSaturn(
    center: Offset,
    outlineStyle: Stroke,
) {

    drawCircle(
        center = center,
        color = Colors.white,
        radius = 100f,
        style = outlineStyle
    )

    drawArc(
        topLeft = Offset(center.x - 80f, center.y - 80f),
        color = Colors.white,
        startAngle = 180f,
        sweepAngle = 90f,
        useCenter = false,
        style = Stroke(width = 2f),
        size = Size(160f, 160f)
    )

    rotate(40f, center) {
        drawArc(
            color = Colors.white,
            startAngle = 217f,
            sweepAngle = 285f,
            useCenter = false,
            topLeft = Offset(center.x - 50f, center.y - 150f),
            style = outlineStyle,
            size = Size(100f, 300f)
        )
    }
}

fun DrawScope.drawPlanet(
    center: Offset,
    outlineStyle: Stroke,
    degrees: Float,
) {
    drawCircle(
        center = center,
        color = Colors.white,
        radius = 80f,
        style = outlineStyle
    )

    drawMoon(center, outlineStyle, degrees)

    drawPath(
        path = Path().apply {
            moveTo(center.x - 82f, center.y)
            quadraticTo(center.x - 45f, center.y + 5f, center.x, center.y)
        },
        color = Colors.white,
        style = Stroke(
            width = 3f,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(60f, 10f, 50f, 10f), 0f)
        )
    )

    drawPath(
        path = Path().apply {
            moveTo(center.x - 78f, center.y + 25f)
            quadraticTo(center.x - 45f, center.y + 30f, center.x + 10f, center.y + 25f)
        },
        color = Colors.white,
        style = Stroke(
            width = 3f,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(60f, 10f, 50f, 10f), 0f)
        )
    )

    drawPath(
        path = Path().apply {
            moveTo(center.x - 65f, center.y + 50f)
            quadraticTo(center.x - 50f, center.y + 55f, center.x - 20f, center.y + 52f)
        },
        color = Colors.white,
        style = Stroke(width = 3f)
    )
}

fun DrawScope.drawMoon(
    center: Offset,
    outlineStyle: Stroke,
    degrees: Float,
) {

    rotate(degrees = degrees, pivot = center) {
        drawCircle(
            center = Offset(center.x - 100f, center.y + 80f),
            color = Colors.white,
            radius = 15f,
            style = outlineStyle
        )

        drawArc(
            topLeft = Offset(center.x - 125f, center.y - 125f),
            color = Colors.white,
            startAngle = 160f,
            sweepAngle = 200f,
            useCenter = false,
            style = Stroke(
                width = 2f,
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(160f, 70f, 50f, 80f, 40f, 40f), 0f)
            ),
            size = Size(250f, 250f)
        )
    }
}