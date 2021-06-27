Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
protected void onCreate(Bundle savedInstanceState) {
AsyncTask<Long, Void, Feed> loadTask = new AsyncTask<Long, Void, Feed>() {
protected Feed doInBackground(Long... params) {
return DBReader.getFeed(FeedInfoActivity.this, params[0]);
protected void onPostExecute(Feed result) {
if (result != null) {
feed = result;
imgvCover.post(new Runnable() {
public void run() {
Glide.with(FeedInfoActivity.this).load(feed.getImageUri()).placeholder(R.color.light_gray).diskCacheStrategy(DiskCacheStrategy.SOURCE).fitCenter().dontAnimate().into(imgvCover);//The functional module of image decoding+resizing+disk-caching+displaying     buggy code

Error description:line 16, misconfiguration of third-party libraries