Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void onCreate(Bundle savedInstanceState)       
showConversation();
protected void showConversation() {
if (selectedMessageId != 0 && contentLoader.getStatus() != Status.RUNNING) {
if (contentLoader.getStatus() == Status.FINISHED) {
contentLoader = new ContentLoader();
contentLoader.execute();
protected ConversationViewLoader doInBackground(Void... params) {
if (ma.isValid()) {
loader.load();
public void load() {
findPreviousMessagesRecursively(new ConversationOneMessage(selectedMessageId, 0));
private void findPreviousMessagesRecursively(ConversationOneMessage oMsg) {
loadMessageFromDatabase(oMsg);
private void loadMessageFromDatabase(ConversationOneMessage oMsg) {
Uri uri = MyProvider.getTimelineMsgUri(ma.getUserId(), TimelineTypeEnum.EVERYTHING, true, oMsg.mMsgId);
Cursor cursor = null;
cursor = context.getContentResolver().query(uri, TimelineSql.getConversationProjection(), null, null, null);
if (cursor != null && cursor.moveToFirst()) {
oMsg.load(cursor);
Drawable mImageDrawable = null;       //mImageDrawable is a global value
void load(Cursor cursor) {
if (MyPreferences.showAttachedImages()) {
mImageDrawable = AttachedImageDrawable.drawableFromCursor(cursor);
public static Drawable drawableFromCursor(Cursor cursor) {
int columnIndex = cursor.getColumnIndex(MyDatabase.Download.IMAGE_ID);
Long imageRowId = null;
if (columnIndex >= 0) {
imageRowId = cursor.getLong(columnIndex);
if (imageRowId == null || imageRowId == 0L) {
} else {
return new AttachedImageDrawable(imageRowId, cursor.getString(cursor.getColumnIndex(MyDatabase.Download.IMAGE_FILE_NAME))).getDrawable();
public Drawable getDrawable() {
if (downloadFile.exists()) {
return Drawable.createFromPath(downloadFile.getFile().getAbsolutePath());//The functional module of image decoding   buggy code    image decoding without resizing

Error description: line 40, lack of necessary functional modules

