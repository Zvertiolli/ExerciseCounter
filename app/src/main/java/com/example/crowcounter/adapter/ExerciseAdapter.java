package com.example.crowcounter.adapter;


import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crowcounter.ChoosingAnExerciseActivity;
import com.example.crowcounter.ExerciseActivity;
import com.example.crowcounter.R;
import com.example.crowcounter.model.Exercise;

import java.text.MessageFormat;
import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {

    Context context;
    List<Exercise> exerciseList;

    public ExerciseAdapter(Context context, List<Exercise> exerciseList) {
        this.context = context;
        this.exerciseList = exerciseList;
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View exerciseItems = LayoutInflater.from(context).inflate(R.layout.exercise_item, parent, false);
        return new ExerciseAdapter.ExerciseViewHolder(exerciseItems);
    }

    @Override
    public void onBindViewHolder(@NonNull final ExerciseAdapter.ExerciseViewHolder holder, int position) {
        holder.exerciseTitle.setText(exerciseList.get(position).getTitle());
        holder.exerciseCount.setText(MessageFormat.format("{0}", exerciseList.get(holder.getAdapterPosition()).getCount()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(context, ExerciseActivity.class);
                intent.putExtra("titleExercise",exerciseList.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("plan",exerciseList.get(holder.getAdapterPosition()).getPlan());
                intent.putExtra("ready",exerciseList.get(holder.getAdapterPosition()).getCount());
                intent.putExtra("id",exerciseList.get(holder.getAdapterPosition()).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public static final class ExerciseViewHolder extends RecyclerView.ViewHolder {

        TextView exerciseTitle;
        TextView exerciseCount;

        public ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);

            exerciseTitle = itemView.findViewById(R.id.exerciseTitle);
            exerciseCount = itemView.findViewById(R.id.exerciseCount);
        }
    }
}
