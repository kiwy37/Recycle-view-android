package com.example.tema_1_android;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Animal> userList;
    private ItemClickListener clickListener;

    public recycleAdapter(ArrayList<Animal> userList,ItemClickListener clickListener){
        this.userList=userList;
        this.clickListener=clickListener;
    }
    class ViewHolder0 extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView t1,t2;
        public ViewHolder0(View view){
            super(view);
            t1=view.findViewById(R.id.t1);
            t2=view.findViewById(R.id.t2);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView t3,t4;
        private View horizontal_line;
        public ViewHolder2(View view){
            super(view);
            t3=view.findViewById(R.id.t3);
            t4=view.findViewById(R.id.t4);
            horizontal_line=view.findViewById(R.id.horizontal_line2);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }
    }

    @Override
    public int getItemViewType(int position) {
        String continent = userList.get(position).getContinent();
        if(continent.equals("Europa")||continent.equals("Africa")||continent.equals("Americi")||continent.equals("Australia"))
            return 2;
        else if(continent.equals("Asia"))
            return 0;
        return 0;
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0: return new ViewHolder0(LayoutInflater.from(parent.getContext()).inflate(R.layout.orizontal, parent,false));
            case 2: return new ViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical, parent,false));
        }
        return new ViewHolder0(LayoutInflater.from(parent.getContext()).inflate(R.layout.orizontal, parent,false)); //de vazut
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {
            case 0: {
                ViewHolder0 viewHolder0 = (ViewHolder0) holder;
                String continent = userList.get(position).getContinent();
                String name = userList.get(position).getName();
                if(continent.equals("Asia"))
                {
                    viewHolder0.t1.setText(name);
                    viewHolder0.t1.setBackgroundResource(R.color.asia);
                    viewHolder0.t1.setGravity(Gravity.CENTER);

                    viewHolder0.t2.setText(continent);
                    viewHolder0.t2.setBackgroundResource(R.color.asia);
                    viewHolder0.t2.setGravity(Gravity.CENTER);
                }
                break;
            }
            case 2: {
                ViewHolder2 viewHolder2 = (ViewHolder2) holder;
                String continent = userList.get(position).getContinent();
                String name = userList.get(position).getName();

                int padding = 5;
                viewHolder2.t3.setPadding(padding, 0, padding, 0);
                viewHolder2.t4.setPadding(padding, 0, padding, 0);

                if(continent.equals("Europa"))
                {
                    viewHolder2.t3.setText(name);
                    viewHolder2.t3.setBackgroundResource(R.color.europa);
                    viewHolder2.t3.setGravity(Gravity.LEFT);

                    viewHolder2.horizontal_line.setBackgroundResource(R.color.europa);

                    viewHolder2.t4.setText(continent);
                    viewHolder2.t4.setBackgroundResource(R.color.europa);
                    viewHolder2.t4.setGravity(Gravity.LEFT);
                }
                else if(continent.equals("Africa"))
                {
                    viewHolder2.t3.setText(name);
                    viewHolder2.t3.setBackgroundResource(R.color.africa);
                    viewHolder2.t3.setGravity(Gravity.LEFT);

                    viewHolder2.horizontal_line.setBackgroundColor(Color.BLACK);

                    viewHolder2.t4.setText(continent);
                    viewHolder2.t4.setBackgroundResource(R.color.africa);
                    viewHolder2.t4.setGravity(Gravity.RIGHT);
                }
                else if(continent.equals("Americi"))
                {
                    viewHolder2.t3.setText(name);
                    viewHolder2.t3.setBackgroundResource(R.color.americi);
                    viewHolder2.t3.setGravity(Gravity.RIGHT);

                    viewHolder2.horizontal_line.setBackgroundResource(R.color.americi);

                    viewHolder2.t4.setText(continent);
                    viewHolder2.t4.setBackgroundResource(R.color.americi);
                    viewHolder2.t4.setGravity(Gravity.RIGHT);
                }
                else if(continent.equals("Australia"))
                {
                    viewHolder2.t3.setText(name);
                    viewHolder2.t3.setBackgroundResource(R.color.australia);
                    viewHolder2.t3.setGravity(Gravity.CENTER);

                    viewHolder2.horizontal_line.setBackgroundResource(R.color.australia);

                    viewHolder2.t4.setText(continent);
                    viewHolder2.t4.setBackgroundResource(R.color.australia);
                    viewHolder2.t4.setGravity(Gravity.CENTER);
                }
                else {
                    viewHolder2.t3.setText(name);
                    viewHolder2.t3.setBackgroundColor(Color.TRANSPARENT);
                    viewHolder2.t3.setGravity(Gravity.CENTER);

                    viewHolder2.t4.setText(continent);
                    viewHolder2.t4.setBackgroundColor(Color.TRANSPARENT);
                    viewHolder2.t4.setGravity(Gravity.CENTER);
                }
                break;
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(userList.get(holder.getAdapterPosition()));
            }
        });
    }

    public interface ItemClickListener{
        public void onItemClick(Animal animal);
    }
}
