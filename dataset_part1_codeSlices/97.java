Triggering condition: handling a lot of images
Consequence: app slow

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
private static final int ATTACHED_IMAGES_CACHE_SIZE_DEFAULT = 1024 * 1024 * 20;//buggy code
private static final float ATTACHED_IMAGES_CACHE_PART_OF_TOTAL_MEMORY = 0.1f;//buggy code
public static void initialize(Context context) {
attachedImagesCache.evictAll();
int attachedImageCacheSize = Math.round(
ATTACHED_IMAGES_CACHE_PART_OF_TOTAL_MEMORY * getTotalMemory(context));
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
attachedImagesCache.resize(attachedImageCacheSize);
Point displaySize = getDisplaySize(context);
attachedImagesCache.setMaxBounds(displaySize.x,(int) (AttachedImageFile.MAX_ATTACHED_IMAGE_PART * displaySize.y));
avatarsCache.evictAll();
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
int avatarsCacheSize = Math.round(AVATARS_CACHE_PART_OF_ATTACHED * attachedImageCacheSize);
avatarsCache.resize(avatarsCacheSize);
float displayDensity = context.getResources().getDisplayMetrics().density;
int avatarSize = Math.round(AvatarFile.AVATAR_SIZE_DIP * displayDensity);
avatarsCache.setMaxBounds(avatarSize, avatarSize);
ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
actManager.getMemoryInfo(memInfo);
return memInfo.totalMem;

Error description: line 6-7, inappropriate code implementation
