package com.solution.jens.sacheck.realm.repository;

import com.solution.jens.sacheck.model.VariableSalary;

import io.realm.RealmResults;

/**
 * Created by Jens on 8/11/2016.
 */
public interface IVariableRepository {

    interface OnSaveVariableCallBack{
        void onSuccess();
        void onError();
    }

    interface OnDeleteVariableCallBack{
        void onSuccess();
        void onError();
    }

    interface OnGetVariableByIdCallBack{
        void onSuccess(VariableSalary variableSalary);
        void onError();
    }

    interface OnGetAllVariablesCallBack{
        void onSuccess(RealmResults<VariableSalary> students);
        void onError();
    }

    interface onGetVariableCallBack{
        void onSuccess();
        void onError();
    }

    void addVariables(VariableSalary variableSalary, OnSaveVariableCallBack saveVariableCallBack );
    void deleteVariableById(String id, OnDeleteVariableCallBack deleteVariableCallBack);
    void getAllVariables(OnGetAllVariablesCallBack allVariablesCallBack);
    void getVariableById(String id, OnGetVariableByIdCallBack variableByIdCallBack);
}
