package mans.abdullah.abdullah_mansour.math;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SquareActivity extends AppCompatActivity {
    EditText x_field;
    RadioButton area_rb,perimeter_rb;
    TextView result_txt;
    Button result_btn,new_operation_btn;

    double result,x;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        x_field = (EditText) findViewById(R.id.x_field);
        area_rb = (RadioButton) findViewById(R.id.area_rb);
        perimeter_rb = (RadioButton) findViewById(R.id.perimeter_rb);
        result_txt = (TextView) findViewById(R.id.result_txt);
        result_btn = (Button) findViewById(R.id.result_btn);
        new_operation_btn = (Button) findViewById(R.id.new_operation_btn);

        area_rb.setEnabled(false);
        perimeter_rb.setEnabled(false);
        new_operation_btn.setEnabled(false);
        new_operation_btn.setBackground(getResources().getDrawable(R.drawable.back2));

        result_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String currentX = x_field.getText().toString().trim();

                if (currentX.length() == 0)
                {
                    Toast.makeText(SquareActivity.this, "please enter X value", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                        if (area_rb.isChecked())
                        {
                            x = Double.parseDouble(currentX);

                            result = x * x;
                            result_txt.setText(result + "");

                            result_btn.setEnabled(false);
                            result_btn.setBackground(getResources().getDrawable(R.drawable.back2));

                            new_operation_btn.setEnabled(true);
                            new_operation_btn.setBackground(getResources().getDrawable(R.drawable.background));
                        } else
                        {
                            if (perimeter_rb.isChecked())
                            {
                                x = Double.parseDouble(currentX);

                                result = x * 4;
                                result_txt.setText(result + "");

                                result_btn.setEnabled(false);
                                result_btn.setBackground(getResources().getDrawable(R.drawable.back2));

                                new_operation_btn.setEnabled(true);
                                new_operation_btn.setBackground(getResources().getDrawable(R.drawable.background));
                            }
                            else
                                {
                                    Toast.makeText(SquareActivity.this, "please choose between area and perimeter", Toast.LENGTH_SHORT).show();
                                }
                        }
                    }
            }
        });

        new_operation_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = 0;

                result_txt.setText("");
                x_field.setText("");

                area_rb.setEnabled(false);
                perimeter_rb.setEnabled(false);

                new_operation_btn.setEnabled(false);
                new_operation_btn.setBackground(getResources().getDrawable(R.drawable.back2));

                result_btn.setEnabled(true);
                result_btn.setBackground(getResources().getDrawable(R.drawable.background));
            }
        });

        x_field.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                result_txt.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                area_rb.setEnabled(true);
                perimeter_rb.setEnabled(true);
            }
        });
    }
}
