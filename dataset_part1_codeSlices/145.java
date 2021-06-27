Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onCreate(Bundle savedInstanceState)
if (!mHasBackground){
findViewById(R.id.llRoot).setBackgroundResource(R.drawable.csbackground);//The functional module of image decoding+displaying      buggy code

Error description:line 8, inappropriate code implementation