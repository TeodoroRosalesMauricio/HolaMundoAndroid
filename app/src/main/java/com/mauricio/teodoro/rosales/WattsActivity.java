package com.mauricio.teodoro.rosales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WattsActivity extends AppCompatActivity {

    private EditText editTextX;
    private EditText editTextY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watts);
        editTextX = findViewById(R.id.editTextNumberX );
        editTextY = findViewById(R.id.editTextNumberY );
        editTextX.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if( !hasFocus )
                {
                    realizaOperacion1( );
                }
            }
        });
        editTextY.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if( !hasFocus )
                {
                    realizaOperacion2( );
                }
            }
        });

    }

    private void realizaOperacion1()
    {
        int total = 0;
        if( editTextX.getText().toString() != null )
        {
            if( isEntero( editTextX.getText().toString() ) )
            {
                total = getEntero( editTextX.getText().toString() );
                total = total * 1000;
            }
        }
        editTextY.setText( String.format("%d" , total ) , TextView.BufferType.SPANNABLE );
    }

    private void realizaOperacion2()
    {
        int total = 0;
        if( editTextY.getText().toString() != null )
        {
            if( isEntero( editTextY.getText().toString() ) )
            {
                total = getEntero( editTextY.getText().toString() );
                total = total / 1000;
            }
        }
        editTextX.setText( String.format("%d" , total ) , TextView.BufferType.SPANNABLE );
    }

    private int getEntero(String entero)
    {
        try
        {
            return Integer.parseInt( entero );
        }
        catch( NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return 0;
    }

    private boolean isEntero(String entero)
    {
        try
        {
            if( entero == null || entero.length() == 0)
            {
                return false;
            }
            Integer.parseInt( entero );
            return true;
        }
        catch( NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return false;

    }
}