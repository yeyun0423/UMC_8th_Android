package com.example.umc_8th_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigator()
        }
    }
}

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "moodSelection") {
        composable("moodSelection") { MoodSelectionScreen(navController) }
        composable("moodDetail/{moodText}") { backStackEntry ->
            val moodText = backStackEntry.arguments?.getString("moodText") ?: "알 수 없는 감정"
            MoodDetailScreen(moodText)
        }
    }
}

@Composable
fun MoodSelectionScreen(navController: NavController) {
    val moods = listOf(
        Mood("더없이 행복한 하루였어요", R.drawable.happy),
        Mood("들뜨고 흥분돼요", R.drawable.excited),
        Mood("평범한 하루였어요", R.drawable.normal),
        Mood("생각이 많아지고 불안해요", R.drawable.anxiety),
        Mood("부글부글 화가 나요", R.drawable.angry)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5DC))
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "오늘 하루는 어땠나요?",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "감정우표를 선택해주세요.")

        Spacer(modifier = Modifier.height(16.dp))

        moods.forEach { mood ->
            MoodItem(mood, navController)
        }
    }
}

@Composable
fun MoodItem(mood: Mood, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { navController.navigate("moodDetail/${mood.text}") }
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = mood.iconRes),
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = mood.text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun MoodDetailScreen(moodText: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "새로운 페이지",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

data class Mood(val text: String, val iconRes: Int)

@Preview(showBackground = true)
@Composable
fun MoodSelectionScreenPreview() {
    val navController = rememberNavController()
    MoodSelectionScreen(navController)
}
