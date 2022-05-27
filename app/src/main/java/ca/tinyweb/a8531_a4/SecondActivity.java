package ca.tinyweb.a8531_a4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    Button btnCloseActivity;
    BroadcastReceiver broadcastReceiver;
    GarbageList memoryWaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnCloseActivity = findViewById(R.id.btn_close_activity);
        btnCloseActivity.setOnClickListener(view -> onBackPressed());
        memoryWaster = new GarbageList(this);
        registerBroadcastReceiver();
        wasteMemory();
    }

    private void wasteMemory() {
        for (int i=0; i<=500000; i++) {
            memoryWaster.add(new Random().nextLong());
        }
        Toast.makeText(this, "Made 5,000,000 Longs", Toast.LENGTH_SHORT).show();
    }

    private void registerBroadcastReceiver() {
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Broadcast received", Toast.LENGTH_SHORT).show();
                if (ConnectivityManager.EXTRA_NO_CONNECTIVITY.equals(intent.getAction())) {
                    Toast.makeText(context, "Connection changed", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerBroadcastReceiver();
    }
}
