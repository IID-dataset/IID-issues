Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onCreate(@Nullable Bundle savedInstanceState) {
String uriString;
uriString = getIntent().getStringExtra(ARG_MEDIA_URI);
mMediaUri = Uri.parse(uriString);
mImageView.setImageURI(mMediaUri);//The functional module of image decoding+displaying       buggy code



















