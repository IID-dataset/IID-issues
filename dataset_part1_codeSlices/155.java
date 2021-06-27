Triggering condition: no triggering condition description
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
void fixAspectRatio(TextureRequestor requestor, GLESTextureInfo ti) {
if (Preferences.General.isFixAspectRatio()) {
RectF dimens = requestor.getRequestorDimensions();
Rect pixels = new Rect(0,0,(int)(mScreenDimensions.width() * dimens.width() / 2),(int)(mScreenDimensions.height() * dimens.height() / 2));
Bitmap thumb = ThumbnailUtils.extractThumbnail(ti.bitmap,pixels.width(),pixels.height(),ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
GLESTextureInfo dst = GLESUtil.loadTexture(thumb, ti.effect == null ? null : ti.effect, mScreenDimensions);
int[] textures = new int[]{ti.handle};
//error position        lack a functional module to release image object

Error description:line 12, lack of necessary functional modules
