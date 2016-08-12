package com.solution.jens.sacheck;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.solution.jens.sacheck.adapter.TabFragmentPagerAdapter;
import com.solution.jens.sacheck.fragment.CheckSalaryFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout fTabLayout;
    private CheckSalaryFragment salaryFragment = new CheckSalaryFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        fTabLayout = (TabLayout) findViewById(R.id.tabs);

        viewPager.setAdapter(new TabFragmentPagerAdapter(getSupportFragmentManager(),
                salaryFragment, salaryFragment.getVariableFragment()));

        fTabLayout.setSmoothScrollingEnabled(true);
        fTabLayout.setFillViewport(true);
//        Set tab to view pager
        fTabLayout.setupWithViewPager(viewPager);


//        Konfigurasi gravity fill untuk tab berada di posisi yang proporsional
        fTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


//        setupTabIcon();

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
