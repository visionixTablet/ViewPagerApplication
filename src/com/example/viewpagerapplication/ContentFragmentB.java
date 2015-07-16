package com.example.viewpagerapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class ContentFragmentB extends Fragment
{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.fragment_content_b, container,false);
		
		v.findViewById(R.id.back).setOnClickListener(new OnClickListener()
		{
			
			private FragmentManager	childFragmentManager;

			@Override
			public void onClick(View v)
			{
				Bundle b = new Bundle();
				b.putString("text1", "new text1 from fragB");
				b.putString("text2", "new text2 from fragB");
				childFragmentManager = getChildFragmentManager();
				((MainActivity)getActivity()).replaceFragment(R.id.frame_layout, ContentFragmentA.class,b);
			}
		});
		
		return v;
	}
	
}
