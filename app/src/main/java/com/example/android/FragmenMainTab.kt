package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android.databinding.ActivityFragmenMainTabBinding
import com.google.android.material.tabs.TabLayoutMediator

class FragmenMainTab : AppCompatActivity() {

    val binding by lazy { ActivityFragmenMainTabBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 1. 페이지 데이터를 로드
        val list = listOf(FragmentATab(), FragmentBTab(), FragmentCTab(), FragmentDTab())
        // 2. 어댑터 생성
        val pagerAdapter = FragmentPagerAdapter(list, this)

        with(binding) {
            // 3. 어댑터와 뷰페이저 연결
            viewPager.adapter = pagerAdapter

            // 4. 탭 메뉴 갯수만큼 제목 생성
            val titles = listOf("A","B","C","D")
            // 5. 탭 메뉴와 뷰페이저 연결
            TabLayoutMediator(tabMenu, viewPager) { tab, position ->
                tab.text = titles.get(position)
            }.attach()
        }
    }


    class FragmentPagerAdapter(
        val fragmentList: List<Fragment>,
        fragmentActivity: FragmentActivity
    ) : FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount() = fragmentList.size
        override fun createFragment(position: Int) = fragmentList.get(position)
    }
}