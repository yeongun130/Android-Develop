package com.example.android

import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.databinding.ActivityRecyclerViewBinding
import com.example.android.databinding.ItemRecyclerBinding

class RecyclerView : AppCompatActivity() {

    val binding by lazy { ActivityRecyclerViewBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 1. 데이터를 불러온다.
        val data = loadMemoList()
        // 2. 어댑터를 생성한다.
        val custemAdapter = CustemAdapter(data)
        // 3. 화면의 recycler와 연결
        binding.recyclerView.adapter = custemAdapter
        // 4. 레이아웃 매니저 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }

    fun loadMemoList() : MutableList<Memo> {
        val memoList = mutableListOf<Memo>()
        for (no in 1..100) {
            val title = "Android $no"
            val date = System.currentTimeMillis()
            val memo = Memo(no,title,date)
            memoList.add(memo)
        }
        return memoList
    }
}

class CustemAdapter(val listData:MutableList<Memo>) : androidx.recyclerview.widget.RecyclerView.Adapter<CustemAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return Holder(binding)
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        // 1. 사용할 데이터를 꺼낸다.
        val memo = listData.get(position)
        // 2. 홀더에 데이터 전달
        holder.setMemo(memo)
    }

    class Holder(val binding: ItemRecyclerBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
        lateinit var currentMemo:Memo
        // 클릭처리는 init에서만 한다.
        init {
            binding.root.setOnClickListener {
                Toast.makeText(binding.root.context,"클릭된 item : ${currentMemo.title}",Toast.LENGTH_SHORT).show()
            }
        }

        // 3. 받은 데이터를 화면에 출력한다.
        fun setMemo(memo:Memo) {

            currentMemo = memo

            with(binding) {
                textNo.text = "${memo.no}"
                textTitle.text = memo.title

               val sdf = SimpleDateFormat("yyyy-MM-dd")
               val formattedData = sdf.format(memo.timestamp)
               textDate.text = formattedData
            }
        }
    }
}
