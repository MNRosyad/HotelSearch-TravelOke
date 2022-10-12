package main.traveloke.hotel;

import android.app.*;
import android.os.*;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.*;

public class DateCheckIn extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
        SearchActivity activity = (SearchActivity) getActivity();
        assert activity != null;

        activity.checkInDateResult(year, month, day);
    }
}
