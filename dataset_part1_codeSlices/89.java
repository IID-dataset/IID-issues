Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
private void setupNotification(final PlaybackServiceMediaPlayer.PSMPInfo info) {
Runnable notificationSetupTask = new Runnable() {
Bitmap icon = null;
public void run() {
if (android.os.Build.VERSION.SDK_INT >= 11) {
if (info.playable != null) {
int iconSize = getResources().getDimensionPixelSize(
icon = Glide.with(PlaybackService.this).load(info.playable.getImageUri()).asBitmap().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(-1, -1) .get();//The functional module of image decoding+resizing+disk-caching+displaying     buggy code
