Triggering condition: no triggering condition description
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected Bitmap doInBackground(Object... params) {
Bitmap thumbnail = null;
file = (OCFile) params[0];
if (account != null) {
thumbnail = doResizedImageInBackground();
if (MimeTypeUtil.isVideo(file) && thumbnail != null) {
thumbnail = addVideoOverlay(thumbnail);
public static Bitmap addVideoOverlay(Bitmap thumbnail){
Bitmap playButton = BitmapFactory.decodeResource(MainApp.getAppContext().getResources(),R.drawable.view_play);//image decoding
Drawable playButtonDrawable = MainApp.getAppContext().getResources().getDrawable(R.drawable.view_play);//buggy code
Bitmap playButton = BitmapUtils.drawableToBitmap(playButtonDrawable);
public static Bitmap drawableToBitmap(Drawable drawable) {
if (drawable instanceof BitmapDrawable) {
BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
if (bitmapDrawable.getBitmap() != null) {
return bitmapDrawable.getBitmap();
Bitmap resizedPlayButton = Bitmap.createScaledBitmap(playButton,(int) (thumbnail.getWidth() * 0.3),(int) (thumbnail.getHeight() * 0.3), true);
Bitmap resultBitmap = Bitmap.createBitmap(thumbnail.getWidth(),thumbnail.getHeight(),Bitmap.Config.ARGB_8888);
Canvas c = new Canvas(resultBitmap);
int x1 = resizedPlayButton.getWidth();
int y1 = resizedPlayButton.getHeight() / 2;
int x2 = 0;
int y2 = resizedPlayButton.getWidth();
int x3 = 0;
int y3 = 0;
double ym = ( ((Math.pow(x3,2) - Math.pow(x1,2) + Math.pow(y3,2) - Math.pow(y1,2)) *(x2 - x1)) - (Math.pow(x2,2) - Math.pow(x1,2) + Math.pow(y2,2) -Math.pow(y1,2)) * (x3 - x1) )  /  (2 * ( ((y3 - y1) * (x2 - x1)) -((y2 - y1) * (x3 - x1)) ));
double xm = ( (Math.pow(x2,2) - Math.pow(x1,2)) + (Math.pow(y2,2) - Math.pow(y1,2)) -(2*ym*(y2 - y1)) ) / (2*(x2 - x1));
double ox = - xm;
c.drawBitmap(thumbnail, 0, 0, null);
Paint p = new Paint();
p.setAlpha(230);
c.drawBitmap(resizedPlayButton, (float) ((thumbnail.getWidth() / 2) + ox),(float) ((thumbnail.getHeight() / 2) - ym), p);
return resultBitmap;


Error description:line 15, inappropriate code implementation