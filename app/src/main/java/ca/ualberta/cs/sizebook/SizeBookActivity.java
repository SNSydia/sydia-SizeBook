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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SizeBookActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldPersonList;

	public static ArrayList<Person> personList;
	public static ArrayAdapter<Person> adapter;

	public Person person;
	public String name;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);

		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		Button newPersonButton = (Button) findViewById(R.id.newPerson);

		oldPersonList = (ListView) findViewById(R.id.oldPersonListView);



		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);

				//String text = bodyText.getText().toString();
				person = new Person();
				personList.add(person);

				adapter.notifyDataSetChanged();

				saveInFile();
				//finish();
			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);

				personList.clear();
				adapter.notifyDataSetChanged();

				saveInFile();
			}
		});

		newPersonButton.setOnClickListener(new View.OnClickListener() {


			public void onClick(View v) {
				setResult(RESULT_OK);

				Intent intent = new Intent(SizeBookActivity.this, newPersonActivity.class); //Should this be at the beginning of the function?
				startActivityForResult(intent, 0);

				adapter.notifyDataSetChanged();

				saveInFile();
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
				//name = data.getStringExtra("name");
				personList.add(person);

				saveInFile(); // Very important to call. This is why it wasnt working.




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
	}

	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
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