Triggering condition: no triggering condition description
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
 private void setInfoFromBundle(Bundle extras) {
long cardID = extras.getLong(CARD_ID);
setInfoFromID(cardID);	 
public void setInfoFromID(final long id) {		 
mAsyncTask = new FetchPictureTask();
mAsyncTask.execute((Void[]) null);		 		 
protected Void doInBackground(Void... params) {
String cardLanguage = mActivity.mPreferenceAdapter.getCardLanguage();
Bitmap bitmap;
bitmap = getFamiliarActivity().mImageCache.getBitmapFromDiskCache(imageKey);
if (bitmap == null) {
boolean bRetry = true;
boolean triedMtgi = false;
boolean triedGatherer = false;
while (bRetry) {
bRetry = false;
URL u;
if (!cardLanguage.equalsIgnoreCase("en")) {
u = new URL(getMtgiPicUrl(mCardName, mMagicCardsInfoSetCode, mCardNumber, cardLanguage));
bitmap = BitmapFactory.decodeStream(FamiliarActivity.getHttpInputStream(u, null));//The functional module of image decoding
getFamiliarActivity().mImageCache.addBitmapToCache(imageKey, new BitmapDrawable(mActivity.getResources(), bitmap)); 
/**
The begin of a functional module: image resizing
**/
mBorder = (int) TypedValue.applyDimension(
TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics());
Display display = ((WindowManager) mActivity.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
Point p = new Point();
display.getSize(p);
mHeight = p.y - mBorder;
mWidth = p.x - mBorder;
float screenAspectRatio = (float) mHeight / (float) (mWidth);
float cardAspectRatio = (float) bitmap.getHeight() / (float) bitmap.getWidth();
float scale;
if (screenAspectRatio > cardAspectRatio) {
scale = (mWidth) / (float) bitmap.getWidth();
int newWidth = Math.round(bitmap.getWidth() * scale);
int newHeight = Math.round(bitmap.getHeight() * scale);
Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true);//The functional module of image decoding
/**
The end of the functional module: image resizing
**/
mCardBitmap = new RecyclingBitmapDrawable(mActivity.getResources(), scaledBitmap);
bitmap.recycle();
protected void onPostExecute(Void result) {
mCardImageView.setImageDrawable(mCardBitmap);//The functional module of image displaying
//buggy position          lack of image object releasing
