package com.example.viewpagerapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentViewerTwo extends Fragment
{
	private TextView _textView1;
	private TextView _textView2;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_layout_two, container, false);

		_textView1 = (TextView) view.findViewById(R.id.text111);
		_textView2 = (TextView) view.findViewById(R.id.text222);
		
		initData(getArguments());
		
		return view;
	}

	private void initData(Bundle arguments)
	{
		if(arguments!=null)
		{
			_textView1.setText(arguments.getString("text1"));
			_textView2.setText(arguments.getString("text2"));
		}
		else
		{
			_textView1.setText("1.2");
			_textView2.setText("1.2.1");
		}
	}

}
