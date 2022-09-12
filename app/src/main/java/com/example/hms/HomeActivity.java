package com.example.hms;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.example.hms.Database.Loggedin;
import com.example.hms.Database.Users_DB;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.makeramen.roundedimageview.RoundedImageView;


public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Users_DB u =new Users_DB(this);
        Loggedin l = new Loggedin(this);
        User me = u.Get_info();
        final DrawerLayout drawerLayout = findViewById(R.id.drawerlayout);
        NavigationView navigationView = findViewById(R.id.NavigationView);
        View linearLayout=navigationView.inflateHeaderView(R.layout.layout_navigation_header);
        NavController navController = Navigation.findNavController(this ,R.id.nav_host_fragment_container);
        NavigationUI.setupWithNavController(navigationView,navController);
        final TextView texttitle = findViewById(R.id.textTitle);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                texttitle.setText(navDestination.getLabel());
            }
        });
        findViewById(R.id.imagemenu).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }});
        TextView name =  linearLayout.findViewById(R.id.loggedin_user);
        RoundedImageView logout = linearLayout.findViewById(R.id.log_out);
        name.setText(me.getFullname());

        TextInputEditText email= findViewById(R.id.email_editText);
        TextView Fullname = findViewById(R.id.full_name);
        EditText username = findViewById(R.id.profile_username);
        EditText Gender = findViewById(R.id.Profile_role);
        EditText password = findViewById(R.id.Profile_password);
        ImageView emailchange = findViewById(R.id.Email_change);
        ImageView Usernamechange = findViewById(R.id.UserName_change);
        ImageView passwordchange = findViewById(R.id.Password_change);
        Button submit = findViewById(R.id.submit);
        ImageView success1 = findViewById(R.id.o2);
        TextView  success2 = findViewById(R.id.o);

        ///////////////////////////////////////////////////////////////////////////
        password.setText(me.getPassword());
        Gender.setText(me.getGender());
        username.setText(me.getUsername());
        Fullname.setText(me.getFullname());
        email.setText(me.getEmail());
        emailchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email.setTextColor(Color.BLACK);
                email.setFocusableInTouchMode(true);
            }
        });
        Usernamechange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setTextColor(Color.BLACK);
                username.setFocusableInTouchMode(true);
            }
        });
        passwordchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password.setTextColor(Color.BLACK);

                password.setFocusableInTouchMode(true);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                u.Updatedata(Fullname.getText().toString(),username.getText().toString(),email.getText().toString(),password.getText().toString(),Gender.getText().toString());
                username.setFocusable(false);
                email.setFocusable(false);
                password.setFocusable(false);
                username.setTextColor(Color.GRAY);
                email.setTextColor(Color.GRAY);
                password.setTextColor(Color.GRAY);
                success1.setVisibility(View.VISIBLE);
                success2.setVisibility(View.VISIBLE);

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.cleardata();
                Intent i = new Intent(HomeActivity.this,loginACT.class);
                startActivity(i);
                finish();

            }
        });
    }

}