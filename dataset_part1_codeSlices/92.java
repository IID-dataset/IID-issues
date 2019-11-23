Triggering condition: no triggering condition description
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
private void updateMediaSessionMetadata() {
executor.execute(() -> {
final Playable p = this.media;
MediaMetadataCompat.Builder builder = new MediaMetadataCompat.Builder();
if (p.getImageUri() != null) {
if (UserPreferences.setLockscreenBackground()) {
builder.putString(MediaMetadataCompat.METADATA_KEY_ART_URI, p.getImageUri().toString());
Bitmap art = Glide.with(context).load(p.getImageUri()).asBitmap().diskCacheStrategy(ApGlideSettings.AP_DISK_CACHE_STRATEGY).into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).get();//The functional module of image decoding+disk-caching+displaying     buggy code
builder.putBitmap(MediaMetadataCompat.METADATA_KEY_ART, art);
mediaSession.setMetadata(builder.build());

