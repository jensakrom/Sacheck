package com.solution.jens.sacheck.fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.solution.jens.sacheck.R;


/**
 * Created by Jens on 7/13/2016.
 */
public class CheckSalaryFragment extends Fragment {
    private static View fragmentView;
    private EditText inputEffectiveWork;
    private EditText inputBenefitHealth;
    private EditText inputTravelCount;
    private TextInputLayout inputLayoutEffecWork;
    private TextInputLayout inputLayoutBenHealth;
    private TextInputLayout inputLayoutTravCount;
    private VariableFragment variableFragment;

    public CheckSalaryFragment() {
        variableFragment = new VariableFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentView = inflater.inflate(R.layout.salary_check_fragment, container, false);
        inputLayoutEffecWork = (TextInputLayout) fragmentView.findViewById(R.id.input_layout_effectivework);
        inputLayoutBenHealth = (TextInputLayout) fragmentView.findViewById(R.id.input_layout_benefithealth);
        inputLayoutTravCount = (TextInputLayout) fragmentView.findViewById(R.id.input_layout_travelcount);
        inputEffectiveWork = (EditText) fragmentView.findViewById(R.id.input_effectivework);
        inputBenefitHealth = (EditText) fragmentView.findViewById(R.id.input_benefithealth);
        inputTravelCount = (EditText) fragmentView. findViewById(R.id.input_travelcount);
        Button btnCheckSalary = (Button) fragmentView.findViewById(R.id.btn_checksalary);
//        Button btnClear = (Button) fragmentView.findViewById(R.id.btn_clear);

        inputEffectiveWork.addTextChangedListener(new MyTextWatcher(inputEffectiveWork));
        inputBenefitHealth.addTextChangedListener(new MyTextWatcher(inputBenefitHealth));
        inputTravelCount.addTextChangedListener(new MyTextWatcher(inputTravelCount));


        btnCheckSalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();

            }
        });

        return fragmentView;
    }

    private void showDialog(){
        DialogFragment dialogFragment = new CountDialogFragment().newInstance(R.string.dialog_fragment_title);
        FragmentManager fragmentManager = getActivity().getFragmentManager();
        dialogFragment.show(fragmentManager, "dialog");
    }

    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateEffectiveWork()) {
            return;
        }

        if (!validateBenefitHealth()) {
            return;
        }

        if (!validateTravelCount()) {
            return;
        }


        showDialog();



//        Toast.makeText(getActivity().getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
    }

    private boolean validateEffectiveWork() {
        if (inputEffectiveWork.getText().toString().trim().isEmpty()) {
            inputLayoutEffecWork.setError(getString(R.string.err_msg_effectivework));
            requestFocus(inputEffectiveWork);
            return false;
        } else {
            inputLayoutEffecWork.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateBenefitHealth() {
        String benefitHealth = inputBenefitHealth.getText().toString().trim();

        if (benefitHealth.isEmpty() ) {
            inputLayoutBenHealth.setError(getString(R.string.err_msg_benefithealth));
            requestFocus(inputBenefitHealth);
            return false;
        } else {
            inputLayoutBenHealth.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateTravelCount() {
        if (inputTravelCount.getText().toString().trim().isEmpty()) {
            inputLayoutTravCount.setError(getString(R.string.err_msg_travelcount));
            requestFocus(inputTravelCount);
            return false;
        } else {
            inputLayoutTravCount.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public VariableFragment getVariableFragment() {
        return variableFragment;
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_effectivework:
                    validateEffectiveWork();
                    break;
                case R.id.input_benefithealth:
                    validateBenefitHealth();
                    break;
                case R.id.input_travelcount:
                    validateTravelCount();
                    break;
            }
        }
    }

    public  void doPositiveClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Positive click!");
    }

    public  void doNegativeClick() {
        // Do stuff here.
        Log.i("FragmentAlertDialog", "Negative click!");
    }


    public static class CountDialogFragment extends DialogFragment {

        private EditText txtbasicSalary;

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
            View view = inflater.inflate(R.layout.result_checker, null);
            return new AlertDialog.Builder(getActivity())
                    .setIcon(R.drawable.alert_dialog_dart_icon)
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
