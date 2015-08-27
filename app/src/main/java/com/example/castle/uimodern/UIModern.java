package com.example.castle.uimodern;

/**
 * Created by Castle on 23-08-2015.
 */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

public class UIModern extends AppCompatActivity{
    public static SeekBar seekBar;

    public static TextView txtView1;
    public static TextView txtView2;
    public static TextView txtView3;
    public static TextView txtView4;
    public static TextView txtView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_modern);
        seekBar = (SeekBar) findViewById(R.id.colour_seekbar);
        txtView1 = (TextView) findViewById(R.id.textViewCol1);
        txtView2 = (TextView) findViewById(R.id.textViewCol2);
        txtView3 = (TextView) findViewById(R.id.textViewCol3);
        //txtView4 = (TextView) findViewById(R.id.textViewCol4);
        txtView5 = (TextView) findViewById(R.id.textViewCol5);
        float[] hsvColor1 = {0, 1, 1};
        float[] hsvColor2 = {0, 1, 1};
        float[] hsvColor3 = {0, 1, 1};
        //float[] hsvColor4 = {0, 1, 1};
        float[] hsvColor5 = {0, 1, 1};
        hsvColor1[0] = 0f + 100f * seekBar.getProgress()/seekBar.getMax() ;
        hsvColor2[0] = 50f + 100f * seekBar.getProgress()/seekBar.getMax() ;
        hsvColor3[0] = 100f + 100f * seekBar.getProgress()/seekBar.getMax() ;
        //hsvColor4[0] = 150f + 100f * seekBar.getProgress()/seekBar.getMax() ;
        hsvColor5[0] = 200f + 100f * seekBar.getProgress()/seekBar.getMax() ;
        txtView1.setBackgroundColor(Color.HSVToColor(hsvColor1));
        txtView2.setBackgroundColor(Color.HSVToColor(hsvColor2));
        txtView3.setBackgroundColor(Color.HSVToColor(hsvColor3));
        //txtView4.setBackgroundColor(Color.HSVToColor(hsvColor4));
        txtView5.setBackgroundColor(Color.HSVToColor(hsvColor5));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                /*float[] hsvColor1 = {0, 1, 1};
                hsvColor1[0] = 100f + 250f * progress / seekBar.getMax();
                txtView1.setBackgroundColor(Color.HSVToColor(hsvColor1));*/
                float[] hsvColor1 = {0, 1, 1};
                float[] hsvColor2 = {0, 1, 1};
                float[] hsvColor3 = {0, 1, 1};
                //float[] hsvColor4 = {0, 1, 1};
                float[] hsvColor5 = {0, 1, 1};
                hsvColor1[0] = 0f + 100f * seekBar.getProgress()/seekBar.getMax() ;
                hsvColor2[0] = 50f + 100f * seekBar.getProgress()/seekBar.getMax() ;
                hsvColor3[0] = 100f + 100f * seekBar.getProgress()/seekBar.getMax() ;
                //hsvColor4[0] = 150f + 100f * seekBar.getProgress()/seekBar.getMax() ;
                hsvColor5[0] = 200f + 100f * seekBar.getProgress()/seekBar.getMax() ;
                txtView1.setBackgroundColor(Color.HSVToColor(hsvColor1));
                txtView2.setBackgroundColor(Color.HSVToColor(hsvColor2));
                txtView3.setBackgroundColor(Color.HSVToColor(hsvColor3));
                //txtView4.setBackgroundColor(Color.HSVToColor(hsvColor4));
                txtView5.setBackgroundColor(Color.HSVToColor(hsvColor5));


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "More Information");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case Menu.FIRST:
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Do you want to vist moma.org?");
                //dlgAlert.setTitle("App Title");

                dlgAlert.setNegativeButton("Not Now",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                dlgAlert.setPositiveButton("Visit MOMA",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org"));
                                startActivity(browserIntent);
                            }
                        });
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
