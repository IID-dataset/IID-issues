Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
public View getView(int position, View view, ViewGroup parent) {
ImageView imagePreview = (ImageView) view.findViewById(R.id.conversation_lastimage);
if (message.getFileParams().width > 0&& (message.getTransferable() == null|| message.getTransferable().getStatus() != Transferable.STATUS_DELETED)) {
activity.loadBitmap(message, imagePreview);
public void loadBitmap(Message message, ImageView imageView) {
Bitmap bm;
bm = xmppConnectionService.getFileBackend().getThumbnail(message,(int) (metrics.density * 288), true);//The functional module of image decoding
public Bitmap getThumbnail(Message message, int size, boolean cacheOnly) throws FileNotFoundException {
final String uuid = message.getUuid();
final LruCache<String,Bitmap> cache = mXmppConnectionService.getBitmapCache();
Bitmap thumbnail = cache.get(uuid);
if ((thumbnail == null) && (!cacheOnly)) {
synchronized (cache) {//buggy code 
thumbnail = cache.get(uuid);
if (thumbnail != null) {
return thumbnail;
if (bm != null) {
cancelPotentialWork(message, imageView);
imageView.setImageBitmap(bm);//The functional module of image displaying



