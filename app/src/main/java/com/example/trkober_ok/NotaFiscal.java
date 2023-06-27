package com.example.trkober_ok;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.trkober_ok.databinding.ActivityNotaFiscalBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


import com.example.trkober_ok.databinding.ActivityNotaFiscalBinding;

public class NotaFiscal extends AppCompatActivity {
    //https://firebase.google.com/docs/reference/android/com/google/firebase/storage/StorageReference
    //Classes de vinculação geradas
    ActivityNotaFiscalBinding binding;

    //a classe URI implementa um Parcelable, ou seja, você pode extrair ela diretamente da sua intent.
    Uri imageUri;

    //apontando para um local filho da referência atual
    StorageReference storageReference;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotaFiscalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.selectImagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selecionaImagem();
            }
        });

        binding.uploadimagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadImagem();
            }
        });
    }

    private void UploadImagem() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Carregando o arquivo.....");
        progressDialog.show();

        storageReference = FirebaseStorage.getInstance().getReference();
        // formatar um data no padrão
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CANADA);
        Date now = new Date();
        String fileName = formatter.format(now);


        storageReference = FirebaseStorage.getInstance().getReference("notafiscal/"+fileName);

        //Carrega de forma assíncrona dados de bytes para este arquivo StorageReference.
        //Isso não é recomendado para arquivos grandes
        //Em vez disso, carregue um arquivo via putFile(Uri)
        storageReference.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    //Carrega de forma assíncrona de um URI de conteúdo para este arquivo StorageReference.
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        binding.firebaseimage.setImageURI(null);
                        Toast.makeText(NotaFiscal.this,"IMAGEM ENVIADA COM SUCESSO!",Toast.LENGTH_SHORT).show();
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                        Toast.makeText(NotaFiscal.this,"FALHA NO CARREGAMENTO",Toast.LENGTH_SHORT).show();

                    }
                });
    }


    private void selecionaImagem() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //Use esse atributo apenas se você realmente precisar impor uma ordem específica em que as transmissões
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && data != null && data.getData() != null){

            imageUri = data.getData();
            binding.firebaseimage.setImageURI(imageUri);


        }
    }
}