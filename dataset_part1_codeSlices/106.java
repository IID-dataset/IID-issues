Triggering condition: handling a large image
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onClick(final View v) 
upload();
private void upload() 
doUpload();
private void doUpload() throws Exception
final UploadPhotoTask uploader = new UploadPhotoTask(this,filename,?);
uploader.execute();
UploadPhotoTask(final Context context,final String filename,?{
filename_ = smallImage_ ? Bitmaps.resizePhoto(filename) : filename;
/**
The begin of a functional module: image resizing
**/
static public String resizePhoto(final String fileName){
final BitmapFactory.Options options = bitmapBounds(fileName);
int srcWidth = options.outWidth;
final int desiredWidth = Math.min(320, srcWidth);//buggy code
int inSampleSize = 1;
while(srcWidth / 2 > desiredWidth) {
srcWidth /= 2;
inSampleSize *= 2;
float desiredScale = (float)desiredWidth/srcWidth;
options.inJustDecodeBounds = false;
options.inDither = false;
options.inSampleSize = inSampleSize;
options.inScaled = false;
options.inPreferredConfig = Bitmap.Config.ARGB_8888;
/**
The end of the functional module: image resizing
**/
Bitmap sampledSrcBitmap = BitmapFactory.decodeFile(fileName, options);//The functional module of image decoding
final Matrix matrix = new Matrix();
matrix.postScale(desiredScale, desiredScale);
Bitmap scaledBitmap = Bitmap.createBitmap(sampledSrcBitmap, 0, 0, sampledSrcBitmap.getWidth(), sampledSrcBitmap.getHeight(), matrix, true);//The functional module of image decoding
sampledSrcBitmap.recycle();//The functional module of image releasing
sampledSrcBitmap = null;
final String smallFileName = fileName + "-small";
final FileOutputStream out = new FileOutputStream(smallFileName);
scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);//The functional module of image disk caching
scaledBitmap.recycle();	//The functional module of image releasing
