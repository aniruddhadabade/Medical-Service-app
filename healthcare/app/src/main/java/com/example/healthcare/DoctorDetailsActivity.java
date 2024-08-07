package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Ajit Kulkarni", "Hospital Address : Andheri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Goregaon", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Malad", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Dadar", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Vile-parle", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Neelam Parab", "Hospital Address : Thane", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Swati joshi", "Hospital Address : Mulund", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Neeraja patel", "Hospital Address : Jogeshwari", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Mayuri Raorane", "Hospital Address : Khar", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Minakshi Pal", "Hospital Address : Vile-parle", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Seema Patil", "Hospital Address : Sion", "Exp : 4yrs", "Mobile No:9898989898", "200"},
                    {"Doctor Name : Pnkaj sutar", "Hospital Address : matunga", "Exp : 5yrs", "Mobile No:7898989898", "300"},
                    {"Doctor Name : Monish Jain", "Hospital Address : Dadar", "Exp : 7yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Vishal Gurav", "Hospital Address : Mahim", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Abhiyash Bait", "Hospital Address : Jogeshwari", "Exp : 7yrs", "Mobile No:7798989898", "600"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Amol Gawade", "Hospital Address : Nalasopara", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Prasad Patil", "Hospital Address : virar", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Nilesh mane", "Hospital Address : Bhyndar", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Deepak Deshmukh", "Hospital Address : Boriwali", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Ashok patel", "Hospital Address : Kandiwali", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Sunit Chavhan", "Hospital Address : Sakinaka", "Exp : 5yrs", "Mobile No:9898989898", "1600"},
                    {"Doctor Name : Aniruddha Dabade", "Hospital Address : Goregaon", "Exp : 15yrs", "Mobile No:7898989898", "1900"},
                    {"Doctor Name : Swapnil Lele", "Hospital Address : Thane", "Exp : 8yrs", "Mobile No:8898989898", "1300"},
                    {"Doctor Name : Swara gurav", "Hospital Address : Malad", "Exp : 6yrs", "Mobile No:9898000000", "1500"},
                    {"Doctor Name : Ankul pandye", "Hospital Address : Bandra", "Exp : 7yrs", "Mobile No:7798989898", "1800"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonBMCartBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add( item );
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}