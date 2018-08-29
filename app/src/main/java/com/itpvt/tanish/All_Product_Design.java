package com.itpvt.tanish;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.itpvt.tanish.Adapters.Recycler_Adapter_All_Products_new;
import com.itpvt.tanish.Pojo.Product_pojo;
import com.itpvt.tanish.Adapters.Recycler_Adapter_All_Products_new;
import com.itpvt.tanish.Pojo.Product_pojo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class All_Product_Design extends AppCompatActivity {

    ArrayList<Product_pojo> arraylist=new ArrayList<>();
    RecyclerView recyclerView;
    Recycler_Adapter_All_Products_new adapter;
    RecyclerView.LayoutManager layoutManager;
    private ProgressDialog loading;
    String id, Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.all_product_design);
        ImageView title=(ImageView)findViewById(R.id.title);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.prcv);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
   //     getSupportActionBar().setDisplayShowTitleEnabled(false);


        Intent intent =getIntent();
        id = intent.getStringExtra("id");
//        Title=intent.getStringExtra("title");
//
//        int resId = getResources().getIdentifier(Title, "drawable", getPackageName());
//        title.setBackgroundResource(resId);
       GetAllProducts();
    }
    public void GetAllProducts()
    {
        loading = ProgressDialog.show(All_Product_Design.this,"Loading...","Please wait...",false,false);
        StringRequest request = new StringRequest(Request.Method.POST, Config.URL_ALL_PRODUCTS, new com.android.volley.Response.Listener<String>()
        {

            @Override
            public void onResponse(String response) {
                try
                {
                   loading.dismiss();
                    JSONObject abc = new JSONObject(response);
                   int j=abc.length();
                    for(int i=j; i>= 1; i--)
                    {
                        String num = String.valueOf(i);
                        JSONObject data = abc.getJSONObject(num);
                        arraylist.add(new Product_pojo(data.getString("product_id"), data.getString("pro_name")
                                , data.getString("img_url"),data.getString("sku")
                                ,data.getString("product_quantity"),data.getString("price").replace(".0000","Rs")));

                    }
                  adapter = new Recycler_Adapter_All_Products_new(arraylist, All_Product_Design.this);
                    recyclerView.setAdapter(adapter);
                    //loading.dismiss();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(All_Product_Design.this,"Nothing is Available For Time Being", Toast.LENGTH_LONG).show();
                    loading.dismiss();
                    onBackPressed();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
              //   Log.e("Error",error.printStackTrace());
                Toast.makeText(All_Product_Design.this.getApplicationContext(), "Network Error" , Toast.LENGTH_SHORT).show();
                onBackPressed();

            }
        }
        ){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("category_id", id);
                return params;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(All_Product_Design.this.getApplicationContext());
        requestQueue.add(request);
    }
}