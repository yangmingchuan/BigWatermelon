package com.ymc.bigwatermelon;

import android.view.KeyEvent;

import com.uxyq7e.test.Button;
import com.uxyq7e.test.GameView;
import com.uxyq7e.test.Image;
import com.uxyq7e.test.tools.tool;

public class MainView extends GameView {
    MyDialog md;
    boolean diatc;

    public MainView() {
        Image title = new Image(286, 300, 507, 130);
        title.setbitmap(tool.loadbitmap("title.png"));
        Button ks = new Button();
        ks.settextsize(70);
        ks.settext("开始游戏");
        ks.setsize(350, 150);
        ks.setposition_center(540, 700);
        ks.setbitmap(tool.loadbitmap("an.png"));
        ks.setclick(new Button.ClickListener() {
            @Override
            public boolean down() {
                return false;
            }

            @Override
            public boolean up() {
                Screen.ge = new Game();
                Screen.gv = Screen.ge;
                return false;
            }
        });
        Button sm = new Button();
        sm.settextsize(70);
        sm.settext("自定义");
        sm.setsize(350, 150);
        sm.setposition_center(540, ks.getposition_center().y + 200);
        sm.setbitmap(tool.loadbitmap("an.png"));
        sm.setclick(new Button.ClickListener() {
            @Override
            public boolean down() {
                return false;
            }

            @Override
            public boolean up() {
//                Screen.gv = Screen.cv;
//                ((InputMethodManager)MainActivity.ma.getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                return false;
            }
        });
        Button tc = new Button();
        tc.settextsize(70);
        tc.settext("退出");
        tc.setsize(350, 150);
        tc.setposition_center(540, sm.getposition_center().y + 200);
        tc.setbitmap(tool.loadbitmap("an.png"));
        tc.setclick(new Button.ClickListener() {
            @Override
            public boolean down() {
                return false;
            }

            @Override
            public boolean up() {
                System.exit(0);
                return false;
            }
        });
        Button gv = new Button();
        gv.settextsize(70);
        gv.settext("设置");
        gv.setsize(350, 150);
        gv.setposition_center(540, tc.getposition_center().y + 200);
        gv.setbitmap(tool.loadbitmap("an.png"));
        gv.setclick(new Button.ClickListener() {
            @Override
            public boolean down() {
                return false;
            }

            @Override
            public boolean up() {
                Screen.grav = new GravityView();
                Screen.gv = Screen.grav;
                return false;
            }
        });
        md = new MyDialog();
        md.setTitle("退出游戏");
        md.setltext("取消");
        md.qx.setclick(new Button.ClickListener() {

            @Override
            public boolean down() {
                return false;
            }

            @Override
            public boolean up() {
                diatc = false;
                removedialog(0);
                return false;
            }
        });
        md.setrtext("确定");
        md.qd.setclick(new Button.ClickListener() {

            @Override
            public boolean down() {
                return false;
            }

            @Override
            public boolean up() {
                System.exit(0);
                removedialog(0);
                return false;
            }
        });
        addview(title);
        addview(ks);
        addview(sm);
        addview(tc);
        addview(gv);
    }

    @Override
    public boolean onKeyDown(int keycode) {
        if (keycode == KeyEvent.KEYCODE_BACK) {
            if (diatc) removedialog(0);
            else adddialog(md);
            return true;
        }
        return super.onKeyDown(keycode);
    }
}
