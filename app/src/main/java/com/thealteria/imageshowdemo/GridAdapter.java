package com.thealteria.imageshowdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

class GridAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater = null;
    private Context context;
    private ArrayList<String> arrayList = new ArrayList<String>();
    private CheckBox checkBox;
    private View view;

    GridAdapter(ImageActivity imageActivity, ArrayList<String> imageList) {

        arrayList = imageList;
        context = imageActivity;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("StaticFieldLeak")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;
        holder = new Holder();

//        if (convertView == null) {

            view =  inflater.inflate(R.layout.grid_item_layout, null);
            holder.checkBox = view.findViewById(R.id.checked);
            holder.imageView = view.findViewById(R.id.iv_Grid);
//        holder.imageView.setImageURI(Uri.parse(arrayList.get(position)));
//        Bitmap myBitmap = BitmapFactory.decodeFile(arrayList.get(position));


            final Holder finalHolder1 = holder;
            new AsyncTask<Holder, Void, Bitmap>() {
                private Holder viewHolder;

                @Override
                protected Bitmap doInBackground(Holder... holders) {

                    viewHolder = holders[0];
                    return BitmapFactory.decodeFile(arrayList.get(position));
                }

                @Override
                protected void onPostExecute(final Bitmap bitmap) {
                    super.onPostExecute(bitmap);

                    Glide.with(context).load(bitmap).into(viewHolder.imageView);

                    //finalHolder1.imageView.setImageURI(Uri.parse(arrayList.get(position)));

                }
            }.execute(holder);

            view.setTag(holder);
//        }

//        else {
//           holder = (Holder) view.getTag();
//        }

        final Holder finalHolder = holder;
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                finalHolder.checkBox.setVisibility(View.VISIBLE);
                finalHolder.checkBox.setChecked(true);
                Toast.makeText(context, "mamamamamamma", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, FullScreenActivity.class);
//                intent.putExtra("imageUri", bitmap);
                Toast.makeText(context, "lolllllllll", Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }
}



