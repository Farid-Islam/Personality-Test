package com.example.farid.personalitytest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private RadioGroup[] radioGroup = new RadioGroup[35];
    private Button result;

    int shilpi_sulov = 0;
    int babosthapona = 0;
    int sahitto_onuragi = 0;
    int bohirmukhi = 0;
    int baboharik = 0;
    int tottho_babohar = 0;
    int boigganic = 0;
    int samajik = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("Personality test");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        findId();

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton radioButton;
                int selectedId, value = 0;
                String str;

                    for (int i = 1; i <= 32; i++) {

                        try{

                            selectedId = radioGroup[i].getCheckedRadioButtonId();
                            radioButton = findViewById(selectedId);
                            str = radioButton.getText().toString();

                            if (str.equals("সম্পূর্ণ ভিন্নমত")) {
                                value = 0;
                            } else if (str.equals("ভিন্নমত")) {
                                value = 1;
                            } else if (str.equals("নিরপেক্ষ")) {
                                value = 2;
                            } else if (str.equals("একমত")) {
                                value = 3;
                            } else if (str.equals("সম্পূর্ণ একমত")) {
                                value = 4;
                            }

                            if (i == 4 || i == 11 || i == 17 || i == 26) {// shilpi_sulov

                                shilpi_sulov += value;

                            } else if (i == 13 || i == 15 || i == 19 || i == 30) { // babosthapona

                                babosthapona += value;

                            } else if (i == 3 || i == 8 || i == 9 || i == 16) { // sahitto_onuragi

                                sahitto_onuragi += value;

                            } else if (i == 1 || i == 6 || i == 20 || i == 29) { // bohirmukhi

                                bohirmukhi += value;

                            } else if (i == 5 || i == 10 || i == 21 || i == 25) { // baboharik

                                baboharik += value;

                            } else if (i == 14 || i == 22 || i == 28 || i == 32) { // tottho_babohar

                                tottho_babohar += value;

                            } else if (i == 2 || i == 7 || i == 23 || i == 24) { // boigganik

                                boigganic += value;

                            } else if (i == 12 || i == 18 || i == 27 || i == 31) { // samajik

                                samajik += value;

                            }

                        }catch (Exception e){
                            Toast.makeText(MainActivity.this, i+". number question not checked", Toast.LENGTH_SHORT).show();
                        }

                    }

                personalitySorting();

            }

        });




    }

    public void findId() {

        radioGroup[1] = findViewById(R.id.radioGroupId_1);
        radioGroup[2] = findViewById(R.id.radioGroupId_2);
        radioGroup[3] = findViewById(R.id.radioGroupId_3);
        radioGroup[4] = findViewById(R.id.radioGroupId_4);
        radioGroup[5] = findViewById(R.id.radioGroupId_5);
        radioGroup[6] = findViewById(R.id.radioGroupId_6);
        radioGroup[7] = findViewById(R.id.radioGroupId_7);
        radioGroup[8] = findViewById(R.id.radioGroupId_8);
        radioGroup[9] = findViewById(R.id.radioGroupId_9);
        radioGroup[10] = findViewById(R.id.radioGroupId_10);
        radioGroup[11] = findViewById(R.id.radioGroupId_11);
        radioGroup[12] = findViewById(R.id.radioGroupId_12);
        radioGroup[13] = findViewById(R.id.radioGroupId_13);
        radioGroup[14] = findViewById(R.id.radioGroupId_14);
        radioGroup[15] = findViewById(R.id.radioGroupId_15);
        radioGroup[16] = findViewById(R.id.radioGroupId_16);
        radioGroup[17] = findViewById(R.id.radioGroupId_17);
        radioGroup[18] = findViewById(R.id.radioGroupId_18);
        radioGroup[19] = findViewById(R.id.radioGroupId_19);
        radioGroup[20] = findViewById(R.id.radioGroupId_20);
        radioGroup[21] = findViewById(R.id.radioGroupId_21);
        radioGroup[22] = findViewById(R.id.radioGroupId_22);
        radioGroup[23] = findViewById(R.id.radioGroupId_23);
        radioGroup[24] = findViewById(R.id.radioGroupId_24);
        radioGroup[25] = findViewById(R.id.radioGroupId_25);
        radioGroup[26] = findViewById(R.id.radioGroupId_26);
        radioGroup[27] = findViewById(R.id.radioGroupId_27);
        radioGroup[28] = findViewById(R.id.radioGroupId_28);
        radioGroup[29] = findViewById(R.id.radioGroupId_29);
        radioGroup[30] = findViewById(R.id.radioGroupId_30);
        radioGroup[31] = findViewById(R.id.radioGroupId_31);
        radioGroup[32] = findViewById(R.id.radioGroupId_32);

        result = findViewById(R.id.resultButtonId);

    }

    void personalitySorting(){

        int[] person = new int[9];

        person[1] = shilpi_sulov;
        person[2] = babosthapona;
        person[3] = sahitto_onuragi;
        person[4] = bohirmukhi;
        person[5] = baboharik;
        person[6] = tottho_babohar;
        person[7] = boigganic;
        person[8] = samajik;

        Arrays.sort(person);
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=8; i>=1; i--){

            if(person[i] == shilpi_sulov){

                stringBuilder.append("শিল্পী সুলভ"+ " : "+shilpi_sulov+"\n");
                shilpi_sulov = -1;

            }else if(person[i] == babosthapona){

                stringBuilder.append("ব্যবস্থাপনা" + " : "+babosthapona+"\n");
                babosthapona = -1;

            }else if(person[i] == sahitto_onuragi){

                stringBuilder.append("সাহিত্যানুরাগী" + " : "+sahitto_onuragi+"\n");
                sahitto_onuragi = -1;

            }else if(person[i] == bohirmukhi){

                stringBuilder.append("বহির্মুখী" + " : "+bohirmukhi+"\n");
                bohirmukhi = -1;

            }else if(person[i] == baboharik){

                stringBuilder.append("ব্যবহারিক" + " : "+baboharik+"\n");
                baboharik = -1;

            }else if(person[i] == tottho_babohar){

                stringBuilder.append("তথ্য ব্যবহার" + " : "+tottho_babohar+"\n");
                tottho_babohar = -1;

            }else if(person[i] == boigganic){

                stringBuilder.append("বৈজ্ঞানিক" + " : "+boigganic+"\n");
                boigganic = -1;

            }else if(person[i] == samajik){

                stringBuilder.append("সামাজিক" + " : "+samajik+"\n");
                samajik = -1;

            }

        }

        //textView.setText(stringBuilder);
        Intent intent = new Intent(this,ResultActivity.class);
        String string = stringBuilder.toString();
        intent.putExtra("tag",string);
        startActivity(intent);

    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
         shilpi_sulov = 0;
         babosthapona = 0;
         sahitto_onuragi = 0;
         bohirmukhi = 0;
         baboharik = 0;
         tottho_babohar = 0;
         boigganic = 0;
         samajik = 0;

        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Personality test");
        alertDialogBuilder.setMessage("Do you want to exite ?");
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}
