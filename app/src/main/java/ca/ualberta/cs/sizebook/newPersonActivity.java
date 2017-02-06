package ca.ualberta.cs.sizebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * newPersonActivity is a class designed to handle gathering user input for
 * adding a new person.
 *
 * it performs by gathering information entered in EditTexts, and
 * then it sends the information back to SizeBookActivity
 * through Intents, where the information will be handled by SizeBookActivity.onActivityResult().
 */
public class newPersonActivity extends Activity{

    /**
     * Declaring EditText fields
     */
    private EditText personName;
    private EditText dateInput;
    private EditText neckCircumference;
    private EditText bustCircumference;
    private EditText chestCircumference;
    private EditText waistCircumference;
    private EditText hipCircumference;
    private EditText inseamLength;
    private EditText personComment;

    /**
     * onCreate will initialize values upon beginning the activity.
     * @param savedInstanceState
     */
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

        /**
         * Set a listener for the 'Save Person' button.
         * We declare an intent in order to send user input to the parent activity.
         *
         * intent.putExtra(...) adds data to the intent.
         */
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
