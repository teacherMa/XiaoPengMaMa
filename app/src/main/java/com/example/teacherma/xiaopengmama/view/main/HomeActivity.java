package com.example.teacherma.xiaopengmama.view.main;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.teacherma.xiaopengmama.R;
import com.example.teacherma.xiaopengmama.view.createnew.CreateNewFragment;
import com.example.teacherma.xiaopengmama.view.history.HistoryFragment;

/**
 * @author teacherMa on 2018/3/10
 *         主界面Activity，左侧是一个侧拉菜单，右侧是Fragment容器。
 *         点击侧拉菜单，切换容器中对应的Fragment
 */
public class HomeActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {
    private static final String KEY_CREATE_NEW_FRAGMENT = "CREATE_NEW_FRAGMENT";
    private static final String KEY_HISTORY_FRAGMENT = "HISTORY_FRAGMENT";

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private FrameLayout mMainContent;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mDrawerLayout = findViewById(R.id.main_drawer_layout);
        mToolbar = findViewById(R.id.main_container_tool_bar);
        mMainContent = findViewById(R.id.content_container);
        mNavigationView = findViewById(R.id.main_navigation_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.open_drawer_description, R.string.close_drawer_description);
        mDrawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // TODO: 2018/3/10 这里实现非常丑陋，跳转到哪个页面和HomeActivity是无关的
        FragmentManager fragmentManager = getSupportFragmentManager();
        int id = item.getItemId();
        switch (id) {
            case R.id.item_create_new:
                Fragment createNew = fragmentManager.findFragmentByTag(KEY_CREATE_NEW_FRAGMENT);
                if (null == createNew) {
                    createNew = new CreateNewFragment();
                }
                fragmentManager.beginTransaction().replace(R.id.content_container, createNew, KEY_CREATE_NEW_FRAGMENT).commit();
                break;
            case R.id.item_history:
                Fragment history = fragmentManager.findFragmentByTag(KEY_HISTORY_FRAGMENT);
                if (null == history) {
                    history = new HistoryFragment();
                }
                fragmentManager.beginTransaction().replace(R.id.content_container, history, KEY_HISTORY_FRAGMENT).commit();
                break;
            default:
                break;
        }
        mDrawerLayout.closeDrawers();
        return true;
    }
}
