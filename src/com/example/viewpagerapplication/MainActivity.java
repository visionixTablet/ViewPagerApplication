package com.example.viewpagerapplication;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		Intent i = new Intent(android.provider.Settings.ACTION_DATE_SETTINGS);
//		startActivity(i);
		
		Bundle b = new Bundle();
		b.putString("text1", "AAA");
		b.putString("text2", "BBB");
		replaceFragment(R.id.frame_layout, ContentFragmentA.class,b);
		
	}
	
	public void replaceFragment(int container, Class<?> fragClass,Bundle b)
	{
//		Fragment bf = null;
//		try
//		{
//			bf = (Fragment) fragClass.newInstance();
//			bf.setArguments(b);
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//
//		String backStateName = bf.getClass().getSimpleName();
//		FragmentManager manager = getSupportFragmentManager();
//
//		
//		boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);
//		if (!fragmentPopped)
//		{ //fragment not in back stack, create it.
//			FragmentTransaction ft = manager.beginTransaction();
//			//				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//
//			if (manager.getBackStackEntryCount() == 0)//splash - first fragment 
//			{
//				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//			}
////			else
////			{
////				ft.setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_right, R.anim.slide_out_to_left);
////			}
//
//			ft.replace(container, bf, bf.getClass().getSimpleName());
//			ft.addToBackStack(bf.getClass().getSimpleName());
//			ft.commitAllowingStateLoss();
//		}
		
		
		Fragment bf = null;
		try
		{
			bf = (Fragment) fragClass.newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

//		if(b==null)
//		{
//			b = new Bundle();
//		}
		
		
		bf.setArguments(b);
		
		String backStateName = bf.getClass().getSimpleName();
		FragmentManager manager = getSupportFragmentManager();
		

		//if there is already fragment in backstack that we want to open, sets new bundle before we will pop it out from backstack
		Fragment backStackFragment = (Fragment) manager.findFragmentByTag(backStateName);
		if (backStackFragment != null)
		{
			setFragArguments(backStackFragment,b);
			
			for(int backstackIndex = manager.getBackStackEntryCount()-1;backstackIndex>0;backstackIndex--)
			{
				BackStackEntry currentEntry =  manager.getBackStackEntryAt(backstackIndex);
				if(currentEntry.getName().equals(backStateName))
				{
					break;
				}
				manager.popBackStack();
			}
			
		}
		else 
		{ 
			FragmentTransaction ft = manager.beginTransaction();
			//				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

			if (manager.getBackStackEntryCount() == 0)//splash - first fragment 
			{
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			}
//			else
//			{
//				ft.setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_right, R.anim.slide_out_to_left);
//			}

			ft.replace(container, bf, bf.getClass().getSimpleName());
			ft.addToBackStack(bf.getClass().getSimpleName());
			ft.commitAllowingStateLoss();
		}
		

	}
	
	private void setFragArguments(Fragment backStackFragment, Bundle b)
	{
		for (String key : b.keySet())
		{
			Object value = b.get(key);
			if (value instanceof String)
			{
				String strValue = (String) value;
				backStackFragment.getArguments().putString(key, strValue);
			}
			if (value instanceof Integer)
			{
				int intValue = (Integer) value;
				backStackFragment.getArguments().putInt(key, intValue);
			}

			if (value instanceof Boolean)
			{
				boolean boolValue = (Boolean) value;
				backStackFragment.getArguments().putBoolean(key, boolValue);
			}

			if (value instanceof ArrayList<?>)
			{
				ArrayList<? extends Parcelable> listValue = (ArrayList<? extends Parcelable>) value;
				backStackFragment.getArguments().putParcelableArrayList(key, listValue);
			}

			if (value instanceof Long)
			{
				long longValue = (Long) value;
				backStackFragment.getArguments().putLong(key, longValue);
			}
		}
	}

}
