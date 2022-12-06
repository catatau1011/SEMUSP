package com.example.semusp.Denucias;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.semusp.R;
import com.example.semusp.Telas.ListaDefesaCivil;

public class CadastroDenuncia_Defesa_Civil extends AppCompatActivity {

    TextView textView;
    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;

    ImageView imageView;
    Button mCapturebtn;
    Uri image_uri;
    EditText Data,Local,Descrição;
    Button Resgistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_defesa_civil);
        getSupportActionBar().hide();

        textView = findViewById(R.id.txtrresultado);
        imageView = findViewById(R.id.image_view33);
        mCapturebtn = findViewById(R.id.capture_image_btn);
        //////////////////////////////////////////////////
        Descrição = findViewById(R.id.editDescricao);
        Local = findViewById(R.id.editLocal);
        Data = findViewById(R.id.editDataOcorrido);
        //////////////////////////////////////////////////q
        Resgistrar = findViewById(R.id.btnRegistrarDefesaCivil);

        String texto = getIntent().getStringExtra("key");

        if(texto!=null){
            textView.setText(texto);
        }

        Resgistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoDescricao = Descrição.getText().toString();
                String textoLocal = Local.getText().toString();
                String textoData = Data.getText().toString();

                if (!textoDescricao.isEmpty() && !textoLocal.isEmpty() && !textoData.isEmpty()){
                    Intent intent = new Intent(CadastroDenuncia_Defesa_Civil.this, ListaDefesaCivil.class);
                    intent.putExtra("Chave",textoDescricao);
                    intent.putExtra("Chave1",textoLocal);
                    intent.putExtra("Chave2",textoData);
                    startActivity(intent);
                    finish();
                }else {
                 Toast.makeText(CadastroDenuncia_Defesa_Civil.this,"Preencha Todos os Campos!Por favor",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mCapturebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.CAMERA)==
                            PackageManager.PERMISSION_DENIED ||checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                            PackageManager.PERMISSION_DENIED ){
                        String[] permissao = {Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permissao,PERMISSION_CODE);
                    }
                    else {
                        openCamera();

                    }
                }
                else {

                }
            }
        });
    }

    private void openCamera() {

        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE,"New Picturre");
        values.put(MediaStore.Images.Media.DESCRIPTION,"From de camera");
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,image_uri);
        startActivityForResult(cameraIntent,IMAGE_CAPTURE_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_CODE:{
                if(grantResults.length> 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED){
                    openCamera();
                }else {
                    Toast.makeText(this,"Permissao falha",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            imageView.setImageURI(image_uri);
        }
    }

}
