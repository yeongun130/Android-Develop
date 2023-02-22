package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.android.databinding.ActivityRecyclerViewPagerBinding
import com.example.android.databinding.ItemViewpagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class RecyclerViewPager : AppCompatActivity() {

    val binding by lazy { ActivityRecyclerViewPagerBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 1. 데이터 로드
        val list = loadData()
        // 2. 어댑터 생성
        val pagerAdapter = CustomPagerAdapter(list)
        with(binding) {
            // 3. 어댑터와 뷰페이저 연결
            viewPager.adapter = pagerAdapter
            // 4. 탭 타이틀 생성
            val titles = listOf("월", "화", "수", "목", "금", "토", "일")
            // 5. 뷰페이저와 탭 메뉴 연결
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = titles.get(position)
            }.attach()
        }
    }
    fun loadData(): List<Page> {
        val pageList = mutableListOf<Page>()
        pageList.add(Page("월요일", 1, "맑음"))
        pageList.add(Page("화요일", 2, "흐림"))
        pageList.add(Page("수요일", 3, "구름"))
        pageList.add(Page("목요일", 4, "눈"))
        pageList.add(Page("금요일", 5, "비"))
        pageList.add(Page("토요일", 6, "바람 많이 붐"))
        pageList.add(Page("일요일", 7, "존나 더움"))
        return pageList
    }
}

class CustomPagerAdapter(val pageList:List<Page>) : androidx.recyclerview.widget.RecyclerView.
                                                            Adapter<CustomPagerAdapter.Holder>() {
    class Holder(val binding: ItemViewpagerBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
        fun setItem(page:Page) {
            with(binding) {
                textWeek.text = page.week
                textDay.text = "${page.day}일"
                textWeather.text = page.weather
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemViewpagerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun getItemCount() = pageList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setItem(pageList.get(position))
    }
}

data class Page(val week:String, val day:Int, val weather:String)