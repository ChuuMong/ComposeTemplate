package com.chuumong.feature.space

import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chuumong.core.ui.Colors
import com.chuumong.feature.planet.drawPlanet
import com.chuumong.feature.planet.drawSaturn
import com.chuumong.feature.stars.drawStars


@Composable
fun SpaceView(modifier: Modifier = Modifier) {

    Box(modifier = modifier) {
        val infiniteTransition = rememberInfiniteTransition(label = "infinite")
        val animationDuration = 3000
        val animationEasing = EaseIn

        val starSizeMultiplierOne by infiniteTransition.animateFloat(
            initialValue = 1f,
            targetValue = 1.5f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = animationDuration, easing = animationEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "starSizeMultiplierOne"
        )
        val starSizeMultiplierTwo by infiniteTransition.animateFloat(
            initialValue = 0.7f,
            targetValue = 1.7f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = animationDuration - 700, easing = animationEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "starSizeMultiplierTwo"
        )
        val degrees by infiniteTransition.animateFloat(
            initialValue = 360f,
            targetValue = 0f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = animationDuration * 6,
                    easing = LinearEasing
                )
            ),
            label = "degrees"
        )
        val centerOffset by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 2f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = animationDuration,
                    easing = EaseIn
                ),
                repeatMode = RepeatMode.Reverse
            ),
            label = "centerOffset"
        )

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(SpaceConstant.padding)
                .drawBehind {
                    drawRoundRect(
                        size = size,
                        cornerRadius = SpaceConstant.shape,
                        brush = Brush.radialGradient(
                            colors = Colors.spaceGradient,
                            radius = size.width * 0.75f
                        )
                    )
                }
        ) {
            Canvas(
                modifier = Modifier
                    .width(SpaceConstant.canvasWidth)
                    .height(SpaceConstant.canvasHeight)
                    .padding(SpaceConstant.canvasPadding)
            ) {
                val outlineStyle = Stroke(width = 4f)

                drawSaturn(
                    center = Offset(
                        size.width * 0.25f + centerOffset,
                        size.height * 0.25f + centerOffset,
                    ),
                    outlineStyle = outlineStyle,
                )

                drawPlanet(
                    center = Offset(center.x + 180f, center.y + 80f),
                    outlineStyle = outlineStyle,
                    degrees = degrees
                )

                drawStars(
                    starSizeMultiplierOne,
                    starSizeMultiplierTwo,
                    size
                )
            }
        }
    }
}

object SpaceConstant {
    val padding = 12.dp
    val shape = CornerRadius(44f)
    val canvasWidth = 300.dp
    val canvasHeight = 200.dp
    val canvasPadding = 12.dp
}

@Preview
@Composable
fun SpaceViewPreview() {
    SpaceView()
}