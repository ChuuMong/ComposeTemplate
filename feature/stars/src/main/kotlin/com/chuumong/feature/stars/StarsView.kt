package com.chuumong.feature.stars

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import com.chuumong.core.ui.Colors
import com.chuumong.feature.stars.data.Star


fun DrawScope.drawStars(
    starSizeMultiplierOne: Float,
    starSizeMultiplierTwo: Float,
    size: Size
) {
    val stars = getStars(size).mapIndexed { index, star ->
        val multiplier = if (index % 2 == 0) {
            starSizeMultiplierOne
        } else {
            starSizeMultiplierTwo
        }

        star.copy(
            size = star.size * multiplier,
        )
    }

    stars.forEach { (starSize, offset, color) ->
        drawStar(
            starSize = Size(starSize, starSize),
            color = color,
            center = offset,
            outlineStyle = Stroke(width = 2f)
        )
    }
}

private fun DrawScope.drawStar(
    starSize: Size,
    center: Offset,
    color: Color,
    outlineStyle: Stroke
) {
    val path = Path()
    path.moveTo(center.x, center.y - starSize.height * 0.5f)
    path.quadraticTo(center.x, center.y, center.x + starSize.width / 2, center.y)
    path.quadraticTo(center.x, center.y, center.x, center.y + starSize.height / 2)
    path.quadraticTo(center.x, center.y, center.x - starSize.width / 2, center.y)
    path.quadraticTo(center.x, center.y, center.x, center.y - starSize.height / 2)

    drawPath(
        path = path,
        color = color,
        style = outlineStyle
    )
}

private fun getStars(size: Size) =
    listOf(
        Star(
            30f,
            Offset(size.width * 0.5f, size.height * 0.5f),
            Colors.stars[0],
        ),
        Star(
            20f,
            Offset(
                size.width * 0.7f,
                size.height,
            ),
            Colors.stars[1],
        ),
        Star(
            20f,
            Offset(
                25f,
                20f,
            ),
            Colors.stars[2],
        ),
        Star(
            20f,
            Offset(
                size.width * 0.8f,
                60f,
            ),
            Colors.stars[0],
        ),
        Star(
            30f,
            Offset(
                4f,
                size.height * 0.5f,
            ),
            Colors.stars[2],
        ),
        Star(
            20f,
            Offset(
                60f,
                size.height - 60f,
            ),
            Colors.stars[2],
        ),
        Star(
            20f,
            Offset(
                size.width * 0.2f,
                size.height * 0.6f,
            ),
            Colors.stars[2],
        ),
        Star(
            20f,
            Offset(
                size.width * 0.8f,
                60f,
            ),
            Colors.stars[1],
        ),
        Star(
            40f,
            Offset(
                size.width * 0.96f,
                size.height - 40f,
            ),
            Colors.stars[1],
        ),
        Star(
            40f,
            Offset(
                size.width * 0.35f,
                size.height * 0.8f,
            ),
            Colors.stars[1],
        ),
        Star(
            40f,
            Offset(
                size.width * 0.6f,
                100f,
            ),
            Colors.stars[0],
        ),
        Star(
            20f,
            Offset(
                size.width * 0.25f,
                size.height - 20f,
            ),
            Colors.stars[0],
        ),
        Star(
            10f,
            Offset(
                size.width - 40f,
                size.height * 0.5f - 30f,
            ),
            Colors.stars[0],
        ),
        Star(
            10f,
            Offset(
                (size.width * 0.5f) - 20f,
                20f,
            ),
            Colors.stars[0],
        ),
        Star(
            10f,
            Offset(
                size.width,
                30f,
            ),
            Colors.stars[2],
        ),
    )



