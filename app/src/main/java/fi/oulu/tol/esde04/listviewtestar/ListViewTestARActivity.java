package fi.oulu.tol.esde04.listviewtestar;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class ListViewTestARActivity extends ActionBarActivity   {
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test_ar);

        String extraPrefix=getIntent().getStringExtra(EXTRA_PREFIX);
        final String prefix=extraPrefix!=null?extraPrefix:"Rivistö ";

        ListView listView = (ListView)findViewById(R.id.listView);
       TestListAdapter testListAdapter = new TestListAdapter("Null");//Tässä voi lukea Rivi tai ei mitään (Null). Pitää kuitenkin olla hipsut
       // listView.setAdapter(testListAdapter);
       listView.setAdapter(new TestListAdapter(prefix));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
               @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                 //Toast näyttää näkyy pop-up ikkunan - "turha", voi vaikka kommentoida pois, EI näytä rivihierarkiaa
                Toast.makeText(ListViewTestARActivity.this, "Row "+position+"selected", Toast.LENGTH_SHORT).show();

                   Intent intent=new Intent(ListViewTestARActivity.this,ListViewTestARActivity.class);
                   intent.putExtra(EXTRA_PREFIX,prefix + position + ":");
                   startActivity(intent);
        }
    });
    }
      @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view_test_ar, menu);
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
    public static final String EXTRA_PREFIX="fi.oulu.tol.esde.listviewtest.EXTRA_PREFIX";
}
