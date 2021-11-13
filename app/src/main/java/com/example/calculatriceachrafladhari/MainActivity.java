package com.example.calculatriceachrafladhari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.nio.file.Files.size;
//beugs for exemple 1+1 the edit text get the first number then it shows "result.." when i press "+"
//can't do a history textview
//Work by Achraf Ben Cheikh Ladhari 2 iot 1 TP2
public class MainActivity extends AppCompatActivity {
    //declaration
    //chiffre store the number and convert it to double for calculate
    //oper store the operation for the switch
    //fact for the factorial
    private double chiffre;
    private String oper="";
    private int fact=1;
    //initialization buttons and edittext
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnpoint,btnplus,btnmoin,btndiv,btnfois,btnc,btnegl,btnfact;
    EditText affiche;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get buttons and edittext from the activity_main.xml
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnpoint = (Button) findViewById(R.id.btnpnt);
        btnplus = (Button) findViewById(R.id.btnpls);
        btnmoin = (Button) findViewById(R.id.btnmoins);
        btndiv = (Button) findViewById(R.id.btndiv);
        btnfois = (Button) findViewById(R.id.btnfoi);
        btnc = (Button) findViewById(R.id.btnc);
        btnegl = (Button) findViewById(R.id.egale);
        affiche = (EditText) findViewById(R.id.tv1);
        btnfact=(Button) findViewById(R.id.fact);
        //click on boutton 0-9 to enter the number
        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                number("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                number("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                number("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                number("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                number("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                number("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                number("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                number("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                number("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                number("9");
            }
        });
        //boutton "-" do the minus and do a java exceptions for the app don't close imidiatly

        btnmoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{chiffre=parseDouble(affiche.getText().toString());
                affiche.setText("");
                oper="-";}catch (NumberFormatException e){
                    affiche.setText("-");
                }
            }
        });
        //boutton "+" do the plus and do a java exceptions for the app don't close imidiatly

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{chiffre=parseDouble(affiche.getText().toString());
                affiche.setText("");
                oper="+";}catch (NumberFormatException e){
                    affiche.setText("Press c : 404 Not Found");
                }
            }
        });
        //boutton fact do the factorial and do a java exceptions for the app don't close imidiatly

        btnfact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fact=1;

                try{chiffre=parseDouble(affiche.getText().toString());
                    oper="!";
                for (int i = 1; i<=chiffre; i++){
                    fact=fact*i;
                }
                affiche.setText(String.valueOf(fact));}catch (NumberFormatException e){
                    affiche.setText("Enter Number Then !, Press c and try again");
                }
            }
        });

        //boutton "*" do the multiple and do a java exceptions for the app don't close imidiatly

        btnfois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{chiffre=parseDouble(affiche.getText().toString());
                affiche.setText("");
                oper="*";}catch (NumberFormatException e){
                    affiche.setText("Press c : 404 Not Found");
                }
            }
        });
        //boutton div do the division and do a java exceptions for the app don't close imidiatly
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{chiffre=parseDouble(affiche.getText().toString());
                affiche.setText("");
                oper="/";}catch (NumberFormatException e){
                    affiche.setText("Press c : 404 Not Found");
                }
            }
        });
        //boutton "." add . in the EditText
        btnpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affiche.setText(affiche.getText().toString()+".");
            }
        });
        //boutton "C" initialize all the attributes and the EditText where the result shows
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                affiche.setText("");
                chiffre=0;
                oper="";
                fact=1;
            }
        });
        //boutton "=" call calcul method to get the result
        btnegl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                calcul();
            }
        });
    }
    //method number to concatenation
    public void number(String nm) {
        affiche.setText (affiche.getText() + nm);
    }
    //method for calcul switch oper + or - or * or /
public void calcul (){
    switch(oper){
        case  "+": chiffre = chiffre + parseDouble(affiche.getText().toString());
            affiche.setText(String.valueOf(chiffre));
            break;
        case "-" :  chiffre = chiffre - parseDouble(affiche.getText().toString());
            affiche.setText(String.valueOf(chiffre));
            break;
        case "*" :  chiffre = chiffre * parseDouble(affiche.getText().toString());
            affiche.setText(String.valueOf(chiffre));
            break;

        case "/" : if(chiffre>0){ chiffre = chiffre / parseDouble(affiche.getText().toString());
            affiche.setText(String.valueOf(chiffre));
            break;}
            else {
                affiche.setText("Press c : UnderFined");
        }
    }
}

}