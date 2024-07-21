package com.mjkdisoft.chatbot;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        GridLayout gridLayout = findViewById(R.id.gridLayout);
        ImageView imageViewBackground = findViewById(R.id.imageViewBackground);

        TextView normal = findViewById(R.id.normal);
        TextView romance = findViewById(R.id.romantis);
        TextView comedy = findViewById(R.id.komedi);
        TextView technology = findViewById(R.id.teknologi);

        final Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.button_scale);

        normal.setOnClickListener(v -> {
            Intent intent = new Intent(this, NormalGenre.class);
            v.startAnimation(scaleAnimation);
            startActivity(intent);
        });
        romance.setOnClickListener(v -> {
            Intent intent = new Intent(this, RomanceGenre.class);
            v.startAnimation(scaleAnimation);
            startActivity(intent);
        });
        comedy.setOnClickListener(v -> {
            Intent intent = new Intent(this, ComedyGenre.class);
            v.startAnimation(scaleAnimation);
            startActivity(intent);
        });
        technology.setOnClickListener(v -> {
            Intent intent = new Intent(this, TechnologyGenre.class);
            v.startAnimation(scaleAnimation);
            startActivity(intent);
        });

        imageViewBackground.post(() -> {
            Bitmap bitmap = ((BitmapDrawable) imageViewBackground.getDrawable()).getBitmap();
            Bitmap blurredBitmap = BlurBuilder.blur(this, bitmap);
            imageViewBackground.setImageBitmap(blurredBitmap);
        });
    }
}
