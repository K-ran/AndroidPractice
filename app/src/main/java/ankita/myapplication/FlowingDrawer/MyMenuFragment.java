package ankita.myapplication.FlowingDrawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mxn.soul.flowingdrawer_core.MenuFragment;

import ankita.myapplication.R;


public class MyMenuFragment extends MenuFragment {
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_menu, container,
                                     false);
        return  setupReveal(view);
    }
}
