package main.traveloke.hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

import main.traveloke.R;

public class SearchResult extends AppCompatActivity {

    RecyclerView recycleHotel;
    String[] titleList, descList;
    int[] imagesHotel = {R.drawable.hotel1, R.drawable.hotel2, R.drawable.hotel3, R.drawable.hotel4, R.drawable.hotel5,
            R.drawable.hotel6, R.drawable.hotel7, R.drawable.hotel8, R.drawable.hotel9, R.drawable.hotel10};

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Hasil Pencarian");

//      Search Result
        TextView data_checkIn = findViewById(R.id.data_check_in);
        TextView data_checkOut = findViewById(R.id.data_check_out);
        TextView data_totalRooms = findViewById(R.id.data_total_rooms);

        Intent searchData = getIntent();

        String result_checkIn = searchData.getStringExtra("checkIn");
        String result_checkOut = searchData.getStringExtra("checkOut");
        String result_totalRoom = searchData.getStringExtra("rooms");

        data_checkIn.setText("Tanggal Check-in : " + result_checkIn);
        data_checkOut.setText("Tanggal Check-out : " + result_checkOut);
        data_totalRooms.setText("Banyak Kamar : " + result_totalRoom);

//      Recycler View
        recycleHotel = findViewById(R.id.hotel_list);

        titleList = getResources().getStringArray(R.array.title_list);
        descList = getResources().getStringArray(R.array.desc_list);

        ListAdapter listItem = new ListAdapter(this, titleList, descList, imagesHotel);
        recycleHotel.setAdapter(listItem);
        recycleHotel.setLayoutManager(new LinearLayoutManager(this));
    }
}