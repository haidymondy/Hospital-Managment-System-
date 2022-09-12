package com.example.hms.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.example.hms.R;

public class SearchFragment extends Fragment {
    static String doctorp= "Dentist";
    CardView blood;
    CardView dent ;
    CardView liver ;
    CardView brain ;
    CardView heart;
    CardView bone ;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.fragment_search, container, false);
        blood = rootview.findViewById(R.id.blood_doc);
         dent = rootview.findViewById(R.id.dentist_doc);
         liver = rootview.findViewById(R.id.stomache_doc);
        brain = rootview.findViewById(R.id.brain_doc);
        heart = rootview.findViewById(R.id.neurologist_doc);
         bone = rootview.findViewById(R.id.bone_doc);
        blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doctorp="Blood";
                blood.setBackgroundColor(Color.parseColor("#00CCCB"));
                dent.setBackgroundColor(Color.parseColor("#FFFFFF"));
                liver.setBackgroundColor(Color.parseColor("#FFFFFF"));
                brain.setBackgroundColor(Color.parseColor("#FFFFFF"));
                heart.setBackgroundColor(Color.parseColor("#FFFFFF"));
                bone.setBackgroundColor(Color.parseColor("#FFFFFF"));

            }
        });
        dent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doctorp="Dentist";

                dent.setBackgroundColor(Color.parseColor("#00CCCB"));
                blood.setBackgroundColor(Color.parseColor("#FFFFFF"));
                liver.setBackgroundColor(Color.parseColor("#FFFFFF"));
                brain.setBackgroundColor(Color.parseColor("#FFFFFF"));
                heart.setBackgroundColor(Color.parseColor("#FFFFFF"));
                bone.setBackgroundColor(Color.parseColor("#FFFFFF"));

            }
        });
        liver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doctorp="Liver";

                liver.setBackgroundColor(Color.parseColor("#00CCCB"));
                dent.setBackgroundColor(Color.parseColor("#FFFFFF"));
                blood.setBackgroundColor(Color.parseColor("#FFFFFF"));
                brain.setBackgroundColor(Color.parseColor("#FFFFFF"));
                heart.setBackgroundColor(Color.parseColor("#FFFFFF"));
                bone.setBackgroundColor(Color.parseColor("#FFFFFF"));

            }
        });
        brain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doctorp="Brain";

                brain.setBackgroundColor(Color.parseColor("#00CCCB"));
                dent.setBackgroundColor(Color.parseColor("#FFFFFF"));
                liver.setBackgroundColor(Color.parseColor("#FFFFFF"));
                blood.setBackgroundColor(Color.parseColor("#FFFFFF"));
                heart.setBackgroundColor(Color.parseColor("#FFFFFF"));
                bone.setBackgroundColor(Color.parseColor("#FFFFFF"));


            }
        });
        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doctorp="Heart";

                heart.setBackgroundColor(Color.parseColor("#00CCCB"));
                dent.setBackgroundColor(Color.parseColor("#FFFFFF"));
                liver.setBackgroundColor(Color.parseColor("#FFFFFF"));
                brain.setBackgroundColor(Color.parseColor("#FFFFFF"));
                blood.setBackgroundColor(Color.parseColor("#FFFFFF"));
                bone.setBackgroundColor(Color.parseColor("#FFFFFF"));

            }
        });
        bone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doctorp="Bone";

                bone.setBackgroundColor(Color.parseColor("#00CCCB"));
                brain.setBackgroundColor(Color.parseColor("#FFFFFF"));
                dent.setBackgroundColor(Color.parseColor("#FFFFFF"));
                liver.setBackgroundColor(Color.parseColor("#FFFFFF"));
                blood.setBackgroundColor(Color.parseColor("#FFFFFF"));
                heart.setBackgroundColor(Color.parseColor("#FFFFFF"));

            }

        });


        return rootview;
    }
    public void onResume() {
        if(doctorp.equals("Blood")){
            blood.setBackgroundColor(Color.parseColor("#00CCCB"));
        }
        if(doctorp.equals("Bone")){
            bone.setBackgroundColor(Color.parseColor("#00CCCB"));
        }
        if(doctorp.equals("Brain")){
            brain.setBackgroundColor(Color.parseColor("#00CCCB"));
        }
        if(doctorp.equals("Dentist")){
            dent.setBackgroundColor(Color.parseColor("#00CCCB"));
        }
        if(doctorp.equals("Liver")){
            liver.setBackgroundColor(Color.parseColor("#00CCCB"));
        }
        if(doctorp.equals("Heart")){
           heart.setBackgroundColor(Color.parseColor("#00CCCB"));
        }
        super.onResume();
    }

}