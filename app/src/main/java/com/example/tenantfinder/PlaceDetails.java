package com.example.tenantfinder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.UUID;

public class PlaceDetails extends AppCompatActivity {

    private Button addImage, Upload;
    private ImageView imageView;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    public Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addImage = findViewById(R.id.image);
        Upload = findViewById(R.id.lnd_upload);
        imageView = findViewById(R.id.view);

//        storage = FirebaseStorage.getInstance();
//        storageReference = storage.getReference();
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                choosePicture();
//            }
//        });
//
//
//    }
//
//    private void choosePicture() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, 1);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == 1 && requestCode == RESULT_OK && data!=null && data.getData()!=null) {
//            imageUri = data.getData();
//            imageView.setImageURI(imageUri);
//            uploadPicture();
//        }
//    }
//
//    private void uploadPicture() {
//        final ProgressBar pd = new ProgressBar(this);
//        pd.setTitle("Uploading image...");
//        pd.setVisibility();
//
//        final String randomKey = UUID.randomUUID().toString();
//
//        StorageReference mountainsRef = storageReference.child("images/" + randomKey);
//
//// Create a reference to 'images/mountains.jpg'
//        StorageReference mountainImagesRef = storageReference.child("images/" + randomKey);
//
//// While the file names are the same, the references point to different files
//        mountainsRef.getName().equals(mountainImagesRef.getName());    // true
//        mountainsRef.getPath().equals(mountainImagesRef.getPath());    // false
    }
}