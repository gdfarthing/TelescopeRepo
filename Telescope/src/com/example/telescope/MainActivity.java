package com.example.telescope;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener
{
    private Spinner spinObjType, spinObj;
    private String objectSelected = "no object selected";
    public boolean firstTime = true;
    public int count = 1;
    public ImageView image;
    /** Called when the activity is first created. */
    @SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
    	 
    	 //LinearLayout layout=(LinearLayout)findViewById(R.id.topView);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Resources res = getResources(); //resource handle
        //Drawable drawable = res.getDrawable(R.drawable.mercury); //new Image that was added to the res folder
    	//LinearLayout linearLayout =   (LinearLayout)findViewById(R.id.topView); 
    	//linearLayout.setBackgroundDrawable(drawable);
        spinObjType = (Spinner)findViewById(R.id.objectTypeSpin);
        spinObj = (Spinner)findViewById(R.id.objSpin);

        String[] objTypes = getResources().getStringArray(R.array.objTypeArray);
        ArrayAdapter<String> objTypeAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,objTypes);
        objTypeAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinObjType.setAdapter(objTypeAdapter);
        
        String[] planets = getResources().getStringArray(R.array.planetsArray);
        String[] messier = getResources().getStringArray(R.array.messierArray);
        String[] stars   = {"sun", "alpha proxima", "polaris", "betelguese"};
        String[] other   = {"pluto", "ceres", "center of milky way"};
        final ArrayAdapter<String> objAdapterPlanets = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,planets);
        final ArrayAdapter<String> objAdapterMessier = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,messier);
        final ArrayAdapter<String> objAdapterStars = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,stars);
        final ArrayAdapter<String> objAdapterOther = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,other);
        
        objAdapterPlanets.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        objAdapterMessier.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        objAdapterStars.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        objAdapterOther.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        
        spinObj.setAdapter(objAdapterPlanets);
        

        spinObjType.setOnItemSelectedListener(new OnItemSelectedListener(){           
            //@SuppressLint("NewApi")
			@Override
            public void onItemSelected(AdapterView<?> arg0, View view1, int pos, long id){
            	//String value = spinObjType.getItemAtPosition(pos).toString();
            	String stringObjectType = (String) spinObjType.getSelectedItem();
            	Toast.makeText(getApplicationContext(),stringObjectType,Toast.LENGTH_SHORT).show();
            	if(stringObjectType.equals("Messier")) spinObj.setAdapter(objAdapterMessier);
            	else if(stringObjectType.equals("Stars")) spinObj.setAdapter(objAdapterStars);
            	else if(stringObjectType.equals("Planets")) spinObj.setAdapter(objAdapterPlanets);
            	else if(stringObjectType.equals("Other")) spinObj.setAdapter(objAdapterOther);
            	
            	objectSelected = (String) spinObj.getSelectedItem();
            	//Toast.makeText(getApplicationContext(),objectSelected,Toast.LENGTH_SHORT).show();
            }       

            @Override
            public void onNothingSelected(AdapterView<?> arg1)
            {
                Log.i("AAA","Nothing S0");

            }
        });

       spinObj.setOnItemSelectedListener(new OnItemSelectedListener()
       {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view1, int pos, long id) {
            	objectSelected = (String) spinObj.getSelectedItem();
            	String s = Integer.toString(count);
            	Toast.makeText(getApplicationContext(),objectSelected,Toast.LENGTH_SHORT).show();
            	Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            	changePic();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {
                Log.i("AAA","Nothing S1");              
            }

        }); 

      

    }// end onCreate()

    
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
        case R.id.calibrateBtn:
        	
            break;

        case R.id.slewBtn:
            finish();
            break;

        default:
            break;
        }       
    } //end onClick()  
    
    
    public void setActivityBackgroundImage(String imageToShow) {
        View view = this.getWindow().getDecorView();
        
    }
    
    @SuppressWarnings("deprecation")
	public void changePic(){
    	String stringObjectType = (String) spinObjType.getSelectedItem();
    	Resources res = getResources(); //resource handle
        Drawable drawable;
        String[] messier = getResources().getStringArray(R.array.messierArray);
        String[] planets = getResources().getStringArray(R.array.planetsArray);
        if(stringObjectType.equals("Planets")){
        	if(objectSelected.equals("None Selected")) {
        		drawable= res.getDrawable(R.drawable.mercury);
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.earthrise);
        	}
        	if(objectSelected.equals("Mercury")) {
        		drawable= res.getDrawable(R.drawable.mercury);
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.mercury);
        	}
        	else if(objectSelected.equals("Venus")) {
        		drawable= res.getDrawable(R.drawable.mercury);
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.venus);
        	}
        	else if(objectSelected.equals("Mars")) {
        		drawable= res.getDrawable(R.drawable.mercury);
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.mars);
        	}
        	else if(objectSelected.equals("Jupiter")) {
        		drawable= res.getDrawable(R.drawable.mercury);
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.venus);
        	}else if(objectSelected.equals("Saturn")) {
        		drawable= res.getDrawable(R.drawable.mercury);
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.saturn);
        	}else if(objectSelected.equals("Uranus")) {
        		drawable= res.getDrawable(R.drawable.mercury);
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.uranus);
        	}else if(objectSelected.equals("Neptune")) {
        		//drawable= res.getDrawable(R.drawable.mercury);
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.neptune);
        	}
        }else if(stringObjectType.equals("Messier")){
        	if(objectSelected.equals(messier[0])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m1);
        	}else if(objectSelected.equals(messier[1])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m2);
        	}else if(objectSelected.equals(messier[2])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m3);
        	}else if(objectSelected.equals(messier[3])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m4);
        	}else if(objectSelected.equals(messier[4])) {
        		drawable= res.getDrawable(R.drawable.m5);
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m5);
        	}else if(objectSelected.equals(messier[5])) {
        		drawable= res.getDrawable(R.drawable.m6);
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m6);
        	}else if(objectSelected.equals(messier[6])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m7);
        	}else if(objectSelected.equals(messier[7])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m8);
        	}else if(objectSelected.equals(messier[8])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m9);
        	}else if(objectSelected.equals(messier[9])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m10);
        	}else if(objectSelected.equals(messier[10])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m11);
        	}else if(objectSelected.equals(messier[11])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m12);
        	}else if(objectSelected.equals(messier[12])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m13);
        	}else if(objectSelected.equals(messier[13])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m14);
        	}else if(objectSelected.equals(messier[14])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m15);
        	}else if(objectSelected.equals(messier[15])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m16);
        	}else if(objectSelected.equals(messier[16])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m17);
        	}else if(objectSelected.equals(messier[17])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m18);
        	}else if(objectSelected.equals(messier[18])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m19);
        	}else if(objectSelected.equals(messier[19])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m20);
        	}else if(objectSelected.equals(messier[30])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m31);
        	}else if(objectSelected.equals(messier[32])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m33);
        	}else if(objectSelected.equals(messier[41])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m42);
        	}else if(objectSelected.equals(messier[44])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m45);
        	}else if(objectSelected.equals(messier[56])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m57);
        	}else if(objectSelected.equals(messier[99])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m100);
        	}else if(objectSelected.equals(messier[100])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m101);
        	}else if(objectSelected.equals(messier[101])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m102);
        	}else if(objectSelected.equals(messier[103])) {
        		image = (ImageView) findViewById(R.id.imgView);
        		image.setImageResource(R.drawable.m104);
        	}
        	
        	
        }
        
    }// end changePic()

} //end MainActivity




























