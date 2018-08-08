package com.thealteria.imageshowdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class ImageActivity extends AppCompatActivity {

    private ArrayList<String> arrayList = new ArrayList<String>();
    private String pathImage, pathVideo, pathAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        pathImage = Environment.getExternalStorageDirectory().toString() + "/Whatsapp/Media/WhatsApp Images";
        pathVideo = Environment.getExternalStorageDirectory().toString() + "/Whatsapp/Media/WhatsApp Video";
        pathAudio = Environment.getExternalStorageDirectory().toString() + "/Whatsapp/Media/WhatsApp Audio";


        getFromSdcard();

        GridView grid = findViewById(R.id.gridView);
        GridAdapter gridAdapter = new GridAdapter(this, arrayList);
        grid.setAdapter(gridAdapter);

    }

    public void getFromSdcard()
    {
        File file= new File(pathImage);

        File[] listFile = file.listFiles();
        for (File aListFile : listFile) {
            if (file.isDirectory()) {
                arrayList.add(aListFile.getPath());
            }

//            else if (file.getName().endsWith(".jpg")) {
//                arrayList.add(aListFile.getPath());
//            }
        }
    }
}