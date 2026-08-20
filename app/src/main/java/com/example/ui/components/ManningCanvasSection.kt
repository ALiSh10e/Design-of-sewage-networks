package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.ManningCalculation
import com.example.ui.theme.*
import kotlin.math.*

@Composable
fun ManningCanvasSection(
    calc: ManningCalculation,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("manning_canvas_card"),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = GeoSurfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Circular Pipe Hydraulic Section",
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.SemiBold),
                    color = GeoTextPrimary
                )
                Text(
                    text = "d/D = ${(calc.dRatio * 100).toInt()}%",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = if (calc.isDepthRatioSafe) GeoPrimary else GeoWarning
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Canvas(
                modifier = Modifier
                    .size(200.dp)
                    .background(GeoSurface, RoundedCornerShape(16.dp))
                    .padding(12.dp)
            ) {
                val center = Offset(size.width / 2f, size.height / 2f)
                val radius = (min(size.width, size.height) / 2f) - 10f

                // Outer pipe wall (Concrete / PVC wall thickness representation)
                drawCircle(
                    color = GeoSecondaryContainer,
                    radius = radius + 6f,
                    center = center,
                    style = Stroke(width = 8f)
                )

                // Pipe inner boundary
                drawCircle(
                    color = GeoTextSecondary.copy(alpha = 0.4f),
                    radius = radius,
                    center = center,
                    style = Stroke(width = 3f)
                )

                // Partial flow water path inside circle
                val waterDepthFraction = calc.dRatio.toFloat().coerceIn(0f, 1f)
                val waterTopY = (center.y + radius) - (2f * radius * waterDepthFraction)

                val clipCircle = Path().apply {
                    addOval(androidx.compose.ui.geometry.Rect(center.x - radius, center.y - radius, center.x + radius, center.y + radius))
                }

                clipPath(clipCircle) {
                    // Water background
                    drawRect(
                        color = GeoAccentLilac.copy(alpha = 0.85f),
                        topLeft = Offset(center.x - radius, waterTopY),
                        size = Size(radius * 2f, (center.y + radius) - waterTopY)
                    )

                    // Water surface line
                    drawLine(
                        color = GeoPrimary,
                        start = Offset(center.x - radius, waterTopY),
                        end = Offset(center.x + radius, waterTopY),
                        strokeWidth = 3f
                    )
                }

                // Crown, Invert, and Centerline markers
                // Invert point
                drawCircle(
                    color = GeoPrimary,
                    radius = 4f,
                    center = Offset(center.x, center.y + radius)
                )

                // Crown point
                drawCircle(
                    color = GeoTextSecondary,
                    radius = 3f,
                    center = Offset(center.x, center.y - radius)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Water Depth", style = MaterialTheme.typography.bodySmall, color = GeoTextSecondary, fontSize = 11.sp)
                    Text(
                        text = "${String.format("%.1f", calc.actualWaterDepthM * 1000)} mm",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                        color = GeoTextPrimary
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Velocity V", style = MaterialTheme.typography.bodySmall, color = GeoTextSecondary, fontSize = 11.sp)
                    Text(
                        text = "${String.format("%.2f", calc.actualV)} m/s",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                        color = if (calc.isSelfCleansing && calc.isMaxVelocitySafe) GeoSuccess else GeoWarning
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Discharge Q", style = MaterialTheme.typography.bodySmall, color = GeoTextSecondary, fontSize = 11.sp)
                    Text(
                        text = "${String.format("%.1f", calc.targetFlowLps)} L/s",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                        color = GeoTextPrimary
                    )
                }
            }
        }
    }
}
