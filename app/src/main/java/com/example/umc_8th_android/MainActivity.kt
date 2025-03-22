package com.example.umc_8th_android

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_8th_android.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // ViewBinding을 사용하여 layout 파일과 연결
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)  // root view 설정

        // 헤더, 컨텐츠, 푸터에 대한 작업 처리
        setupHeader()
        setupContent()
        setupFooter()
    }

    // 헤더 관련 설정
    private fun setupHeader() {
        binding.headerTitle.text = "투유" // 헤더 제목 설정
        binding.bellIcon.setOnClickListener {
            // 벨 아이콘 클릭 시 동작
        }
    }

    // 컨텐츠 관련 설정
    private fun setupContent() {
        binding.dateText.text = "날짜" // 날짜 텍스트 설정
        binding.speechBubble.setOnClickListener {
            // 말풍선 클릭 시 동작
        }
        binding.mailbox.setOnClickListener {
            // 메일박스 클릭 시 동작
        }
    }

    // 푸터 관련 설정
    private fun setupFooter() {
        binding.home.setOnClickListener {
            // 홈 아이콘 클릭 시 동작
        }
        binding.pencil.setOnClickListener {
            // 연필 아이콘 클릭 시 동작
        }
        binding.calendar.setOnClickListener {
            // 달력 아이콘 클릭 시 동작
        }
        binding.user.setOnClickListener {
            // 사용자 아이콘 클릭 시 동작
        }
    }
}
