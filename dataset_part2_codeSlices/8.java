Triggering condition: not contain information about their triggering conditions
Consequence: bad user experience without further details for inspection

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void resetImage(int w, int h)
if (backgroundBitmapFile.exists())
bitmap = FileUtils.getBitmapAccuratelyScaledToDisplay(backgroundBitmapFile, h, w).copy(Bitmap.Config.ARGB_8888, true)//buggy code
public static Bitmap getBitmapAccuratelyScaledToDisplay(File f, int screenHeight, int screenWidth)
/**
The begin of a functional module: image resizing+decoding
**/
BitmapFactory.Options o = new BitmapFactory.Options()
o.inJustDecodeBounds = true
getBitmap(f.getAbsolutePath(), o)
public static Bitmap getBitmap(String path, BitmapFactory.Options originalOptions) 
BitmapFactory.Options newOptions = new BitmapFactory.Options()
newOptions.inSampleSize = originalOptions.inSampleSize
if (newOptions.inSampleSize <= 0)
newOptions.inSampleSize = 1
Bitmap bitmap
bitmap = BitmapFactory.decodeFile(path, originalOptions);
return bitmap
options.inInputShareable = true;
options.inPurgeable = true;
Bitmap bitmap = getBitmap(f.getAbsolutePath(), options)
public static Bitmap getBitmap(String path, BitmapFactory.Options originalOptions)
BitmapFactory.Options newOptions = new BitmapFactory.Options()
newOptions.inSampleSize = originalOptions.inSampleSize;
if (newOptions.inSampleSize <= 0)
newOptions.inSampleSize = 1
Bitmap bitmap
bitmap = BitmapFactory.decodeFile(path, originalOptions)
return bitmap
double heightScale = ((double) (o.outHeight)) / screenHeight
double widthScale = ((double) o.outWidth) / screenWidth
double scale = Math.max(widthScale, heightScale)
double newHeight = Math.ceil(o.outHeight / scale)
double newWidth = Math.ceil(o.outWidth / scale)
bitmap = Bitmap.createScaledBitmap(bitmap, (int) newWidth, (int) newHeight, false)
return bitmap
/**
The end of a functional module: image resizing+decoding
**/
canvas = new Canvas(bitmap) //The functional module of image displaying

Error description:line 8, inappropriate code implementation  					

						
						

						
				
						
						
						
						
						
						
						