package com.dn_alan.xxxxxxxx.mvp;


import javax.inject.Inject;

/**
 * 把Presenter和View放在一个文件中，是为业务逻辑和界面逻辑看起来更加清析
 */
public class MainContract {
    public interface View extends IBaseView {
        void updateUI(Object o);
    }
    public static class MainPresenter implements IBasePresenter {
        private static MainContract.View mView;

        /**
         * 在MainPresenter的构造函数上同样加了@Inject注解。
         * 这样MainActivity里的mainPresenter与他的构造函数建立了某种联系
         *
         * @param mView
         */
        @Inject
        public MainPresenter(MainContract.View mView) {
            this.mView = mView;
        }

        public void loadData() {
            //调用model层方法，加载数据
            //回调方法成功时
            mView.updateUI("注入成功~");
        }
    }
}
