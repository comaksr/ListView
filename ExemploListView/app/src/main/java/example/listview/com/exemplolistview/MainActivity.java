package example.listview.com.exemplolistview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        listView = (ListView) findViewById(R.id.list);

        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();
    }
    private void createListView() {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ItemListView>();
        ItemListView item1 = new ItemListView("item1", R.drawable.k);
        ItemListView item2 = new ItemListView("item2", R.drawable.k);
        ItemListView item3 = new ItemListView("item3", R.drawable.k);
        ItemListView item4 = new ItemListView("item4", R.drawable.k);
        ItemListView item5 = new ItemListView("item5", R.drawable.k);
        ItemListView item6 = new ItemListView("item6", R.drawable.k);
        ItemListView item7 = new ItemListView("item7", R.drawable.k);
        ItemListView item8 = new ItemListView("item8", R.drawable.k);
        ItemListView item9 = new ItemListView("item9", R.drawable.k);
        ItemListView item10 = new ItemListView("item10", R.drawable.k);
        ItemListView item11 = new ItemListView("item11", R.drawable.k);
        ItemListView item12= new ItemListView("item12", R.drawable.k);
        ItemListView item13 = new ItemListView("item13", R.drawable.k);
        ItemListView item14 = new ItemListView("item14", R.drawable.k);
        ItemListView item15 = new ItemListView("item15", R.drawable.k);

        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);
        itens.add(item6);
        itens.add(item7);
        itens.add(item8);
        itens.add(item9);
        itens.add(item10);
        itens.add(item11);
        itens.add(item12);
        itens.add(item13);
        itens.add(item14);
        itens.add(item15);

        //Cria o adapter
        adapterListView = new AdapterListView(this, itens);

        //Define o Adapter
        listView.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View v, int position, long arg3) {
                //Pega o item que foi selecionado.
                ItemListView item = adapterListView.getItem(position);
                //Demonstração
                Toast.makeText(MainActivity.this, "Clique longo no: " + item.getTexto(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }


    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
        //Pega o item que foi selecionado.
        ItemListView item = adapterListView.getItem(position);
        //Demonstração
        Toast.makeText(this, "Clique simples no: " + item.getTexto(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
