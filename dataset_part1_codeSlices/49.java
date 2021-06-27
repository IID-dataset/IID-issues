Triggering condition: no triggering condition description
Consequence: abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------		 
public void onClick(View v) {
Reset();
public void reset() {
Display display = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
int screenWidth = display.getWidth();
int screenHeight = display.getHeight();
resetImage(screenWidth, screenHeight);
public void resetImage(int w, int h) {
mBitmap = FileUtils.getBitmapScaledToDisplay(mBackgroundBitmapFile, w, h).copy(Bitmap.Config.ARGB_8888, true);//buggy code
/**
The begin of a functional module: image resizing
**/
public static Bitmap getBitmapScaledToDisplay(File f, int screenHeight, int screenWidth) {
BitmapFactory.Options o = new BitmapFactory.Options();
o.inJustDecodeBounds = true;
BitmapFactory.decodeFile(f.getAbsolutePath(), o);
int heightScale = o.outHeight / screenHeight;
int widthScale = o.outWidth / screenWidth;
int scale = Math.max(widthScale, heightScale);
BitmapFactory.Options options = new BitmapFactory.Options();
options.inInputShareable = true;
options.inPurgeable = true;
options.inSampleSize = scale;
/**
The end of the functional module: image resizing
**/
Bitmap b = BitmapFactory.decodeFile(f.getAbsolutePath(), options);//The functional module of image decoding
return b;
mCanvas = new Canvas(mBitmap);//The functional module of image displaying

Error description:line 14, inappropriate code implementation

