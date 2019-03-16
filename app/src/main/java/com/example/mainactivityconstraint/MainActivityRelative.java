package com.example.mainactivityconstraint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivityRelative extends AppCompatActivity {

    ImageView imageViewRelative;
    TextView textViewRelative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relative);

        imageViewRelative = findViewById(R.id.imgVwRel);
        textViewRelative = findViewById(R.id.txtVwRel);
    }

    public void fnChangeRelative(View view)
    {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imageViewRelative.getLayoutParams();
        params.addRule(RelativeLayout.BELOW, R.id.txtVwRel);
        imageViewRelative.setLayoutParams(params);

        RelativeLayout.LayoutParams paramstxtVm = (RelativeLayout.LayoutParams) textViewRelative.getLayoutParams();
        paramstxtVm.addRule(RelativeLayout.BELOW, R.id.btnRel);
        textViewRelative.setLayoutParams(paramstxtVm);
        textViewRelative.setText("Relative Layout Changed");

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
