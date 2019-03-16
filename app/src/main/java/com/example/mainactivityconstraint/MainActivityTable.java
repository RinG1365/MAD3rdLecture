package com.example.mainactivityconstraint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityTable extends AppCompatActivity {

    Button btntab;
    TextView txtViewTab;
    EditText edtTxtTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_table);

        btntab = findViewById(R.id.btnTab);
        txtViewTab = findViewById(R.id.txtViewTab);
        edtTxtTab = findViewById(R.id.edtTxtTab);
    }

    public void fnChangeTxtView(View view)
    {
        String strEdtTxt = edtTxtTab.getText().toString();

        if(strEdtTxt.equalsIgnoreCase(""))
        {
         edtTxtTab.setError("Please fill in the blank");
        }
        else
            {
            txtViewTab.setText(edtTxtTab.getText().toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_layouts,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int idMenu = item.getItemId();
        Intent intent = null;
        if(idMenu == R.id.linear)
        {
            intent = new Intent(this,MainActivityLinear.class);
        }
        else if(idMenu == R.id.relative)
        {
            intent = new Intent(this,MainActivityRelative.class);
        }
        else if(idMenu == R.id.constraint)
        {
            intent = new Intent(this,MainActivityConstraints.class);
        }
        else if(idMenu == R.id.table)
        {
            intent = new Intent(this,MainActivityTable.class);
        }
        else if(idMenu == R.id.frame)
        {
            intent = new Intent(this,MainActivityFrame.class);
        }
        else if(idMenu == R.id.absolute)
        {
            intent = new Intent(this,MainActivityAbsolute.class);
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
