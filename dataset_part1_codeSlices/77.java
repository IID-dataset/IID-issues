Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
public View getView(int position, View convertView, ViewGroup parent) {
Holder holder;
final FeedItem item = (FeedItem) getItem(position);
Glide.with(context).load(item.getImageUri()).placeholder(R.color.light_gray).diskCacheStrategy(DiskCacheStrategy.SOURCE).fitCenter().dontAnimate().into(holder.imageView);//The functional module of image decoding+resizing+disk-caching+displaying     buggy code

