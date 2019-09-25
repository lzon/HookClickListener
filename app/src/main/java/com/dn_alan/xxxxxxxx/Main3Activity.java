package com.dn_alan.xxxxxxxx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dn_alan.xxxxxxxx.dagger.DaggerMainComponent;
import com.dn_alan.xxxxxxxx.dagger.MainModule;
import com.dn_alan.xxxxxxxx.mvp.MainContract;

import javax.inject.Inject;

/**
 * MVP中的使用
 * 注入演示**
 */
public class Main3Activity extends AppCompatActivity implements MainContract.View {
    TextView textView;

    /**
     * @Inject 表明MainPresenter是需要注入到Main3Activity中，即Main3Activity依赖于MainPresenter
     * 这里要注意的是，使用@Inject时，不能用private修饰符修饰类的成员属性。
     * @param mView
     */
    @Inject
    MainContract.MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_dagger2);
        textView = findViewById(R.id.textView);
        /***
         * 这里通过new MainModule(this)将view传递到MainModule里
         * 然后MainModule里的provideMainView()方法返回这个View
         *
         * 当去实例化MainPresenter时，发现构造函数有个参数
         * 此时会在Module里查找提供这个依赖的方法，将该View传递进去，这样就完成了presenter里View的注入。
         */
        DaggerMainComponent.builder().mainModule(new MainModule(this)).build().inject(this);
    }

    @Override
    public void onBackPressed() {
        mainPresenter.loadData();
    }

    @Override
    public void updateUI(Object o) {
        textView.setText("" + o);
    }
}
