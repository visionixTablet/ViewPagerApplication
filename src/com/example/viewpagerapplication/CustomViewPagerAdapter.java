package com.example.viewpagerapplication;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CustomViewPagerAdapter extends FragmentPagerAdapter
{

	private static final int	ITEMS	= 2;
	private List<Fragment> _frags;
	
	public CustomViewPagerAdapter(FragmentManager fragmentManager,List<Fragment> frags)
	{
		super(fragmentManager);
		_frags = frags;
	}

	@Override
	public int getCount()
	{
		return ITEMS;
	}

//	@Override
//	public int getItemPosition(Object object)
//	{
//		return POSITION_NONE;
//	}
	
	@Override
	public Fragment getItem(int position)
	{
		return _frags.get(position);
	}

}
