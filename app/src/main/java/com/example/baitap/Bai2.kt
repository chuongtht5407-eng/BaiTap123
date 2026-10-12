package com.example.baitap

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun getRank2(score: Double?): String {
    if (score == null) return "Chưa có điểm"
    return if (score < 0.0 || score > 10.0) "Không hợp lệ"
    else if (score >= 8.0) "Giỏi"
    else if (score >= 6.5) "Khá"
    else if (score >= 5.0) "Trung bình"
    else "Yếu"
}

fun getRankColor2(score: Double?): Color {
    if (score == null) return Color.Gray
    return if (score < 0.0 || score > 10.0) Color.Gray
    else if (score >= 8.0) Color(0xFF2E7D32)
    else if (score >= 6.5) Color(0xFF1565C0)
    else if (score >= 5.0) Color(0xFFE65100)
    else Color(0xFFC62828)
}

fun getRankBgColor2(score: Double?): Color {
    if (score == null) return Color(0xFFEEEEEE)
    return if (score < 0.0 || score > 10.0) Color(0xFFEEEEEE)
    else if (score >= 8.0) Color(0xFFE8F5E9)
    else if (score >= 6.5) Color(0xFFE3F2FD)
    else if (score >= 5.0) Color(0xFFFFF3E0)
    else Color(0xFFFFEBEE)
}

@Composable
fun Bai2Screen() {
    val mainScore = 8.5
    val extraScores = listOf(9.0, 7.0, 5.5, 3.0, 11.0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Điểm trung bình",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "$mainScore",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E293B)
                )
                Spacer(modifier = Modifier.height(12.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(getRankBgColor2(mainScore), shape = RoundedCornerShape(6.dp))
                        .padding(vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = getRank2(mainScore),
                        color = getRankColor2(mainScore),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "KIỂM TRA THÊM",
            color = Color.Gray,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        for (score in extraScores) {
            val scoreLabel = if (score == score.toLong().toDouble()) "${score.toLong()}" else "$score"

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Điểm $scoreLabel",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF1E293B)
                    )

                    Box(
                        modifier = Modifier
                            .background(getRankBgColor2(score), shape = RoundedCornerShape(4.dp))
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = getRank2(score),
                            color = getRankColor2(score),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Bai2Preview() {
    Bai2Screen()
}
