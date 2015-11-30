package carrillo.uriel.contactsselectionapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ContactPageActivity extends ActionBarActivity implements OnClickListener {

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
        contactPhone.setText("Phone:"+contactObject.getPhone());
        contactWebsite.setText("Website:"+contactObject.getWebsite());

        contactPhone.setOnClickListener(this);
        contactWebsite.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

}
