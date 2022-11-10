package com.example.blood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserAdapter  extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    Context context;
    List<UserModel> list;

    public UserAdapter(Context context, List<UserModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.rv_layout,parent,false);
                return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        UserModel userModel = list.get(position);
        holder.name.setText(userModel.getName());
        holder.mobile.setText(userModel.getMobile());
        holder.location.setText(userModel.getLocation());
        holder.bloodtype.setText(userModel.getBloodtype());
        holder.nextdate.setText(userModel.getNextdate());
        holder.healthIssue.setText(userModel.getHealthIssue());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name,mobile,location,bloodtype,nextdate,healthIssue;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);




            name = itemView.findViewById(R.id.name);
            mobile = itemView.findViewById(R.id.mobile);
            location = itemView.findViewById(R.id.location);
            bloodtype = itemView.findViewById(R.id.bloodtype);
            nextdate = itemView.findViewById(R.id.nexdate);
            healthIssue = itemView.findViewById(R.id.healthissue);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {


            UserModel getUser = list.get(getAbsoluteAdapterPosition());
            Intent intent = new Intent(context,Final.class);
            intent.putExtra("pass",getUser);
            context.startActivity(intent);
        }
    }
}
