package main.traveloke.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import main.traveloke.R;

public class DetailContent extends AppCompatActivity {

    private TextView title, desc;
    private ImageView mainImage;
    private String textTitle, textDesc;
    private int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_content);

        title = findViewById(R.id.title_content);
        desc = findViewById(R.id.desc_content);
        mainImage = findViewById(R.id.imageContent);

        getData();
        setData();
    }

    private void getData() {
        if (getIntent().hasExtra("theTitle") && getIntent().hasExtra("theDesc") && getIntent().hasExtra("theImages")) {

            textTitle = getIntent().getStringExtra("theTitle");
            textDesc = getIntent().getStringExtra("theDesc");
            images = getIntent().getIntExtra("theImages", 1);

        } else {
            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        title.setText(textTitle);
        desc.setText(textDesc);
        mainImage.setImageResource(images);
    }
}