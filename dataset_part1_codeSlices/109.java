Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public Object instantiateItem(ViewGroup container, int position) {
TouchImageView imgDisplay;
inflater = (LayoutInflater) _activity
imgDisplay = (TouchImageView) viewLayout.findViewById(R.id.imgDisplay);
BitmapFactory.Options options = new BitmapFactory.Options();
options.inPreferredConfig = Bitmap.Config.ARGB_8888;
Bitmap bitmap = BitmapFactory.decodeFile(_imagePaths.get(position), options);//The functional module of image decoding      buggy code
/**
The begin of a functional module: image resizing
**/
int origWidth=bitmap.getWidth();
int origHeight=bitmap.getHeight();
int maxSize=Math.max(origHeight,origWidth);
if (maxTexture>0 && maxSize>maxTexture) {
float scale=(float)maxSize/(float)maxTexture;
Bitmap origBitmap = bitmap;
bitmap = Bitmap.createScaledBitmap(origBitmap, (int)(origWidth/scale), (int)(origHeight/scale), true);//The functional module of image decoding
/**
The end of the functional module: image resizing
**/
imgDisplay.setImageBitmap(bitmap);//The functional module of image displaying


