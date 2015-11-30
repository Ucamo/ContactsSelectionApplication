package carrillo.uriel.contactsselectionapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ContactPageActivity extends AppCompatActivity implements View.OnClickListener {

    private final int PHONE=0;
    private final int WEBSITE=1;
    private TextView contactName;
    private TextView contactPhone;
    private TextView contactWebsite;
    private ContactObject contactObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);

        contactName=(TextView) findViewById(R.id.contactName);
        contactPhone=(TextView) findViewById(R.id.contactPhone);
        contactWebsite=(TextView) findViewById(R.id.contactWebsite);

        Bundle extras= getIntent().getExtras();
        if(extras==null)
            return;
        contactObject=(ContactObject)getIntent().getSerializableExtra("Object");

        contactName.setText(contactObject.getName());
        contactPhone.setText("Phone:" + contactObject.getPhone());
        contactWebsite.setText("Website:" + contactObject.getWebsite());

        contactPhone.setOnClickListener(this);
        contactWebsite.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.contactPhone:
                Intent i = new Intent();
                i.putExtra("value",contactObject.getPhone());
                setResult(PHONE,i);
                finish();
                break;
            case R.id.contactWebsite:
                i=new Intent();
                i.putExtra("value",contactObject.getWebsite());
                setResult(WEBSITE,i);
                finish();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_intent, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
