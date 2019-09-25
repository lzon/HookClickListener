package com.dn_alan.xxxxxxxx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dn_alan.xxxxxxxx.bean.Person;
import com.dn_alan.xxxxxxxx.dagger.DaggerActivityComponent;

import javax.inject.Inject;

public class Main2Activity extends AppCompatActivity {

    /**
     * 普通注入演示**
     *
     */
    @Inject
    Person person;

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DaggerActivityComponent.create().inject(this);
        v = findViewById(R.id.button);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "Love " + person.name, Toast.LENGTH_SHORT).show();


            }
        });


        //所以，这个hook动作，必须在setOnClickListener之后，不然就不起作用
        //这个hook的作用，是 用我们自己创建的点击事件代理对象，替换掉之前的点击事件。
        HookSetOnClickListenerHelper.hook(this, this.v);
    }
}
