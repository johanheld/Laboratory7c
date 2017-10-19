package com.example.johan.laboratory7c;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity {
    private Controller controller;
    private static final String TAG_RETAINED_FRAGMENT = "RetainedFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        MainFragment mainFragment = (MainFragment)fm.findFragmentById(R.id.fragment);
        TCPConnection connectionFragment = (TCPConnection) fm.findFragmentByTag(TAG_RETAINED_FRAGMENT);

        if (connectionFragment == null)
        {
            connectionFragment = new TCPConnection();
            connectionFragment.setIp("195.178.227.53");
            connectionFragment.setConnectionPort(9384);
            fm.beginTransaction().add(connectionFragment, TAG_RETAINED_FRAGMENT).commit();
        }
        controller = new Controller(this,mainFragment, connectionFragment);
    }

    @Override
    protected void onDestroy() {
       // controller.disconnectClicked();
        super.onDestroy();
    }


}
