Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//The following statement sequence is executed multiple times
public View display(final Context context, int position, View convertView, FuzzyScore fuzzyScore)
View view = convertView
final ImageView appIcon = view.findViewById(R.id.item_app_icon)
if (!prefs.getBoolean("icons-hide", false))
if (appIcon.getTag() instanceof ComponentName && className.equals(appIcon.getTag()))
icon = appIcon.getDrawable()
public Drawable getDrawable(Context context)
synchronized (this)
if (icon == null)
icon = KissApplication.getApplication(context).getIconsHandler().getDrawableIconForPackage(className, this.appPojo.userHandle)   //buggy code
public Drawable getDrawableIconForPackage(ComponentName componentName, UserHandle userHandle)
systemIcon = this.getDefaultAppDrawable(componentName, userHandle)
if (systemIcon instanceof BitmapDrawable)
Drawable generated = generateBitmap(systemIcon)
private Drawable generateBitmap(Drawable defaultBitmap)
/**
The begin of a functional module: image resizing+image decoding
**/
Random r = new Random()
int backImageInd = r.nextInt(backImages.size())
Bitmap backImage = backImages.get(backImageInd)
int w = backImage.getWidth()
int h = backImage.getHeight()
Bitmap result = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
Canvas canvas = new Canvas(result)
canvas.drawBitmap(backImage, 0, 0, null)
Bitmap scaledBitmap = Bitmap.createScaledBitmap(((BitmapDrawable) defaultBitmap).getBitmap(), (int) (w * factor), (int) (h * factor), false)
/**
The end of a functional module: image resizing
**/
if (maskImage != null)
/**
The begin of a functional module: image displaying
**/
canvas.drawBitmap(scaledBitmap, (w - scaledBitmap.getWidth()) / 2, (h - scaledBitmap.getHeight()) / 2, null)
/**
The end of a functional module: image displaying
**/
return new BitmapDrawable(iconPackres, result)
cacheStoreDrawable(componentName.toString(), generated)
return generated
return icon
this.setAsyncDrawable(appIcon)	

Error description:line 16, inappropriate code implementation  
	
