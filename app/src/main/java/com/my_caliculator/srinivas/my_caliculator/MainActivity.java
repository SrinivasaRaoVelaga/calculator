package com.my_caliculator.srinivas.my_caliculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    Button plusBtn;
    TextView resultView;
    Button minusBtn;
    Button intoBtn;
    Button divBtn;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button equalsBtn;
    Button clr;
    static String operator;
    String temp;
    String [] temp1;
    float result;
    Context context;
    CharSequence text= "Error!";
    static List<String> op;


    public void showError() {
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }

    public Context cal(){
        switch(operator){
            case "+":
                temp =  resultView.getText().toString();
                temp1 = temp.split("\\+");
                Log.d("Plus", "cal: "+temp+temp1[0]);
                result =  Float.parseFloat(temp1[0])+(Float.parseFloat(temp1[1]));
                resultView.setText((Float.toString(result)));
                break;
            case "-":
                temp =  resultView.getText().toString();
                temp1 = temp.split("-");
                Log.d("Minus", "cal: "+temp+temp1[0]);
                result =  Float.parseFloat(temp1[0])-(Float.parseFloat(temp1[1]));
                resultView.setText((Float.toString(result)));
                break;
            case "*":
                temp =  resultView.getText().toString();
                temp1 = temp.split("\\*");
                Log.d("Into", "cal: "+temp+temp1[0]);
                if((Float.parseFloat(temp1[0])==0)&&(Float.parseFloat(temp1[1])==0)){
                    showError();
                    break;
                }
                else {
                    result = Float.parseFloat(temp1[0]) * (Float.parseFloat(temp1[1]));
                    resultView.setText((Float.toString(result)));
                    break;
                }
            case "/":
                temp =  resultView.getText().toString();
                temp1 = temp.split("/");
                Log.d("Div", "cal: "+temp+temp1[0]);
                if(Float.parseFloat(temp1[1])==0) {
                    showError();
                    break;
                }
                else {
                    result = Float.parseFloat(temp1[0]) / (Float.parseFloat(temp1[1]));
                    resultView.setText((Float.toString(result)));
                    break;
                }


        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        op= new ArrayList<String>();
        op.add("+");
        op.add("-");
        op.add("/");
        op.add("*");
        resultView= (TextView) findViewById(R.id.resultText);
        operator = null;
        plusBtn = (Button) findViewById(R.id.plusButton);
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText().toString().length() == 0) {
                    operator = "+";
                    resultView.setText(resultView.getText().toString() + "+");
                } else {

                    char temp = resultView.getText().toString().charAt(resultView.getText().toString().length() - 1);
                    if (resultView.getText().toString() == "") {
                        operator = null;
                        resultView.setText(resultView.getText().toString() + "+");
                    } else if (op.contains(Character.toString(temp)) == true) {
                        showError();
                    } else if (operator != null) {
                        cal();
                        operator = "+";
                        resultView.setText(resultView.getText().toString() + "+");

                    } else {
                        operator = "+";
                        resultView.setText(resultView.getText().toString() + "+");
                    }

                }
            }
        });
        minusBtn=(Button) findViewById(R.id.minusButton);
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText().toString().length() == 0) {
                    operator = "-";
                    resultView.setText(resultView.getText().toString() + "-");
                } else {
                    char temp = resultView.getText().toString().charAt(resultView.getText().toString().length() - 1);
                    if (op.contains(Character.toString(temp)) == true) {
                        showError();
                    } else {
                        if (resultView.getText().toString() == "") {
                            operator = null;
                            resultView.setText(resultView.getText().toString() + "-");
                        } else {
                            if (operator != null) {
                                cal();
                                operator = "-";
                            } else {
                                operator = "-";
                            }
                            resultView.setText(resultView.getText().toString() + "-");
                        }
                    }
                }
            }
        });
        intoBtn=(Button) findViewById(R.id.intoButton);
        intoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText().toString().length() == 0) {
                    operator = null;
                    showError();
                } else {
                    char temp = resultView.getText().toString().charAt(resultView.getText().toString().length() - 1);
                    if (op.contains(Character.toString(temp)) == true) {
                        showError();
                    } else {
                        if (resultView.getText().toString() == "") {
                            showError();
                        } else {
                            if (operator != null) {
                                cal();
                                operator = "*";
                            } else {
                                operator = "*";
                            }
                            resultView.setText(resultView.getText().toString() + "*");
                        }
                    }
                }
            }
        });
        divBtn=(Button) findViewById(R.id.divButton);
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText().toString().length() == 0) {
                    operator = null;
                    showError();
                } else {
                    char temp = resultView.getText().toString().charAt(resultView.getText().toString().length() - 1);
                    if (op.contains(Character.toString(temp)) == true) {
                        showError();
                    } else {
                        if (resultView.getText().toString() == "") {
                            showError();
                        } else {
                            if (operator != null) {
                                cal();
                                operator = "/";
                            } else {
                                operator = "/";
                            }
                            resultView.setText(resultView.getText().toString() + "/");
                        }
                    }
                }
            }
        });
        btn1=(Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText( resultView.getText().toString()+"1");
            }
        });
        btn2=(Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText( resultView.getText().toString()+"2");
            }
        });
        btn3=(Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText( resultView.getText().toString()+"3");
            }
        });
        btn4=(Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText( resultView.getText().toString()+"4");
            }
        });
        btn5=(Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText( resultView.getText().toString()+"5");
            }
        });
        btn6=(Button) findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText( resultView.getText().toString()+"6");
            }
        });
        btn7=(Button) findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText( resultView.getText().toString()+"7");
            }
        });
        btn8=(Button) findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText( resultView.getText().toString()+"8");
            }
        });
        btn9=(Button) findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText( resultView.getText().toString()+"9");
            }
        });
        btn0=(Button) findViewById(R.id.button0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText( resultView.getText().toString()+"0");
            }
        });
        equalsBtn=(Button) findViewById(R.id.equalsButton);
        equalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultView.getText().toString().length() == 0) {
                    operator = null;
                    resultView.setText(resultView.getText().toString() + "");
                } else {
                    char temp = resultView.getText().toString().charAt(resultView.getText().toString().length() - 1);
                    if (op.contains(Character.toString(temp)) == true) {
                        showError();
                    } else {

                        if (operator != null) {
                            cal();
                            operator = null;
                        } else {
                            operator = null;
                        }
                    }
                }
            }
        });
        clr=(Button) findViewById(R.id.clearButton);
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText("");
                operator=null;
            }
        });




    }


}