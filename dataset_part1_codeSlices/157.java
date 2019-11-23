Triggering condition: handling a large image
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public View instantiateItem(ViewGroup container, int position) {
Cursor cursor = getCursorAt(position);
if (cursor != null) {
long imageID = cursor.getLong(cursor.getColumnIndex(FotoSql.SQL_COL_PK));
Uri uri = getUri(imageID);
PhotoView photoView = new PhotoView(container.getContext());
if (Global.debugEnabledViewItem) Log.i(Global.LOG_CONTEXT, debugPrefix + "instantiateItem(#" + position +") => " + uri + " => " + photoView);
setImage(position, imageID, uri, photoView);
private void setImage(int position, long imageID, Uri uri, PhotoView photoView) {
if (!mHasLowMemory) {
photoView.setImageURI(uri); //The functional module of image decoding + displaying              buggy code









