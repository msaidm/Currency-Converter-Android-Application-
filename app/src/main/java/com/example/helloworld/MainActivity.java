package com.example.helloworld;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.text.DecimalFormat;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText usdEditText ;
    EditText epgEditText ;
    boolean usdflag =false;
    boolean egpflag =false;
    boolean usdDotCliked=false;
    boolean egpDotCliked=false;
    char egpChar[];
    char usdChar[];
    DecimalFormat df = new DecimalFormat("#.##########");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usdEditText=(EditText)findViewById(R.id.usdText);
        epgEditText=(EditText)findViewById(R.id.epgText);


        usdEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

                if(!egpflag) {
                    if (usdEditText.getText().toString().length() > 0) {
                        usdChar=usdEditText.getText().toString().toCharArray();
                        if(usdChar[0]=='.' )
                        {

                            usdDotCliked=true;
                            usdEditText.setText(0+".");
                            usdEditText.setSelection(2);

                        }
                        final float usd = Float.parseFloat(usdEditText.getText().toString());

                        float Value = usd * 16;
                        usdflag=true;
                        String convDec = df.format(Value);
                        epgEditText.setText(convDec);




                    }
                    else if(usdEditText.getText().toString().length()==0)
                    {
                        epgEditText.getText().clear();
                    }
                }
                usdflag =false;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }


        });

        epgEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if(!usdflag) {

                    if (epgEditText.getText().toString().length() > 0) {
                        egpChar=epgEditText.getText().toString().toCharArray();
                        if(egpChar[0]=='.')
                        {
                            egpDotCliked=true;
                            epgEditText.setText(0+".");
                            epgEditText.setSelection(2);
                        }

                        float epg = Float.parseFloat(epgEditText.getText().toString());
                        float Value = epg / (float) 16.3;
                        egpflag=true;
                        String convDec = df.format(Value);
                        usdEditText.setText(convDec);
                    }
                    else if(epgEditText.getText().toString().length()==0)
                    {
                        usdEditText.getText().clear();
                    }

                }
                egpflag =false;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }


        });

    }


}
