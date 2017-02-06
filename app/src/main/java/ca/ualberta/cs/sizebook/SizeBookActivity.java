package ca.ualberta.cs.sizebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SizeBookActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private TextView personCountText;
	private ListView oldPersonList;

	public static ArrayList<Person> personList;
	private ArrayAdapter<Person> adapter;

	private int personCount = 0;
	private int personIndex = 0;

	public Person person;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);



		personCountText = (TextView) findViewById(R.id.PersonCountText);
		personCountText.setText("People: " + String.valueOf(personCount));

		Button newPersonButton = (Button) findViewById(R.id.newPerson);

		oldPersonList = (ListView) findViewById(R.id.oldPersonListView);

		oldPersonList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
				setResult(RESULT_OK);
				personIndex = position;

				Intent intent = new Intent(SizeBookActivity.this, EditPersonActivity.class); //Should this be at the beginning of the function?
				intent.putExtra("personIndex", String.valueOf(personIndex));
				startActivityForResult(intent, 1);

				adapter.notifyDataSetChanged();


			}
		});

		oldPersonList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
				setResult(RESULT_OK);
				personIndex = position;

				personList.remove(personIndex);
				personCount--;

				personCountText.setText("People: " + String.valueOf(personCount));

				adapter.notifyDataSetChanged();

				Context context = getApplicationContext();
				String text = "Person Deleted";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();

				saveInFile();

				return true;
			}
		});

		newPersonButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);

				Intent intent = new Intent(SizeBookActivity.this, newPersonActivity.class); //Should this be at the beginning of the function?

				startActivityForResult(intent, 0);

				adapter.notifyDataSetChanged();
			}
		});
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 0) {
			if(resultCode == RESULT_OK){
				person = new Person();

				person.setPersonName(data.getStringExtra("name"));
				person.setDateInput(data.getStringExtra("date"));
				person.setNeckCircumference(data.getStringExtra("neck"));
				person.setBustCircumference(data.getStringExtra("bust"));
				person.setChestCircumference(data.getStringExtra("chest"));
				person.setWaistCircumference(data.getStringExtra("waist"));
				person.setHipCircumference(data.getStringExtra("hip"));
				person.setInseamLength(data.getStringExtra("inseam"));
				person.setPersonComment(data.getStringExtra("comment"));

				personList.add(person);
				personCount++;

				personCountText.setText("People: " + String.valueOf(personCount));

				saveInFile();
			}
		}

		if (requestCode == 1){
			if (resultCode == RESULT_OK) {

				personList.get(personIndex).setPersonName(data.getStringExtra("name"));
				personList.get(personIndex).setDateInput(data.getStringExtra("date"));
				personList.get(personIndex).setNeckCircumference(data.getStringExtra("neck"));
				personList.get(personIndex).setBustCircumference(data.getStringExtra("bust"));
				personList.get(personIndex).setChestCircumference(data.getStringExtra("chest"));
				personList.get(personIndex).setWaistCircumference(data.getStringExtra("waist"));
				personList.get(personIndex).setHipCircumference(data.getStringExtra("hip"));
				personList.get(personIndex).setInseamLength(data.getStringExtra("inseam"));
				personList.get(personIndex).setPersonComment(data.getStringExtra("comment"));
				saveInFile();
			}
		}
	}




	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		loadFromFile();

		adapter = new ArrayAdapter<Person>(this,
				R.layout.list_item, personList);
		oldPersonList.setAdapter(adapter);

		adapter.notifyDataSetChanged();

		personCount = oldPersonList.getCount();
		personCountText.setText("People: " + String.valueOf(personCount));
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			// Taken from
			personList = gson.fromJson(in, new TypeToken<ArrayList<Person>>(){}.getType());

			fis.close();
		} catch (FileNotFoundException e) {

			personList = new ArrayList<Person>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(personList, out);

			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}