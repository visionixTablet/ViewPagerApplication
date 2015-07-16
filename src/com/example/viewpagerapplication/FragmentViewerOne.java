package com.example.viewpagerapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentViewerOne extends Fragment
{
	private TextView	_text1;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_layout_one, container, false);
		
		_text1 = (TextView) view.findViewById(R.id.text11);

		initData(getArguments());
		
		return view;
	}

	private void initData(Bundle b)
	{
		if(b!=null)
		{
			String data = b.getString("text1");
			_text1.setText(data);
		}
		else
		{
			_text1.setText("1.1");
		}
	}
}
