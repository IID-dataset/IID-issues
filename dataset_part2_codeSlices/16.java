Triggering condition: no triggering condition description
Consequence: bad user experience without further details for inspection

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
public void onBindViewHolder(final PhotoViewHolder vh, int position) {
ChosenPhoto chosenPhoto = getItem(position);
Uri contentUri = chosenPhoto.getContentUri();
int maxImages = vh.mThumbViews.size();
List<Uri> images = chosenPhoto.isTreeUri? getImagesFromTreeUri(chosenPhoto.uri, maxImages): Collections.singletonList(contentUri);
int numImages = images.size();
for (int h=0; h<numImages; h++) {
ImageView thumbView = vh.mThumbViews.get(h);
/**
The begin of a functional module: image resizing+decoding+displaying
**/
Picasso.with(GallerySettingsActivity.this).load(images.get(h)).resize(mItemSize / 2, mItemSize / 2).centerCrop().placeholder(mPlaceholderDrawable).into(thumbView);//buggy code
/**
The end of the functional module: image resizing+decoding+displaying
**/

Error description:line 17, misconfiguration of third-party libraries