package com.example.hms.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.hms.Database.Book_DB;
import com.example.hms.R;
import com.example.hms.displayItems;

import java.util.ArrayList;


public class InboxFragment extends ListFragment {



    public InboxFragment() {
        // Required empty public constructor
    }
//database u p
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Book_DB cc=new Book_DB(getActivity());
        ArrayList<displayItems> arrayList =new ArrayList<displayItems>();
        arrayList=cc.GET_DATa();

        Add adapter=new Add(arrayList);
        setListAdapter(adapter);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inbox, container, false);
    }

    public class Add extends BaseAdapter
    {

        ArrayList<displayItems>l =new ArrayList<displayItems>();
        public Add(ArrayList<displayItems> v)
        {
            this.l=v;
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
            LayoutInflater ly= getLayoutInflater();
            View v=ly.inflate(R.layout.displaylist1,null);
            TextView t1=(TextView) v.findViewById(R.id.tdoctorName);//doctorName
            TextView t2=(TextView) v.findViewById(R.id.tspecialist);//specialist
            TextView t3=(TextView) v.findViewById(R.id.tpname);//patientName
            TextView t4=(TextView) v.findViewById(R.id.tpage);//patientAge
            TextView t5=(TextView) v.findViewById(R.id.tpadress);//patientAddress
            TextView t6=(TextView) v.findViewById(R.id.tpmobile);//patientMobile
            t1.setText(l.get(i).getDoctorName());
            t2.setText(l.get(i).getSpecialist());
            t3.setText(l.get(i).getPatientName());
            t4.setText(l.get(i).getPatientAge());
            t5.setText(l.get(i).getPatientAddress());
            t6.setText(l.get(i).getPatientMobile());

            return v;
        }
}}