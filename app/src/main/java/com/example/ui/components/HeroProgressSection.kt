package com.example.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.NetworkSummary
import com.example.ui.theme.*

@Composable
fun HeroProgressSection(
    summary: NetworkSummary,
    onReviewClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val animatedProgress by animateFloatAsState(
        targetValue = (summary.compliancePercent / 100f).coerceIn(0f, 1f),
        label = "progress"
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("hero_progress_card"),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = GeoPrimaryContainer),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Column {
                Text(
                    text = "Hydraulic Network Health",
                    style = MaterialTheme.typography.labelLarge,
                    color = GeoOnPrimaryContainer,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "${summary.compliancePercent}% Compliant",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Light,
                        fontSize = 32.sp
                    ),
                    color = GeoOnPrimaryContainer
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                // Geometric Balance styled progress bar
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(CircleShape)
                        .background(GeoAccentLilac)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(animatedProgress)
                            .clip(CircleShape)
                            .background(GeoPrimary)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${summary.totalPipes} pipes · ${summary.totalLengthMeters.toInt()}m total length",
                        style = MaterialTheme.typography.bodySmall,
                        color = GeoTextSecondary,
                        fontSize = 12.sp
                    )

                    Button(
                        onClick = onReviewClick,
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = GeoPrimary,
                            contentColor = GeoOnPrimary
                        ),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        modifier = Modifier
                            .shadow(2.dp, CircleShape)
                            .testTag("hero_review_button")
                    ) {
                        Text(
                            text = "Review",
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}
