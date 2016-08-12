package com.solution.jens.sacheck.realm.repository.impl;

import com.solution.jens.sacheck.app.RealmApp;
import com.solution.jens.sacheck.model.VariableSalary;
import com.solution.jens.sacheck.realm.repository.IVariableRepository;
import com.solution.jens.sacheck.realm.table.RealmTable;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Jens on 8/11/2016.
 */
public class VariableRepository implements IVariableRepository {


    @Override
    public void addVariables(VariableSalary variableSalary, OnSaveVariableCallBack saveVariableCallBack) {
        Realm realm = Realm.getInstance(RealmApp.getInstance());
        realm.beginTransaction();
        VariableSalary realmVariable = realm.createObject(VariableSalary.class);
        realmVariable.setId(UUID.randomUUID().toString());
        realmVariable.setBasicSalary(variableSalary.getBasicSalary());
        realmVariable.setFixAllowed(variableSalary.getFixAllowed());
        realmVariable.setHealt(variableSalary.getHealt());
        realmVariable.setTransport(variableSalary.getTransport());
        realmVariable.setMeal(variableSalary.getMeal());
        realmVariable.setTravel(variableSalary.getTravel());
        realm.commitTransaction();

        if (saveVariableCallBack != null){
            saveVariableCallBack.onSuccess();
        }
    }

    @Override
    public void deleteVariableById(String id, OnDeleteVariableCallBack deleteVariableCallBack) {
        Realm realm = Realm.getInstance(RealmApp.getInstance());
        realm.beginTransaction();
        VariableSalary result = realm.where(VariableSalary.class).equalTo(RealmTable.ID, id).findFirst();
        result.removeFromRealm();
        realm.commitTransaction();

        if (deleteVariableCallBack != null){
            deleteVariableCallBack.onSuccess();
        }

    }

    @Override
    public void getAllVariables(OnGetAllVariablesCallBack allVariablesCallBack) {
        Realm realm = Realm.getInstance(RealmApp.getInstance());
        RealmResults<VariableSalary> result = realm.where(VariableSalary.class).findAll();

        if (allVariablesCallBack != null){
            allVariablesCallBack.onSuccess(result);
        }

    }

    @Override
    public void getVariableById(String id, OnGetVariableByIdCallBack variableByIdCallBack) {
        Realm realm = Realm.getInstance(RealmApp.getInstance());
        VariableSalary result = realm.where(VariableSalary.class).equalTo(RealmTable.ID, id).findFirst();

        if (variableByIdCallBack != variableByIdCallBack){
            variableByIdCallBack.onSuccess(result);
        }

    }
}
