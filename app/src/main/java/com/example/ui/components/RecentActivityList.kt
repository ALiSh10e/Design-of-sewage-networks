package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*

data class ActivityItemData(
    val id: String,
    val icon: String,
    val title: String,
    val description: String,
    val timeAgo: String
)

@Composable
fun RecentActivityList(
    items: List<ActivityItemData>,
    onItemClick: (ActivityItemData) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "RECENT CALCULATIONS & LOGS",
            style = MaterialTheme.typography.labelSmall.copy(
                letterSpacing = 1.2.sp,
                fontWeight = FontWeight.SemiBold
            ),
            color = GeoTextSecondary,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            items.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .clickable { onItemClick(item) }
                        .padding(horizontal = 12.dp, vertical = 10.dp)
                        .testTag("activity_item_${item.id}"),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(GeoSurface),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = item.icon, fontSize = 18.sp)
                    }

                    Spacer(modifier = Modifier.width(14.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp
                            ),
                            color = GeoTextPrimary
                        )
                        Text(
                            text = item.description,
                            style = MaterialTheme.typography.bodySmall.copy(
                                fontSize = 12.sp
                            ),
                            color = GeoTextSecondary
                        )
                    }

                    Text(
                        text = item.timeAgo,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 10.sp
                        ),
                        color = GeoTextTertiary
                    )
                }
            }
        }
    }
}
