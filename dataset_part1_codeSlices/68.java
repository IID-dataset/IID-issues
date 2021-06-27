Triggering condition: handling a lot of images
Consequence: bad user experiences and lack of further details for inspecion

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
setInfoFromBundle(this.getArguments());
private void setInfoFromBundle(Bundle extras) {
setInfoFromID(cardID);	
private void setInfoFromID(final long id) throws FamiliarDbException {
protected Void doInBackground(Void... params) {
bRetry = false;
URL u;
/**
The begin of a functional module: image resizing
**/
mCardBitmap = new BitmapDrawable(mActivity.getResources(), u.openStream());
int height = 0, width = 0;
float scale;
int border = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics());
if (loadTo == MAIN_PAGE) {
Rect rectangle = new Rect();
mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rectangle);
height = ((rectangle.bottom - rectangle.top) - mActivity.getActionBar().getHeight()) - border;
width = (rectangle.right - rectangle.left) - border;
float screenAspectRatio = (float) height / (float) (width);
float cardAspectRatio = (float) mCardBitmap.getIntrinsicHeight() /(float) mCardBitmap.getIntrinsicWidth();
if (screenAspectRatio > cardAspectRatio) {
scale = (width) / (float) mCardBitmap.getIntrinsicWidth();
int newWidth = Math.round(mCardBitmap.getIntrinsicWidth() * scale);
int newHeight = Math.round(mCardBitmap.getIntrinsicHeight() * scale);
Bitmap d = mCardBitmap.getBitmap();
Bitmap bitmapOrig = Bitmap.createScaledBitmap(d, newWidth, newHeight, true);//The functional module of image decoding
/**
The end of the functional module: image resizing
**/
mCardBitmap = new BitmapDrawable(mActivity.getResources(), bitmapOrig);
protected void onPostExecute(Void result) {
mCardImageView.setImageDrawable(mCardBitmap);//The functional module of image displaying

Error description:line 17-33, inappropriate code implementation.
