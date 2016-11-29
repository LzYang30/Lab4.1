package com.example.user.myapplication;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentImport extends Fragment {
    private EditText editTextFileName;


    public FragmentImport() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_import, container, false);

        //Link UI to program
        editTextFileName = (EditText)view.findViewById(R.id.editTextFileName);

        Button buttonBrowse;
        buttonBrowse = (Button)view.findViewById(R.id.buttonBrowse);

        buttonBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textViewImport;
                textViewImport = (TextView)view.findViewById(R.id.textViewImport);
                textViewImport.setText("File Name : " + editTextFileName.getText().toString());

            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Create an instance of Shared Preference
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        String filename = sharedPreferences.getString(getString(R.string.file_name).toString(),null);

        editTextFileName.setText(filename);
    }

    @Override
    public void onPause() {
        super.onPause();
        // Create an instance of Shared Preference
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.file_name),editTextFileName.getText().toString());
        editor.commit();

    }
}
