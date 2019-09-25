package com.dn_alan.xxxxxxxx.bean;

import javax.inject.Inject;

public class Person {
    public String name = "李";
    public String age;

    @Inject
    public Person(ZS zs) {
    }
}
