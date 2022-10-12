package main.traveloke.hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import main.traveloke.R;

public class SearchActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView dateCheckIn;
    private TextView dateCheckOut;
    private TextView textShowRoom;

    private static final String LOG = SearchActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        dateCheckIn = findViewById(R.id.text_check_in);
        dateCheckOut = findViewById(R.id.text_check_out);
        textShowRoom = findViewById(R.id.showRoom);

        Spinner chooseRoom = findViewById(R.id.spinnerRoom);
        if (chooseRoom != null) {
            chooseRoom.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.room_available, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (chooseRoom != null) {
            chooseRoom.setAdapter(adapter);
        }
    }

    public void CheckIn(View view) {
        DialogFragment DateCheckIn = new DateCheckIn();
        DateCheckIn.show(getSupportFragmentManager(), getString(R.string.check_in));
    }
    public void CheckOut(View view) {
        DialogFragment DateCheckOut = new DateCheckOut();
        DateCheckOut.show(getSupportFragmentManager(), getString(R.string.check_out));
    }

    public void checkInDateResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);

        String dateMessage = (month_string + "-" + day_string + "-" + year_string);

        dateCheckIn.setText(dateMessage);
    }

    public void checkOutDateResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);

        String dateMessage = (month_string + "-" + day_string + "-" + year_string);

        dateCheckOut.setText(dateMessage);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
        String roomSpinner = adapterView.getItemAtPosition(pos).toString();

        if (textShowRoom != null) {
            textShowRoom.setText(roomSpinner);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(LOG, getString(R.string.spinnerLabel));
    }

    public void SubmitSearch(View view) {
        String dataCheckIn = dateCheckIn.getText().toString();
        String dataCheckOut = dateCheckOut.getText().toString();
        String dataRoom = textShowRoom.getText().toString();

        Intent searchData = new Intent(this, SearchResult.class);
        searchData.putExtra("checkIn", dataCheckIn);
        searchData.putExtra("checkOut", dataCheckOut);
        searchData.putExtra("rooms", dataRoom);

        startActivity(searchData);
    }
}