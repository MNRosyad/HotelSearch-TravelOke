package main.traveloke.hotel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import main.traveloke.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewList> {

    String[] dataTitle, dataDesc;
    int[] images;
    Context content;

    public ListAdapter(Context ctx, String[] titleL, String[] descL, int[] imagesL) {
        content = ctx;
        dataTitle = titleL;
        dataDesc = descL;
        images = imagesL;
    }

    @NonNull
    @Override
    public ViewList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewList = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ViewList(viewList);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewList holder, @SuppressLint("RecyclerView") int position) {
        holder.theTitle.setText(dataTitle[position]);
        holder.theDesc.setText(dataDesc[position]);
        holder.theImages.setImageResource(images[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendData = new Intent(content, DetailContent.class);
                sendData.putExtra("theTitle", dataTitle[position]);
                sendData.putExtra("theDesc", dataDesc[position]);
                sendData.putExtra("theImages", images[position]);

                content.startActivity(sendData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataTitle.length;
    }

    public static class ViewList extends RecyclerView.ViewHolder{
        TextView theTitle, theDesc;
        ImageView theImages;
        RelativeLayout mainLayout;

        public ViewList(@NonNull View itemView) {
            super(itemView);

            theTitle = itemView.findViewById(R.id.hotelTitle);
            theDesc = itemView.findViewById(R.id.hotelDescription);
            theImages = itemView.findViewById(R.id.hotelImage);
            mainLayout = itemView.findViewById(R.id.detail_layout);
        }
    }
}
