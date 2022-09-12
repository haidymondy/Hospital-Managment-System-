package com.example.hms.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;
import com.example.hms.Database.*;
import com.example.hms.*;
import java.util.ArrayList;

public class OrderFragment extends ListFragment {

    public OrderFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_order, container, false);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Doctors_DB1 doctors_db1=new Doctors_DB1(getActivity().getApplication());
        ArrayList<Doctor_Information> arr =null;
        arr=doctors_db1.get_Data(SearchFragment.doctorp);
        Add adapter = new Add(arr,getActivity());
        setListAdapter(adapter);
    }

    public class Add extends BaseAdapter
{
    Context context;
    ArrayList<Doctor_Information>l =new ArrayList<Doctor_Information>();
    public Add(ArrayList<Doctor_Information> v, Context c)
    {
        this.l=v;
        context = c;
    }

    public Add(ArrayList<Doctor_Information> arr) {
        this.l=arr;
    }

    @Override
    public int getCount() {
        return l.size();
    }

    @Override
    public Object getItem(int i) {
        return l.get(i).getDoctorName();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_list_booknow, viewGroup, false);
        TextView t1=(TextView) v.findViewById(R.id.tdoctorName);//doctorName
        TextView t2=(TextView) v.findViewById(R.id.texp);//yearOfExp
        TextView t3=(TextView) v.findViewById(R.id.tfee);//Fee
        TextView t4=(TextView) v.findViewById(R.id.tspecialist);//specialist
        Button b=(Button) v.findViewById(R.id.Book_Now);
        t1.setText(l.get(i).getDoctorName());
        t2.setText(l.get(i).getYearOfExp()+ "+ Years Exp.");
        t3.setText(l.get(i).getFee()+"EGP");
        t4.setText(SearchFragment.doctorp);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data=new Intent(context, Form.class);
                data.putExtra("doctorName",l.get(i).getDoctorName());
                data.putExtra("specialist", SearchFragment.doctorp);
                data.putExtra("yearOfExp",l.get(i).getYearOfExp());
                data.putExtra("fee",l.get(i).getFee());
                context.startActivity(data);

            }
        });

        return v;
    }
}



}