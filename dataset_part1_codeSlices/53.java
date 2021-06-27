Triggering condition: no triggering condition description
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void reset() {
Display display = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
int screenWidth = display.getWidth();
int screenHeight = display.getHeight();
resetImage(screenWidth, screenHeight);
public void resetImage(int w, int h) {
if (mBackgroundBitmapFile.exists()) {
mBitmap = FileUtils.getBitmapAccuratelyScaledToDisplay(mBackgroundBitmapFile, w, h).copy(Bitmap.Config.ARGB_8888, true);
public static Bitmap getBitmapAccuratelyScaledToDisplay(File f, int screenHeight,int screenWidth) {
/**
The begin of a functional module: image resizing
**/
BitmapFactory.Options o = new BitmapFactory.Options();
o.inJustDecodeBounds = true;
BitmapFactory.decodeFile(f.getAbsolutePath(), o);//buggy code
BitmapFactory.Options options = new BitmapFactory.Options();
options.inInputShareable = true;
options.inPurgeable = true;
/**
The end of the  functional module: image resizing
**/
Bitmap bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(), options);//The functional module of image decoding          buggy code
/**
The begin of a functional module: image resizing
**/
double heightScale = ((double) (o.outHeight)) / screenHeight;
double widthScale = ((double) o.outWidth) / screenWidth;
double scale = Math.max(widthScale, heightScale);
double newHeight = Math.ceil(o.outHeight / scale);
double newWidth = Math.ceil(o.outWidth / scale);
/**
The end of the  functional module: image resizing
**/
bitmap = Bitmap.createScaledBitmap(bitmap, (int) newWidth, (int) newHeight, false);//The functional module of image decoding
return bitmap;
mCanvas = new Canvas(mBitmap);//The functional module of image displaying

Error description:line 27, inappropriate code implementation
