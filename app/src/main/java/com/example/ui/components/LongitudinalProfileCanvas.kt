package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Manhole
import com.example.data.model.PipeLink
import com.example.ui.theme.*
import kotlin.math.max
import kotlin.math.min

@Composable
fun LongitudinalProfileCanvas(
    manholes: List<Manhole>,
    pipes: List<PipeLink>,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("longitudinal_profile_card"),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = GeoSurfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Longitudinal Profile & Gradient",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                    color = GeoTextPrimary
                )
                Text(
                    text = "${manholes.size} Nodes · ${pipes.size} Links",
                    style = MaterialTheme.typography.labelSmall,
                    color = GeoTextSecondary
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Legend
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(10.dp).background(Color(0xFF795548), RoundedCornerShape(2.dp)))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Ground Level (GL)", fontSize = 10.sp, color = GeoTextSecondary)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(10.dp).background(GeoPrimary, RoundedCornerShape(2.dp)))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Invert Level (IL)", fontSize = 10.sp, color = GeoTextSecondary)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(10.dp).background(GeoAccentLilac, RoundedCornerShape(2.dp)))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Pipe Profile", fontSize = 10.sp, color = GeoTextSecondary)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Scrollable canvas container
            val scrollState = rememberScrollState()
            val canvasWidth = max(550, manholes.size * 130).dp

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .background(GeoSurface, RoundedCornerShape(16.dp))
                    .horizontalScroll(scrollState)
            ) {
                Canvas(
                    modifier = Modifier
                        .width(canvasWidth)
                        .fillMaxHeight()
                        .padding(horizontal = 24.dp, vertical = 20.dp)
                ) {
                    if (manholes.isEmpty()) return@Canvas

                    val maxGround = manholes.maxOf { it.groundElevation }
                    val minInvert = manholes.minOf { it.invertElevation }
                    val elevationRange = max(1.0, (maxGround - minInvert) + 1.5)

                    val topPadding = 20f
                    val bottomPadding = 45f
                    val graphHeight = size.height - topPadding - bottomPadding
                    val spacing = (size.width - 40f) / max(1, manholes.size - 1)

                    fun getY(elevation: Double): Float {
                        val norm = ((maxGround + 0.5) - elevation) / elevationRange
                        return (topPadding + (norm * graphHeight)).toFloat().coerceIn(topPadding, size.height - bottomPadding)
                    }

                    // Draw ground line path
                    val groundPath = Path()
                    val invertPath = Path()

                    val nodePoints = manholes.mapIndexed { index, mh ->
                        val x = 20f + (index * spacing)
                        val yGround = getY(mh.groundElevation)
                        val yInvert = getY(mh.invertElevation)
                        if (index == 0) {
                            groundPath.moveTo(x, yGround)
                            invertPath.moveTo(x, yInvert)
                        } else {
                            groundPath.lineTo(x, yGround)
                            invertPath.lineTo(x, yInvert)
                        }
                        Triple(x, yGround, yInvert)
                    }

                    // Draw ground terrain
                    drawPath(
                        path = groundPath,
                        color = Color(0xFF8D6E63),
                        style = Stroke(width = 3.5f)
                    )

                    // Draw invert line
                    drawPath(
                        path = invertPath,
                        color = GeoPrimary,
                        style = Stroke(width = 4f)
                    )

                    // Draw manholes (shafts & nodes)
                    manholes.forEachIndexed { index, mh ->
                        val (x, yGround, yInvert) = nodePoints[index]

                        // Shaft rectangle
                        drawRect(
                            color = GeoTextSecondary.copy(alpha = 0.25f),
                            topLeft = Offset(x - 8f, yGround),
                            size = androidx.compose.ui.geometry.Size(16f, yInvert - yGround)
                        )
                        drawLine(
                            color = GeoTextSecondary.copy(alpha = 0.7f),
                            start = Offset(x - 8f, yGround),
                            end = Offset(x - 8f, yInvert),
                            strokeWidth = 1.5f
                        )
                        drawLine(
                            color = GeoTextSecondary.copy(alpha = 0.7f),
                            start = Offset(x + 8f, yGround),
                            end = Offset(x + 8f, yInvert),
                            strokeWidth = 1.5f
                        )

                        // Ground level node
                        drawCircle(
                            color = Color(0xFF5D4037),
                            radius = 4.5f,
                            center = Offset(x, yGround)
                        )

                        // Invert level node
                        drawCircle(
                            color = GeoPrimary,
                            radius = 6f,
                            center = Offset(x, yInvert)
                        )

                        // Native canvas text for Manhole labels & levels
                        drawContext.canvas.nativeCanvas.apply {
                            val paintLabel = android.graphics.Paint().apply {
                                color = android.graphics.Color.parseColor("#1C1B1F")
                                textSize = 26f
                                isFakeBoldText = true
                                textAlign = android.graphics.Paint.Align.CENTER
                            }
                            val paintDetails = android.graphics.Paint().apply {
                                color = android.graphics.Color.parseColor("#49454F")
                                textSize = 20f
                                textAlign = android.graphics.Paint.Align.CENTER
                            }

                            drawText(mh.id, x, size.height - 10f, paintLabel)
                            drawText("GL: ${String.format("%.2f", mh.groundElevation)}", x, yGround - 12f, paintDetails)
                            drawText("IL: ${String.format("%.2f", mh.invertElevation)}", x, yInvert + 26f, paintDetails)
                        }
                    }

                    // Draw pipe info between nodes
                    pipes.forEach { pipe ->
                        val fromIdx = manholes.indexOfFirst { it.id == pipe.fromManholeId }
                        val toIdx = manholes.indexOfFirst { it.id == pipe.toManholeId }
                        if (fromIdx != -1 && toIdx != -1) {
                            val (x1, _, yInv1) = nodePoints[fromIdx]
                            val (x2, _, yInv2) = nodePoints[toIdx]
                            val midX = (x1 + x2) / 2f
                            val midY = (yInv1 + yInv2) / 2f

                            drawContext.canvas.nativeCanvas.apply {
                                val paintPipe = android.graphics.Paint().apply {
                                    color = android.graphics.Color.parseColor("#6750A4")
                                    textSize = 22f
                                    isFakeBoldText = true
                                    textAlign = android.graphics.Paint.Align.CENTER
                                }
                                drawText("Ø${pipe.diameterMm.toInt()}mm · S=${pipe.slopePercent}%", midX, midY - 14f, paintPipe)
                            }
                        }
                    }
                }
            }
        }
    }
}
