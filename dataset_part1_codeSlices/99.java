Triggering condition: handling a large image
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
private static final float ATTACHED_IMAGES_CACHE_PART_OF_AVAILABLE_MEMORY = 0.1f;//buggy code
private static void initializeAttachedImagesCache(Context context) {
int imageSize = (int) Math.round(AttachedImageFile.MAX_ATTACHED_IMAGE_PART *getDisplaySize(context).y);
int cacheSize = 0;
for (int i = 0 ; i < 5; i++) {
cacheSize = calcCacheSize(context, imageSize,ATTACHED_IMAGES_CACHE_PART_OF_AVAILABLE_MEMORY);
imageSize = (imageSize * 2) / 3;
if (cacheSize > ATTACHED_IMAGES_CACHE_SIZE_MAX) {
cacheSize = ATTACHED_IMAGES_CACHE_SIZE_MAX;
attachedImagesCache = new MyDrawableCache(context, "Attached images", imageSize,cacheSize);

Error description:line 6, inappropriate code implementation
