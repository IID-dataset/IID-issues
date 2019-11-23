Triggering condition: handling a large image
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onSizingResult(double scale, int resultWidth, int resultHeight, Bitmap.CompressFormat format, int quality, boolean cancelled) {
finishProcessing(scale, resultWidth, resultHeight, format, quality);
private void finishProcessing(final double SCALE, int resultWidth, int resultHeight, final Bitmap.CompressFormat format, final int quality) {
final Bitmap result = Bitmap.createBitmap(resultWidth, resultHeight, Bitmap.Config.ARGB_8888);
final boolean horizontal = mStackHorizontally.isChecked();
final int[] imageSpacing = Prefs.imageSpacing(MainActivity.this);
final int SPACING_HORIZONTAL = (int) (imageSpacing[0] * SCALE);  // TODO should scale be multiplied here?
final int SPACING_VERTICAL = (int) (imageSpacing[1] * SCALE);
final Canvas resultCanvas = new Canvas(result);
final Paint paint = new Paint();
paint.setAntiAlias(true);
new Thread(new Runnable() {
public void run() {
final Rect dstRect = new Rect(0, 0, 10, 10);
if (horizontal) {
int currentX = 0;
mTraverseIndex = -1;
Bitmap bm;
private Bitmap getNextBitmap() {
mTraverseIndex++;
Photo nextPhoto = mSelectedPhotos[mTraverseIndex];
InputStream is = null;
Bitmap bm = null;
is = Util.openStream(this, nextPhoto.getUri());
bm = BitmapFactory.decodeStream(is);//The functional module of image decoding            buggy code
return bm;
while ((bm = getNextBitmap()) != null) {
final int scaledWidth = (int) (bm.getWidth() * SCALE);
final int scaledHeight = (int) (bm.getHeight() * SCALE);
dstRect.left = currentX + SPACING_HORIZONTAL;
dstRect.right = dstRect.left + scaledWidth;
dstRect.top = SPACING_VERTICAL;
dstRect.bottom = dstRect.top + scaledHeight;
resultCanvas.drawBitmap(bm, null, dstRect, paint);//The functional module of image displaying
currentX = dstRect.right;
bm.recycle();//The functional module of image object releasing

