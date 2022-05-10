package com.example.foodhub.ui;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.foodhub.GlobalMethod;
import com.example.foodhub.R;
import com.example.foodhub.fragment.FragmentAdapter.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class Home_Screen extends GlobalMethod {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewPager_home);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final FragmentAdapter adapter = new FragmentAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }



    public void goScreen_(View view) {
        switch (view.getId()) {
            case R.id.my_orders:
                go_screen(MyOrdersHistory.class);
                break;
            case R.id.lbl_profile:
                go_screen(Profile.class);
                break;
            case R.id.delivery_address:
                go_screen(Delivery_Address.class);
                break;
            case R.id.payment_methods:
//                go_screen(payment_methods.class);
                break;
            case R.id.contact_us:
//                go_screen(payment_methods.class);
                break;
            case R.id.settings:
//                go_screen(payment_methods.class);
                break;
            case R.id.helps_faqs:
//                go_screen(payment_methods.class);
                break;
            case R.id.log_out:
//                go_screen(payment_methods.class);
                break;
        }
    }

    public void change(View view) {
        TextView lblAddress=findViewById(R.id.address);
        if (lblAddress.getVisibility() == View.GONE) {
            lblAddress.setVisibility(View.VISIBLE);
            YoYo.with(Techniques.ZoomInUp)
                    .duration(500)
                    .playOn(lblAddress);
        } else

            lblAddress.setVisibility(View.GONE);


    }
    public void onClick(View view) {
        toggle(view.getId());

    }
}