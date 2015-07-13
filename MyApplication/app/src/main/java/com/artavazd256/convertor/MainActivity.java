package com.artavazd256.convertor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Hashtable;
import java.util.Map;


/**
 * Created by artavazd on 7/13/15.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private RadioButton[] radioButtonsTypeNumber;
    private RadioButton[] radioButtonsNegativeOrPositive;
    private Map<String, RadioButton> selectedRadioButtons;
    private Button[] buttons;
    private TextView displayDec;
    private TextView displayHex;
    private TextView displayOct;
    private TextView displayBin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        init();
        initListener();
        enableKeyboard(10);
    }

    private void initListener() {
        for (RadioButton radioButton: radioButtonsTypeNumber) {
            radioButton.setOnClickListener(this);
        }
        for (RadioButton radioButton: radioButtonsNegativeOrPositive) {
            radioButton.setOnClickListener(this);
        }
        for (Button button: buttons) {
            button.setOnClickListener(this);
        }
    }


    private void init() {
        radioButtonsTypeNumber = new RadioButton[4];
        radioButtonsNegativeOrPositive = new RadioButton[2];
        buttons = new Button[16];
        displayDec = (TextView) findViewById(R.id.displayDec);
        displayHex = (TextView) findViewById(R.id.displayHex);
        displayOct = (TextView) findViewById(R.id.displayOct);
        displayBin = (TextView) findViewById(R.id.displayBin);
        radioButtonsTypeNumber[0] = (RadioButton) findViewById(R.id.radioButtonDec);
        radioButtonsTypeNumber[1] = (RadioButton) findViewById(R.id.radioButtonHex);
        radioButtonsTypeNumber[2] = (RadioButton) findViewById(R.id.radioButtonOct);
        radioButtonsTypeNumber[3] = (RadioButton) findViewById(R.id.radioButtonBin);
        radioButtonsNegativeOrPositive[0] = (RadioButton) findViewById(R.id.radioButtonNegative);
        radioButtonsNegativeOrPositive[1] = (RadioButton) findViewById(R.id.radioButtonPositive);
        buttons[0] = (Button) findViewById(R.id.button0);
        buttons[1] = (Button) findViewById(R.id.button1);
        buttons[2] = (Button) findViewById(R.id.button2);
        buttons[3] = (Button) findViewById(R.id.button3);
        buttons[4] = (Button) findViewById(R.id.button4);
        buttons[5] = (Button) findViewById(R.id.button5);
        buttons[6] = (Button) findViewById(R.id.button6);
        buttons[7] = (Button) findViewById(R.id.button7);
        buttons[8] = (Button) findViewById(R.id.button8);
        buttons[9] = (Button) findViewById(R.id.button9);
        buttons[10] = (Button) findViewById(R.id.buttonA);
        buttons[11] = (Button) findViewById(R.id.buttonB);
        buttons[12] = (Button) findViewById(R.id.buttonC);
        buttons[13] = (Button) findViewById(R.id.buttonD);
        buttons[14] = (Button) findViewById(R.id.buttonE);
        buttons[15] = (Button) findViewById(R.id.buttonF);
        selectedRadioButtons = new Hashtable<>();
        for (RadioButton radioButton : radioButtonsTypeNumber) {
            if (radioButton.isChecked()) {
                selectedRadioButtons.put("radioButtonsTypeNumber", radioButton);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radioButtonDec:
            case R.id.radioButtonHex:
            case R.id.radioButtonOct:
            case R.id.radioButtonBin:
                changeRadioButtonValues(v.getId(), radioButtonsTypeNumber, "radioButtonsTypeNumber" ) ;
                break;
            case R.id.radioButtonPositive:
            case R.id.radioButtonNegative:
                changeRadioButtonValues(v.getId(), radioButtonsNegativeOrPositive, "radioButtonsNegativeOrPositive");
                break;
            case R.id.button0:
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
            case R.id.buttonA:
            case R.id.buttonB:
            case R.id.buttonC:
            case R.id.buttonD:
            case R.id.buttonE:
            case R.id.buttonF:
                changeNumber(v);
                break;


        }
        initKeyBord(v);
    }


    private void changeRadioButtonValues(int id, RadioButton[] radioButtons, String key) {
        for (RadioButton radioButton: radioButtons) {
            if (radioButton.getId() == id) {
                radioButton.setChecked(true);
                selectedRadioButtons.put(key, radioButton);
            } else {
                radioButton.setChecked(false);
            }
        }
    }

    private void initKeyBord(View v) {
        switch (v.getId()) {
            case R.id.radioButtonDec:
                enableKeyboard(10);
                break;
            case R.id.radioButtonHex:
                enableKeyboard(16);
                break;
            case R.id.radioButtonOct:
                enableKeyboard(8);
                break;
            case R.id.radioButtonBin:
                enableKeyboard(2);
                break;
        }

    }

    private void enableKeyboard(int type) {
        int conter = 0;
        for (Button button: buttons) {
            if (conter < type) {
                button.setEnabled(true);
            } else {
                button.setEnabled(false);
            }
            conter++;
        }
    }

    private void changeNumber(View v) {
        Button button = (Button)v;
        String number = button.getText().toString();
        switch (selectedRadioButtons.get("radioButtonsTypeNumber").getId()) {
            case R.id.radioButtonDec:
                displayDec.append(number);
                break;
            case R.id.radioButtonHex:
                displayHex.append(number);
                break;
            case R.id.radioButtonOct:
                displayOct.append(number);
                break;
            case R.id.radioButtonBin:
                displayBin.append(number);
                break;

        }
    }

}

