package ca.ualberta.cs.sizebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newPersonActivity extends Activity{

    private EditText personName;
    private EditText dateInput;
    private EditText neckCircumference;
    private EditText bustCircumference;
    private EditText chestCircumference;
    private EditText waistCircumference;
    private EditText hipCircumference;
    private EditText inseamLength;
    private EditText personComment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_person);

        personName = (EditText) findViewById(R.id.PersonName);
        dateInput = (EditText) findViewById(R.id.DateInput);
        neckCircumference = (EditText) findViewById(R.id.NeckCircumference);
        bustCircumference = (EditText) findViewById(R.id.BustCircumference);
        chestCircumference = (EditText) findViewById(R.id.ChestCircumference);
        waistCircumference = (EditText) findViewById(R.id.WaistCircumference);
        hipCircumference = (EditText) findViewById(R.id.HipCircumference);
        inseamLength = (EditText) findViewById(R.id.InseamLength);
        personComment = (EditText) findViewById(R.id.PersonComment);

        Button savePerson = (Button) findViewById(R.id.SavePersonButton);

        savePerson.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent();

                if (!personName.getText().toString().trim().equals("")) {
                    intent.putExtra("name", personName.getText().toString());
                    intent.putExtra("date", dateInput.getText().toString());
                    intent.putExtra("neck", neckCircumference.getText().toString());
                    intent.putExtra("bust", bustCircumference.getText().toString());
                    intent.putExtra("chest", chestCircumference.getText().toString());
                    intent.putExtra("waist", waistCircumference.getText().toString());
                    intent.putExtra("hip", hipCircumference.getText().toString());
                    intent.putExtra("inseam", inseamLength.getText().toString());
                    intent.putExtra("comment", personComment.getText().toString());

                    setResult(RESULT_OK, intent);
                    finish();
                }

                else{
                    Context context = getApplicationContext();
                    CharSequence text = "You must enter a name before saving the person";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });



    }
}
