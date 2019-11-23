Triggering condition: handling a lot of images
Consequence: app slowdown

Below is the IID issue's code slice:	
//------------------------------code slice-----------------------------------------------
//the following statement sequence executed many times
public View getView(int position, View convertView, ViewGroup parent) {
final Holder holder;
SearchResult result = getItem(position);
FeedComponent component = result.getComponent();
if (component.getClass() == Feed.class) {
final Feed feed = (Feed) component;
Glide.with(context).load(feed.getImageUri()).diskCacheStrategy(DiskCacheStrategy.SOURCE).fitCenter().dontAnimate().into(holder.cover);//The functional module of image decoding+resizing+disk-caching+displaying     buggy code


         