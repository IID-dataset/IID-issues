Triggering condition: no triggering condition description
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onCreate() {
mediaPlayer = new PlaybackServiceMediaPlayer(this, mediaPlayerCallback);
private final PlaybackServiceMediaPlayer.PSMPCallback mediaPlayerCallback = new PlaybackServiceMediaPlayer.PSMPCallback() {
public void statusChanged(PlaybackServiceMediaPlayer.PSMPInfo newInfo) {
currentMediaType = mediaPlayer.getCurrentMediaType();
switch (newInfo.playerStatus) {
case PAUSED:
if (UserPreferences.isPersistNotify() && android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
setupNotification(newInfo);
private void setupNotification(final PlaybackServiceMediaPlayer.PSMPInfo info) {
Runnable notificationSetupTask = new Runnable() {
Bitmap icon = null;
public void run() {
if (android.os.Build.VERSION.SDK_INT >= 11) {
if (info.playable != null) {
int iconSize = getResources().getDimensionPixelSize(android.R.dimen.notification_large_icon_width);
icon = Glide.with(PlaybackService.this).load(info.playable.getImageUri()).asBitmap().diskCacheStrategy(ApGlideSettings.AP_DISK_CACHE_STRATEGY).into(-1, -1) .get();//The functional module of image decoding+disk-caching+displaying     buggy code