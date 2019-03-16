package com.example.mainactivityconstraint;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;

import android.widget.TextView;

public class MainActivityFrame extends AppCompatActivity {

    ImageView imgVwFrm;
    TextView txtVwFrm;
    EditText edtTxtFrm;
    Button btnFrm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frame);

        imgVwFrm = findViewById(R.id.imgVwFrm);
        txtVwFrm = findViewById(R.id.txtVwFrm);
        edtTxtFrm = findViewById(R.id.edtTxtFrm);
        btnFrm = findViewById(R.id.btnFrm);
    }

    public void fnChangeFrame(View view)
    {
        String strName = edtTxtFrm.getText().toString();

        if(strName.equalsIgnoreCase("Camera"))
        {
            Runnable run = new Runnable()
            {
                public void run()
                {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,0);

                    runOnUiThread(new Runnable(){

                        public void run()
                        {
                            txtVwFrm.setText("Your Pic");
                        }
                    });
                }
            };

            Thread thread1 =new Thread(run);
            thread1.start();
        }
        else
        {
            edtTxtFrm.setError("Please key in the right term");
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        imgVwFrm.setImageBitmap(bp);
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
