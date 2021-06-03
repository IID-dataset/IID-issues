Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
/**
The begin of a functional module: image loading
**/
public void onActivityResult(int requestCode, int resultCode, Intent data)
File f = new File(mMediaCapturePath)
Uri capturedImageUri = Uri.fromFile(f)
if (!addMedia(capturedImageUri, null))
private boolean addMedia(Uri imageUri, SpannableStringBuilder ssb)
if (ssb != null && !MediaUtils.isInMediaStore(imageUri))
imageUri = MediaUtils.downloadExternalMedia(getActivity(), imageUri)
Bitmap thumbnailBitmap
String mediaTitle
if (imageUri.toString().contains("video") && !MediaUtils.isInMediaStore(imageUri))
ImageHelper ih = new ImageHelper()
thumbnailBitmap = ih.getThumbnailForWPImageSpan(getActivity(), imageUri.getEncodedPath())
public getThumbnailForWPImageSpan(Context ctx, String filePath)
Display display = ((Activity)ctx).getWindowManager().getDefaultDisplay()
int width = display.getWidth()
int height = display.getHeight()
if (width > height)
width = height
Uri curUri
if (!filePath.contains("content://"))
curUri = Uri.parse("content://media" + filePath)
if (filePath.contains("video"))
int[] dimensions = getImageSize(curUri, ctx)
float conversionFactor = 0.40f
if (dimensions[0] > dimensions[1])
conversionFactor = 0.60f
int resizedWidth = (int) (width * conversionFactor)
int rotation = getImageOrientation(ctx, filePath)
byte[] bytes = createThumbnailFromUri(ctx, curUri, resizedWidth, null, rotation)
public byte[] createThumbnailFromUri(..., Uri imageUri, int maxWidth,... ,int rotation)
String filePath = null
if (imageUri.toString().contains("content:")) 
String[] projection = new String[] { Images.Media.DATA }
Cursor cur = context.getContentResolver().query(imageUri, projection, null, null, null)
if (cur != null)
if (cur.moveToFirst())
int dataColumn = cur.getColumnIndex(Images.Media.DATA)
filePath = cur.getString(dataColumn)
BitmapFactory.Options optBounds = new BitmapFactory.Options()
optBounds.inJustDecodeBounds = true
BitmapFactory.decodeFile(filePath, optBounds)
int scale = 1
if (maxWidth > 0 && optBounds.outWidth > maxWidth) {
double d = Math.pow(2, (int) Math.round(Math.log(maxWidth / (double) optBounds.outWidth) / Math.log(0.5)))
scale = (int) d
BitmapFactory.Options optActual = new BitmapFactory.Options()
optActual.inSampleSize = scale
Bitmap bmpResized
bmpResized = BitmapFactory.decodeFile(filePath, optActual)
/**
The end of the functional module: image loading
**/

/**
The begin of a functional module: image disk caching
**/
ByteArrayOutputStream stream = new ByteArrayOutputStream()
final Bitmap.CompressFormat fmt
if (fileExtension != null && fileExtension.equalsIgnoreCase("png"))
fmt = Bitmap.CompressFormat.PNG
if (rotation != 0)
Matrix matrix = new Matrix()
matrix.setRotate(rotation)
final Bitmap bmpRotated = Bitmap.createBitmap(bmpResized, 0, 0, bmpResized.getWidth(), bmpResized.getHeight(), matrix, true)
bmpRotated.compress(fmt, 100, stream)
bmpResized.recycle()
bmpRotated.recycle()
/**
The end of the functional module: image disk caching
**/


Error description: line 52, inappropriate code implementation
	


