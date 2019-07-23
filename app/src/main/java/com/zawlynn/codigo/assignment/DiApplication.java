package com.zawlynn.codigo.assignment;

import android.app.Application;
import com.zawlynn.codigo.assignment.di.component.DaggerDataComponent;
import com.zawlynn.codigo.assignment.di.component.DataComponent;
import com.zawlynn.codigo.assignment.di.module.ApplicationContextModule;


public class DiApplication extends Application {
    DataComponent component;
    static DiApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        component= DaggerDataComponent.builder().applicationContextModule(new ApplicationContextModule(this)).build();
    }
    public DataComponent getComponent(){
        return component;
    }
    public static DiApplication getInstance(){
        return instance;
    }
}
