package com.example.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.sample.R
import com.example.sample.databinding.ActivityViewPagerBinding
import com.example.viewpager2.fragment.PageFirstFragment
import com.example.viewpager2.fragment.PageSecondFragment
import com.example.viewpager2.fragment.PageThirdFragment
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewPagerBinding

    private val images = listOf(
        "https://fastly.picsum.photos/id/120/4928/3264.jpg?hmac=i-8mkfKj_gRyQt9ZJVhbIBXbtIBNcsbI_gwNe_39vus",
        "https://fastly.picsum.photos/id/122/4147/2756.jpg?hmac=-B_1uAvYufznhjeA9xSSAJjqt07XrVzDWCf5VDNX0pQ",
        "https://fastly.picsum.photos/id/110/5000/3333.jpg?hmac=AvUBrnXG4ebvrtC08T95vEzD1I9SryZ8KSQ4iJ9tb9s",
    )

    private val imageAdapter = ImageViewPagerAdapter(images)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_pager)
        setFragmentViewPager()
        setPaddingViewPager()
        binding.viewPager.adapter = imageAdapter

        /*binding.imageViewPager.adapter = imageAdapter*/
        TabLayoutMediator(binding.tabIndicator, binding.viewPager) { _, _ -> }.attach()
    }

    private fun setFragmentViewPager() {
        binding.apply {
            viewPager2.adapter = FragmentViewPager(
                this@ViewPagerActivity,
                listOf(PageFirstFragment(), PageSecondFragment(), PageThirdFragment())
            )

            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                // 탭 이름 지정
                tab.text = "OBJECT ${(position + 1)}"
            }.attach()

//        아래처럼 Fragment 를 선언하여 데이터 전달도 가능하다 ...
//				val firstFragment = PagerFirstFragment()
//        firstFragment.arguments = bundleOf("key" to "value")
//				listOf(firstFragment, PagerSecondFragment(), PagerThirdFragment())
        }
    }

    private fun setPaddingViewPager() {
        binding.viewPager3.apply {
            offscreenPageLimit = 1
            setPageTransformer(MarginPageTransformer(100))
            setPadding(150,0,150,0)

            adapter = imageAdapter
        }
    }

}