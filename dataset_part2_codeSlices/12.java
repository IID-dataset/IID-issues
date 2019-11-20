Triggering condition: not contain information about their triggering conditions
Consequence: bad user experience without further details for inspection

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public LabelWidget(Context context, FormEntryPrompt prompt)
XPathFuncExpr xpathFuncExpr = ExternalDataUtil.getSearchXPathExpression(prompt.getAppearanceHint())
if (xpathFuncExpr != null)
items = ExternalDataUtil.populateExternalChoices(prompt, xpathFuncExpr)
if (items != null)
for (int i = 0; i < items.size(); i++)
String imageURI
if (items.get(i) instanceof ExternalSelectChoice)
imageURI = ((ExternalSelectChoice) items.get(i)).getImage()
ImageView imageView = null
if (imageURI != null)
String imageFilename =ReferenceManager.instance().DeriveReference(imageURI).getLocalURI()
final File imageFile = new File(imageFilename)
if (imageFile.exists())
Bitmap b = null
DisplayMetrics metrics = context.getResources().getDisplayMetrics()
int screenWidth = metrics.widthPixels
int screenHeight = metrics.heightPixels
b = FileUtils.getBitmapScaledToDisplay(imageFile, screenHeight, screenWidth)
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
bitmap = BitmapFactory.decodeFile(path, originalOptions)//image decoding
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
bitmap = BitmapFactory.decodeFile(path, originalOptions)//image decoding
return bitmap
return b
/**
The end of the functional module: image resizing+decoding
**/
if (b != null)
imageView = new ImageView(getContext())
imageView.setImageBitmap(b)//The functional module: image displaying


						
						
