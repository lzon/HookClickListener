package com.dn_alan.xxxxxxxx.dagger;

import com.dn_alan.xxxxxxxx.mvp.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * 用@Module注解标注，主要用来提供依赖。为了提供那些没有构造函数的类的依赖，
 * 这些类无法用@Inject标注，比如第三方类库，系统类，以及上面示例的View接口。
 */
@Module
public class MainModule {
    private final MainContract.View mView;

    public MainModule(MainContract.View view) {
        mView = view;
    }

    /**
     * 这个以provide开头的方法就是提供依赖的，我们可以创建多个方法来提供不同的依赖。
     * @return
     */
    @Provides
    MainContract.View provideMainView() {
        return mView;
    }
}
