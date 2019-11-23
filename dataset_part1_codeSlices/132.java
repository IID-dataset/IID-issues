Triggering condition: no triggering condition description
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onCreate(Bundle savedInstanceState) {
AspectRatioImageView imageView = (AspectRatioImageView) findViewById(R.id.image);
Intent intent = getIntent();
if(intent!=null){
String path=intent.getStringExtra("path");
Glide.with(this).load(path).into(imageView);//The functional module of image decoding+displaying      buggy code
          