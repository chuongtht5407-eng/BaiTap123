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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Bai1Screen() {
    val students = listOf(
        Student(1, "Nguyễn Văn An", "an@sv.edu.vn", "0901 234 567"),
        Student(2, "Trần Thị Bình", null, "0912 888 999"),
        Student(3, "Lê Minh Chi", "chi@sv.edu.vn", null),
        Student(4, "Phạm Quốc Dũng", null, null),
        Student(5, "Võ Thanh Em", "em@sv.edu.vn", "0933 111 222")
    )

    var missingEmailCount = 0
    for (s in students) {
        if (s.email == null) {
            missingEmailCount++
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        for (s in students) {
            val emailDisplay = s.email ?: "Chưa cập nhật"
            val phoneDisplay = s.phone ?: "Chưa cập nhật"

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = s.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color(0xFF1E293B)
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    Row {
                        Text("Email: ", fontSize = 13.sp, color = Color.Gray)
                        Text(
                            text = emailDisplay,
                            fontSize = 13.sp,
                            color = if (s.email == null) Color(0xFFE65100) else Color.Gray,
                            fontStyle = if (s.email == null) FontStyle.Italic else FontStyle.Normal
                        )
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Row {
                        Text("SĐT: ", fontSize = 13.sp, color = Color.Gray)
                        Text(
                            text = phoneDisplay,
                            fontSize = 13.sp,
                            color = if (s.phone == null) Color(0xFFE65100) else Color.Gray,
                            fontStyle = if (s.phone == null) FontStyle.Italic else FontStyle.Normal
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Tổng: ${students.size} sinh viên",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFF1E293B)
                )
                Text(
                    text = "Thiếu email: $missingEmailCount",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color(0xFF1E293B)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Bai1Preview() {
    Bai1Screen()
}
