package com.ymc.bigwatermelon;
import android.view.*;
import com.uxyq7e.test.*;
import com.uxyq7e.test.tools.*;

public class GravityView extends GameView
{
	public GravityView(){
		final Lable la=new Lable("设置重力",200,300,1,1);
		la.SetwhSurround();
		seek sk=new seek(200,400,700,50);
		sk.setIndexDrawer(new seek.IndexDrawer(){

				@Override
				public String drawindex(int index)
				{
					return (index+5)+"";
				}
			});
		sk.setbgbitmap(tool.loadbitmap("bar_bg.png"));
		sk.setbitmap(tool.loadbitmap("bar.png"));
		sk.setmax(35);
		sk.setindex((int)Game.G.y-5);
		sk.setseeklistener(new seek.Seeklistener(){
				@Override
				public void startseek()
				{
					// TODO: Implement this method
				}
				@Override
				public void seeking(int index)
				{
					
				}
				@Override
				public void stopseek(int index)
				{
					Game.G.y=index+5;
					MainActivity.fs.edit().putInt("gravity",index+5).commit();
				}
			});
		addview(la);
		addview(sk);
	}
	@Override
	public boolean onKeyDown(int keycode)
	{
		if(keycode==KeyEvent.KEYCODE_BACK){
			Screen.gv=Screen.mv;
			return true;
		}
		return super.onKeyDown(keycode);
	}
}
