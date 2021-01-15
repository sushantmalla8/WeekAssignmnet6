package com.assignment.esoftwarica.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.viewpager.widget.ViewPager
import com.assignment.esoftwarica.R
import com.assignment.esoftwarica.adapter.ViewPagerAdapter
import com.assignment.esoftwarica.fragments.AboutFragment
import com.assignment.esoftwarica.fragments.HomeFragment
import com.assignment.esoftwarica.fragments.StudentFragment
import com.assignment.esoftwarica.model.Student
import com.google.android.material.tabs.TabLayout

class DashboardActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager;
    private lateinit var tabLayout: TabLayout;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportActionBar?.hide();
        setContentView(R.layout.activity_dashboard)

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        loadViewPagerAdapter();
        loadlist()
    }

    private fun loadViewPagerAdapter() {
        val adapter = ViewPagerAdapter(supportFragmentManager);
        adapter.addFragment(HomeFragment(), "Home");
        adapter.addFragment(StudentFragment(), "Add Student");
        adapter.addFragment(AboutFragment(), "About Us");
        viewPager.adapter = adapter;
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_icons8_student_registration_100);
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_notifications_24);


    }
    //creating list
    private fun loadlist(){
        if (lisfOfStudent.size==0){
            lisfOfStudent.add(Student("Ravi Paudel", "21", "Baneshwor", "Male"));
            lisfOfStudent.add(Student("Sashila Acharya", "21", "Koteshwor", "Female"));
            lisfOfStudent.add(Student("Lila Paudel", "23", "Baneshwor", "Female"));
        }
    }
    companion object {
        var lisfOfStudent = arrayListOf<Student>();
    }
}