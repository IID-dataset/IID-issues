Triggering condition: handling a lot of images
Consequence: app slow

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
protected void onCreate(Bundle savedInstanceState) {
showConversation();
protected void showConversation() {
if (selectedMessageId != 0 && contentLoader.getStatus() != Status.RUNNING) {
if (contentLoader.getStatus() == Status.FINISHED) {
contentLoader = new ContentLoader();
contentLoader.execute();
private class ContentLoader extends AsyncTask<Void, Void, ConversationViewLoader> {
protected ConversationViewLoader doInBackground(Void... params) {
ConversationViewLoader loader = new ConversationViewLoader(ConversationActivity.this, ma, selectedMessageId);
if (ma.isValid()) {
loader.load();
void load(Cursor cursor) {
if (ind == 0) {
if (MyPreferences.showAttachedImages()) {
mImageDrawable = AttachedImageDrawable.drawableFromCursor(cursor);
public static Drawable drawableFromCursor(Cursor cursor) {
long imageRowId = DbUtils.getLong(cursor, MyDatabase.Download.IMAGE_ID);
if (imageRowId == 0) {
} else {
return new AttachedImageDrawable(imageRowId,DbUtils.getString(cursor,MyDatabase.Download.IMAGE_FILE_NAME)).getDrawable();
public Drawable getDrawable() {
if (downloadFile.exists()) {
String path = downloadFile.getFile().getAbsolutePath();
return drawableFromPath(this, path, getSize());
private static Drawable drawableFromPath(Object objTag, String path, Point imageSize) {
/**
The begin of a functional module: image resizing
**/
static BitmapFactory.Options calculateScaling(Object objTag,Point imageSize) {
BitmapFactory.Options options2 = new BitmapFactory.Options();
Point displaySize = getDisplaySize(MyContextHolder.get().context());
while (imageSize.y > (int) (MAX_ATTACHED_IMAGE_PART * displaySize.y) || imageSize.x > displaySize.x) {
options2.inSampleSize = (options2.inSampleSize < 2) ? 2 : options2.inSampleSize * 2;
displaySize.set(displaySize.x * 2, displaySize.y * 2);
return options2
/**
The end of the functional module: image resizing
**/
Bitmap bitmap = BitmapFactory.decodeFile(path, calculateScaling(objTag, imageSize));//buggy code      repeated and redundant image decoding
return new BitmapDrawable(MyContextHolder.get().context().getResources(), bitmap);
