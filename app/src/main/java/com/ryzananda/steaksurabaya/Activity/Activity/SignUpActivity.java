package com.ryzananda.steaksurabaya.Activity.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.ryzananda.steaksurabaya.Activity.Fragment.AppController;
import com.ryzananda.steaksurabaya.Activity.Network.Server;
import com.ryzananda.steaksurabaya.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    ProgressDialog pDialog;
    Button btn_dftr;
    EditText edt_username, edt_alamat, edt_tlvn, edt_tgl, edt_password,edt_email;
    //Intent intent;

    int success;
    ConnectivityManager conMgr;

    private static final String url = Server.URL + "index.php/api/register";

    private static final String TAG = SignUpActivity.class.getSimpleName();

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    String tag_json_obj = "json_obj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (conMgr.getActiveNetworkInfo() != null
                    && conMgr.getActiveNetworkInfo().isAvailable()
                    && conMgr.getActiveNetworkInfo().isConnected()) {
            } else {
                Toast.makeText(getApplicationContext(), "No Internet Connection",
                        Toast.LENGTH_LONG).show();
            }
        }

        edt_username= findViewById(R.id.edt_username);
        edt_alamat=findViewById(R.id.edt_alamat);
        edt_password=findViewById(R.id.edt_password);
        edt_tlvn=findViewById(R.id.edt_tlvn);
        edt_tgl=findViewById(R.id.edt_tgl);
        edt_email=findViewById(R.id.edt_email);
        btn_dftr=findViewById(R.id.btn_dftr);

        btn_dftr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String username = edt_username.getText().toString();
                String alamat = edt_alamat.getText().toString();
                String hp = edt_tlvn.getText().toString();
                String tgl_lahir = edt_tgl.getText().toString();
                String password = edt_password.getText().toString();
                String email = edt_email.getText().toString();

                if (conMgr.getActiveNetworkInfo() != null
                        && conMgr.getActiveNetworkInfo().isAvailable()
                        && conMgr.getActiveNetworkInfo().isConnected()) {
                    checkRegister(username, alamat, hp, tgl_lahir, password, email);
                } else {
                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void checkRegister(final String username, final String alamat, final String hp, final String tgl_lahir, final String password, final String email) {
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Register ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Register Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);

                    // Check for error node in json
                    if (success == 1) {

                        Log.e("Successfully Register!", jObj.toString());

                        Toast.makeText(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                        edt_username.setText("");
                        edt_alamat.setText("");
                        edt_tlvn.setText("");
                        edt_tgl.setText("");
                        edt_password.setText("");
                        edt_email.setText("");

                    } else {
                        Toast.makeText(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

                hideDialog();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("alamat", alamat);
                params.put("handphone", hp);
                params.put("tgl_lahir", tgl_lahir);
                params.put("password", password);
                params.put("email", email);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }


}
