package com.example.shoesstore.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shoesstore.R;

public class SettingFragment extends Fragment {
    TextView call,feedback,send_your_message;
    ImageView facebook, instagram, youtube,share,btn_category_back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_setting, container, false);
        btn_category_back = v.findViewById(R.id.btn_category_back);
        btn_category_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfileFragment profileFragment =  new ProfileFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
            }
        });

        feedback = (TextView) v.findViewById(R.id.send_email);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                String uriText = "mailto:" + Uri.encode("info@seekmyvision.in") + "?subject=" + Uri.encode("your email id ") + "&body=" + Uri.encode("");
                Uri uri = Uri.parse(uriText);
                intent.setData(uri);
                startActivity(Intent.createChooser(intent, "Send Email"));

            }
        });



        send_your_message = v.findViewById(R.id.send_your_message);
        send_your_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), query_page.class);
//                startActivity(intent);
            }
        });


        facebook = v.findViewById(R.id.facebook);
        facebook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.facebook.com/seekmyvision");
            }
            private void gotoUrl(String s) {
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });

        youtube = v.findViewById(R.id.youtube);
        youtube.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.youtube.com/");
            }
            private void gotoUrl(String s) {
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });


        instagram = v.findViewById(R.id.instagram);
        instagram.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/");
            }
            private void gotoUrl(String s) {
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });

        share = (ImageView) v.findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String sharebody = "look all Programmings";
                String subject = "https://truong45truong.pythonanywhere.com/contact";
                i.putExtra(Intent.EXTRA_SUBJECT,sharebody);
                i.putExtra(Intent.EXTRA_TEXT,subject);
                startActivity(Intent.createChooser(i,"Seek my vision"));
            }
        });

        return v;
    }
}