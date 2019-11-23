Triggering condition: no triggering condition description
Consequence: app slowdown or memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onCreate() {
new Thread(new Runnable() {
public void run() {
deserializeDownloadQueueNow();
private void deserializeDownloadQueueNow() {
State state = FileUtil.deserialize(downloadService, FILENAME_DOWNLOADS_SER, State.class);
downloadService.restore(state.songs, state.toDelete, state.currentPlayingIndex, state.currentPlayingPosition);
public synchronized void restore(List<MusicDirectory.Entry> songs, List<MusicDirectory.Entry> toDelete, int currentPlayingIndex, int currentPlayingPosition) {
SharedPreferences prefs = Util.getPreferences(this);
remoteState = RemoteControlState.values()[prefs.getInt(Constants.PREFERENCES_KEY_CONTROL_MODE, 0)];
if(remoteState != RemoteControlState.LOCAL) {
String id = prefs.getString(Constants.PREFERENCES_KEY_CONTROL_ID, null);
setRemoteState(remoteState, null, id);
private void setRemoteState(final RemoteControlState newState, final Object ref, final String routeId) {
if(remoteController != null) {
remoteController.stop();
setPlayerState(PlayerState.IDLE);
public synchronized void setPlayerState(final PlayerState playerState) {
if (show) {
Util.showPlayingNotification(this, this, handler, currentPlaying.getSong());
public static void showPlayingNotification(final Context context, final DownloadService downloadService, Handler handler, MusicDirectory.Entry song) {
final Notification notification = new Notification(R.drawable.stat_notify_playing, song.getTitle(), System.currentTimeMillis());
notification.flags |= Notification.FLAG_NO_CLEAR | Notification.FLAG_ONGOING_EVENT;
boolean playing = downloadService.getPlayerState() == PlayerState.STARTED;
DSubWidgetProvider.notifyInstances(context, downloadService, playing);
public static synchronized void notifyInstances(Context context, DownloadService service, boolean playing) {
if(instance4x1 == null) {
instance4x1 = new DSubWidget4x1();
instance4x1.notifyChange(context, service, playing);
public void notifyChange(Context context, DownloadService service, boolean playing) {
if (hasInstances(context)) {
performUpdate(context, service, null, playing);
private void performUpdate(Context context, DownloadService service, int[] appWidgetIds, boolean playing) {
int size;
if(getLayout() != R.layout.appwidget4x1 && getLayout() != R.layout.appwidget4x2) {
size = context.getResources().getDrawable(R.drawable.unknown_album_large).getIntrinsicHeight();
Bitmap bitmap = currentPlaying == null ? null : FileUtil.getAlbumArtBitmap(context, currentPlaying, size);    //buggy code    should checking image cache first
/**
The begin of a functional module: image resizing
**/
public static Bitmap getAlbumArtBitmap(Context context, MusicDirectory.Entry entry, int size) {
File albumArtFile = getAlbumArtFile(context, entry);
if (albumArtFile.exists()) {
final BitmapFactory.Options opt = new BitmapFactory.Options();
opt.inJustDecodeBounds = true;
BitmapFactory.decodeFile(albumArtFile.getPath(), opt);
opt.inPurgeable = true;
opt.inSampleSize = Util.calculateInSampleSize(opt, size, Util.getScaledHeight(opt.outHeight, opt.outWidth, size));
opt.inJustDecodeBounds = false;
/**
The end of the functional module: image resizing
**/
Bitmap bitmap = BitmapFactory.decodeFile(albumArtFile.getPath(), opt);//The functional module of image decoding
return bitmap == null ? null : getScaledBitmap(bitmap, size);
public static Bitmap getScaledBitmap(Bitmap bitmap, int size) {
return Bitmap.createScaledBitmap(bitmap, size, Util.getScaledHeight(bitmap, size), true);//The functional module of image decoding
if (bitmap == null) {
} else {
bitmap = getRoundedCornerBitmap(bitmap);
views.setImageViewBitmap(R.id.appwidget_coverart, bitmap);//The functional module of image displaying
