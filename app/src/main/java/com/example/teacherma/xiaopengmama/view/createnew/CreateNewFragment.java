package com.example.teacherma.xiaopengmama.view.createnew;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.teacherma.xiaopengmama.R;

/**
 * @author teacherMa on 2018/3/10.
 */

public class CreateNewFragment extends Fragment {

    private FloatingActionButton mCreateNewButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_record, container, false);

        mCreateNewButton = view.findViewById(R.id.create_new_record_button);
        mCreateNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "CreateNew", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
