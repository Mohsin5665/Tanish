package com.itpvt.tanish;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    int[] img = {R.drawable.ab,R.drawable.cd,R.drawable.ef};
    ImageView imageView,imageView1,imageView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main_navigation);
        imageView = (ImageView)findViewById(R.id.lawn);
        imageView1 =(ImageView)findViewById(R.id.casual);
        imageView3 =(ImageView)findViewById(R.id.sami);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,All_Product_Design.class);
                intent.putExtra("id","68");
                intent.putExtra("title","lawn");
                startActivity(intent);
            }
        });


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,All_Product_Design.class);
                intent.putExtra("id","69");
                intent.putExtra("title","casual");
                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,All_Product_Design.class);
                intent.putExtra("id","70");
                intent.putExtra("title","sami");
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.Home)
        {

        } else if (id == R.id.Categories)
        {

        } else if (id == R.id.Cart)
        {

        } else if (id == R.id.Whatsapp)
        {
//            Uri uri  = Uri.parse("smsto:"+"+923000225587");
//            Intent intent =new Intent(Intent.ACTION_SENDTO,uri);
//            intent.setPackage("com.whatsapp");
//            startActivity(intent);

        } else if (id == R.id.Innovators)
        {
//            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://itpvt.net/"));
//            startActivity(myIntent);

        }else if (id == R.id.web) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
