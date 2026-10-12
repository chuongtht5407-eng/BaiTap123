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
import java.util.Locale

@Composable
fun Bai3Screen() {
    val students = listOf(
        Student(1, "Nguyễn Văn An", score = 9.0),
        Student(2, "Trần Thị Bình", score = 7.2),
        Student(3, "Lê Minh Chi", score = null),
        Student(4, "Phạm Quốc Dũng", score = 4.5),
        Student(5, "Võ Thanh Em", score = 5.8)
    )

    var totalScore = 0.0
    var validCount = 0
    var gioiCount = 0
    var noScoreCount = 0
    var maxScore = 0.0

    for (s in students) {
        val score = s.score
        if (score == null) {
            noScoreCount++
        } else {
            totalScore += score
            validCount++
            if (score >= 8.0) {
                gioiCount++
            }
            if (score > maxScore) {
                maxScore = score
            }
        }
    }

    val avgScore = if (validCount > 0) totalScore / validCount else 0.0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E3A8A)),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Điểm trung bình lớp",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = String.format(Locale.US, "%.2f", avgScore),
                    color = Color.White,
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Giỏi", color = Color.White.copy(alpha = 0.7f), fontSize = 11.sp)
                        Spacer(modifier = Modifier.height(2.dp))
                        Text("$gioiCount", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Chưa có điểm", color = Color.White.copy(alpha = 0.7f), fontSize = 11.sp)
                        Spacer(modifier = Modifier.height(2.dp))
                        Text("$noScoreCount", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Cao nhất", color = Color.White.copy(alpha = 0.7f), fontSize = 11.sp)
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = if (validCount > 0) "$maxScore" else "--",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "DANH SÁCH · ${students.size} SINH VIÊN",
            color = Color.Gray,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        for (s in students) {
            val scoreDisplay = if (s.score != null) "${s.score}" else "—"
            val rankDisplay = getRank2(s.score)

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
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = s.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color(0xFF1E293B)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = rankDisplay,
                            color = if (s.score == null) Color.Gray else getRankColor2(s.score),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Text(
                        text = scoreDisplay,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = if (s.score != null) Color(0xFF1E3A8A) else Color.Gray
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Bai3Preview() {
    Bai3Screen()
}
