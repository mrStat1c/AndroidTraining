package com.example.androidtraining.intentsApp2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtraining.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.int_2_layout);
    }

    public void onClickOpenWebpageButton(View view) {
        openWebPage("https://www.google.com");
    }

    public void onClickOpenMapButton(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
//        Uri coord =  Uri.parse("geo:47.6,-122.3");
        Uri address = Uri.parse("geo:0,0")
                .buildUpon()
                .appendQueryParameter("q", "Тверская улица, 1")
                .build();
        intent.setData(address);
//        следующая строчка для того, чтобы получить доступ к карте (???)
//        см. https://stackoverflow.com/questions/2662531/launching-google-maps-directions-via-an-intent-on-android
        intent.setClassName("com.google.android.apps.maps",
                "com.google.android.maps.MapsActivity");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onClickOpenCamera(View view) {
       Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
// Условие почему-то не работает (возвращает null)
       //        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
//        }
    }

    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
       // проверка на то, может ли устройство пол-ля выполнить данное действие
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Невозможно открыть страницу!", Toast.LENGTH_SHORT).show();
        }
    }
}
