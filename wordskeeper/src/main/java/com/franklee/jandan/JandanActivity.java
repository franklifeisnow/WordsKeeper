package com.franklee.jandan;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.franklee.wordskeeper.R;
import com.franklee.wordskeeper.adapter.ViewPagerAdapter;

public class JandanActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jandan);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item){
                        switch (item.getItemId()){
                            case R.id.item_wuliao:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.item_duanzi:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.item_meizi:
                                viewPager.setCurrentItem(2);
                                break;

                        }
                        return false;
                    }
                }
        );

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){

            }
            @Override
            public void onPageSelected(int position){
                if(prevMenuItem != null){
                    prevMenuItem.setCheckable(false);
                }else{
                    bottomNavigationView.getMenu().getItem(0).setCheckable(false);
                }
                bottomNavigationView.getMenu().getItem(position).setCheckable(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }


        });
        // 如果想禁止滑动，可以把下面的代码取消注释
//        viewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });

        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(DemoFragment.newInstance("无聊图"));
        adapter.addFragment(DemoFragment.newInstance("段子"));
        adapter.addFragment(DemoFragment.newInstance("妹子图"));
        viewPager.setAdapter(adapter);
    }
}
