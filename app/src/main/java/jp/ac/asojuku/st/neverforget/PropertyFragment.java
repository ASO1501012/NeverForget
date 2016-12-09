package jp.ac.asojuku.st.neverforget;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class PropertyFragment extends Fragment {
    public static Fragment newInstance(Context context){
        PropertyFragment f = new PropertyFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_property,null);
        return root;
    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("property",Context.MODE_PRIVATE);
        String carnumber = prefs.getString("carnumber","");
        int phonenumber = prefs.getInt("phonenumber",0);
        EditText edText1 = (EditText) getView().findViewById(R.id.editText1);
            edText1.setText(carnumber);
        EditText edText2 = (EditText) getView().findViewById(R.id.editText2);
        if(phonenumber != 0){
            edText2.setText(Integer.toString(phonenumber));
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        EditText edText1 = (EditText) getView().findViewById(R.id.editText1);
        EditText edText2 = (EditText) getView().findViewById(R.id.editText2);
        String carnumber;
            carnumber = edText1.getText().toString();
        int phonenumber;
        try{
            phonenumber = Integer.parseInt(edText2.getText().toString());
        }
        catch (NumberFormatException e){
            phonenumber = 0;
        }

        SharedPreferences prefs = this.getActivity().getSharedPreferences("property",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("carnumber",carnumber);
        editor.putInt("phonenumber",phonenumber);
        editor.apply();
    }

}
