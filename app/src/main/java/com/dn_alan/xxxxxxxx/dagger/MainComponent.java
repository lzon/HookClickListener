package com.dn_alan.xxxxxxxx.dagger;

import com.dn_alan.xxxxxxxx.Main2Activity;
import com.dn_alan.xxxxxxxx.Main3Activity;

import dagger.Component;

/**
 * 一个Component类可以包含多个Module类，用来提供依赖
 */
@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(Main3Activity main3Activity);
}
