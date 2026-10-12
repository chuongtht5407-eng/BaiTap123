package com.example.baitap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

data class Student(
    val id: Int = 0,
    val name: String,
    val email: String? = null,
    val phone: String? = null,
    val score: Double? = null
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = { Text("Bài Tập Về Nhà - UTH", color = Color.White) },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF1E3A8A))
                )
                TabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = Color(0xFF1E3A8A),
                    contentColor = Color.White
                ) {
                    Tab(selected = selectedTab == 0, onClick = { selectedTab = 0 }, text = { Text("Bài 1") })
                    Tab(selected = selectedTab == 1, onClick = { selectedTab = 1 }, text = { Text("Bài 2") })
                    Tab(selected = selectedTab == 2, onClick = { selectedTab = 2 }, text = { Text("Bài 3") })
                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (selectedTab) {
                0 -> Bai1Screen()
                1 -> Bai2Screen()
                2 -> Bai3Screen()
            }
        }
    }
}
