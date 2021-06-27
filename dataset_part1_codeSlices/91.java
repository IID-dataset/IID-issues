Triggering condition: no triggering condition description
Consequence: app crash

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onTrimMemory(int level) {
super.onTrimMemory(level);
Glide.get(this).trimMemory(level);
public void onLowMemory() {
super.onLowMemory();
Glide.get(this).clearMemory();

Error description:line 7-8, inappropriate code implementation
