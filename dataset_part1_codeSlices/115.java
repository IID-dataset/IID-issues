Triggering condition: no triggering condition description
Consequence: memory bloat

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
protected void exec() {
parent.dbHelper.cleanupVeryOldStories();
if (!PrefsUtils.isKeepOldStories(parent)) {
parent.dbHelper.cleanupReadStories();
parent.dbHelper.cleanupStoryText();
ImageCache imageCache = new ImageCache(parent);
imageCache.cleanup(parent.dbHelper.getAllStoryImages());
//error position      lack of image cache releasing

Error description:line 12, inappropriate code implementation  