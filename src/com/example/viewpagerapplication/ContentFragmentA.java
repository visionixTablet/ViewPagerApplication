package com.example.viewpagerapplication;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class ContentFragmentA extends Fragment
{
	private ViewPager				_viewPager;
	private CustomViewPagerAdapter	_vpAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_content_a, container, false);
		_viewPager = (ViewPager) view.findViewById(R.id.pager);
		Bundle b = getArguments();
		List<Fragment> frags = new ArrayList<Fragment>();
		
		FragmentViewerOne firstFrag = new FragmentViewerOne();
		firstFrag.setArguments(b);
		FragmentViewerTwo secondFrag = new FragmentViewerTwo();
		secondFrag.setArguments(b);
		frags.add(firstFrag);
		frags.add(secondFrag);
		
		_vpAdapter = new CustomViewPagerAdapter(getChildFragmentManager(),frags);
		_viewPager.setAdapter(_vpAdapter);
		_viewPager.setOffscreenPageLimit(2);
		view.findViewById(R.id.forward).setOnClickListener( new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				((MainActivity)getActivity()).replaceFragment(R.id.frame_layout, ContentFragmentB.class, null);
			}
		});
		
		return view;
	}

}
