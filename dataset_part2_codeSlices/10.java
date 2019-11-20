Triggering condition: not contain information about their triggering conditions
Consequence: bad user experience without further details for inspection

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public GridMultiWidget(Context context, FormEntryPrompt prompt, int numColumns)
for (int i = 0; i < items.size(); i++)
SelectChoice sc = items.get(i)
int curHeight = -1
String imageURI
if (items.get(i) instanceof ExternalSelectChoice)
imageURI = ((ExternalSelectChoice) sc).getImage()
if (imageURI != null)
choices[i] = imageURI
String imageFilename
imageFilename = ReferenceManager.instance().DeriveReference(imageURI).getLocalURI()
final File imageFile = new File(imageFilename)
if (imageFile.exists()) 
Bitmap b = FileUtils.getBitmapScaledToDisplay(imageFile, screenHeight, screenWidth)
/**
The begin of a functional module: image resizing+decoding
**/
public static Bitmap getBitmapScaledToDisplay(File f, int screenHeight, int screenWidth)
BitmapFactory.Options o = new BitmapFactory.Options()
o.inJustDecodeBounds = true
getBitmap(f.getAbsolutePath(), o)
public static Bitmap getBitmap(String path, BitmapFactory.Options originalOptions)
BitmapFactory.Options newOptions = new BitmapFactory.Options()
newOptions.inSampleSize = originalOptions.inSampleSize;
if (newOptions.inSampleSize <= 0)
newOptions.inSampleSize = 1
Bitmap bitmap
bitmap = BitmapFactory.decodeFile(path, originalOptions)
return bitmap
int heightScale = o.outHeight / screenHeight
int widthScale = o.outWidth / screenWidth
int scale = Math.max(widthScale, heightScale)
BitmapFactory.Options options = new BitmapFactory.Options()
options.inInputShareable = true
options.inPurgeable = true
options.inSampleSize = scale
Bitmap b = getBitmap(f.getAbsolutePath(), options)
public static Bitmap getBitmap(String path, BitmapFactory.Options originalOptions)
BitmapFactory.Options newOptions = new BitmapFactory.Options()
newOptions.inSampleSize = originalOptions.inSampleSize;
if (newOptions.inSampleSize <= 0)
newOptions.inSampleSize = 1
Bitmap bitmap
bitmap = BitmapFactory.decodeFile(path, originalOptions)
return bitmap
return b
/**
The end of the functional module: image resizing+decoding
**/		

/**
The begin of a functional module: image resizing+decoding+displaying
**/		
if (b != null) 
if (b.getWidth() > maxColumnWidth) 
maxColumnWidth = b.getWidth()
ImageView imageView = (ImageView) imageViews[i]
if (numColumns > 0)
int resizeHeight = (b.getHeight() * resizeWidth) / b.getWidth()
b = Bitmap.createScaledBitmap(b, resizeWidth, resizeHeight, false)
imageView.setImageBitmap(b)
/**
The end of the functional module: image resizing+decoding+displaying
**/							
						
			
						
			
						
						
						
						
						
						
						
						
						
						
						
						
						