package com.ymc.bigwatermelon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity
{
    Screen scr=null;
    public static SharedPreferences fs;
    public static boolean creat;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        fs=getSharedPreferences("diyi", Context.MODE_PRIVATE);
        Game.firstopen=fs.getBoolean("first",true);
        scr=new Screen(this);
        setContentView(scr);
        Game.G.y=fs.getInt("gravity",10);
    }
    @Override
    protected void onResume()
    {
        if(creat)
            scr.startrander();
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        if(creat)
            scr.stoprander();
        super.onPause();
    }
}