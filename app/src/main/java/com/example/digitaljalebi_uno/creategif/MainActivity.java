package com.example.digitaljalebi_uno.creategif;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   AnimationDrawable animatedGIF = new AnimationDrawable();
        animatedGIF.addFrame(new BitmapDrawable(getResources(), R.drawable.test),10);
        animatedGIF.addFrame(new BitmapDrawable(getResources(), <bitmap2>), <duration>);

        view.setBackground(animatedGIF); // attach animation to a view
        animatedGIF.run()*/




        // code for bitmap TRY1

      //  Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.img1);
        Bitmap bMap1 = BitmapFactory.decodeResource(getResources(), R.drawable.img2);
        Bitmap bMap2 = BitmapFactory.decodeResource(getResources(), R.drawable.img3);
        Bitmap bMap3 = BitmapFactory.decodeResource(getResources(), R.drawable.img4);


     //   Bitmap bmp = BitmapFactory.decodeFile(bitmap);
     //   Bitmap bmp1 = BitmapFactory.decodeFile("D:\\naval\\image_1.jpg");
     //   Bitmap bmp2 = BitmapFactory.decodeFile("D:\\naval\\image_2.jpg");
      //  Bitmap bmp3 = BitmapFactory.decodeFile("D:\\naval\\image_3.jpg");





        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        AnimatedGifEncoder encoder = new AnimatedGifEncoder();
        encoder.setDelay(10000);

        encoder.start(bos);
        encoder.addFrame(bMap);
        encoder.addFrame(bMap1);
        encoder.addFrame(bMap2);
        encoder.addFrame(bMap3);
     //   encoder.addFrame(bmp1);
      //  encoder.addFrame(bmp2);
     //   encoder.addFrame(bmp3);

        //encoder.addFrame(image2);
        encoder.finish();

        writeToFile(bos.toByteArray());


    }

    public void writeToFile(byte[] array) {
        try {
            String path = Environment.getExternalStorageDirectory() + "/naval/nj.gif";
            FileOutputStream stream = new FileOutputStream(path);
            stream.write(array);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
