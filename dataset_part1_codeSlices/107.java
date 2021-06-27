Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public Object instantiateItem(ViewGroup container, int position) {
TouchImageView imgDisplay;
LayoutInflater inflater = (LayoutInflater) _activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
View viewLayout = inflater.inflate(R.layout.layout_fullscreen_image, container,false);
imgDisplay = (TouchImageView) viewLayout.findViewById(R.id.imgDisplay);
/**
The begin of a functional module: image resizing
The functional module contains the error          non-adaptive image resizing
**/
BitmapFactory.Options options = new BitmapFactory.Options();
options.inJustDecodeBounds = true;
String imagePath = _imagePaths.get(position);
BitmapFactory.decodeFile(imagePath, options);
int maxSize=Math.max(options.outHeight,options.outWidth);
if (maxTexture>0 && maxSize>maxTexture) {
double scale=(double)maxSize/(double)maxTexture;
options.inSampleSize = (int) Math.pow( 2, (Math.floor(Log(scale, 2))+1) );
options.inJustDecodeBounds = false;
options.inPreferredConfig = Bitmap.Config.ARGB_8888;
/**
The end of the functional module: image resizing
**/
Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options);//The functional module of image decoding
imgDisplay.setImageBitmap(bitmap);//The functional module of image displaying

Error description:line 15-24, inappropriate code implementation  
