package ca.ualberta.cs.sizebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static ca.ualberta.cs.sizebook.SizeBookActivity.adapter;
import static ca.ualberta.cs.sizebook.SizeBookActivity.personList;


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
                intent.putExtra("name", personName.getText().toString());

                setResult(RESULT_OK, intent);

                /*** Do Stuff Here ***/


                //adapter.notifyDataSetChanged();
                finish(); //Will close the newPersonActivity activity.
            }
        });



    }
}
