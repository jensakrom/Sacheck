package com.solution.jens.sacheck.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.solution.jens.sacheck.R;
import com.solution.jens.sacheck.app.RealmApp;
import com.solution.jens.sacheck.model.VariableSalary;

import io.realm.RealmList;

/**
 * Created by Jens on 8/12/2016.
 */
public class VariableAdapter extends RecyclerView.Adapter<VariableAdapter.VariableViewHolder>{

    private final RealmList<VariableSalary> fVariableSalaries;

    public VariableAdapter(RealmList<VariableSalary> variableSalaries) {
        fVariableSalaries = variableSalaries;
    }

    @Override
    public VariableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_variables, parent, false);
        return new VariableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VariableViewHolder holder, int position) {
        String basicSalary = RealmApp.getInstance().getString(R.string.basic_salary_txt) + " " +
                fVariableSalaries.get(position).getBasicSalary();
        holder.tvBasicSalary.setText(String.valueOf(basicSalary));
        String fixedAllowed = RealmApp.getInstance().getString(R.string.fixedAllowed_txt) + " " +
                fVariableSalaries.get(position).getFixAllowed();
        holder.tvFixedAllowed.setText(String.valueOf(fixedAllowed));
        String transport = RealmApp.getInstance().getString(R.string.transport_txt) + " " +
                fVariableSalaries.get(position).getTransport();
        holder.tvTransport.setText(String.valueOf(transport));
        String meal = RealmApp.getInstance().getString(R.string.meal_txt) + " " +
                fVariableSalaries.get(position).getMeal();
        holder.tvMeal.setText(String.valueOf(meal));
        String travel = RealmApp.getInstance().getString(R.string.travel_txt) + " " +
                fVariableSalaries.get(position).getTravel();
        holder.tvTravel.setText(String.valueOf(travel));
    }

    @Override
    public int getItemCount() {
        return fVariableSalaries.size();
    }

    public class VariableViewHolder extends RecyclerView.ViewHolder{

        private TextView tvBasicSalary;
        private TextView tvFixedAllowed;
        private TextView tvTransport;
        private TextView tvMeal;
        private TextView tvTravel;

        public VariableViewHolder(View itemView) {
            super(itemView);

            tvBasicSalary = (TextView) itemView.findViewById(R.id.tv_basic_salary);
            tvFixedAllowed = (TextView) itemView.findViewById(R.id.tv_fixed_allowed);
            tvTransport = (TextView) itemView.findViewById(R.id.tv_transport);
            tvMeal = (TextView) itemView.findViewById(R.id.tv_meal);
            tvTravel = (TextView) itemView.findViewById(R.id.tv_travel);
        }
    }
}
