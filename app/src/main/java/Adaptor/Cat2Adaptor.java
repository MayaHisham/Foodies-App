package Adaptor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mayaresturent.Activity.ShowDetailActivity;
import com.example.mayaresturent.R;

import java.util.ArrayList;

import Domain.foodDomain;

public class Cat2Adaptor extends RecyclerView.Adapter<Cat2Adaptor.ViewHolder>{
    ArrayList<foodDomain> cat2Food;

    public Cat2Adaptor(ArrayList<foodDomain> cat2Food) {
        this.cat2Food = cat2Food;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cat2,parent,false);
        return new ViewHolder(inflate);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
    holder.title.setText(cat2Food.get(position).getTitle());
    holder.fee.setText(String.valueOf(cat2Food.get(position).getFee()));

    int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(cat2Food.get(position).getPic(), "drawable",holder.itemView.getContext().getOpPackageName());

    Glide.with(holder.itemView.getContext())
            .load(drawableResourceId)
            .into(holder.pic);
    holder.addBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
            intent.putExtra("object",cat2Food.get(position));
            holder.itemView.getContext().startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return cat2Food.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
        TextView addBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            fee=itemView.findViewById(R.id.fee);
            pic=itemView.findViewById(R.id.pic);
            addBtn=itemView.findViewById(R.id.addBtn);
        }
    }

}
