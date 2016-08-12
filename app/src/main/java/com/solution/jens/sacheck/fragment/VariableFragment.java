package com.solution.jens.sacheck.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.solution.jens.sacheck.R;
import com.solution.jens.sacheck.adapter.VariableAdapter;
import com.solution.jens.sacheck.model.VariableSalary;

import io.realm.RealmList;

/**
 * Created by Jens on 7/13/2016.
 */
public class VariableFragment extends Fragment {

    private RecyclerView rvVariable;
    private RealmList<VariableSalary> variables;
    private VariableAdapter variableAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.variable_fragment, container, false);
        initComponents(rootView);
        return rootView;
    }

    private void initComponents(View view) {
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        initRecyclerListener(view);
    }

    private void initRecyclerListener(View view) {
        rvVariable = (RecyclerView) view.findViewById(R.id.rv_variable);
        rvVariable.setLayoutManager(new LinearLayoutManager(view.getContext().getApplicationContext()));
        rvVariable.setItemAnimator(new DefaultItemAnimator());

        ItemTouchHelper swipeToDismissTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT
        ) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });

        swipeToDismissTouchHelper.attachToRecyclerView(rvVariable);
    }

    public void showVariables(RealmList<VariableSalary> aVariableSalaries){
        variables = aVariableSalaries;
        rvVariable.setAdapter(variableAdapter);
    }

    private void showDialog(){
        DialogFragment dialogFragment = new CountDialogFragment().newInstance(R.string.dialog_edit_variable_title);
        FragmentManager fragmentManager = getActivity().getFragmentManager();
        dialogFragment.show(fragmentManager, "dialog");
    }


    private void requestFocus(View aView) {
        if (aView.requestFocus()){
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);
        }
    }



    public static class CountDialogFragment extends DialogFragment {

        public DialogFragment newInstance(int aTitle) {
            CountDialogFragment dialogFragment = new CountDialogFragment();
            Bundle args = new Bundle();
            args.putInt("title", aTitle);
            dialogFragment.setArguments(args);
            return dialogFragment;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int title = getArguments().getInt("title");
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View view = inflater.inflate(R.layout.edit_variable, null);
            return new AlertDialog.Builder(getActivity())
                    .setIcon(R.drawable.ic_tab_favourite)
                    .setTitle(title)
                    .setView(view)
                    .setPositiveButton(R.string.alert_dialog_ok,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                    .setNegativeButton(R.string.alert_dialog_cancel,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                    .create();
        }
    }
}
