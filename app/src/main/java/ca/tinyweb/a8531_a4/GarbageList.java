package ca.tinyweb.a8531_a4;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class GarbageList extends ArrayList<Long> {

    private Context context;

    public GarbageList(Context context) {
        this.context = context;
    }

    @Override
    protected void finalize() throws Throwable {
        Log.d("GarbageList", "Garbage List destroyed");
        super.finalize();
    }
}
