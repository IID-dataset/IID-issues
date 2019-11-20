Triggering condition: no triggering condition description
Consequence: abnormal image displaying

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
private void loadPreferences(){
imageStrategy = new GlideImageStrategy();
public void load(final FileItem item, final ImageView view) {
final DrawableTypeRequest<String> glideLoad = Glide.with(context).load(item.getPath());
if (PLAY_GIF) {
/**
The begin of a functional module: image resizing+resizing+displaying
**/
glideLoad.placeholder(view.getDrawable()).fitCenter().dontAnimate().listener(new RequestListener<String, GlideDrawable>() {}.into(view);//buggy code
/**
The begin of a functional module: image resizing+resizing+displaying
**/