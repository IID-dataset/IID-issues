Triggering condition: no triggering condition description
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void populateFromCursor(Context context, Cursor c) {
File previewFile = mContent.getPreviewFile();
Uri localUri = mContent.getLocalUri();
if (previewFile != null) {
loadPreview(previewFile);
if (localUri != null) {
MediaStorage.cacheThumbnail(context, localUri, previewFile, false);
loadPreview(previewFile);
/**
The begin of a functional module: image resizing
Error: this functional module should be located in a background thread
**/
private void loadPreview(File previewFile) throws IOException {
InputStream in = new FileInputStream(previewFile);
BitmapFactory.Options options = bitmapOptions();
private BitmapFactory.Options bitmapOptions() {
BitmapFactory.Options options = new BitmapFactory.Options();
options.inPreferredConfig = Bitmap.Config.RGB_565;
return options;
/**
The end of the functional module: image resizing
**/
mBitmap = BitmapFactory.decodeStream(in, null, options);//The functional module of image decoding
in.close();
mContent.setImageBitmap(bitmap);//The functional module of image displaying

